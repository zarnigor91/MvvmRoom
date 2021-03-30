package uz.zn.taskalifteach.app.feature.feature.creation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uz.mayasoft.marta.wallet.data.utils.flow.launchWithState
import uz.zn.taskalifteach.app.feature.feature.alltask.AllTaskResource
import uz.zn.taskalifteach.doimain.TaskInteractor
import javax.inject.Inject

class CreationViewModel @Inject constructor(
    private val taskInteractor: TaskInteractor
) : ViewModel(){
    private val _addTaskLiveData = MutableLiveData<AllTaskResource>()
    val addTaskLiveData: LiveData<AllTaskResource> = _addTaskLiveData

    fun setNameTask(name: String) =
        taskInteractor.setNameTask(name)

    fun setDateTask(date: String) =
        taskInteractor.setDateTask(date)

    fun setStatusTask(status: Boolean) =
        taskInteractor.setStatusTask(status)

    fun  insertTask() {
        viewModelScope.launch {
            taskInteractor.getAlltasks()
                .launchWithState(
                    onStart = { _addTaskLiveData.postValue(AllTaskResource.Loading)},
                    onSuccess = {_addTaskLiveData.postValue(AllTaskResource.Success(it))},
                    onFailure = {_addTaskLiveData.postValue(AllTaskResource.Failure(it))}
                )
        }
    }
}