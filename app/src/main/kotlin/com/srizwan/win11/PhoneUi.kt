package com.srizwan.win11

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.app.role.RoleManager
import android.app.DownloadManager
import android.app.Notification
import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.SharedPreferences
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.Matrix
import android.graphics.Rect
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.net.Uri
import android.os.*
import android.provider.ContactsContract
import android.provider.MediaStore
import android.provider.Settings
import android.provider.Telephony
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.telephony.SmsManager
import android.text.format.DateUtils
import android.util.Base64
import android.util.Log
import android.view.*
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.graphics.Typeface
import android.graphics.pdf.PdfRenderer
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.webkit.*
import android.widget.*
import android.widget.VideoView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.zip.ZipInputStream

// Phone: dialer, contacts picker, recent calls (split out of MainActivity).
// All functions are extensions of MainActivity; state lives in MainActivity.

internal fun MainActivity.createDialerView(): LinearLayout {
    val layout = LinearLayout(this).apply {
        orientation = LinearLayout.VERTICAL
        setBackgroundColor(Color.TRANSPARENT)
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
        )
    }

    // ── Header ──
    val header = LinearLayout(this).apply {
        orientation = LinearLayout.HORIZONTAL
        setBackgroundColor(GLASS_BAR)
        setPadding(dp(16), dp(12), dp(16), dp(12))
        gravity = Gravity.CENTER_VERTICAL
    }
    val headerTitle = TextView(this).apply {
        text = "Phone & Flashlight"
        iconStart(R.drawable.ic_w_phone, 20, Color.WHITE, 8)
        textSize = 18f
        typeface = Typeface.DEFAULT_BOLD
        setTextColor(Color.WHITE)
        layoutParams =
            LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f)
    }
    torchBtn = Button(this).apply {
        text = "ON"
        iconStart(R.drawable.ic_qs_flashlight, 18, Color.WHITE, 6)
        glass(Color.argb(70, 255, 255, 255))
        setTextColor(Color.WHITE)
        textSize = 13f
        layoutParams = LinearLayout.LayoutParams(dp(90), dp(40))
        setOnClickListener { toggleTorch(this) }
    }
    header.addView(headerTitle)
    header.addView(torchBtn)
    layout.addView(header)

    // ── Scroll ──
    val scroll = ScrollView(this).apply {
        layoutParams =
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f)
    }
    val inner = LinearLayout(this).apply {
        orientation = LinearLayout.VERTICAL
        setPadding(dp(16), dp(12), dp(16), dp(16))
        setBackgroundColor(Color.TRANSPARENT)
    }

    // ── Display field ──
    dialInput = EditText(this).apply {
        hint = "Number / name"
        textSize = 22f
        gravity = Gravity.CENTER
        setTextColor(Color.WHITE)
        setHintTextColor(Color.GRAY)
        background = glassCard(GLASS_FILL, 8)
        setPadding(dp(12), dp(12), dp(12), dp(12))
        isFocusable = true
        isFocusableInTouchMode = true
        layoutParams =
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(60))
    }
    inner.addView(dialInput)
    inner.addView(View(this).apply {
        layoutParams =
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(10))
    })

    // ── Numpad ──
    val numpadRows =
        listOf(listOf("1", "2", "3"), listOf("4", "5", "6"), listOf("7", "8", "9"), listOf("*", "0", "#"))
    for (row in numpadRows) {
        val rowLayout = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER
            layoutParams =
                LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(64)).apply {
                    setMargins(0, dp(4), 0, dp(4))
                }
        }
        for (digit in row) {
            val btn = Button(this).apply {
                text = digit
                textSize = 22f
                typeface = Typeface.DEFAULT_BOLD
                setTextColor(Color.WHITE)
                glass(GLASS_FILL_STRONG)
                layoutParams =
                    LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f).apply {
                        setMargins(dp(4), 0, dp(4), 0)
                    }
                setOnClickListener { dialInput?.append(digit) }
            }
            rowLayout.addView(btn)
        }
        inner.addView(rowLayout)
    }

    // ── Action row ──
    inner.addView(View(this).apply {
        layoutParams =
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(8))
    })
    val actionRow = LinearLayout(this).apply {
        orientation = LinearLayout.HORIZONTAL
        gravity = Gravity.CENTER
        layoutParams =
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(64))
    }

    val deleteBtn = Button(this).apply {
        iconOnly(R.drawable.ic_w_backspace, 24, Color.WHITE)
        textSize = 22f
        setTextColor(Color.WHITE)
        glass(Color.argb(56, 255, 255, 255))
        layoutParams =
            LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f).apply {
                setMargins(dp(4), 0, dp(4), 0)
            }
        setOnClickListener {
            val s = dialInput?.text ?: return@setOnClickListener
            if (s.isNotEmpty()) dialInput?.setText(s.dropLast(1))
        }
        setOnLongClickListener { dialInput?.setText(""); true }
    }
    val callBtn = Button(this).apply {
        text = "Call"
        iconStart(R.drawable.ic_w_phone, 22, Color.WHITE, 8)
        textSize = 18f
        typeface = Typeface.DEFAULT_BOLD
        setTextColor(Color.WHITE)
        glass(Color.argb(235, 76, 175, 80))
        layoutParams =
            LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 2f).apply {
                setMargins(dp(4), 0, dp(4), 0)
            }
        setOnClickListener { makeCall() }
    }
    val contactsBtn = Button(this).apply {
        iconOnly(R.drawable.ic_w_person, 24, Color.WHITE)
        textSize = 22f
        setTextColor(Color.WHITE)
        glass(Color.argb(230, 21, 101, 192))
        layoutParams =
            LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f).apply {
                setMargins(dp(4), 0, dp(4), 0)
            }
        setOnClickListener { openContactPicker() }
    }
    actionRow.addView(deleteBtn)
    actionRow.addView(callBtn)
    actionRow.addView(contactsBtn)
    inner.addView(actionRow)

    // ── Recent calls ──
    inner.addView(View(this).apply {
        layoutParams =
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(16))
    })
    val recentTitle = TextView(this).apply {
        text = "Recent Calls"
        iconStart(R.drawable.ic_w_history, 16, Color.parseColor("#AAAAAA"), 8)
        textSize = 14f
        typeface = Typeface.DEFAULT_BOLD
        setTextColor(Color.parseColor("#AAAAAA"))
        setPadding(0, 0, 0, dp(8))
    }
    inner.addView(recentTitle)
    inner.addView(buildRecentCallsView())

    scroll.addView(inner)
    layout.addView(scroll)
    return layout
}


