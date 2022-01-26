package com.example.core.data.preferences

import android.content.SharedPreferences
import com.example.core.domain.model.ActivityLevel
import com.example.core.domain.model.Gender
import com.example.core.domain.model.GoalType
import com.example.core.domain.model.UserInfo
import com.example.core.domain.preferences.Preferences
import javax.inject.Inject

class DefaultPreferences @Inject constructor(
    private val sharedPref: SharedPreferences
) : Preferences {
    private val editor = sharedPref.edit()
    override fun saveGender(gender: Gender) {
        editor.putString(Preferences.KEY_GENDER, gender.name).apply()
    }

    override fun saveAge(age: Int) {
        editor.putInt(Preferences.KEY_AGE, age).apply()
    }

    override fun saveWeight(weight: Float) {
        editor.putFloat(Preferences.KEY_WEIGHT, weight).apply()
    }

    override fun saveHeight(height: Int) {
        editor.putInt(Preferences.KEY_HEIGHT, height).apply()
    }

    override fun saveActivityLevel(level: ActivityLevel) {
        editor.putString(Preferences.KEY_ACTIVITY_LEVEL, level.name)
    }

    override fun saveGoalType(goalType: GoalType) {
        editor.putString(Preferences.KEY_GOAL_TYPE, goalType.name)
    }

    override fun saveCarbRatio(carbRatio: Float) {
        editor.putFloat(Preferences.KEY_CARB_RATIO, carbRatio)
    }

    override fun saveProteinRatio(proteinRatio: Float) {
        editor.putFloat(Preferences.KEY_PROTEIN_RATIO, proteinRatio)
    }

    override fun saveFatRatio(fatRatio: Float) {
        editor.putFloat(Preferences.KEY_FAT_RATIO, fatRatio)
    }

    override fun loadUserInfo(): UserInfo {
        val gender = Gender.fromString(getString(Preferences.KEY_AGE))
        val age = getInt(Preferences.KEY_AGE)
        val weight = getFloat(Preferences.KEY_WEIGHT)
        val height = getInt(Preferences.KEY_HEIGHT)
        val activityLevel = ActivityLevel.fromString(getString(Preferences.KEY_ACTIVITY_LEVEL))
        val goalType = GoalType.fromString(getString(Preferences.KEY_GOAL_TYPE))
        val carbRatio = getFloat(Preferences.KEY_CARB_RATIO)
        val proteinRatio = getFloat(Preferences.KEY_PROTEIN_RATIO)
        val fatRatio = getFloat(Preferences.KEY_FAT_RATIO)
        return UserInfo(
            gender = gender,
            age = age,
            weight = weight,
            height = height,
            activityLevel = activityLevel,
            goalType = goalType,
            carbRatio = carbRatio,
            proteinRatio = proteinRatio,
            fatRatio = fatRatio
        )
    }

    private fun getInt(key: String): Int = sharedPref.getInt(key, -1)
    private fun getFloat(key: String): Float = sharedPref.getFloat(key, -1f)
    private fun getString(key: String): String = sharedPref.getString(key, "") ?: ""
}