//package uz.zn.taskalifteach.app.feature.feature
//
//import androidx.lifecycle.ViewModel
//import androidx.navigation.NavController
//import uz.zn.taskalifteach.app.feature.MainRootFragmentDirections
//import javax.inject.Inject
//import kotlin.properties.Delegates
//
//class DashboardRootViewModel @Inject constructor(
////    private val dashboardRootInteractor: DashboardRootInteractor,
//    private val routeController: DashboardNavController
//) : ViewModel(), DashboardNavController.RouteEventListener {
//
//    private var navController: NavController by Delegates.notNull()
//    fun setNavControl(navController: NavController) {
//        this.navController = navController
//    }
//
//    override fun onStartUpdateTask(name: String, date: String, status: Boolean) {
//        navController.navigate(MainRootFragmentDirections.actionMainRootFragmentToEditTaskFragment(name,date,status))
//    }
//
//}