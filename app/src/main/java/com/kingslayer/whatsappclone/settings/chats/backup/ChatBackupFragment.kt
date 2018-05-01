package com.kingslayer.whatsappclone.settings.chats.backup

import android.os.Bundle
import android.support.v7.preference.PreferenceFragmentCompat
import com.kingslayer.whatsappclone.R

class ChatBackupFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.pref_google_drive)
    }
}