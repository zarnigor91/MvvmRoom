package uz.zn.taskalifteach.app.feature.feature.completed.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import uz.zn.taskalifteach.app.application.di.fragment.FragmentKey
import uz.zn.taskalifteach.app.application.di.viewmodel.ViewModelKey
import uz.zn.taskalifteach.app.feature.feature.completed.CompletedFragment
import uz.zn.taskalifteach.app.feature.feature.completed.CompletedViewModel
import uz.zn.taskalifteach.app.feature.feature.edit.UpdateTaskFragment
import uz.zn.taskalifteach.app.feature.feature.edit.UpdateTaskViewModel

@Module(includes = [CompletedDaggerModule.Binder::class])
internal object CompletedDaggerModule{

    @Module
    interface Binder {
        @Binds
        @IntoMap
        @FragmentKey(CompletedFragment::class)
        fun completedTaskFragment(fragment: CompletedFragment): Fragment

        @Binds
        @IntoMap
        @ViewModelKey(CompletedViewModel::class)
        fun completedTaskViewModel(viewModel: CompletedViewModel): ViewModel
    }

}