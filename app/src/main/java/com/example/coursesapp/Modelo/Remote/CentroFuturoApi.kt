package com.example.coursesapp.Modelo.Remote

import com.example.coursesapp.Modelo.Local.Database.CoursesEntity
import com.example.coursesapp.Modelo.Remote.frominternet.Course
import com.example.coursesapp.Modelo.Remote.frominternet.CourseDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CentroFuturoApi {



    @GET("courses")
    suspend fun fecthCoursesList():Response<List <Course>>

    @GET("courses/{id}")
    suspend fun fecthCoursesDetail(@Path("id")id:String):Response<List <CourseDetail>>


}