package uz.zn.taskalifteach.data.repository

import com.example.alifteachtask.data.datasourse.TaskDao
import com.example.alifteachtask.data.model.TaskEntity
import kotlinx.coroutines.flow.Flow
import uz.zn.taskalifteach.data.model.Tasks

class TaskRepositoryImpl(
    private val taskDao: TaskDao
) : TaskRepository {
    override fun getAllTask(): Flow<Tasks> {
        TODO("Not yet implemented")
    }

    override fun getTask(): Flow<TaskEntity> {
        TODO("Not yet implemented")
    }

    override fun taskCreation(): Flow<TaskEntity> {
        TODO("Not yet implemented")
    }
}