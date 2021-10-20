package uz.zn.taskalifteach.data.provider

import uz.zn.taskalifteach.data.repository.TaskRepository
import uz.zn.taskalifteach.data.repository.source.BookRepository

interface RepositoryProvider {
    val taskRepository : TaskRepository
    val bookRepository : BookRepository
}