package uz.zn.taskalifteach.app.global.di

import dagger.Module
import uz.zn.taskalifteach.app.feature.di.MainRootDaggerModule

@Module(includes = [MainRootDaggerModule::class])
object GlobalDaggerModules