internal fun MainActivity.makeCall() {
    val number = dialInput?.text?.toString()?.trim() ?: return
    if (number.isEmpty()) {
        Toast.makeText(this, "নম্বর লিখুন", Toast.LENGTH_SHORT).show()
        return
    }
    if (ContextCompat.checkSelfPermission(this, PERM_CALL) != PackageManager.PERMISSION_GRANTED) {
        ActivityCompat.requestPermissions(this, arrayOf(PERM_CALL), REQ_CALL)
        return
    }
    try {
        startActivity(Intent(Intent.ACTION_CALL, Uri.parse("tel:$number")))
    } catch (e: Exception) {
        try {
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number")))
        } catch (e2: Exception) {
            Toast.makeText(this, "Call failed: ${e2.message}", Toast.LENGTH_SHORT).show()
        }
    }
}


internal fun MainActivity.openContactPicker() {
    if (ContextCompat.checkSelfPermission(this, PERM_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
        ActivityCompat.requestPermissions(this, arrayOf(PERM_CONTACTS), REQ_CONTACTS)
        return
    }
    showContactListDialog()
}


internal fun MainActivity.showContactListDialog() {
    val contacts = mutableListOf<Pair<String, String>>()
    try {
        val cursor = contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            arrayOf(
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER
            ),
            null, null,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC"
        )
        cursor?.use {
            val nameIdx =
                it.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
            val numIdx =
                it.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER)
            while (it.moveToNext()) {
                val name = it.getString(nameIdx) ?: ""
                val num = it.getString(numIdx) ?: ""
                if (num.isNotEmpty()) contacts.add(Pair(name, num))
            }
        }
    } catch (e: Exception) {
        Toast.makeText(this, "Contacts error: ${e.message}", Toast.LENGTH_SHORT).show()
        return
    }
    if (contacts.isEmpty()) {
        Toast.makeText(this, "No contacts found", Toast.LENGTH_SHORT).show()
        return
    }

    val dialogView = LinearLayout(this).apply {
        orientation = LinearLayout.VERTICAL
        setBackgroundColor(Color.TRANSPARENT)
    }
    val searchField = GlassSearch(this, "Search contacts")
    val searchEdit = searchField.edit
    dialogView.addView(searchField.root, LinearLayout.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT, dp(40)).apply { bottomMargin = dp(8) })
    val listView = ListView(this).apply {
        layoutParams =
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(350))
        setBackgroundColor(Color.TRANSPARENT)
        divider = null
    }
    dialogView.addView(listView)

    fun makeAdapter(list: List<Pair<String, String>>) =
        object : ArrayAdapter<Pair<String, String>>(
            this, android.R.layout.simple_list_item_2, android.R.id.text1, list
        ) {
            override fun getView(
                position: Int, convertView: View?, parent: ViewGroup
            ): View {
                val view = super.getView(position, convertView, parent)
                val item = getItem(position) ?: return view
                view.setBackgroundColor(Color.TRANSPARENT)
                view.findViewById<TextView>(android.R.id.text1).apply {
                    text = item.first
                    iconStart(R.drawable.ic_w_person, 18, Color.WHITE, 8)
                    setTextColor(Color.WHITE)
                    textSize = 14f
                }
                view.findViewById<TextView>(android.R.id.text2).apply {
                    text = item.second
                    setTextColor(Color.parseColor("#AAAAAA"))
                    textSize = 12f
                }
                return view
            }
        }

    var currentList = contacts.toMutableList()
    listView.adapter = makeAdapter(currentList)
    val dialog = W11Dialog.Builder(this).setTitle("Contacts").setIcon(R.drawable.ic_w_person).setView(dialogView)
        .setNegativeButton("Cancel", null).create()
    listView.setOnItemClickListener { _, _, pos, _ ->
        val pair = currentList.getOrNull(pos) ?: return@setOnItemClickListener
        dialInput?.setText(pair.second.replace(" ", "").replace("-", ""))
        dialog.dismiss()
    }
    searchEdit.addTextChangedListener(object : android.text.TextWatcher {
        override fun afterTextChanged(s: android.text.Editable?) {
            val q = s.toString().lowercase()
            currentList =
                contacts.filter {
                    it.first.lowercase().contains(q) || it.second.contains(q)
                }.toMutableList()
            listView.adapter = makeAdapter(currentList)
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    })
    dialog.show()
}


