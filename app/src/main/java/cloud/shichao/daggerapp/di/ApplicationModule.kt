package cloud.shichao.daggerapp.di

import cloud.shichao.androidapp.net.data.LocalDataSource
import cloud.shichao.androidapp.net.data.RemoteDataSource
import cloud.shichao.androidapp.net.data.UserDataSource
import cloud.shichao.androidapp.net.data.UserRepository
import cloud.shichao.daggerapp.data.IUserRepository
import cloud.shichao.daggerapp.data.User
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier
import javax.inject.Singleton

/**
 * 2020/7/8
 *
 * @author shichao
 */

@Module(includes = [ApplicationModuleBinds::class])
object ApplicationModule {

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class UsersLocalDataSource


    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class UsersRemoteDataSource

    @JvmStatic
    @Singleton
    @UsersLocalDataSource
    @Provides
    fun provideLocalDataSource(): UserDataSource {
        return LocalDataSource()
    }


    @JvmStatic
    @Singleton
    @UsersRemoteDataSource
    @Provides
    fun provideRemoteDataSource(apiService: IGithubService): UserDataSource {
        return RemoteDataSource(apiService)
    }

}


@Module
abstract class ApplicationModuleBinds {

    @Singleton
    @Binds
    abstract fun bindUserRepository(repo: UserRepository): IUserRepository
}