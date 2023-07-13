package com.example.coursesapp.Modelo.Remote

import com.example.coursesapp.Modelo.Local.CentroFuturoDao
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitClient {

    companion object{
        private const val BASE_URL="https://caso-invest-center-mariocanedo.vercel.app/"
        fun retrofitInstance():CentroFuturoApi{


            val retrofit=Retrofit.Builder()
            .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(CentroFuturoApi::class.java)

        }
    }

}