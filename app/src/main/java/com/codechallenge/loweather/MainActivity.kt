package com.codechallenge.loweather

import android.os.Bundle
import com.codechallenge.loweather.base.BaseActivity
import com.codechallenge.loweather.ui.searchresult.SearchFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    override val layoutResourceId: Int get() = R.layout.main_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, SearchFragment())
                    .addToBackStack(null)
                    .commit()
        }
    }
}