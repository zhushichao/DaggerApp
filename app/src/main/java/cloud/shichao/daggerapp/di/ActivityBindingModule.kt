package cloud.shichao.daggerapp.di

import androidx.lifecycle.ViewModel
import cloud.shichao.daggerapp.MainActivity
import cloud.shichao.daggerapp.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * 2020/7/8
 *
 * @author shichao
 */

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [ViewModelBuilder::class])
    abstract fun mainActivity(): MainActivity

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindViewModel(viewModel: MainViewModel): ViewModel
}