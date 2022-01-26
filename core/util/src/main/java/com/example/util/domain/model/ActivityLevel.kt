package com.example.util.domain.model

enum class ActivityLevel {
    LOW,
    MEDIUM,
    HIGH;

    companion object {
        fun fromString(name: String): ActivityLevel {
            return values().firstOrNull { it.name == name }
                ?: throw IllegalStateException("Activity level not found")
        }
    }
}
