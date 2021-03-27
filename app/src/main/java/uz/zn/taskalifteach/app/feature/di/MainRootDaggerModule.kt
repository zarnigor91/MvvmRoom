package uz.zn.taskalifteach.app.feature.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import uz.zn.taskalifteach.app.application.di.fragment.FragmentKey
import uz.zn.taskalifteach.app.application.di.viewmodel.ViewModelKey
import uz.zn.taskalifteach.app.feature.MainRootFragment
import uz.zn.taskalifteach.app.feature.MainRootViewModel
import uz.zn.taskalifteach.app.feature.completed.di.CompletedDaggerModule
import uz.zn.taskalifteach.app.feature.creation.di.CreationDaggerModule
import uz.zn.taskalifteach.app.feature.dashboard.di.DashboardDaggerModule
import uz.zn.taskalifteach.app.feature.edit.di.EditDaggerModule
import uz.zn.taskalifteach.app.feature.undone.di.UndoneDaggerModule

@Module(
    includes = [
        MainRootDaggerModule.Binder::class,
        MainRootDaggerModule.FeaturesDaggerModules::class
    ]
)
object MainRootDaggerModule {

    @Module
    interface Binder {
        @Binds
        @IntoMap
        @FragmentKey(MainRootFragment::class)
        fun mainScreenFragment(fragment: MainRootFragment): Fragment

        @Binds
        @IntoMap
        @ViewModelKey(MainRootViewModel::class)
        fun mainScreenViewModel(viewModel: MainRootViewModel): ViewModel
    }

    @Module(
        includes = [
            DashboardDaggerModule::class,
            EditDaggerModule::class,
            CompletedDaggerModule::class,
            CreationDaggerModule::class,
            UndoneDaggerModule::class
        ]
    )
    object FeaturesDaggerModules
}