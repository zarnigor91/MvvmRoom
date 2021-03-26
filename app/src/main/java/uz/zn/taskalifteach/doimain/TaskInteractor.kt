package uz.zn.taskalifteach.doimain

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