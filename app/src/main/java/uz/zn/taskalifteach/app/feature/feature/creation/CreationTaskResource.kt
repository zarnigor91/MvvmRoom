package uz.zn.taskalifteach.app.feature.feature.creation

sealed class CreationTaskResource {

    object Loading : CreationTaskResource()

    data class Success(
        val values: Long
    ) : CreationTaskResource()

    data class Failure(val throwable: Throwable) : CreationTaskResource()
}