internal fun MainActivity.buildRecentCallsView(): LinearLayout {
    val container = LinearLayout(this).apply { orientation = LinearLayout.VERTICAL }
    try {
        if (ContextCompat.checkSelfPermission(
                this, Manifest.permission.READ_CALL_LOG
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            container.addView(TextView(this).apply {
                text =
                    "Call log permission not granted.\nAdd READ_CALL_LOG permission and grant at runtime."
                setTextColor(Color.parseColor("#888888"))
                textSize = 12f
                setPadding(0, dp(4), 0, dp(4))
            })
            return container
        }
        val cursor = contentResolver.query(
            android.provider.CallLog.Calls.CONTENT_URI,
            arrayOf(
                android.provider.CallLog.Calls.NUMBER,
                android.provider.CallLog.Calls.CACHED_NAME,
                android.provider.CallLog.Calls.TYPE,
                android.provider.CallLog.Calls.DATE
            ),
            null, null,
            android.provider.CallLog.Calls.DATE + " DESC"
        )
        var count = 0
        cursor?.use {
            val numIdx = it.getColumnIndex(android.provider.CallLog.Calls.NUMBER)
            val nameIdx = it.getColumnIndex(android.provider.CallLog.Calls.CACHED_NAME)
            val typeIdx = it.getColumnIndex(android.provider.CallLog.Calls.TYPE)
            val dateIdx = it.getColumnIndex(android.provider.CallLog.Calls.DATE)
            while (it.moveToNext() && count < 20) {
                val num = if (numIdx >= 0) it.getString(numIdx) else "?"
                val name = if (nameIdx >= 0) it.getString(nameIdx) ?: "" else ""
                val type = if (typeIdx >= 0) it.getInt(typeIdx) else 0
                val date = if (dateIdx >= 0) it.getLong(dateIdx) else 0L
                val typeIcon = when (type) {
                    android.provider.CallLog.Calls.INCOMING_TYPE -> R.drawable.ic_w_call_in
                    android.provider.CallLog.Calls.OUTGOING_TYPE -> R.drawable.ic_w_call_out
                    android.provider.CallLog.Calls.MISSED_TYPE -> R.drawable.ic_w_call_missed
                    else -> R.drawable.ic_w_history
                }
                val typeTint = if (type == android.provider.CallLog.Calls.MISSED_TYPE)
                    Color.rgb(255, 82, 82) else Color.rgb(76, 194, 255)
                val displayName = if (name.isNotEmpty()) name else num ?: "Unknown"
                val timeStr =
                    if (date > 0) DateUtils.getRelativeTimeSpanString(
                        date, System.currentTimeMillis(), DateUtils.MINUTE_IN_MILLIS
                    ).toString() else ""
                val row = LinearLayout(this).apply {
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_VERTICAL
                    background = glassCard(GLASS_FILL, 8)
                    setPadding(dp(10), dp(10), dp(10), dp(10))
                    layoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    ).apply { setMargins(0, dp(2), 0, dp(2)) }
                }
                val iconView = TextView(this).apply {
                    iconOnly(typeIcon, 22, typeTint)
                    layoutParams = LinearLayout.LayoutParams(dp(36), dp(36)).apply {
                        setMargins(0, 0, dp(10), 0)
                    }
                }
                val textBlock = LinearLayout(this).apply {
                    orientation = LinearLayout.VERTICAL
                    layoutParams = LinearLayout.LayoutParams(
                        0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f
                    )
                }
                textBlock.addView(TextView(this).apply {
                    text = displayName
                    setTextColor(Color.WHITE)
                    textSize = 14f
                })
                textBlock.addView(TextView(this).apply {
                    text = "$num  ·  $timeStr"
                    setTextColor(Color.parseColor("#888888"))
                    textSize = 11f
                })
                val callBackBtn = Button(this).apply {
                    iconOnly(R.drawable.ic_w_phone, 22, Color.WHITE)
                    textSize = 18f
                    setTextColor(Color.WHITE)
                    glass(Color.argb(235, 76, 175, 80))
                    layoutParams = LinearLayout.LayoutParams(dp(46), dp(46))
                    setPadding(0, 0, 0, 0)
                    setOnClickListener {
                        dialInput?.setText(num)
                        makeCall()
                    }
                }
                row.addView(iconView)
                row.addView(textBlock)
                row.addView(callBackBtn)
                container.addView(row)
                count++
            }
        }
        if (count == 0) {
            container.addView(TextView(this).apply {
                text = "No recent calls"
                setTextColor(Color.parseColor("#666666"))
                textSize = 13f
            })
        }
    } catch (e: SecurityException) {
        container.addView(TextView(this).apply {
            text = "Call log access denied"
            setTextColor(Color.parseColor("#888888"))
            textSize = 12f
        })
    } catch (e: Exception) {
        container.addView(TextView(this).apply {
            text = "Call log error: ${e.message}"
            setTextColor(Color.parseColor("#888888"))
            textSize = 12f
        })
    }
    return container
}

// =====================================================================
// ██████████  SMS SECTION  ██████████
// =====================================================================

