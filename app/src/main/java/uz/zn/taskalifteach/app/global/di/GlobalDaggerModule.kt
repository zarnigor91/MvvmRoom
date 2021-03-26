package uz.zn.taskalifteach.app.global.di

import androidx.fragment.app.FragmentFactory

import dagger.Binds
import dagger.Module
import uz.zn.taskalifteach.app.application.di.fragment.ProviderFragmentFactory


@Module(includes = [GlobalDaggerModule.Binder::class])
object GlobalDaggerModule {

    @Module
    interface Binder {
        @Binds
        @GlobalScope
        fun bindProviderFragmentFactory(
            factory: ProviderFragmentFactory
        ): FragmentFactory
    }
}