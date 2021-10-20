package uz.zn.taskalifteach.data.model


import com.example.alifteachtask.data.model.TaskEntity
import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("endDate")
    val endDate: String? = "",
    @SerializedName("icon")
    val icon: String? = "",
    @SerializedName("loginRequired")
    val loginRequired: Boolean? = false,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("objType")
    val objType: String? = "",
    @SerializedName("startDate")
    val startDate: String? = "",
    @SerializedName("url")
    val url: String? = "",
    @SerializedName("venue")
    val venue: Venue? = Venue()
)
fun Data.toEntity() : TaskEntity {
    return TaskEntity(null,endDate,icon, data = String(), loginRequired,name,objType,startDate,url
    )
}