package com.linetndau.postapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var PostDetailsAdapter : PostDetailsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.rvPost)
        recyclerView.layoutManager=LinearLayoutManager(this)
fetchPosts()

        }

    fun fetchPosts(){
        val apiInterface = ApiClient.buildApiInterface(PostsApiInterface::class.java)
        val request = apiInterface.fetchPosts()
        request.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    val post = response.body()
                    post?.let {
                        PostDetailsAdapter = PostDetailsAdapter(it)
                        recyclerView.adapter = PostDetailsAdapter

                        Toast.makeText(baseContext, "fetched $post!!.size}post", Toast.LENGTH_LONG)
                            .show()
                    }
                }
                else{
                    Toast.makeText(baseContext, response.errorBody()?.string(), Toast.LENGTH_LONG).show()

                    } }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(baseContext,t.message, Toast.LENGTH_LONG)
            } }

        )} }
