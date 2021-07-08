package com.example.mobiledeviceprogramming.presentation.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.mobiledeviceprogramming.R

private val TAB_TITLES = arrayOf(
    R.string.tab_tv,
    R.string.tab_movie
)

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return if (position == 0) {
            TabFragment.withData("TV")
        } else {
            TabFragment.withData("Movie")
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int = TAB_TITLES.size
}