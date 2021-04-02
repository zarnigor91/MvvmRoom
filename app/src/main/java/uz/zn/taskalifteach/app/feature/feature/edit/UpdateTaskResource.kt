package uz.zn.taskalifteach.app.feature.feature.edit


sealed class UpdateTaskResource {

    object Loading : UpdateTaskResource()

    data class Success(
        val values: Int

    ) : UpdateTaskResource()


    data class Failure(val throwable: Throwable) : UpdateTaskResource()
}