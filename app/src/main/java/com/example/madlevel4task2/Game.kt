package com.example.madlevel4task2

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.sql.Timestamp

@Parcelize
@Entity(tableName = "gameTable")
data class Game(
    @ColumnInfo(name="computerPlay")
    var computerPlay:Int,
    @ColumnInfo(name="playerPlay")
    var playerPlay:Int,
    @ColumnInfo(name="result")
    var result:Int,
    @ColumnInfo(name = "timestamp")
    var time:Timestamp,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
):Parcelable
