package com.jskhaleel.navsample.di

import android.content.Context
import com.jskhaleel.navsample.data.source.local.NavDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePreference(@ApplicationContext context: Context): NavDataStore {
        return NavDataStore(context)
    }
}