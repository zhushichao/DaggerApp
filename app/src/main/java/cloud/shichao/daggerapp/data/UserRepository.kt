package cloud.shichao.androidapp.net.data

import androidx.lifecycle.LiveData
import cloud.shichao.daggerapp.data.IUserRepository
import cloud.shichao.daggerapp.data.User
import cloud.shichao.daggerapp.di.ApplicationModule
import cloud.shichao.daggerapp.di.ApplicationModule.UsersLocalDataSource
import cloud.shichao.daggerapp.di.ApplicationModule.UsersRemoteDataSource
import javax.inject.Inject

/**
 * 2020/7/8
 *
 * @author shichao
 */

class UserRepository @Inject constructor(
    @UsersRemoteDataSource private val remoteDataSource: UserDataSource,
    @UsersLocalDataSource private val localDataSource: UserDataSource
) : IUserRepository {

    override suspend fun getUser(): User? {
        var user = localDataSource.getUserByLocal()
        if (user == null) {
            user = remoteDataSource.getUserByNet()
        }
        return user
    }

    override fun getLiveUser(): LiveData<User> = remoteDataSource.getLiveUser()

}