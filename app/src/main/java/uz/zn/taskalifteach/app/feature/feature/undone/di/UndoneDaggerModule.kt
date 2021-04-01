package uz.zn.taskalifteach.app.feature.feature.undone.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import uz.zn.taskalifteach.app.application.di.fragment.FragmentKey
import uz.zn.taskalifteach.app.application.di.viewmodel.ViewModelKey
import uz.zn.taskalifteach.app.feature.feature.completed.CompletedFragment
import uz.zn.taskalifteach.app.feature.feature.completed.CompletedViewModel
import uz.zn.taskalifteach.app.feature.feature.undone.UndoneFragment
import uz.zn.taskalifteach.app.feature.feature.undone.UndoneViewModel

@Module(includes = [UndoneDaggerModule.Binder::class])
internal object UndoneDaggerModule{

    @Module
    interface Binder {
        @Binds
        @IntoMap
        @FragmentKey(UndoneFragment::class)
        fun undoneTaskFragment(fragment: UndoneFragment): Fragment

        @Binds
        @IntoMap
        @ViewModelKey(UndoneViewModel::class)
        fun undoneTaskViewModel(viewModel: UndoneViewModel): ViewModel
    }

}