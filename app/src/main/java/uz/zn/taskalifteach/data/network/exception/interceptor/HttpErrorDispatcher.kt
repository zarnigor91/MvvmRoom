package uz.zn.taskalifteach.data.network.exception.interceptor

import okhttp3.OkHttpClient
import uz.zn.guidebook.data.network.exception.interceptor.HttpErrorDispatcherComponent
import uz.zn.guidebook.data.network.exception.interceptor.HttpErrorResponseHandler
import uz.zn.guidebook.data.network.exception.interceptor.HttpErrorResponseMapper

internal fun OkHttpClient.Builder.withHttpErrorDispatcher(
    vararg components: HttpErrorDispatcherComponent
): OkHttpClient.Builder = addInterceptor(
    HttpErrorDispatcherInterceptor.Companion.Builder()
        .setResponseHandlers(
            *components.filterIsInstance<HttpErrorResponseHandler>().toTypedArray()
        )
        .setResponseMappers(*components.filterIsInstance<HttpErrorResponseMapper>().toTypedArray())
        .build()
)