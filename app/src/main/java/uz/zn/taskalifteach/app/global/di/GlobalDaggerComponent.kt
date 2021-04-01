package uz.zn.taskalifteach.app.global.di

import dagger.Component
import uz.zn.taskalifteach.app.application.di.component.IApplicationDaggerComponent
import uz.zn.taskalifteach.app.global.GlobalActivity
import uz.zn.taskalifteach.data.provider.RepositoryProvider

@GlobalScope
@Component(
    dependencies = [IApplicationDaggerComponent::class],
    modules = [GlobalDaggerModule::class, GlobalDaggerModules::class]
)
interface GlobalDaggerComponent : RepositoryProvider {

    fun inject(activity: GlobalActivity)

    @Component.Factory
    interface Factory {
        fun create(component: IApplicationDaggerComponent): GlobalDaggerComponent
    }

    companion object {
        fun create(component: IApplicationDaggerComponent): GlobalDaggerComponent =
            DaggerGlobalDaggerComponent
                .factory()
                .create(component)
    }
}