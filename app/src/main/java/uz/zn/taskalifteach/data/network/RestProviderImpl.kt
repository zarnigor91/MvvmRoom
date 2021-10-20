package uz.zn.taskalifteach.data.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.zn.taskalifteach.data.network.exception.error.ServerExceptionHandler
import uz.zn.taskalifteach.data.network.exception.error.ServerExceptionMapper
import uz.zn.taskalifteach.data.network.exception.interceptor.withHttpErrorDispatcher
import uz.zn.taskalifteach.data.network.retrofit.adapter.FlowCallAdapterFactory
import uz.zn.taskalifteach.data.service.PostApi

import java.util.concurrent.TimeUnit

class RestProviderImpl : RestProvider {

        private  val authInterceptor = Interceptor { chain ->
            val original = chain.request()
            // Request customization: add request headers
            val requestBuilder = original.newBuilder()
            val url = original.url.newBuilder()
//                .addQueryParameter("access_token", preferencesUtil.getAcsessToken())
                .build()

            val request = requestBuilder
//                .header("Authorization", Credentials.basic("terminal", "YRZ25V=m-u"))
                .url(url)
                .build()
            chain.proceed(request)
        }

       private val okHttpClientBuilder: OkHttpClient.Builder =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor())
            .withHttpErrorDispatcher(ServerExceptionHandler(), ServerExceptionMapper())
//            .retryOnConnectionFailure(false)
//            .followRedirects(false)
//            .followSslRedirects(false)
            .connectTimeout(CONNECTION_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .readTimeout(CONNECTION_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .writeTimeout(CONNECTION_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .addInterceptor(authInterceptor)


    private val retrofit: Retrofit by lazy {
        @Suppress("EXPERIMENTAL_API_USAGE")
        return@lazy Retrofit.Builder()
//            .baseUrl(ConstantsApiPath.BASE_URL_AUTH)
            .baseUrl("https://guidebook.com/service/v2/")
            .client(okHttpClientBuilder.build())
            .addCallAdapterFactory(FlowCallAdapterFactory)
//
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }


    override val postApi: PostApi =
        retrofit.create(PostApi::class.java)

    private companion object {
        const val CONNECTION_TIMEOUT_SECONDS: Long = 60
    }
}