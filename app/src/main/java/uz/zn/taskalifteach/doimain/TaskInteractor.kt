package uz.zn.taskalifteach.doimain


import android.util.Log
import com.example.alifteachtask.data.model.TaskEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import uz.mayasoft.marta.wallet.data.utils.flow.mapToFlowResult
import uz.zn.taskalifteach.data.model.Data
import uz.zn.taskalifteach.data.repository.TaskRepository
import uz.zn.taskalifteach.data.repository.source.BookRepository
import javax.inject.Inject

class TaskInteractor @Inject constructor(
    private val taskRepository: TaskRepository,
    private val bookRepository: BookRepository
) {
    private var nameTask: String? = ""
    private var dateTask: String? = ""
    private var setStatusTask: Boolean? = false
    private var taskId: Long? =0


    fun getDateTask(): String =
        checkNotNull(dateTask)

    fun getIdTask(): Long =
        checkNotNull(taskId)

    fun getNameTask(): String =
        checkNotNull(nameTask)

    fun getStatusTask(): Boolean =
        checkNotNull(setStatusTask)



    fun setDateTask(value: String) {
        dateTask = value
    }

    fun setNameTask(value: String) {
        nameTask = value
    }

    fun setStatusTask(value: Boolean) {
        setStatusTask = value
    }

    fun setIdTask(value: Long) {
       taskId = value
    }

    fun getAlltasks(): Flow<Result<List<TaskEntity>>> {
        return taskRepository.getAllTask().mapToFlowResult()
            .flowOn(Dispatchers.IO)
    }

    fun getAllOnlineTasks(): Flow<Result<List<Data>>> {
        return bookRepository.getBooks().mapToFlowResult()
            .flowOn(Dispatchers.IO)
    }

    fun getCompletedTasks(): Flow<Result<List<TaskEntity>>> {
        return taskRepository.getAllTask().mapToFlowResult()
            .flowOn(Dispatchers.IO)

    }

    fun getUndoneTasks(): Flow<Result<List<TaskEntity>>> {
        return taskRepository.getAllTask().mapToFlowResult()
            .flowOn(Dispatchers.IO)

    }
//
//    fun addTasks(): Flow<Result<Unit>> {
//        return taskRepository.taskCreation(
//            TaskEntity(
//                null,
//                getNameTask(),
//                getDateTask(),
//                getStatusTask()
//            )
//        ).mapToFlowResult()
//            .flowOn(Dispatchers.IO)
//    }

//    fun updateTasks(): Flow<Result<Int>> {
//        return taskRepository.taskEdit(
//            TaskEntity(
//               getIdTask() ,
//                getNameTask(),
//                getDateTask(),
//                getStatusTask()
//            )
//        ).mapToFlowResult()
//            .flowOn(Dispatchers.IO)
//            .onEach {
//                Log.d("UpdateFragmentName", "${it.getOrNull()}")
//                Log.d("UpdateFragmentName", "${it.exceptionOrNull()}")
//                if (it.isSuccess) {
//                } else {
//
//                }
//                Log.wtf("UpdateFragmentName", "" + getNameTask())
//            }
//    }

    fun deleteTasks(taskEntity: TaskEntity): Flow<Result<Unit>> {
        return taskRepository.taskDelete(taskEntity).mapToFlowResult()
            .flowOn(Dispatchers.IO)
    }

}