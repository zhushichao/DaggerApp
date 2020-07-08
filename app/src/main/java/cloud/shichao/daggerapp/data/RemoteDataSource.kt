package cloud.shichao.androidapp.net.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cloud.shichao.daggerapp.data.User
import cloud.shichao.daggerapp.di.IGithubService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

/**
 * 2020/7/8
 *
 * @author shichao
 */

class RemoteDataSource @Inject constructor(
        private val api: IGithubService
) : UserDataSource {
    override suspend fun getUserByNet(): User? {
        return suspendCoroutine {cont ->
            api.getUserInfo().enqueue(object : Callback<User> {
                override fun onFailure(call: Call<User>, t: Throwable) {
                    cont.resume(User("错误"))
                }

                override fun onResponse(call: Call<User>, response: Response<User>) {
                    cont.resume(User("成功"))
                }
            })
        }
    }

    override suspend fun getUserByLocal(): User? {
        TODO("Not yet implemented")
    }


    override fun getLiveUser(): LiveData<User> {
        val data = MutableLiveData<User>()
        api.getUserInfo().enqueue(object : Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {
                data.postValue(User("错误"))
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                data.postValue(User("吃吃"))
            }
        })
        return data
    }


}