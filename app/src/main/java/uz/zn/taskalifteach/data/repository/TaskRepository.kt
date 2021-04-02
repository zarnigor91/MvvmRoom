package uz.zn.taskalifteach.data.repository

import com.example.alifteachtask.data.model.TaskEntity
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getAllTask(): Flow<List<TaskEntity>>
    fun getCompletedTask(): Flow<List<TaskEntity>>
    fun getUndoneTask(): Flow<List<TaskEntity>>
    fun taskCreation(taks: TaskEntity): Flow<Long>
    fun taskDelete(taskEntity: TaskEntity): Flow<Unit>
    fun taskEdit(taskEntity: TaskEntity): Flow<Int>
}