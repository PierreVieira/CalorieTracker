package com.example.util.domain.use_case.filter_out.float_digits

import com.example.util.domain.use_case.filter_out.FilterOutDigits
import javax.inject.Inject

class FilterFloatOutDigits @Inject constructor(
    private val mapCommaToPoint: MapCommaToPoint,
    private val isPointSeparator: IsPointSeparator,
    private val haveMoreOnePoint: HaveMoreOnePoint,
    private val removeLastPoint: RemoveLastPoint,
) : FilterOutDigits() {

    override suspend fun execute(params: String): String {
        val filteredText = mapCommaToPoint(params).filter {
            it.isDigit() || isPointSeparator(it)
        }
        return if (haveMoreOnePoint(filteredText)) removeLastPoint(filteredText) else filteredText
    }
}