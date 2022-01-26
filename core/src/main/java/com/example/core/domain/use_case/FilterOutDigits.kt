package com.example.core.domain.use_case

class FilterOutDigits {

    operator fun invoke(text: String, maxValue: Int? = null): String {
        val valueText = text.filter { it.isDigit() }.toIntOrNull()
        return valueText?.let {
            if (maxValue == null || it <= maxValue) {
                "$it"
            } else {
                "$maxValue"
            }
        } ?: ""
    }
}