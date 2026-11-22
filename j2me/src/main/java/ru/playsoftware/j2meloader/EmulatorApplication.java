/*
 * Copyright 2017-2018 Nikita Shakarun
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

package ru.playsoftware.j2meloader;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.PreferenceManager;

import org.acra.ACRA;
import org.acra.config.CoreConfigurationBuilder;
import org.acra.config.DialogConfigurationBuilder;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import ru.playsoftware.j2meloader.util.Constants;
import ru.playsoftware.j2meloader.util.FileUtils;

/**
 * Process-wide holder of the host {@link Application} for the J2ME module.
 *
 * Upstream J2ME Loader subclassed Application. Inside the launcher the Application belongs to the host
 * (com.srizwan.win11.App), so this class is now a plain helper the host calls:
 * <ul>
 *   <li>{@link #attach(Application)} - host process: remembers the Application (needed by the Room database, the
 *   MIDlet list and the Documents provider). Cheap, no side effects.</li>
 *   <li>{@link #attachMidletProcess(Application)} - the ":midlet" process only (MicroActivity): remembers the
 *   Application and starts the crash dialog (ACRA) and the saved day / night mode, exactly like upstream did.</li>
 *   <li>{@link #applyNightMode()} - called by the J2ME screens in the host process (BaseActivity), so the J2ME
 *   "Theme" setting is applied when a J2ME screen opens, not at every launcher start.</li>
 * </ul>
 */
public class EmulatorApplication {
	private static final String[] VALID_SIGNATURES = {
			"78EF7758720A9902F731ED706F72C669C39B765C", // GPlay
			"289F84A32207DF89BE749481ED4BD07E15FC268F", // F-Droid
			"FA8AA497194847D5715BAA62C6344D75A936EBA6" // Private
	};

	private static Application instance;
	private static boolean nightListenerRegistered;

	// Strong reference on purpose: SharedPreferences keeps its listeners in a weak map.
	private static final SharedPreferences.OnSharedPreferenceChangeListener themeListener = (sharedPreferences, key) -> {
		if (Constants.PREF_THEME.equals(key)) {
			setNightMode(sharedPreferences.getString(Constants.PREF_THEME, null));
		}
	};

	private EmulatorApplication() {
	}

	/** The host Application (set by {@link #attach} / {@link #attachMidletProcess}). */
	public static Application getInstance() {
		return instance;
	}

	/** Host (launcher) process: only remember the Application. */
	public static synchronized void attach(@NonNull Application app) {
		instance = app;
	}

	/** ":midlet" process: remember the Application, start the crash dialog and apply the saved night mode. */
	@SuppressWarnings("ConstantConditions")
	public static synchronized void attachMidletProcess(@NonNull Application app) {
		instance = app;
		try {
			ACRA.init(app, new CoreConfigurationBuilder()
					.withBuildConfigClass(BuildConfig.class)
					.withParallel(false)
					.withSendReportsInDevMode(false)
					.withPluginConfigurations(new DialogConfigurationBuilder()
							.withTitle(app.getString(R.string.crash_dialog_title))
							.withText(app.getString(R.string.crash_dialog_message))
							.withPositiveButtonText(app.getString(R.string.report_crash))
							.withResTheme(androidx.appcompat.R.style.Theme_AppCompat_DayNight_Dialog)
							.withEnabled(true)
							.build()
					));
			// Reports are only sent by builds signed with the upstream keys (same rule as upstream).
			ACRA.getErrorReporter().setEnabled(isSignatureValid(app));
		} catch (Throwable t) {
			android.util.Log.e("J2ME", "crash dialog init failed", t);
		}
		applyNightMode();
	}

	/** Applies the J2ME "Theme" setting and keeps following changes. Safe to call many times. */
	public static synchronized void applyNightMode() {
		if (instance == null) {
			return;
		}
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(instance);
		if (!nightListenerRegistered) {
			sp.registerOnSharedPreferenceChangeListener(themeListener);
			nightListenerRegistered = true;
		}
		setNightMode(sp.getString(Constants.PREF_THEME, null));
		AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
	}

	@NonNull
	public static String getProcessName() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
			return Application.getProcessName();
		} else {
			return FileUtils.getText("/proc/self/cmdline").trim();
		}
	}

	@SuppressLint("PackageManagerGetSignatures")
	private static boolean isSignatureValid(Application app) {
		try {
			Signature[] signatures;
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
				PackageInfo info = app.getPackageManager()
						.getPackageInfo(app.getPackageName(), PackageManager.GET_SIGNING_CERTIFICATES);
				signatures = info.signingInfo.getApkContentsSigners();
			} else {
				PackageInfo info = app.getPackageManager()
						.getPackageInfo(app.getPackageName(), PackageManager.GET_SIGNATURES);
				signatures = info.signatures;
			}
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			for (Signature signature : signatures) {
				md.update(signature.toByteArray());
				String sha1 = String.format("%032X", new BigInteger(1, md.digest()));
				if (Arrays.asList(VALID_SIGNATURES).contains(sha1)) {
					return true;
				}
			}
		} catch (PackageManager.NameNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return false;
	}

	static void setNightMode(String theme) {
		if (theme == null) {
			theme = instance.getString(R.string.pref_theme_default);
		}
		switch (theme) {
			case "light":
				AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
				break;
			case "dark":
				AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
				break;
			case "auto-battery":
				AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY);
				break;
			case "auto-time":
				//noinspection deprecation
				AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_TIME);
				break;
			default:
			case "system":
				AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
				break;
		}
	}
}
