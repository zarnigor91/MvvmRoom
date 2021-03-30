package uz.zn.taskalifteach.app.feature.feature.alltask

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uz.mayasoft.marta.wallet.data.utils.flow.launchWithState
import uz.zn.taskalifteach.doimain.TaskInteractor
import javax.inject.Inject

class AllTaskViewModel @Inject constructor(
    private val taskInteractor: TaskInteractor
) :ViewModel() {

    private val _allTaskLiveData = MutableLiveData<AllTaskResource>()
    val taskAllLiveData: LiveData<AllTaskResource> = _allTaskLiveData

    fun getAllTaskList() {
        viewModelScope.launch {
            taskInteractor.getAlltasks()
                .launchWithState(
                    onStart = { _allTaskLiveData.postValue(AllTaskResource.Loading)},
                    onSuccess = {_allTaskLiveData.postValue(AllTaskResource.Success(it))},
                    onFailure = {_allTaskLiveData.postValue(AllTaskResource.Failure(it))}
                )
        }
    }


}