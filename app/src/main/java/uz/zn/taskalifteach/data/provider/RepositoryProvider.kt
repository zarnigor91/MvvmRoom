package uz.zn.taskalifteach.data.provider

import uz.zn.taskalifteach.data.repository.TaskRepository

interface RepositoryProvider {
    val taskRepository : TaskRepository
}