package au.com.wwc.droidtalk.data.api

import au.com.wwc.droidtalk.data.model.Message
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MessageApi {

    @GET("/messages")
    fun getMessages(): Observable<List<Message>>

    @POST("/messages")
    fun sendMessage(@Body message: Message): Observable<Message>

    companion object Factory {
        fun create(): MessageApi {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://wwc-chatroom-staging.herokuapp.com/")
                    .build()

            return retrofit.create(MessageApi::class.java);
        }
    }
}
