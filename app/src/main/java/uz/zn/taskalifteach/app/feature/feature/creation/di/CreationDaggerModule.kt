package uz.zn.taskalifteach.app.feature.feature.creation.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import uz.zn.taskalifteach.app.application.di.fragment.FragmentKey
import uz.zn.taskalifteach.app.application.di.viewmodel.ViewModelKey
import uz.zn.taskalifteach.app.feature.feature.creation.CreationTaskFragment
import uz.zn.taskalifteach.app.feature.feature.creation.CreationTaskViewModel

@Module(includes = [CreationDaggerModule.Binder::class])
class CreationDaggerModule {

    @Module
    interface Binder {

        @Binds
        @IntoMap
        @FragmentKey(CreationTaskFragment::class)
        fun creationFragment(fragment: CreationTaskFragment): Fragment

        @Binds
        @IntoMap
        @ViewModelKey(CreationTaskViewModel::class)
        fun creationViewModel(viewModel: CreationTaskViewModel): ViewModel
    }
}