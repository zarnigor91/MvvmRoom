package uz.zn.taskalifteach.app.feature.dashboard.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import uz.zn.taskalifteach.app.application.di.fragment.FragmentKey
import uz.zn.taskalifteach.app.application.di.viewmodel.ViewModelKey
import uz.zn.taskalifteach.app.feature.dashboard.AllTaskFragment
import uz.zn.taskalifteach.app.feature.dashboard.AllTaskViewModel


@Module(includes = [DashboardDaggerModule.Binder::class])
internal object DashboardDaggerModule {

    @Module
    interface Binder {
        @Binds
        @IntoMap
        @FragmentKey(AllTaskFragment::class)
        fun dashboardNewsFragment(fragment: AllTaskFragment): Fragment

        @Binds
        @IntoMap
        @ViewModelKey(AllTaskViewModel::class)
        fun dashboardNewsViewModel(viewModel: AllTaskViewModel): ViewModel
    }

}