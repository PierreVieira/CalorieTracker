package com.example.calorietracker.di

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.example.util.data.preferences.DefaultPreferences
import com.example.util.domain.preferences.Preferences
import com.example.util.domain.use_case.FilterOutDigits
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(app: Application): SharedPreferences =
        app.getSharedPreferences("shared_pref", MODE_PRIVATE)

    @Provides
    @Singleton
    fun providePreferences(sharedPreferences: SharedPreferences): Preferences =
        DefaultPreferences(sharedPreferences)

    @Provides
    @Singleton
    fun providesFilterOutDigitsUseCase(): FilterOutDigits = FilterOutDigits()
}