package uz.zn.taskalifteach.app.feature.feature.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uz.mayasoft.marta.wallet.data.utils.flow.launchWithState
import uz.zn.taskalifteach.doimain.TaskInteractor
import javax.inject.Inject

class UpdateTaskViewModel @Inject constructor(
    private val taskInteractor: TaskInteractor
) : ViewModel(){
    private val _updateTaskLiveData = MutableLiveData<UpdateTaskResource>()
    val updateTaskLiveData: LiveData<UpdateTaskResource> = _updateTaskLiveData

    fun setNameTask(name: String) =
        taskInteractor.setNameTask(name)

    fun setDateTask(date: String) =
        taskInteractor.setDateTask(date)

    fun setStatusTask(status: Boolean) =
        taskInteractor.setStatusTask(status)


    fun  upDateTask(name: String, date: String, status: Boolean) {
        viewModelScope.launch {
            taskInteractor.updateTasks(name,date,status)
                .launchWithState(
                    onStart = {_updateTaskLiveData.postValue(UpdateTaskResource.Loading)},
                    onSuccess = {_updateTaskLiveData.postValue(UpdateTaskResource.Success(it))},
                    onFailure = {_updateTaskLiveData.postValue(UpdateTaskResource.Failure(it))}
                )
        }
    }
}