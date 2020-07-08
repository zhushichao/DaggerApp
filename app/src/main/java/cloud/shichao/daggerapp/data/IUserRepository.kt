package cloud.shichao.daggerapp.data

import androidx.lifecycle.LiveData

/**
 * 2020/7/8
 *
 * @author shichao
 */
interface IUserRepository {
    suspend fun getUser(): User?

    fun getLiveUser(): LiveData<User>
}