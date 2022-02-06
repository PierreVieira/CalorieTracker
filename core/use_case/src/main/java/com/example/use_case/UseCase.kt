package com.example.use_case

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Use case that has exactly 1 input parameter and a return
 */

abstract class UseCase<in INPUT, out OUTPUT>(
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default
) {

    suspend operator fun invoke(params: INPUT): OUTPUT = withContext(dispatcher) {
        execute(params)
    }

    abstract suspend fun execute(params: INPUT): OUTPUT
}