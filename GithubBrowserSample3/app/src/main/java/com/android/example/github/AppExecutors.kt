package com.android.example.github

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2019/3/5 6:28 PM
 **/
@Singleton
open class AppExecutors(
        private val diskIO: Executor,
        private val networkIO: Executor,
        private val mainThread: Executor) {

    @Inject
    constructor() : this(
            Executors.newSingleThreadExecutor(),
            Executors.newFixedThreadPool(3),
            MainThreadExecutor()
    )

    fun diskIO(): Executor {
        return diskIO
    }

    fun networkIO(): Executor {
        return networkIO
    }

    fun mainThread(): Executor {
        return mainThread
    }

    private class MainThreadExecutor : Executor {
        override fun execute(command: Runnable) {
            mainThreadHandler.post(command)
        }

        private val mainThreadHandler = Handler(Looper.getMainLooper())


    }


}