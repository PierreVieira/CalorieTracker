package com.example.util.domain.use_case.filter_out

class FilterIntOutDigits : FilterOutDigits() {

    override suspend fun execute(params: String): String = "${textToValue(params) ?: ""}"

    private fun textToValue(text: String): Int? = text.filter { it.isDigit() }.toIntOrNull()
}