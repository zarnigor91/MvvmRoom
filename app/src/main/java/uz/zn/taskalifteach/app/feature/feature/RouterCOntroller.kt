//package uz.zn.taskalifteach.app.feature.feature
//
//import androidx.navigation.NavController
//import uz.zn.taskalifteach.app.feature.MainRootFragmentDirections
//
//class RouterCOntroller {
//    private var navController: NavController? = null
//
//    fun setNavController(navController: NavController?) {
//        this.navController =navController
//    }
//
//    fun navigateOpenDateils(name: String, date: String, status: Boolean) {
//        val action = MainRootFragmentDirections.actionMainRootFragmentToEditTaskFragment(name,date,status)
//        navController?.navigate(action)
//    }
//
//}