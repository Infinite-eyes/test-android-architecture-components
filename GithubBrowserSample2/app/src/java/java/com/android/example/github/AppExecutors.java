package com.android.example.github;

import android.os.Handler;
import android.os.Looper;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import androidx.annotation.NonNull;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/10/29 9:29 AM
 **/
@Singleton
public class AppExecutors {

    private final Executor diskIO;
    private final Executor networkIO;
    private final Executor mainThread;

    @NotNull
    public final Executor diskIO() {
        return this.diskIO;
    }

    @NotNull
    public final Executor networkIO() {
        return this.networkIO;
    }

    @NotNull
    public final Executor mainThread() {
        return this.mainThread;
    }

    public AppExecutors(@NotNull Executor diskIO,@NotNull Executor networkIO,@NotNull Executor mainThread){
        super();
        this.diskIO = diskIO;
        this.networkIO = networkIO;
        this.mainThread = mainThread;
    }




    public static class MainThreadExecutor implements Executor {
        private Handler mainThreadHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(@NonNull Runnable command) {
            mainThreadHandler.post(command);
        }
    }


}
