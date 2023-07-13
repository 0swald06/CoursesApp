package com.example.coursesapp.Modelo.Local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.coursesapp.Modelo.Local.Database.CoursesDetailEntity
import com.example.coursesapp.Modelo.Local.Database.CoursesEntity


@Dao
interface CentroFuturoDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCourses(listCourses:List <CoursesEntity>)

    @Query("SELECT * FROM courses_list_table ORDER BY id ASC")
    fun getAllCourses():LiveData<List <CoursesEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCoursesDetail(course: CoursesDetailEntity)

  //  @Query("SELECT * FROM course_details_table ORDER BY id ASC")
  //  fun getAllCoursesDetailByID(id:String): CoursesDetailEntity

}