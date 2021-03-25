package com.example.githubuser


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var username:String,
    var name:String,
    var avatar:Int,
    var company:String,
    var location:String,
    var following:String,
    var followers:String,
    var repository:String
) : Parcelable
