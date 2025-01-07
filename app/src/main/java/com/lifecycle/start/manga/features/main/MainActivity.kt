package com.lifecycle.start.manga.features.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Replace
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.lifecycle.start.manga.R
import com.lifecycle.start.manga.core.presntation.Screens
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val navigator: Navigator = object : AppNavigator(this, R.id.main_container) {

        override fun applyCommands(commands: Array<out Command>) {
            super.applyCommands(commands)
            supportFragmentManager.executePendingTransactions()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.layout_main_activity)

        if (savedInstanceState == null) {
            navigator.applyCommands(arrayOf<Command>(Replace(Screens.Top())))
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}

