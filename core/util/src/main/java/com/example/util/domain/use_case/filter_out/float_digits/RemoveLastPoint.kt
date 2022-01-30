package com.example.util.domain.use_case.filter_out.float_digits

import com.example.use_case.UseCase
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class RemoveLastPoint @Inject constructor(
    private val isPointSeparator: IsPointSeparator,
    private val haveMoreOnePoint: HaveMoreOnePoint,
) : UseCase<String, String>(Dispatchers.Default) {

    companion object {
        private const val POINT_SEPARATOR = '.'
    }

    override suspend fun execute(params: String): String {
        var filtered = ""
        val lastPointIndex = params.indexOfLast { it == POINT_SEPARATOR }
        for (i in params.indices) {
            if (i != lastPointIndex) {
                filtered += params[i]
            }
        }
        return filtered
    }
}