package com.example.alifteachtask.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tasks")
data class TaskEntity (
        @PrimaryKey(autoGenerate = true)
        var id:Long? = 0,
        @ColumnInfo(name = "name")
        var name: String? = null,
        @ColumnInfo(name = "data")
       var data: String? = null

)