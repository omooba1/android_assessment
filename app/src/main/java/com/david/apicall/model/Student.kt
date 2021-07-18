package com.david.apicall.model

data class Student(
    val `class`: String,
    val name: String,
    val seat: Int
)

data class StudentResponse(val code: Int?, val meta: String?, val data: Student?)