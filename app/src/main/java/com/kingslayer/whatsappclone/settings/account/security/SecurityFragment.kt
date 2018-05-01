package com.kingslayer.whatsappclone.settings.account.security

import android.os.Bundle
import android.support.v7.preference.PreferenceFragmentCompat
import com.kingslayer.whatsappclone.R

class SecurityFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.pref_security)
    }

}