package com.example.madlevel4task2

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Game(
    var computerPlay:Int,
    var playerPlay:Int,
    var result:Int
):Parcelable
