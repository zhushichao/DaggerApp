package cloud.shichao.androidapp.net.data

import androidx.lifecycle.LiveData
import cloud.shichao.daggerapp.data.User

/**
 * 2020/7/8
 *
 * @author shichao
 */
interface UserDataSource {

    suspend fun getUserByNet(): User?

    suspend fun getUserByLocal(): User?

    fun getLiveUser(): LiveData<User>
}