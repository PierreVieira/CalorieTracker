package com.example.util.data.preferences

import android.content.SharedPreferences
import com.example.util.domain.model.ActivityLevel
import com.example.util.domain.model.Gender
import com.example.util.domain.model.GoalType
import com.example.util.domain.model.UserInfo
import com.example.util.domain.preferences.UserPreferences
import javax.inject.Inject

class DefaultUserPreferences @Inject constructor(
    private val sharedPref: SharedPreferences
) : UserPreferences {
    private val editor = sharedPref.edit()
    override fun saveGender(gender: Gender) {
        editor.putString(UserPreferences.KEY_GENDER, gender.name).apply()
    }

    override fun saveAge(age: Int) {
        editor.putInt(UserPreferences.KEY_AGE, age).apply()
    }

    override fun saveWeight(weight: Float) {
        editor.putFloat(UserPreferences.KEY_WEIGHT, weight).apply()
    }

    override fun saveHeight(height: Int) {
        editor.putInt(UserPreferences.KEY_HEIGHT, height).apply()
    }

    override fun saveActivityLevel(level: ActivityLevel) {
        editor.putString(UserPreferences.KEY_ACTIVITY_LEVEL, level.name)
    }

    override fun saveGoalType(goalType: GoalType) {
        editor.putString(UserPreferences.KEY_GOAL_TYPE, goalType.name)
    }

    override fun saveCarbRatio(carbRatio: Float) {
        editor.putFloat(UserPreferences.KEY_CARB_RATIO, carbRatio)
    }

    override fun saveProteinRatio(proteinRatio: Float) {
        editor.putFloat(UserPreferences.KEY_PROTEIN_RATIO, proteinRatio)
    }

    override fun saveFatRatio(fatRatio: Float) {
        editor.putFloat(UserPreferences.KEY_FAT_RATIO, fatRatio)
    }

    override fun getAge(): Int = getInt(
        key = UserPreferences.KEY_AGE,
        defaultValue = UserPreferences.DEFAULT_AGE
    )


    override fun getGender(): Gender = Gender.fromString(
        getString(
            key = UserPreferences.KEY_GENDER,
            defaultValue = UserPreferences.defaultGender.name
        )
    )

    override fun getHeight(): Int = getInt(
        key = UserPreferences.KEY_HEIGHT,
        defaultValue = UserPreferences.DEFAULT_HEIGHT
    )

    override fun getWeight(): Float = getFloat(
        key = UserPreferences.KEY_WEIGHT,
        defaultValue = UserPreferences.DEFAULT_WEIGHT
    )

    override fun loadUserInfo(): UserInfo {
        val gender = getGender()
        val age = getAge()
        val weight = getFloat(UserPreferences.KEY_WEIGHT)
        val height = getInt(UserPreferences.KEY_HEIGHT)
        val activityLevel = ActivityLevel.fromString(getString(UserPreferences.KEY_ACTIVITY_LEVEL))
        val goalType = GoalType.fromString(getString(UserPreferences.KEY_GOAL_TYPE))
        val carbRatio = getFloat(UserPreferences.KEY_CARB_RATIO)
        val proteinRatio = getFloat(UserPreferences.KEY_PROTEIN_RATIO)
        val fatRatio = getFloat(UserPreferences.KEY_FAT_RATIO)
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