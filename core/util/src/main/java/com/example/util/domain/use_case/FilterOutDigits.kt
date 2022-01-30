package com.example.util.domain.use_case

class FilterOutDigits {

    operator fun invoke(text: String, maxValue: Int? = null): String {
        val value = text.filter { it.isDigit() }.toIntOrNull()
        return value?.let {
            if (maxValue == null || it <= maxValue) {
                "$it"
            } else {
                "$maxValue"
            }
        } ?: ""
    }
}