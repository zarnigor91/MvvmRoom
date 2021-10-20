package uz.zn.taskalifteach.data.datasourse.provider

import android.content.Context
import uz.zn.taskalifteach.data.datasourse.TaskDatabase
import uz.zn.taskalifteach.data.datasourse.TaskDao

 class DatabaseProviderImpl(context: Context) : DatabaseProvider {

    private val taskDatabase: TaskDatabase by lazy {
        TaskDatabase.getAppDatabase(context)
    }

    override val taskDao: TaskDao
        get() = taskDatabase.taskDao
}