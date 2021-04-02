package uz.zn.taskalifteach.data.datasourse

import androidx.room.*
import com.example.alifteachtask.data.model.TaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * from tasks")
    fun selectAllTask(): Flow<List<TaskEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(entity: TaskEntity): Long

    @Delete
    fun delete(entity: TaskEntity)

      @Update
    fun updateTask(taskEntity: TaskEntity): Int
}
