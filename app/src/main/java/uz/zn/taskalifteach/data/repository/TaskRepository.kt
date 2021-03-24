package uz.zn.taskalifteach.data.repository

import com.example.alifteachtask.data.model.TaskEntity
import uz.zn.taskalifteach.data.model.Tasks
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getAllTask() : Flow<Tasks>
    fun getTask() : Flow<TaskEntity>
    fun taskCreation() : Flow<TaskEntity>
}