package uz.zn.taskalifteach.data.repository.source

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import uz.zn.taskalifteach.data.datasourse.TaskDao
import uz.zn.taskalifteach.data.model.Data
import uz.zn.taskalifteach.data.model.toEntity
import uz.zn.taskalifteach.data.service.PostApi


class BookRepositoryImpl(
    private val postApi: PostApi,
    private val taskDao: TaskDao
) : BookRepository{
    override fun getBooks(): Flow<List<Data>> {
        return postApi.getAllBook().map { it.data!!
        }.onEach {
            taskDao.insert(it.map {
                it.toEntity()
            })
        }

    }

}