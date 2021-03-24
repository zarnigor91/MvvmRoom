package com.example.alifteachtask.app.di.component


import android.content.Context
import uz.zn.taskalifteach.app.application.Application
import com.example.newtest.app.di.module.ApplicationDaggerModule
import com.example.newtest.app.di.module.ApplicationDaggerModuleRepository
import dagger.BindsInstance
import dagger.Component
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
