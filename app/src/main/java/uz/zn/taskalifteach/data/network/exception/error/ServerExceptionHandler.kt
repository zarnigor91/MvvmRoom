package uz.zn.taskalifteach.data.network.exception.error




import uz.zn.guidebook.data.network.exception.interceptor.HttpErrorResponse
import uz.zn.guidebook.data.network.exception.interceptor.HttpErrorResponseHandler
import uz.zn.taskalifteach.data.network.exception.ServerBadRequestException
import java.io.IOException
import java.net.HttpURLConnection

internal class ServerExceptionHandler : HttpErrorResponseHandler {

    override fun onHandleError(
        httpErrorCode: Int, errorResponse: HttpErrorResponse
    ): IOException? = when (httpErrorCode) {
        HttpURLConnection.HTTP_BAD_REQUEST ->
            throw ServerBadRequestException(errorResponse)
//        HttpURLConnection.HTTP_UNAUTHORIZED ->
//            throw ServerUnauthorizedException(errorResponse)
//        HttpURLConnection.HTTP_PAYMENT_REQUIRED ->
//            throw ServerPaymentRequiredException(errorResponse)
//        HttpURLConnection.HTTP_FORBIDDEN ->
//            throw ServerForbiddenException(errorResponse)
//        HttpURLConnection.HTTP_NOT_FOUND ->
//            throw ServerNotFoundException(errorResponse)
//        HttpURLConnection.HTTP_INTERNAL_ERROR ->
//            throw ServerInternalServerErrorException(errorResponse)
//        HttpURLConnection.HTTP_UNAVAILABLE ->
//            throw ServiceUnavailableException(errorResponse)
        else -> null
    }
}