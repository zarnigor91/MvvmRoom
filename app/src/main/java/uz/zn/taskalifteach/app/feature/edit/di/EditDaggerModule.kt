package uz.zn.taskalifteach.app.feature.edit.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import uz.zn.taskalifteach.app.application.di.fragment.FragmentKey
import uz.zn.taskalifteach.app.application.di.viewmodel.ViewModelKey
import uz.zn.taskalifteach.app.feature.MainRootFragment
import uz.zn.taskalifteach.app.feature.MainRootViewModel
import uz.zn.taskalifteach.app.feature.edit.EditTaskFragment
import uz.zn.taskalifteach.app.feature.edit.EditTaskViewModel

@Module(includes = [EditDaggerModule.Binder::class])
internal object EditDaggerModule{

    @Module
    interface Binder {
        @Binds
        @IntoMap
        @FragmentKey(EditTaskFragment::class)
        fun editTaskFragment(fragment: EditTaskFragment): Fragment

        @Binds
        @IntoMap
        @ViewModelKey(EditTaskViewModel::class)
        fun editTaskViewModel(viewModel: EditTaskViewModel): ViewModel
    }

}