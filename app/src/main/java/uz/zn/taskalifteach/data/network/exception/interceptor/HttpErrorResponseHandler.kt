package uz.zn.guidebook.data.network.exception.interceptor

import java.io.IOException

internal interface HttpErrorResponseHandler : HttpErrorDispatcherComponent {

    fun onHandleError(
        httpErrorCode: Int,
        errorResponse: HttpErrorResponse
    ): IOException?
}