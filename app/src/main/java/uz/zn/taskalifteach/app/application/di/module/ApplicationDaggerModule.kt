package com.example.newtest.app.di.module


import android.content.Context
import com.example.alifteachtask.data.datasourse.TaskDao
import dagger.Module
import dagger.Provides
import uz.zn.taskalifteach.data.provider.RepositoryProvider
import uz.zn.taskalifteach.data.provider.RepositoryProviderImpl
import uz.zn.taskalifteach.data.repository.TaskRepository
import uz.zn.taskalifteach.data.repository.TaskRepositoryImpl
import javax.inject.Singleton

@Module(includes = [Provider::class])
object ApplicationDaggerModule {

    @Module
    object Provider {

        @JvmStatic
        @Provides
        @Singleton
        fun provideDataProvider(
            context: Context
        ): DataProvider = DataProvider(context)

        @JvmStatic
        @Provides
        @Singleton
        fun provideRepositoryProvider(
            dataProvider: DataProvider
        ): RepositoryProvider = dataProvider.repositoryProvider
    }
}
