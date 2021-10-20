package uz.zn.taskalifteach.data.repository.source

import kotlinx.coroutines.flow.Flow
import uz.zn.taskalifteach.data.model.Data

interface BookRepository {
    fun getBooks(): Flow<List<Data>>


}