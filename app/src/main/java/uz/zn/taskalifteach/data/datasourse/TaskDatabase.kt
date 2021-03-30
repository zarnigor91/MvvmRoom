package uz.zn.taskalifteach.data.datasourse

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.alifteachtask.data.model.TaskEntity

@Database(entities = [TaskEntity::class], version = 1, exportSchema = false)
//@TypeConverters(StringListConverters::class, MitableListConverters::class)
abstract class TaskDatabase : RoomDatabase() {

    abstract val taskDao: TaskDao

    companion object {
        private const val DB_NAME = "NewsDatabase"
        fun getAppDatabase(context: Context): TaskDatabase {
            return Room.databaseBuilder(context.applicationContext, TaskDatabase::class.java, DB_NAME)
                .allowMainThreadQueries()
                .build()
        }
    }
}