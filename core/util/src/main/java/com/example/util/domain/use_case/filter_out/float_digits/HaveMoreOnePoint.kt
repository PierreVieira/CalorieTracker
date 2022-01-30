package com.example.util.domain.use_case.filter_out.float_digits

import com.example.use_case.UseCase
import kotlinx.coroutines.Dispatchers

class HaveMoreOnePoint : UseCase<String, Boolean>(Dispatchers.Default) {
    companion object {
        private const val POINT_SEPARATOR = '.'
        private const val MAX_SEPARATOR = 1
    }

    override suspend fun execute(params: String): Boolean =
        params.count { it == POINT_SEPARATOR } > MAX_SEPARATOR
}