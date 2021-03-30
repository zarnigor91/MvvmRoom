package uz.zn.taskalifteach.app.feature.feature.creation

import com.example.alifteachtask.data.model.TaskEntity

sealed class CreationResource {

    object Loading : CreationResource()

    data class Success(
        val values: Long
    ) : CreationResource()

    data class Failure(val throwable: Throwable) : CreationResource()
}