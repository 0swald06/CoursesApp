package com.example.coursesapp.Modelo

import com.example.coursesapp.Modelo.Local.Database.CoursesDetailEntity
import com.example.coursesapp.Modelo.Local.Database.CoursesEntity
import com.example.coursesapp.Modelo.Remote.frominternet.Course
import com.example.coursesapp.Modelo.Remote.frominternet.CourseDetail

fun fromInternetToCousesEntity(coursesList:List<Course>):List<CoursesEntity>{

    return coursesList.map {

        CoursesEntity(
            id=it.id,
            title=it.title,
            previewDescription =it.previewDescription,
            image=it.image,
            weeks=it.weeks,
            star=it.start

        )
    }

}
fun fromInternetToCousesDetailEntity(course:CourseDetail):CoursesDetailEntity{

    return  CoursesDetailEntity(
            id=course.id,
            title=course.title,
            previewDescription = course.previewDescription,
            image = course.image,
            weeks = course.weeks,
            tuition = course.tuition,
            miniumSkill = course.miniumSkill,
            scholashipAvailable = course.scholashipAvailable,
            modality = course.modality,
            star = course.star

        )
 }


