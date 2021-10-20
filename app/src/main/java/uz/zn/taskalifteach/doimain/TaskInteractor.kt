package uz.zn.taskalifteach.doimain


import com.example.alifteachtask.data.model.TaskEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import uz.mayasoft.marta.wallet.data.utils.flow.mapToFlowResult
import uz.zn.taskalifteach.data.model.Data
import uz.zn.taskalifteach.data.repository.TaskRepository
import uz.zn.taskalifteach.data.repository.source.BookRepository
import javax.inject.Inject

class TaskInteractor @Inject constructor(
    private val taskRepository: TaskRepository,
    private val bookRepository: BookRepository
) {


    fun getAllOnlineTasks(): Flow<Result<List<Data>>> {
        return bookRepository.getBooks().mapToFlowResult()
            .flowOn(Dispatchers.IO)
    }


    fun deleteTasks(taskEntity: TaskEntity): Flow<Result<Unit>> {
        return taskRepository.taskDelete(taskEntity).mapToFlowResult()
            .flowOn(Dispatchers.IO)
    }

}