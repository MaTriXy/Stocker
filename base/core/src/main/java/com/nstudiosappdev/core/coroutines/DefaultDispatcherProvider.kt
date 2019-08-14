package com.nstudiosappdev.core.coroutines

import kotlinx.coroutines.Dispatchers

class DefaultDispatcherProvider : DispatcherProvider {

    private val main = Dispatchers.Main
    private val ui = Dispatchers.Main
    private val io = Dispatchers.IO
    private val default = Dispatchers.Default

    override fun main() = main

    override fun ui() = ui

    override fun io() = io

    override fun default() = default
}