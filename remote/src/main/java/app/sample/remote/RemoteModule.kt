package app.sample.remote

import app.sample.remote.services.ComicService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import javax.inject.Named
import javax.inject.Singleton

@Module
object RemoteModule {
    private const val BASE_URL = "https://gateway.marvel.com/"

    @JvmStatic
    @Singleton
    @Provides
    fun provideOkHttpClient(
        @Named("cache") cacheDir: File,
        @Named("stetho") interceptor: Interceptor,
        @Named("apiPublicKey") pubicKey: String
    ): OkHttpClient {
        val builder = OkHttpClient().newBuilder()
        builder.apply {
            addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            addNetworkInterceptor(interceptor)
            cache(Cache(File(cacheDir, "remote_cache"), 10 * 1024 * 1024))
            addInterceptor { chain ->
                val request = chain.request()
                val url = request.url.newBuilder()
                        .addQueryParameter("apikey", pubicKey)
                        .build()
                chain.proceed(request.newBuilder().url(url).build())
            }
        }
        return builder.build()
    }

    @JvmStatic
    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .client(client)
                .baseUrl(BASE_URL)
                .build()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideComicService(retrofit: Retrofit): ComicService = retrofit.create(ComicService::class.java)
}