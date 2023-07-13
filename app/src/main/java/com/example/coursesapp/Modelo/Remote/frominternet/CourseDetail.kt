package com.example.coursesapp.Modelo.Remote.frominternet



data class CourseDetail(
    val id:String,
    val title:String,
    val previewDescription:String,
    val image:String,
    val weeks: Int,
    val tuition:String,
    val miniumSkill:String,
    val scholashipAvailable:Boolean,
    val modality:String,
    val star:String
)