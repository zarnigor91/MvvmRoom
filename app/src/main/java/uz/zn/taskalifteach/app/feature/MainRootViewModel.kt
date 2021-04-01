package uz.zn.taskalifteach.app.feature

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import uz.zn.taskalifteach.app.feature.feature.DashboardNavController
import javax.inject.Inject
import kotlin.properties.Delegates

class MainRootViewModel @Inject constructor(
    private val routeController: DashboardNavController
): ViewModel(), DashboardNavController.RouteEventListener{

    private var navController: NavController by Delegates.notNull()
    fun setNavControl(navController: NavController) {
        this.navController = navController
    }

    override fun onStartUpdateTask(name: String, date: String, status: Boolean) {
        navController.navigate(MainRootFragmentDirections.actionMainRootFragmentToEditTaskFragment(name, date, status))
        Log.wtf("MainRootViewModel", ""+ navController.navigate(MainRootFragmentDirections.actionMainRootFragmentToEditTaskFragment(name, date, status)))
    }

}