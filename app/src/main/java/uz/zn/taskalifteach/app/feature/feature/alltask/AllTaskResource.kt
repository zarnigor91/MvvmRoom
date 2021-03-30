package uz.zn.taskalifteach.app.feature.feature.alltask

import com.example.alifteachtask.data.model.TaskEntity


sealed class AllTaskResource {

    object Loading : AllTaskResource()

    data class Success(
        val values: List<TaskEntity>
    ) : AllTaskResource()

    data class Failure(val throwable: Throwable) : AllTaskResource()
}