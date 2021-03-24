package uz.zn.taskalifteach.app.global.di

import com.example.alifteachtask.app.di.component.IApplicationDaggerComponent
import dagger.Component
import uz.zn.taskalifteach.app.global.GlobalActivity
import uz.zn.taskalifteach.data.provider.RepositoryProvider

@GlobalScope
@Component(
    dependencies = [IApplicationDaggerComponent::class],
    modules = [
        GlobalDaggerModule::class,
        GlobalDaggerModules::class
    ]
)
interface GlobalDaggerComponent : RepositoryProvider {

    fun globalNavController(): GlobalNavController

    fun navControllerHolder(): NavControllerHolder<GlobalNavController>

    fun inject(activity: GlobalActivity)

    @Component.Factory
    interface Factory {
        fun create(component: ApplicationDaggerComponent): GlobalDaggerComponent
    }

    companion object {
        fun create(component: ApplicationDaggerComponent): GlobalDaggerComponent =
            DaggerGlobalDaggerComponent
                .factory()
                .create(component)
    }
}