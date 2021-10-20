package uz.zn.taskalifteach.data.network.exception.error

import uz.zn.guidebook.data.network.exception.interceptor.HttpErrorResponseMapper


internal class ServerExceptionMapper : HttpErrorResponseMapper {
    override fun onHandleResponse(httpErrorCode: Int, response: String?) =
        null
}