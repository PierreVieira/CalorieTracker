package com.example.core.domain.model

enum class GoalType {
    LOSE_WEIGHT,
    KEEP_WEIGHT,
    GAIN_WEIGHT;

    companion object {
        fun fromString(name: String): GoalType {
            return values().firstOrNull { it.name == name }
                ?: throw IllegalStateException("Goal type not found")
        }
    }
}
