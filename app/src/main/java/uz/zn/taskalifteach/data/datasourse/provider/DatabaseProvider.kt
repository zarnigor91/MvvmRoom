package uz.zn.taskalifteach.data.datasourse.provider

import uz.zn.taskalifteach.data.datasourse.TaskDao

internal interface DatabaseProvider {
    val taskDao: TaskDao
}