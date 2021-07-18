package com.david.apicall.api

import com.david.apicall.model.Item
import com.david.apicall.model.Student
import com.david.apicall.model.StudentResponse
import retrofit2.Call
import retrofit2.http.*

interface PlaceHolderAPI {

    @GET("items")
    fun getItems(): Call<List<Item>>

    @GET("students")
    fun getStudentList(): Call<List<Student>>

    @GET("students/{student_seat}")
    fun getStudent(@Path("student_seat") student_seat: String): Call<List<Student>>

    @GET("students")
    fun searchStudent(@Query("name") searchText: String): Call<List<Student>>

    @POST("students")
    fun createStudent(@Body params: Student): Call<List<StudentResponse>>

    @PATCH("students/{student_seat}")
    fun updateStudent(@Path("student_seat") student_seat: String, @Body params: Student): Call<List<StudentResponse>>

    @DELETE("students/{student_seat}")
    fun deleteStudent(@Path("student_seat") student_seat: String): Call<List<StudentResponse>>
}