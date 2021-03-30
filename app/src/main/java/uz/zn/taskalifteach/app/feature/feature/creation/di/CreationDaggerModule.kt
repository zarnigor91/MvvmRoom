package uz.zn.taskalifteach.app.feature.feature.creation.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import uz.zn.taskalifteach.app.application.di.fragment.FragmentKey
import uz.zn.taskalifteach.app.application.di.viewmodel.ViewModelKey
import uz.zn.taskalifteach.app.feature.feature.creation.CreationFragment
import uz.zn.taskalifteach.app.feature.feature.creation.CreationViewModel

@Module(includes = [CreationDaggerModule.Binder::class])
class CreationDaggerModule {

    @Module
    interface Binder {

        @Binds
        @IntoMap
        @FragmentKey(CreationFragment::class)
        fun creationFragment(fragment: CreationFragment): Fragment

        @Binds
        @IntoMap
        @ViewModelKey(CreationViewModel::class)
        fun creationViewModel(viewModel: CreationViewModel): ViewModel
    }
}