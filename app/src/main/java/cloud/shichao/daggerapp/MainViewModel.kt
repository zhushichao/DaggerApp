package cloud.shichao.daggerapp

import androidx.lifecycle.*
import cloud.shichao.daggerapp.data.IUserRepository
import cloud.shichao.daggerapp.data.User
import javax.inject.Inject

/**
 * 2020/7/8
 *
 * @author shichao
 */

class MainViewModel @Inject constructor(
    private val repository: IUserRepository
) : ViewModel() {

    fun getLiveUser(): LiveData<User>{
        return repository.getLiveUser()
    }


    val mUserInfo = MutableLiveData<User>()

    // muserInfo.switchMap()


}