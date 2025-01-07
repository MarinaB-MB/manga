package com.lifecycle.start.manga.di

import com.lifecycle.start.manga.core.domain.Dispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CoreModule {

    @Provides
    @Singleton
    fun bindDispatchers(): Dispatchers {
        return Dispatchers.Base()
    }
}