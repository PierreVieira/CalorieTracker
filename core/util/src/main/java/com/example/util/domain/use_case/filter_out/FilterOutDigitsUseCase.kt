package com.example.util.domain.use_case.filter_out

import com.example.use_case.UseCase
import kotlinx.coroutines.Dispatchers

abstract class FilterOutDigitsUseCase : UseCase<String, String>(Dispatchers.Default)