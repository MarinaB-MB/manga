package com.lifecycle.start.manga.core.presntation

import androidx.lifecycle.ViewModel
import com.lifecycle.start.manga.core.domain.Dispatchers

abstract class BaseViewModel(
    private val dispatchers: Dispatchers
) : ViewModel()