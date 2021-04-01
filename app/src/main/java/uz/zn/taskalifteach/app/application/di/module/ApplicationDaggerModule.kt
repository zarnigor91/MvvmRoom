package uz.zn.taskalifteach.app.application.di.module


import android.content.Context
import dagger.Module
import dagger.Provides
import uz.zn.taskalifteach.data.provider.DataProvider
import uz.zn.taskalifteach.data.provider.RepositoryProvider
import javax.inject.Singleton

@Module(includes = [ ApplicationDaggerModule.Provider::class])
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

//        @JvmStatic
//        @Provides
//        @Singleton
//        fun router (): RouterCOntroller = RouterCOntroller()
    }
}
