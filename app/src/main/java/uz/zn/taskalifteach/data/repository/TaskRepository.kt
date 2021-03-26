package uz.zn.taskalifteach.data.repository

import com.example.alifteachtask.data.model.TaskEntity
import uz.zn.taskalifteach.data.model.Tasks
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getAllTask() : Flow<List<TaskEntity>>
    fun getCompletedTask() :Flow<List<TaskEntity>>
    fun getUndoneTask() :Flow<List<TaskEntity>>
    fun taskCreation(taks : TaskEntity) : Flow<Long>
    fun taskDelete(taskEntity: TaskEntity) :Flow<Long>
    fun taskEdit(id: Long, name: String) : Flow<Long>
}