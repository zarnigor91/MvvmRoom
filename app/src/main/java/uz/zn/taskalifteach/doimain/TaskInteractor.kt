package uz.zn.taskalifteach.doimain

import android.util.Log
import com.example.alifteachtask.data.model.TaskEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import uz.mayasoft.marta.wallet.data.utils.flow.mapToFlowResult
import uz.zn.taskalifteach.data.repository.TaskRepository
import javax.inject.Inject

class TaskInteractor @Inject  constructor(
    private val taskRepository: TaskRepository
) {
private var nameTask: String? = null
    private var dateTask: String? = null
    private var setStatusTask: Boolean? = false

    fun setNameTask(value: String) {
        nameTask = value
    }

    fun setDateTask(value: String) {
        nameTask = value
    }

    fun setStatusTask(value: Boolean) {
        setStatusTask = value
    }

    fun getAlltasks(): Flow<Result<List<TaskEntity>>>{
        return taskRepository.getAllTask().mapToFlowResult()
             .flowOn(Dispatchers.IO)
    }

    fun getCompletedTasks(): Flow<Result<List<TaskEntity>>>{
        return taskRepository.getAllTask().mapToFlowResult()
            .flowOn(Dispatchers.IO)
    }

    fun getUndoneTasks(): Flow<Result<List<TaskEntity>>>{
        return taskRepository.getAllTask().mapToFlowResult()
            .flowOn(Dispatchers.IO)
    }

    fun addTasks(): Flow<Result<List<TaskEntity>>>{
        return taskRepository.getAllTask().mapToFlowResult()
            .flowOn(Dispatchers.IO)
    }

    fun updateTasks(): Flow<Result<List<TaskEntity>>>{
        return taskRepository.getAllTask().mapToFlowResult()
            .flowOn(Dispatchers.IO)
    }

    fun deleteTasks(): Flow<Result<List<TaskEntity>>>{
        return taskRepository.getAllTask().mapToFlowResult()
            .flowOn(Dispatchers.IO)
    }

}