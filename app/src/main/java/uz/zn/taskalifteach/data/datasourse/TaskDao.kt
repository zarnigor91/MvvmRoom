package uz.zn.taskalifteach.data.datasourse

import androidx.room.*
import com.example.alifteachtask.data.model.TaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * from tasks")
    fun selectAllTask(): Flow<MutableList<TaskEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: TaskEntity): Long


    @Delete
    suspend fun delete(entity: TaskEntity): Long

    @Query("UPDATE tasks SET name = name WHERE id = id")
     suspend fun updateTask(id: Long, name: String) : Long
}
