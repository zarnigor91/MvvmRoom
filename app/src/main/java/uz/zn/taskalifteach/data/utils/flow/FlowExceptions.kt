package uz.mayasoft.marta.wallet.data.utils.flow

import android.util.Log
import kotlinx.coroutines.flow.*
import java.util.concurrent.CancellationException

@Suppress("EXPERIMENTAL_API_USAGE")
suspend fun <T> Flow<Result<T>>.launchWithState(
    onStart: () -> Unit = {}, onSuccess: (T) -> Unit, onFailure: (Throwable) -> Unit = {}
) = onStart { runCatching(onStart).onFailure(onFailure) }
    .collect { it ->
        it.onSuccess { runCatching { onSuccess.invoke(it) }.onFailure(onFailure) }
        it.onFailure {
            if (it !is CancellationException) {
                Log.wtf("Flow error:", it)
                onFailure(it)
            }
        }
    }

@Suppress("RemoveExplicitTypeArguments", "EXPERIMENTAL_API_USAGE")
fun <T> Flow<T>.mapToFlowResult(): Flow<Result<T>> =
    map { Result.success(it) }.catch { emit(Result.failure(it)) }