package uz.zn.taskalifteach.app.feature.feature.edit.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import uz.zn.taskalifteach.app.application.di.fragment.FragmentKey
import uz.zn.taskalifteach.app.application.di.viewmodel.ViewModelKey
import uz.zn.taskalifteach.app.feature.feature.edit.UpdateTaskFragment
import uz.zn.taskalifteach.app.feature.feature.edit.UpdateTaskViewModel

@Module(includes = [EditDaggerModule.Binder::class])
internal object EditDaggerModule{

    @Module
    interface Binder {
        @Binds
        @IntoMap
        @FragmentKey(UpdateTaskFragment::class)
        fun editTaskFragment(fragment: UpdateTaskFragment): Fragment

        @Binds
        @IntoMap
        @ViewModelKey(UpdateTaskViewModel::class)
        fun editTaskViewModel(viewModel: UpdateTaskViewModel): ViewModel
    }

}