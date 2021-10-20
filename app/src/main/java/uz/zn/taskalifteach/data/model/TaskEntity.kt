package com.example.alifteachtask.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import uz.zn.taskalifteach.data.model.Data
import uz.zn.taskalifteach.data.model.Venue


@Entity(tableName = "tasks")
data class TaskEntity (
        @PrimaryKey(autoGenerate = true)
        val bookId: Long? = null,
        @ColumnInfo(name = "endDate")
        val endDate: String? = "",
        @ColumnInfo(name = "eicon")
        val icon: String? = "",
        @ColumnInfo(name = "data")
        var data: String? = null,
        @ColumnInfo(name = "loginRequired")
        val loginRequired: Boolean? = false,
        @ColumnInfo(name ="name")
        val name: String? = "",
        @ColumnInfo(name ="objType")
        val objType: String? = "",
        @ColumnInfo(name ="startDate")
        val startDate: String? = "",
        @ColumnInfo(name ="url")
        val url: String? = "",
//        @ColumnInfo(name ="venue")
//        val venue: Venue? = null
)
fun TaskEntity.toBook() : Data {
        return Data(
                endDate,
                icon,loginRequired,name,objType,startDate,url

        )
}