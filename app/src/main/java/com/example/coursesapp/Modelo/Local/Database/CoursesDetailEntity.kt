package com.example.coursesapp.Modelo.Local.Database

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "course_details_table")
data class CoursesDetailEntity (

    @PrimaryKey
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