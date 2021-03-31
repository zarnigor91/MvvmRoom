package uz.zn.taskalifteach.app.feature.feature.edit

import uz.zn.taskalifteach.app.feature.feature.creation.CreationTaskResource

sealed class UpdateTaskResource {

    object Loading : UpdateTaskResource()

    data class Success(
        val values: Int
    ) : UpdateTaskResource()

    data class Failure(val throwable: Throwable) : UpdateTaskResource()
}