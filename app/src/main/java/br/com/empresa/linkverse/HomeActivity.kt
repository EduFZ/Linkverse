package br.com.empresa.linkverse

import android.R.layout
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        configureUI()
    }

    fun configureUI() {
        val rf = Retrofit.Builder()
            .baseUrl(RetrofitService.BASE_URL)
            .addConverterFactory(
                GsonConverterFactory
                    .create()
            ).build()

        val api = rf.create(RetrofitService::class.java)
        val call = api.posts
        call?.enqueue(object : Callback<List<Post?>?> {

            override fun onFailure(call: Call<List<Post?>?>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<List<Post?>?>,
                response: Response<List<Post?>?>
            ) {
                val postList: List<Post> = response.body() as List<Post>
                val post: Array<String?> = arrayOfNulls(postList!!.size)

                for (i in postList!!.indices) {
                    post[i] = postList!![i]!!.body
                    val adapter = ArrayAdapter<String>(
                        applicationContext,
                        layout.simple_dropdown_item_1line,
                        post
                    )
                    val listview = findViewById<ListView>(R.id.listview)
                    listview.adapter = adapter
                }
            }
        })
    }
}






