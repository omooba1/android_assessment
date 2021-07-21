package com.david.apicall.api

import com.david.apicall.model.Item
import com.david.apicall.model.Student
import retrofit2.Call
import retrofit2.http.*

interface PlaceHolderAPI {

    @GET("items")
    suspend fun getItems(): List<Item>

    @GET("students")
    suspend fun getStudent(): List<Student>

    @POST("students")
    suspend fun addStudent(@Body newStudent: Student): List<Student>
}