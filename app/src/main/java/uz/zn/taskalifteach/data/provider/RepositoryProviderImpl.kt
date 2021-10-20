package uz.zn.taskalifteach.data.provider

import uz.zn.taskalifteach.data.datasourse.TaskDao
import uz.zn.taskalifteach.data.repository.TaskRepository
import uz.zn.taskalifteach.data.repository.TaskRepositoryImpl
import uz.zn.taskalifteach.data.repository.source.BookRepository
import uz.zn.taskalifteach.data.repository.source.BookRepositoryImpl
import uz.zn.taskalifteach.data.service.PostApi

class RepositoryProviderImpl (
    private val postApi: PostApi,
    private val taskDao: TaskDao,
): RepositoryProvider{

    override val taskRepository:TaskRepository by lazy {
        TaskRepositoryImpl(taskDao)
    }

    override val bookRepository: BookRepository by lazy {
        BookRepositoryImpl(postApi, taskDao)
    }



}