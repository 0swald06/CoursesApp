package com.example.coursesapp.Modelo.Local.Database

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "courses_list_table")
data class CoursesEntity (

    @PrimaryKey
    @NonNull
    val id:String,
    val title:String,
    val previewDescription:String,
    val image:String,
    val weeks: Int,
    val star:String


        )

