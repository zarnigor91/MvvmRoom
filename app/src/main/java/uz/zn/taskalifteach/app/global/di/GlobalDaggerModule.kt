package uz.zn.taskalifteach.app.global.di

import androidx.fragment.app.FragmentFactory
import com.example.newtest.app.di.fragment.ProviderFragmentFactory
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [GlobalDaggerModule.Binder::class, GlobalDaggerModule.Provider::class])
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
    object Provider {
        @JvmStatic
        @Provides
        @GlobalScope
        fun provideNavControllerHolder(): NavControllerHolder<GlobalNavController> =
            NavControllerHolder(GlobalNavController())

        @JvmStatic
        @Provides
        @GlobalScope
        fun provideGlobalNavController(
            delegate: NavControllerHolder<GlobalNavController>
        ): GlobalNavController =
            delegate.controller
    }
}