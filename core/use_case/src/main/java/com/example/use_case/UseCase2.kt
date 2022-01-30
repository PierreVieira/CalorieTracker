package com.example.use_case

import kotlinx.coroutines.CoroutineDispatcher

/**
 * Use case that has exactly 2 input parameters and a return
 */

abstract class UseCase2<in INPUT1, in INPUT2, out OUTPUT>(
    private val dispatcher: CoroutineDispatcher
) : UseCase<Pair<INPUT1, INPUT2>, OUTPUT>(dispatcher) {

    override suspend fun execute(params: Pair<INPUT1, INPUT2>): OUTPUT =
        execute(firtsParam = params.first, secondParam = params.second)

    abstract suspend fun execute(firtsParam: INPUT1, secondParam: INPUT2): OUTPUT
}