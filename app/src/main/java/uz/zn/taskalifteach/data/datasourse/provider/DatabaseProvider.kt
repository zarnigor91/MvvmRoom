package uz.zn.taskalifteach.data.datasourse.provider

import uz.zn.taskalifteach.data.datasourse.TaskDao

 interface DatabaseProvider {
    val taskDao: TaskDao
}