package com.example.alifteachtask.app.di.component


import android.content.Context
import com.example.alifteachtask.app.Application
import com.example.newtest.app.di.module.ApplicationDaggerModule
import com.example.newtest.app.di.module.ApplicationDaggerModuleRepository
import com.example.newtest.data.repository.IRepositoryProvider
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ApplicationDaggerModule::class, ApplicationDaggerModuleRepository::class])
interface IApplicationDaggerComponent : IRepositoryProvider {
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
