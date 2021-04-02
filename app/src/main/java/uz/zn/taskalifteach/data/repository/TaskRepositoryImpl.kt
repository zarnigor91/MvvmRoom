package uz.zn.taskalifteach.data.repository

import com.example.alifteachtask.data.model.TaskEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.switchMap
import uz.zn.taskalifteach.data.datasourse.TaskDao

class TaskRepositoryImpl(
    private val taskDao: TaskDao
) : TaskRepository {
    override fun getAllTask(): Flow<List<TaskEntity>> {
        return taskDao.selectAllTask()
    }

    override fun getCompletedTask(): Flow<List<TaskEntity>> {
        return taskDao.selectAllTask()

    }

    override fun getUndoneTask(): Flow<List<TaskEntity>> {
        return taskDao.selectAllTask()
    }

    override fun taskCreation(taks: TaskEntity): Flow<Long> {
        return flow { emit(taskDao.insert(taks)) }
    }

    override fun taskDelete(taskEntity: TaskEntity): Flow<Unit> {
        return flow { emit(taskDao.delete(taskEntity)) }
    }

    override fun taskEdit(taskEntity: TaskEntity): Flow<Int> {
        return flow { emit(taskDao.updateTask(taskEntity)) }
    }


}