package uz.zn.taskalifteach.data.network

import uz.zn.taskalifteach.data.service.PostApi


interface RestProvider {
    val postApi: PostApi
}