package com.ynov.projectfragment.adapter.onglet

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ynov.projectfragment.views.JobFragment
import com.ynov.projectfragment.views.Fragment2
import com.ynov.projectfragment.views.Fragment3

class ViewPagerAdapter(supportFragmentManager: FragmentManager) :
    FragmentPagerAdapter(supportFragmentManager) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> JobFragment()
            1 -> Fragment2()
            2 -> Fragment3()
            else -> JobFragment()
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Job"
            1 -> "Monstre"
            2 -> "ville"
            else -> null
        }
    }
}
