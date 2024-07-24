package com.example.lesson211.data


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class Notes(
    val id: Int,
    val name: String,
    val text: String,
    val date: String
) : Parcelable


