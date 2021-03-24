package com.example.alifteachtask.app

import android.app.Application
import android.content.Context
import com.example.alifteachtask.app.di.component.IApplicationDaggerComponent
import me.vponomarenko.injectionmanager.IHasComponent
import me.vponomarenko.injectionmanager.x.XInjectionManager

class Application: Application(), IHasComponent<IApplicationDaggerComponent{

    override fun getComponent(): IApplicationDaggerComponent =
            IApplicationDaggerComponent .create(this)

    override fun attachBaseContext(base: Context) {
        XInjectionManager.let { it.init(this); it.bindComponent(this).inject(this) }
        super.attachBaseContext(base)
    }
}