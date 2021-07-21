package com.bakharaalief.requetapisederhana.data.api

import com.bakharaalief.requetapisederhana.data.model.Post
import retrofit2.http.GET

interface PostService {
    @GET("/posts")
    suspend fun getPost() : List<Post>
}