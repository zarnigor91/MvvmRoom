package uz.zn.taskalifteach.data.network.exception.exeption


import uz.zn.guidebook.data.network.exception.interceptor.HttpErrorResponse
import java.io.IOException

open class ServerBaseException(open val response: HttpErrorResponse) : IOException()