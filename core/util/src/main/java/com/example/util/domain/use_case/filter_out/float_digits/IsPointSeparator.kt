package com.example.util.domain.use_case.filter_out.float_digits

import com.example.use_case.UseCase
import kotlinx.coroutines.Dispatchers

class IsPointSeparator: UseCase<Char, Boolean>(Dispatchers.Default) {
    companion object {
        private const val POINT_SEPARATOR = '.'
    }
    override suspend fun execute(params: Char): Boolean = params == POINT_SEPARATOR
}