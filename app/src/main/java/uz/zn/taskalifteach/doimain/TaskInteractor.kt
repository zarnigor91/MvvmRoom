package uz.zn.taskalifteach.doimain


import com.example.alifteachtask.data.model.TaskEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import uz.mayasoft.marta.wallet.data.utils.flow.mapToFlowResult
import uz.zn.taskalifteach.data.repository.TaskRepository
import javax.inject.Inject

class TaskInteractor @Inject  constructor(
    private val taskRepository: TaskRepository
) {
private var nameTask: String? = ""
    private var dateTask: String? = ""
    private var setStatusTask: Boolean? = false


    fun getNameTask():String =
        checkNotNull(nameTask)

    fun getDateTask():String =
        checkNotNull(dateTask)

    fun getStatusTask():Boolean =
        checkNotNull(setStatusTask)

    fun setNameTask(value: String) {
        nameTask = value
    }

    fun setDateTask(value: String) {
        dateTask = value
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
            .onEach {
                var filterList =  it.filter {it.status == true}

            }
    }

    fun addTasks(): Flow<Result<Long>>{
        return taskRepository.taskCreation(TaskEntity(null,getNameTask(),getDateTask(),getStatusTask())).mapToFlowResult()
            .flowOn(Dispatchers.IO)
    }

    fun updateTasks(name: String, date: String, status: Boolean): Flow<Result<Int>>{
        return taskRepository.taskEdit(name,date,status).mapToFlowResult()
            .flowOn(Dispatchers.IO)
    }

    fun deleteTasks(taskEntity: TaskEntity): Flow<Result<Unit>>{
        return taskRepository.taskDelete(taskEntity).mapToFlowResult()
            .flowOn(Dispatchers.IO)
    }

}