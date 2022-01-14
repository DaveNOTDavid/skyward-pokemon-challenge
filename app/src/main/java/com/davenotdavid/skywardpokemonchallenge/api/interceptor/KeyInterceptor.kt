package com.davenotdavid.skywardpokemonchallenge.api.interceptor

import com.davenotdavid.skywardpokemonchallenge.BuildConfig
import com.davenotdavid.skywardpokemonchallenge.api.HEADER_API_KEY
import okhttp3.Interceptor
import okhttp3.Response

class KeyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain) : Response {
        val request = chain.request().newBuilder()
            .header(HEADER_API_KEY, BuildConfig.API_KEY)
            .build()
        return chain.proceed(request)
    }

}
