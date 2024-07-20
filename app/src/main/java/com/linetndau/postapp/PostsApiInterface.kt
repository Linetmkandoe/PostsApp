package com.linetndau.postapp

import retrofit2.Call
import retrofit2.http.GET

interface PostsApiInterface {
    @GET("/posts")
    fun  fetchPosts(): Call<List<Post>>
}