package com.example.util.domain.use_case.filter_out.float_digits

import com.example.use_case.UseCase
import kotlinx.coroutines.Dispatchers

class MapCommaToPoint : UseCase<String, String>(
    Dispatchers.Default
) {

    companion object {
        private const val POINT_SEPARATOR = '.'
        private const val COMMA_SEPARATOR = ','
    }

    override suspend fun execute(params: String): String =
        params.replace(COMMA_SEPARATOR, POINT_SEPARATOR)
}