package cloud.shichao.daggerapp.di

import android.content.Context
import cloud.shichao.daggerapp.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * 2020/7/8
 *
 * @author shichao
 */
@Singleton
@Component(
    modules = [
        ApiModule::class,
        ApplicationModule::class,
        AndroidSupportInjectionModule::class,
        ActivityBindingModule::class]
)
interface ApplicationComponent : AndroidInjector<App> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Context): ApplicationComponent
    }
}