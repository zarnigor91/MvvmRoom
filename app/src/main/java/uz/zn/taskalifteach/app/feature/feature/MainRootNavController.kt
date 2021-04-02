package uz.zn.taskalifteach.app.feature.feature

import android.util.Log
import androidx.navigation.NavController

class MainRootNavController private constructor(
    var navController: NavController?
) {

    constructor() : this(null) {
        Log.wtf("MainRootNavController", "created")
        instance = this
    }

    private var instance: MainRootNavController? = null

    fun init(navController: NavController) {
        Log.wtf("MainRootNavController", "init method called")
//        return MainRootNavController(navController)
//            .also { instance = it }
        this.navController = navController
    }

    fun getInstance(): MainRootNavController {
        Log.wtf("MainRootNavController", "getInstance method called")
        if (instance == null)
            throw IllegalStateException()
        if (navController == null)
            throw IllegalStateException()
        return checkNotNull(instance)
    }

    inline fun withNavController(navControllerAction: NavController.() -> Unit) {
        if (navController == null)
            throw IllegalStateException()
        navControllerAction(checkNotNull(navController))
        Log.wtf("navController", "init method called")
    }
}