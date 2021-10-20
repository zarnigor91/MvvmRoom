package uz.zn.taskalifteach.data.model


import com.google.gson.annotations.SerializedName

data class GuideBookModel(
    @SerializedName("data")
    val data: List<Data>? = listOf(),
    @SerializedName("total")
    val total: String? = ""
)