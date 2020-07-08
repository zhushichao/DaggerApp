package cloud.shichao.daggerapp.di

import cloud.shichao.daggerapp.data.User
import retrofit2.Call
import retrofit2.http.GET

/**
 * 2020/7/8
 *
 * @author shichao
 */
interface IGithubService {

    @GET("user")
    fun getUserInfo(): Call<User>
}