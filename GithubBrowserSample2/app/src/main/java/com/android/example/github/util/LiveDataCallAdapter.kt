package com.android.example.github.util

import androidx.lifecycle.LiveData
import com.android.example.github.api.ApiResponse
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type
import java.util.concurrent.atomic.AtomicBoolean

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm19930215@163.com
 * @since 2018/10/19 上午9:31
 **/
class LiveDataCallAdapter<R>(private val responseType: Type):
        CallAdapter<R, LiveData<ApiResponse<R>>>{
    override fun adapt(call: Call<R>): LiveData<ApiResponse<R>> {
        return object : LiveData<ApiResponse<R>>(){
            private var started = AtomicBoolean(false)
            override fun onActive() {
                super.onActive()
                if(started.compareAndSet(false,true)){
                    call.enqueue(object : Callback<R> {
                        override fun onResponse(call: Call<R>, response: Response<R>) {
                            postValue(ApiResponse.create(response))
                        }

                        override fun onFailure(call: Call<R>, t: Throwable) {
                            postValue(ApiResponse.create(t))
                        }
                    })
                }
            }
        }
    }

    override fun responseType()= responseType


}
