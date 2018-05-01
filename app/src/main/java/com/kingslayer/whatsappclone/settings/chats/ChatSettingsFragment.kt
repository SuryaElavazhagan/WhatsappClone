package com.kingslayer.whatsappclone.settings.chats

import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.preference.ListPreference
import android.support.v7.preference.Preference
import android.support.v7.preference.PreferenceFragmentCompat
import android.util.Log
import com.kingslayer.whatsappclone.R

class ChatSettingsFragment : PreferenceFragmentCompat(), SharedPreferences.OnSharedPreferenceChangeListener {

    val TAG = "CHAT_FRAGMENT"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preferenceScreen.sharedPreferences.registerOnSharedPreferenceChangeListener(this@ChatSettingsFragment)
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.pref_chat)

        for (i in 0..(preferenceScreen.preferenceCount - 1))
        {
            val p = preferenceScreen.getPreference(i)
            if(p is ListPreference)
                setPreferenceSummary(p, preferenceScreen.sharedPreferences.getString(p.key, ""))
        }
    }

    fun setPreferenceSummary(preference : Preference, value : String)
    {
        val listPreference = preference as ListPreference
        val index = listPreference.findIndexOfValue(value)
        if(index >= 0)
        {
            Log.i(TAG, "Summary changed")
            listPreference.summary = listPreference.entries[index]
        }
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        val preference = findPreference(key)

        if(preference != null)
        {
            // Setting summary after preference is changed
            Log.i(TAG, "Preferece changed and Summary is set.")
            setPreferenceSummary(preference, sharedPreferences?.getString(preference.key, "")!!)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        preferenceScreen.sharedPreferences.unregisterOnSharedPreferenceChangeListener(this@ChatSettingsFragment)
    }
}