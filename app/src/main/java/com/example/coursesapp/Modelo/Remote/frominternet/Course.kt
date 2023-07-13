package com.example.coursesapp.Modelo.Remote.frominternet

data class Course(
    val id:String,
    val title:String,
    val previewDescription:String,
    val image:String,
    val weeks: Int,
    val start:String
)