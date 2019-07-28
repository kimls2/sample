package app.sample.inject

import android.content.Context
import app.sample.BuildConfig
import app.sample.SampleApplication
import app.sample.util.AppCoroutineDispatchers
import app.sample.util.AppRxSchedulers
import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.rx2.asCoroutineDispatcher
import okhttp3.Interceptor
import java.io.File
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [
    AppModuleBinds::class
])
object AppModule {
    @JvmStatic
    @Provides
    fun provideContext(application: SampleApplication): Context = application.applicationContext

    @JvmStatic
    @Singleton
    @Provides
    fun provideRxSchedulers(): AppRxSchedulers = AppRxSchedulers(
            io = Schedulers.io(),
            computation = Schedulers.computation(),
            main = AndroidSchedulers.mainThread()
    )

    @JvmStatic
    @Singleton
    @Provides
    fun provideCoroutineDispatchers(schedulers: AppRxSchedulers) = AppCoroutineDispatchers(
            io = schedulers.io.asCoroutineDispatcher(),
            computation = schedulers.computation.asCoroutineDispatcher(),
            main = Dispatchers.Main
    )

    @JvmStatic
    @Provides
    @Singleton
    @Named("cache")
    fun provideCacheDir(application: SampleApplication): File = application.cacheDir

    @JvmStatic
    @Provides
    @Singleton
    @Named("stetho")
    fun provideStethoInterceptor(): Interceptor {
        return StethoInterceptor()
    }

    @JvmStatic
    @Provides
    @Named("apiPrivateKey")
    fun provideMarvelPrivateKey(): String {
        return BuildConfig.MARVEL_API_PRIVATE_KEY
    }

    @JvmStatic
    @Provides
    @Named("apiPublicKey")
    fun provideApiPublicKey(): String {
        return BuildConfig.MARVEL_API_PUBLIC_KEY
    }
}