package uz.zn.taskalifteach.app.global.di

import dagger.Module
import uz.zn.taskalifteach.app.feature.di.MainRootDaggerModule

@Module(
    includes = [
//        CardListDaggerModule::class,
//        DashboardRootDaggerModule::class,
//        SplashDaggerModule::class,
//        StateDaggerModule::class,
//        LanguageDaggerModule::class,
//        ConfirmationDaggerModule::class,
//        VerificationDaggerModule::class,
//        PasswordDaggerModule::class,
//        LoginDaggerModule::class,
//        ProPasswordDaggerModule::class
        MainRootDaggerModule::class
    ]
)
object GlobalDaggerModules