package uz.zn.taskalifteach.app.feature

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import uz.zn.taskalifteach.app.feature.feature.MainRootNavController
import javax.inject.Inject

class MainRootViewModel @Inject constructor(
    private val mainRootNavController: MainRootNavController
) : ViewModel() {

    fun setNavControl(navController: NavController) {
        mainRootNavController.init(navController)
    }
}