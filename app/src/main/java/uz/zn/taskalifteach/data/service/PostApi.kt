package uz.zn.taskalifteach.data.service

import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import uz.zn.taskalifteach.data.model.GuideBookModel


interface PostApi {
    @GET("upcomingGuides/")
    fun getAllBook(): Flow<GuideBookModel>
}