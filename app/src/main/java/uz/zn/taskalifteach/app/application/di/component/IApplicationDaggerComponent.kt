package uz.zn.taskalifteach.app.application.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import uz.zn.taskalifteach.app.application.Application
import uz.zn.taskalifteach.app.application.di.module.ApplicationDaggerModule
import uz.zn.taskalifteach.app.application.di.module.ApplicationDaggerModuleRepository
import uz.zn.taskalifteach.data.provider.RepositoryProvider
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationDaggerModule::class, ApplicationDaggerModuleRepository::class])
interface IApplicationDaggerComponent : RepositoryProvider {

    fun inject(application: Application)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): IApplicationDaggerComponent
    }

    companion object {
        fun create(context: Context): IApplicationDaggerComponent =
            DaggerIApplicationDaggerComponent
                .factory()
                .create(context)
    }
}
