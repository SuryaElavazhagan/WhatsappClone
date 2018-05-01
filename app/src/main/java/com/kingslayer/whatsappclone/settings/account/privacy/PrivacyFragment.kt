package com.kingslayer.whatsappclone.settings.account.privacy

import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.preference.ListPreference
import android.support.v7.preference.Preference
import android.support.v7.preference.PreferenceFragmentCompat
import android.util.Log
import com.kingslayer.whatsappclone.R

class PrivacyFragment : PreferenceFragmentCompat(), SharedPreferences.OnSharedPreferenceChangeListener {

    val TAG = "PRIVACY_FRAGMENT"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preferenceScreen.sharedPreferences.registerOnSharedPreferenceChangeListener(this@PrivacyFragment)
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {

        addPreferencesFromResource(R.xml.pref_privacy)

        for (i in 0..(preferenceScreen.preferenceCount - 1))
        {
            val p = preferenceScreen.getPreference(i)
            setPreferenceSummary(p, preferenceScreen.sharedPreferences.getString(p.key, ""))
        }

    }

    /*
        setPreferenceSummary() is used to set Summary for listPreferences.
        @param preference is used to specify the preference
        @param value is used to specify the value associated with the preference
     */
    fun setPreferenceSummary(preference : Preference, value : String)
    {
        val listPreference = preference as ListPreference
        val index = listPreference.findIndexOfValue(value)
        Log.i(TAG, "setSummary called, $value")
        if(index >= 0)
        {
            Log.i(TAG, "Summary changed")
            listPreference.summary = listPreference.entries[index]
        }
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        val preference = findPreference(key)
        Log.i(TAG, "onSharedPreferenceChanged triggered")
        if(preference != null)
        {
            // Setting summary after preference is changed
            Log.i(TAG, "Preferece changed and Summary is set.")
            setPreferenceSummary(preference, sharedPreferences?.getString(preference.key, "")!!)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        preferenceScreen.sharedPreferences.unregisterOnSharedPreferenceChangeListener(this@PrivacyFragment)
    }
}