package com.example.coursesapp.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.coursesapp.Modelo.CentroFuturoRepository
import com.example.coursesapp.Modelo.Local.Database.CourseDatabase
import com.example.coursesapp.Modelo.Local.Database.CoursesDetailEntity
import com.example.coursesapp.Modelo.Local.Database.CoursesEntity
import kotlinx.coroutines.launch

class CoursesViewModel(application: Application):AndroidViewModel(application) {

    private val repository:CentroFuturoRepository

    private val courseDetailLiveData=MutableLiveData<CoursesDetailEntity>()

    private var idSelected:String="-1"

    init {
        val bd=CourseDatabase.getDataBase(application)

        val centroFuturoDao=bd.getCentroFuturoDao()
        repository= CentroFuturoRepository(centroFuturoDao)
        viewModelScope.launch {
            repository.fechCourses()
        }
    }

    fun getCourseList():LiveData<List<CoursesEntity>> =repository.cousesListLiveData

    fun getCourseDetail():LiveData<CoursesDetailEntity> = courseDetailLiveData

    fun getCourseDeatilByIdFromInternet(id:String)= viewModelScope.launch {

        val courseDetail=repository.fetchCourseDetail(id)
    courseDetail?.let {
        courseDetailLiveData.postValue(it)
    }


    }
}