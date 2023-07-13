package com.example.coursesapp.Modelo.Local.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.coursesapp.Modelo.Local.CentroFuturoDao

@Database(entities = [CoursesEntity::class, CoursesDetailEntity::class], version =  1,
exportSchema = false)
abstract class CourseDatabase:RoomDatabase(){

    abstract fun getCentroFuturoDao(): CentroFuturoDao

    companion object{

        @Volatile
        private var
                INSTANCE: CourseDatabase?=null
        fun getDataBase(context:Context): CourseDatabase {
            val tempInstance= INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    CourseDatabase::class.java,"courses_db_058")
                    .build()
                INSTANCE =instance
                return instance
            }

        }

    }

}