package uz.zn.taskalifteach.data.provider

import uz.zn.taskalifteach.data.datasourse.TaskDao
import uz.zn.taskalifteach.data.repository.TaskRepository
import uz.zn.taskalifteach.data.repository.TaskRepositoryImpl

internal class RepositoryProviderImpl(
    private val taskDao: TaskDao,
) : RepositoryProvider {

    override val taskRepository: TaskRepository by lazy {
        TaskRepositoryImpl(taskDao)
    }
}