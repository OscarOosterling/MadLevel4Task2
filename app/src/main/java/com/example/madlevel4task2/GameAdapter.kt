package com.example.madlevel4task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_game.view.*
import kotlinx.android.synthetic.main.item_game.view.*

class GameAdapter(private val games:List<Game>): RecyclerView.Adapter<GameAdapter.ViewHolder>(){
    var images:IntArray = intArrayOf(R.drawable.rock,R.drawable.paper,R.drawable.scissors)
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun databind(game:Game){
            //itemView.iv_computer_hand.setImageResource(images[game.computerPlay])
            //itemView.iv_player_hand.setImageResource(images[game.playerPlay])
            itemView.txt_result_cardview.text = game.result.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_game,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(games[position])
    }

    override fun getItemCount(): Int {
        return games.size
    }
}