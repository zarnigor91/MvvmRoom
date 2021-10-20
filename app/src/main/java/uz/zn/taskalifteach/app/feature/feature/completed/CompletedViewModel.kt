package uz.zn.taskalifteach.app.feature.feature.completed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alifteachtask.data.model.TaskEntity
import kotlinx.coroutines.launch
import uz.mayasoft.marta.wallet.data.utils.flow.launchWithState
import uz.zn.taskalifteach.app.feature.MainRootFragmentDirections
import uz.zn.taskalifteach.app.feature.feature.MainRootNavController
import uz.zn.taskalifteach.app.feature.feature.alltask.AllTaskResource
import uz.zn.taskalifteach.app.feature.feature.alltask.TaskDeleteResource
import uz.zn.taskalifteach.doimain.TaskInteractor
import javax.inject.Inject

class CompletedViewModel @Inject constructor(
    private val mainRootNavController: MainRootNavController,
    private val taskInteractor: TaskInteractor
) : ViewModel() {

    private val _completedTaskLiveData = MutableLiveData<AllTaskResource>()
    val completedTaskLiveData: LiveData<AllTaskResource> = _completedTaskLiveData

    private val _deleteTaskLiveData = MutableLiveData<TaskDeleteResource>()
    val deleteAllLiveData: LiveData<TaskDeleteResource> = _deleteTaskLiveData



}