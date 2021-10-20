package uz.zn.guidebook.data.network.exception.interceptor

internal interface HttpErrorResponseMapper : HttpErrorDispatcherComponent {

    fun onHandleResponse(
        httpErrorCode: Int,
        response: String?
    ): HttpErrorResponse?
}