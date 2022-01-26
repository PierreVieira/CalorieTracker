package com.example.util.domain.model

enum class Gender {
    MALE,
    FEMALE;

    companion object {
        fun fromString(name: String): Gender {
            return values().firstOrNull { it.name == name }
                ?: throw IllegalStateException("Name not found")
        }
    }
}
