package uz.zn.taskalifteach.app.feature.feature.alltask

import com.example.alifteachtask.data.model.TaskEntity
import uz.zn.taskalifteach.data.model.Data


sealed class AllTaskResource {

    object Loading : AllTaskResource()

    data class Success(
        val values: List<Data>
    ) : AllTaskResource()

    data class Failure(val throwable: Throwable) : AllTaskResource()
}