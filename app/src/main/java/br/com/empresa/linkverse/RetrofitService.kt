package br.com.empresa.linkverse

import retrofit2.Call
import  retrofit2.http.GET

interface RetrofitService {

    @get:GET("posts")

    val posts : Call <List<Post?>?>?

    companion object {
        const val BASE_URL: String = "https://jsonplaceholder.typicode.com/"
    }
}