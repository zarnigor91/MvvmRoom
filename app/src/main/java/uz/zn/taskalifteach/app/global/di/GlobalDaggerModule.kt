package uz.zn.taskalifteach.app.global.di

import androidx.fragment.app.FragmentFactory

import dagger.Binds
import dagger.Module
import dagger.Provides
import uz.zn.taskalifteach.app.application.di.fragment.ProviderFragmentFactory
import uz.zn.taskalifteach.app.feature.feature.MainRootNavController


@Module(includes = [GlobalDaggerModule.Binder::class, GlobalDaggerModule.Providers::class])
object GlobalDaggerModule {

    @Module
    interface Binder {
        @Binds
        @GlobalScope
        fun bindProviderFragmentFactory(
            factory: ProviderFragmentFactory
        ): FragmentFactory
    }

    @Module
    object Providers {

        @JvmStatic
        @Provides
        @GlobalScope
        fun mainNavController(
        ): MainRootNavController =
            MainRootNavController()
    }
}