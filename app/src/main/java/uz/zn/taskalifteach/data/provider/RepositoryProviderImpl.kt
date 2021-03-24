package uz.zn.taskalifteach.data.provider

import com.example.alifteachtask.data.datasourse.TaskDao
import uz.zn.taskalifteach.data.repository.TaskRepository
import uz.zn.taskalifteach.data.repository.TaskRepositoryImpl

class RepositoryProviderImpl(
    private val taskDao: TaskDao,

) : RepositoryProvider{
    override val taskRepository: TaskRepository by lazy {
       TaskRepositoryImpl(taskDao)
    }


}