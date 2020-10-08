package com.kme.kaltura.kmesdk.rest

import com.kme.kaltura.kmesdk.prefs.IKmePreferences
import com.kme.kaltura.kmesdk.prefs.KmePrefsKeys
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class KmeTokenInterceptor(
    private val kmePreferences: IKmePreferences
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request: Request = chain.request()
        val token = kmePreferences.getString(KmePrefsKeys.ACCESS_TOKEN, "")
        if (!token.isNullOrEmpty()) {
            val url: HttpUrl = request.url.newBuilder().addQueryParameter("access-token", token).build()
            request = request.newBuilder().url(url).build();
        }
        return chain.proceed(request)
    }

}
