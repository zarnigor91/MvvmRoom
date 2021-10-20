package uz.zn.taskalifteach.data.network.exception

import uz.zn.guidebook.data.network.exception.interceptor.HttpErrorResponse
import uz.zn.taskalifteach.data.network.exception.exeption.ServerBaseException


class ServiceUnavailableException(
    override val response: HttpErrorResponse
) : ServerBaseException(response)