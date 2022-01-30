package com.example.calorietracker.di

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.example.util.data.preferences.DefaultUserPreferences
import com.example.util.domain.preferences.UserPreferences
import com.example.util.domain.use_case.filter_out.FilterIntOutDigits
import com.example.util.domain.use_case.filter_out.float_digits.*
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
    fun providePreferences(sharedPreferences: SharedPreferences): UserPreferences =
        DefaultUserPreferences(sharedPreferences)

    @Provides
    @Singleton
    fun providesHaveMoreOnePoint(): HaveMoreOnePoint = HaveMoreOnePoint()

    @Provides
    @Singleton
    fun providesFilterIntOutDigitsUseCase(): FilterIntOutDigits = FilterIntOutDigits()

    @Provides
    @Singleton
    fun providesIsPointSeparator(): IsPointSeparator = IsPointSeparator()

    @Provides
    @Singleton
    fun providesFilterFloatOutDigitsUseCase(
        isPointSeparator: IsPointSeparator,
        removeLastPoint: RemoveLastPoint,
        haveMoreOnePoint: HaveMoreOnePoint
    ): FilterFloatOutDigits =
        FilterFloatOutDigits(
            mapCommaToPoint = MapCommaToPoint(),
            isPointSeparator = isPointSeparator,
            haveMoreOnePoint = haveMoreOnePoint,
            removeLastPoint = removeLastPoint
        )
}