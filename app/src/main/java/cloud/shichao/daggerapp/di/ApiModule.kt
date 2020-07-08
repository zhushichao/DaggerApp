package cloud.shichao.daggerapp.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

/**
 * 2020/7/8
 *
 * @author shichao
 */

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideGithubApi(): IGithubService {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.github.com/")
            .build()
        return retrofit.create(IGithubService::class.java);
    }


//    @Provides
//    @Singleton
//    @Named("baidu")
//    fun provideGithubApiBaidu(): IGithubService {
//        val retrofit = Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl("https://baidu.com/")
//            .build()
//        return retrofit.create(IGithubService::class.java);
//    }
}