package com.example.madlevel4task2

import android.content.Context

public class GameRepository(context: Context){
    private var gameDao:GameDao
    init {
        val gameRoomDatabase = GameRoomDatabase.getDatabase(context)
        gameDao = gameRoomDatabase!!.gameDao()
    }
    fun getAllGames():List<Game>{
        return gameDao.getAllGames()
    }
    fun insertGame(game: Game){
        gameDao.insertGame(game)
    }
    fun deleteGame(game: Game){
        gameDao.deleteGame(game)
    }
    fun updateGame(game: Game){
        gameDao.updateGame(game)
    }
    fun deleteAllGames(){
        gameDao.deleteAllProducts()
    }

}