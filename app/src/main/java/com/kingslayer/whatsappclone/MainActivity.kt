package com.kingslayer.whatsappclone

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
import com.kingslayer.whatsappclone.call.CallFragment
import com.kingslayer.whatsappclone.camera.CameraFragment
import com.kingslayer.whatsappclone.chats.ChatFragment
import com.kingslayer.whatsappclone.settings.SettingsActivity
import com.kingslayer.whatsappclone.status.StatusFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        // Set up the ViewPager with the sections adapter.
        container.adapter = mSectionsPagerAdapter

        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))
        container.setCurrentItem(1, false)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        if (id == R.id.action_settings) {
            startActivity(Intent(this@MainActivity, SettingsActivity::class.java))
        }

        return super.onOptionsItemSelected(item)
    }


    /**
     * A [FragmentPagerAdapter] that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {

            var fragment  = Fragment()
            var flag : Int = WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN
            when(position) {
                0 ->
                {
                    flag = WindowManager.LayoutParams.FLAG_FULLSCREEN
                    fragment = CameraFragment()
                }
                1 ->
                {
                    flag = WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN
                    fragment = ChatFragment()
                }
                2 ->
                {
                    flag = WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN
                    fragment = StatusFragment()
                }
                3 ->
                {
                    flag = WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN
                    fragment = CallFragment()
                }
            }

            this@MainActivity.window.addFlags(flag)
            return fragment
        }

        override fun getCount(): Int {
            // Show 4 total pages.
            return 4
        }
    }

    /*class PlaceholderFragment : Fragment() {

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {
            val rootView = inflater.inflate(R.layout.fragment_main, container, false)
            rootView.section_label.text = "${rootView.section_label.text} \n ${getString(R.string.section_format, arguments?.getInt(ARG_SECTION_NUMBER))}"
            return rootView
        }

        companion object {
            *//**
             * The fragment argument representing the section number for this
             * fragment.
             *//*
            private val ARG_SECTION_NUMBER = "section_number"

            *//**
             * Returns a new instance of this fragment for the given section
             * number.
             *//*
            fun newInstance(sectionNumber: Int): PlaceholderFragment {
                val fragment = PlaceholderFragment()
                val args = Bundle()
                args.putInt(ARG_SECTION_NUMBER, sectionNumber)
                fragment.arguments = args
                return fragment
            }
        }
    }*/
}
