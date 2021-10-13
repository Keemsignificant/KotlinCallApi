package keem.practice.develop.kotlincallapi

import com.google.gson.annotations.SerializedName

class Data(
    @SerializedName("id")
    val id:Int,

    @SerializedName("title")
    val title:String,

    @SerializedName("content")
    val content:String,

    @SerializedName("thumbnail")
    val pic:String,

)