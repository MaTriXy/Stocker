package com.nstudiosappdev.stocker.dashboard.presentation

import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.nstudiosappdev.core.presentation.TabProvider
import com.nstudiosappdev.core.presentation.base.ActionModeListener
import com.nstudiosappdev.core.presentation.base.BaseFragment
import com.nstudiosappdev.stocker.presentation.R
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : BaseFragment() {

    private var lastItem: Int = 0

    private lateinit var pagerAdapter: DashboardPagerAdapter

    override fun getLayoutRes(): Int = R.layout.fragment_dashboard

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pagerAdapter = DashboardPagerAdapter(
            resources.getStringArray(R.array.main_items).toMutableList(),
            childFragmentManager
        )

        viewPagerCurrencies.apply {
            adapter = pagerAdapter
            addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

                override fun onPageScrollStateChanged(state: Int) {
                    // no-op
                }

                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                    // no-op
                }

                override fun onPageSelected(position: Int) {
                    (pagerAdapter.fragments[lastItem] as? ActionModeListener)?.stopActionMode()
                    lastItem = position
                }

            })
            offscreenPageLimit = 3

            (activity as TabProvider).provideTabLayout().setupWithViewPager(viewPagerCurrencies)
            lastItem = viewPagerCurrencies.currentItem

        }

    }
}