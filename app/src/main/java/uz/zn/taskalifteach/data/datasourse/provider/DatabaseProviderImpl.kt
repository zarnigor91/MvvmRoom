package uz.zn.taskalifteach.data.datasourse.provider

import android.content.Context
import com.example.alifteachtask.data.datasourse.TaskDao

internal class DatabaseProviderImpl( context: Context) :DatabaseProvider {
    override val taskDao: TaskDao
        get() = TODO("Not yet implemented")
}