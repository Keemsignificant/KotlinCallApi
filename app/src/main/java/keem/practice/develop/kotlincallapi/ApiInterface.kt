package keem.practice.develop.kotlincallapi


import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface ApiInterface {



    @GET("coffee.json")
    fun getData(): Observable<List<Data>>
}