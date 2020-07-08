package cloud.shichao.androidapp.net.data

import androidx.lifecycle.LiveData
import cloud.shichao.daggerapp.data.User

/**
 * 2020/7/8
 *
 * @author shichao
 */

class LocalDataSource: UserDataSource {

    override suspend fun getUserByNet(): User? {
        TODO("Not yet implemented")
    }

    override suspend fun getUserByLocal(): User? {
        return null
    }

    override fun getLiveUser(): LiveData<User> {
        TODO("Not yet implemented")
    }

}