/*
 * Copyright 2018 Nikita Shakarun
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.playsoftware.j2meloader.filepicker;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.nononsenseapps.filepicker.FilePickerFragment;
import com.nononsenseapps.filepicker.LogicHandler;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import ru.playsoftware.j2meloader.R;

public class FilteredFilePickerFragment extends FilePickerFragment {
	private static final List<String> extList = Arrays.asList(".jad", ".jar", ".kjx");
	private static final Stack<File> history = new Stack<>();
	// true while the "All files access" settings screen is open, so the picker can reload when we come back
	private boolean waitingForAllFilesAccess;

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		if (history.empty()) {
			history.push(Environment.getExternalStorageDirectory());
		}
		requireActivity().getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
			@Override
			public void handleOnBackPressed() {
				if (isBackTop()) {
					setEnabled(false);
					requireActivity().onBackPressed();
				} else {
					goBack();
				}
			}
		});
	}

	@NonNull
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		LayoutInflater li = getLayoutInflater();
		switch (viewType) {
			case LogicHandler.VIEWTYPE_HEADER:
				return new HeaderViewHolder(li.inflate(R.layout.listitem_dir, parent, false));
			case LogicHandler.VIEWTYPE_CHECKABLE:
				return new CheckableViewHolder(li.inflate(R.layout.listitem_checkable, parent, false));
			case LogicHandler.VIEWTYPE_DIR:
			default:
				return new DirViewHolder(li.inflate(R.layout.listitem_dir, parent, false));
		}
	}

	private String getExtension(@NonNull File file) {
		String name = file.getName();
		int i = name.lastIndexOf('.');
		if (i < 0) {
			return null;
		} else {
			return name.substring(i).toLowerCase();
		}
	}

	@Override
	protected boolean isItemVisible(final File file) {
		if (isDir(file)) {
			return true;
		}
		if (mode != MODE_FILE && mode != MODE_FILE_AND_DIR) {
			return false;
		}
		String ext = getExtension(file);
		return ext != null && extList.contains(ext);
	}

	@Override
	public void goToDir(@NonNull File file) {
		history.add(mCurrentPath);
		super.goToDir(file);
	}

	private boolean isBackTop() {
		return history.empty();
	}

	private void goBack() {
		File last = history.pop();
		super.goToDir(last);
	}

	@Override
	public void onBindHeaderViewHolder(@NonNull HeaderViewHolder viewHolder) {
		viewHolder.itemView.setEnabled(!getRoot().equals(mCurrentPath));
		super.onBindHeaderViewHolder(viewHolder);
	}

	// The library only knows the old WRITE_EXTERNAL_STORAGE permission, which the host app declares up to
	// Android 9 only (maxSdkVersion 28). On Android 11+ it can never be granted, so the picker showed
	// "Permisson to access filesystem denied". "All files access" (MANAGE_EXTERNAL_STORAGE) counts as well.
	private boolean hasFilesystemAccess() {
		Context context = getContext();
		if (context == null) {
			return false;
		}
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && Environment.isExternalStorageManager()) {
			return true;
		}
		return ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)
				== PackageManager.PERMISSION_GRANTED;
	}

	protected boolean hasPermission(@NonNull File path) {
		return hasFilesystemAccess();
	}

	protected void handlePermission(@NonNull File path) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
			waitingForAllFilesAccess = true;
			Uri pkg = Uri.parse("package:" + requireContext().getPackageName());
			try {
				startActivity(new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION, pkg));
			} catch (ActivityNotFoundException e) {
				try {
					startActivity(new Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION));
				} catch (ActivityNotFoundException e2) {
					waitingForAllFilesAccess = false;
					Toast.makeText(requireContext(), R.string.permission_request_failed, Toast.LENGTH_SHORT).show();
				}
			}
		} else {
			requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
		}
	}

	@Override
	public void onResume() {
		super.onResume();
		if (waitingForAllFilesAccess) {
			waitingForAllFilesAccess = false;
			if (hasFilesystemAccess()) {
				// Reload the picker now that access is granted
				requireActivity().recreate();
			} else {
				Toast.makeText(requireContext(), R.string.permission_request_failed, Toast.LENGTH_SHORT).show();
			}
		}
	}

	@NonNull
	@Override
	public Uri toUri(@NonNull File file) {
		return Uri.fromFile(file);
	}
}