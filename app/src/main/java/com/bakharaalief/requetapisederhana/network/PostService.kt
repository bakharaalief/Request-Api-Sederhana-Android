package com.bakharaalief.requetapisederhana.network

import com.bakharaalief.requetapisederhana.model.Post
import retrofit2.http.GET

interface PostService {
    @GET("/posts")
    suspend fun getPost() : List<Post>
}