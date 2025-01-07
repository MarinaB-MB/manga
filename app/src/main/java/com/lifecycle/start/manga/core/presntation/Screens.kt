package com.lifecycle.start.manga.core.presntation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.lifecycle.start.manga.features.top.presentation.MangaTopFragment

object Screens {
    fun Top() = FragmentScreen { MangaTopFragment.newInstance() }
}