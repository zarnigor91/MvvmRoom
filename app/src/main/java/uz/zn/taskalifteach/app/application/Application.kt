package uz.zn.taskalifteach.app.application

import android.app.Application
import android.content.Context
import me.vponomarenko.injectionmanager.IHasComponent
import me.vponomarenko.injectionmanager.x.XInjectionManager
import uz.zn.taskalifteach.app.application.di.component.IApplicationDaggerComponent

class Application: Application(), IHasComponent<IApplicationDaggerComponent>{
    override fun getComponent(): IApplicationDaggerComponent =
            IApplicationDaggerComponent .create(this)

    override fun attachBaseContext(base: Context) {
        XInjectionManager.let { it.init(this); it.bindComponent(this).inject(this) }
        super.attachBaseContext(base)
    }
}