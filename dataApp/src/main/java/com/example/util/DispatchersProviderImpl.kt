package com.example.util

import com.example.domainapp.util.DispatchersProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.MainCoroutineDispatcher

/**
 * Created by Ali Asadi on 13/05/2020
 **/
class DispatchersProviderImpl(
    override val io: CoroutineDispatcher,
    override val main: MainCoroutineDispatcher,
    override val default: CoroutineDispatcher
) : DispatchersProvider