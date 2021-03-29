package uz.zn.taskalifteach.data.datasourse

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.alifteachtask.data.model.TaskEntity

@Database(entities = [TaskEntity::class], version = 1, exportSchema = false)
//@TypeConverters(StringListConverters::class, MitableListConverters::class)
abstract class TaskDB : RoomDatabase() {

    abstract fun getNewsDao(): TaskDao

    companion object {
        private const val DB_NAME = "NewsDatabase"
        private var resultDataBase: TaskDB? = null


        fun getAppDatabase(context: Context): TaskDB {
            return Room.databaseBuilder(context.applicationContext, TaskDB::class.java, DB_NAME)
                    .allowMainThreadQueries()
                    .build()
        }
    }
}