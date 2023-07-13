package com.example.coursesapp.Modelo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.coursesapp.Modelo.Local.CentroFuturoDao
import com.example.coursesapp.Modelo.Local.Database.CoursesDetailEntity
import com.example.coursesapp.Modelo.Remote.RetrofitClient

class CentroFuturoRepository(private val centroFuturoDao: CentroFuturoDao) {

    private val networkService = RetrofitClient.retrofitInstance()

    val cousesListLiveData = centroFuturoDao.getAllCourses()

    val courseDetailLiveData = MutableLiveData<CoursesDetailEntity>()


    suspend fun fechCourses() {

        val service = kotlin.runCatching { networkService.fecthCoursesList() }

        service.onSuccess {

            when (it.code()) {
                in 200..299-> it.body()?.let {

                    centroFuturoDao.insertAllCourses(fromInternetToCousesEntity(it))
                }

                else -> Log.d("Repo", "${it.code()}-${it.errorBody()}")
            }
            service.onFailure {
                Log.e("Error", "${it.message}")
            }
        }

    }
    suspend fun fetchCourseDetail(id: String): CoursesDetailEntity? {
        val service = kotlin.runCatching { networkService.fecthCoursesDetail(id) }
        return service.getOrNull()?.body()?.let {
            // guardp los datos que viene del mapper y luego se los paso a dao directo
            val courseDetailEntity = fromInternetToCoursesDetailEntity(it)
            //inserto los detalles de los curso DEL REPOSITORIO
            centroFuturoDao.insertAllCoursesDetail(courseDetailEntity)
            courseDetailEntity
        }
    }

}