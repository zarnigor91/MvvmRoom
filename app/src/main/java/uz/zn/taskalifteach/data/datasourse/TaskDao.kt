package com.example.alifteachtask.data.datasourse

import androidx.room.*
import com.example.alifteachtask.data.model.TaskEntity

@Dao
interface TaskDao {

    @Query("SELECT * from tasks")
    fun selectAllFoods(): MutableList<TaskEntity>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNews(newsEntity: List<TaskEntity>)


    @Delete
    fun deleteFood(food: TaskEntity): Int

}