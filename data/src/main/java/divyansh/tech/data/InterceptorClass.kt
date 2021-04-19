package divyansh.tech.data

import android.util.Log
import divyansh.tech.data.annotations.WithInterceptor
import divyansh.tech.data.persistence.DataStoreManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Invocation
import javax.inject.Inject

/*
* Interceptor class to add the auth token  to every request
* */
class InterceptorClass @Inject constructor(
    private val dataStoreManager: DataStoreManager
): Interceptor {


    /*
    * Provides the actual HTTPClient to be added to the retrofit instance as the middleware
    * @param chain, the interceptor chain
    * @returns Response
    * */
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().newBuilder()
        runBlocking {
            val token = dataStoreManager.authToken.first()
            if (token.isNotEmpty()) {
                Log.i("VIEWMODEL", token)
                newRequest
                    .addHeader("Authorization", "token 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")
                    .addHeader("Accept", "application/json")
                    .addHeader("User-Agent", "request")
            } else {
                Log.i("VIEWMODEL", "EMPTY TOKEN")
            }
        }
        Log.i("VIEWMODEL::NEWREQUEST", newRequest.toString())
        return chain.proceed(newRequest.build())
    }
}