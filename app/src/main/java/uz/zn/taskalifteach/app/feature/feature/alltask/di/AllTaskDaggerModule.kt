package uz.zn.taskalifteach.app.feature.feature.alltask.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import uz.zn.taskalifteach.app.application.di.fragment.FragmentKey
import uz.zn.taskalifteach.app.application.di.viewmodel.ViewModelKey
import uz.zn.taskalifteach.app.feature.feature.alltask.AllTaskFragment
import uz.zn.taskalifteach.app.feature.feature.alltask.AllTaskViewModel


@Module(includes = [AllTaskDaggerModule.Binder::class])
internal object AllTaskDaggerModule {

    @Module
    interface Binder {
        @Binds
        @IntoMap
        @FragmentKey(AllTaskFragment::class)
        fun allTaskFragment(fragment: AllTaskFragment): Fragment

        @Binds
        @IntoMap
        @ViewModelKey(AllTaskViewModel::class)
        fun allTaskViewModel(viewModel: AllTaskViewModel): ViewModel
    }

}