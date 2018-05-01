package com.kingslayer.whatsappclone.settings.datastorage

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.MultiSelectListPreference
import android.support.v7.preference.PreferenceFragmentCompat
import com.kingslayer.whatsappclone.R

class DataStorageSettingsFragment : PreferenceFragmentCompat(), SharedPreferences.OnSharedPreferenceChangeListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preferenceScreen.sharedPreferences.registerOnSharedPreferenceChangeListener(this@DataStorageSettingsFragment)
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.pref_data_and_storage)

        for (i in 0..(preferenceScreen.preferenceCount - 1))
        {
            val p = preferenceScreen.getPreference(i)
            if(p is MultiSelectListPreference)
                setPreferenceSummary(p, preferenceScreen.sharedPreferences?.getStringSet(resources.getString(R.string.mobile_data_key), setOf("No media"))!!)
        }
    }

    fun setPreferenceSummary(preferece: MultiSelectListPreference, value: MutableSet<String>)
    {
        val summaryString = StringBuffer()
        value.forEach {
            summaryString.append(it)
        }
        preferece.summary = summaryString.toString()
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {

        if(sharedPreferences is MultiSelectListPreference)
        {
            setPreferenceSummary(sharedPreferences, sharedPreferences.getStringSet(key, setOf("No media")))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        preferenceScreen.sharedPreferences.unregisterOnSharedPreferenceChangeListener(this)
    }
}

class DataStorageSettingsFragmentTwo : PreferenceFragmentCompat(){

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.pref_data_and_storage_two)
    }
}