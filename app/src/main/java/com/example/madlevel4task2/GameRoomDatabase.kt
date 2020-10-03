package com.example.madlevel4task2

import android.content.Context
import androidx.room.*
import java.sql.Timestamp
import java.util.*

@Database(entities = [Game::class],version = 1,exportSchema = false)
@TypeConverters(Converters::class)
abstract class GameRoomDatabase: RoomDatabase(){

    abstract fun gameDao():GameDao
    companion object{
        private const val DATABASE_NAME = "GAME_DATABASE"

        @Volatile
        private var gameRoomDatabaseInstance:GameRoomDatabase? = null

        fun getDatabase(context: Context):GameRoomDatabase?{
            if(gameRoomDatabaseInstance == null){
                synchronized(GameRoomDatabase::class.java){
                    if(gameRoomDatabaseInstance == null){
                        gameRoomDatabaseInstance = Room.databaseBuilder(context.applicationContext,GameRoomDatabase::class.java,
                            DATABASE_NAME).allowMainThreadQueries().build()
                    }
                }
            }
            return gameRoomDatabaseInstance
        }
    }
}
class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Timestamp? {
        return value?.let { Timestamp(it) }
    }

    @TypeConverter
    fun dateToTimestamp(timeStamp: Timestamp?): Long? {
        return timeStamp?.time?.toLong()
    }
}