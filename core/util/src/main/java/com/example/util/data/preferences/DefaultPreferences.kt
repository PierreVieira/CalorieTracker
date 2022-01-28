package com.example.util.data.preferences

import android.content.SharedPreferences
import com.example.util.domain.model.ActivityLevel
import com.example.util.domain.model.Gender
import com.example.util.domain.model.GoalType
import com.example.util.domain.model.UserInfo
import com.example.util.domain.preferences.Preferences
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

    override fun getAge(): Int = getInt(
        key = Preferences.KEY_AGE,
        defaultValue = Preferences.DEFAULT_AGE
    )


    override fun getGender(): Gender = Gender.fromString(
        getString(
            key = Preferences.KEY_GENDER,
            defaultValue = Preferences.defaultGender.name
        )
    )

    override fun getHeight(): Int = getInt(
        key = Preferences.KEY_HEIGHT,
        defaultValue = Preferences.DEFAULT_HEIGHT
    )


    override fun loadUserInfo(): UserInfo {
        val gender = getGender()
        val age = getAge()
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

    private fun getInt(key: String, defaultValue: Int = -1): Int =
        sharedPref.getInt(key, defaultValue)

    private fun getFloat(key: String, defaultValue: Float = -1f): Float =
        sharedPref.getFloat(key, defaultValue)

    private fun getString(key: String, defaultValue: String = ""): String =
        sharedPref.getString(key, defaultValue) ?: defaultValue
}