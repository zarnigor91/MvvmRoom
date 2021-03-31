package uz.zn.taskalifteach.app.feature.feature.alltask

import com.example.alifteachtask.data.model.TaskEntity

sealed class TaskDeleteResource {
    object Loading : TaskDeleteResource()

    data class Success(
        val values: Unit
    ) :TaskDeleteResource()

    data class Failure(val throwable: Throwable) : TaskDeleteResource()
}