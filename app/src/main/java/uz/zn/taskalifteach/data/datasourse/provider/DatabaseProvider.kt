package uz.zn.taskalifteach.data.datasourse.provider

import com.example.alifteachtask.data.datasourse.TaskDao

internal interface  DatabaseProvider {
    val taskDao : TaskDao
}