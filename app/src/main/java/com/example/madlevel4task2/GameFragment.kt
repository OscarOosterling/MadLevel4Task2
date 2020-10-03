package com.example.madlevel4task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_game.*
import kotlin.random.Random


const val REQ_GAME_KEY = "req_game"
const val BUNDLE_GAME_KEY = "bundle_game"
/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class GameFragment : Fragment() {




    var rock:Int = 0
    var paper:Int = 1
    var scissors:Int = 2

    var images:IntArray = intArrayOf(R.drawable.rock,R.drawable.paper,R.drawable.scissors)
    var resultStrings:Array<String> = arrayOf("Draw!","You win!","You Lose")

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_rock.setOnClickListener{
            startGame(rock)

        }
        btn_paper.setOnClickListener{
            startGame(paper)

        }
        btn_scissors.setOnClickListener{
            startGame(scissors)

        }

    }

    private fun SaveGame(computerPlay: Int,play: Int,result: Int) {
        val game = Game(computerPlay,play,result)
        setFragmentResult(REQ_GAME_KEY, bundleOf(Pair(BUNDLE_GAME_KEY,game)))
        findNavController().navigate(R.id.action_gameFragment_to_historyFragment)
    }

    private fun startGame(play: Int) {
        var computerPlay = pickComputerPlay()

        var result = results(play,computerPlay)

        iv_player_hand.setImageResource(images[play])
        iv_computer_hand.setImageResource(images[computerPlay])
        txt_win_message.text = resultStrings.get(result)

        SaveGame(computerPlay,play,result)
    }

    private fun results(play: Int, computerPlay: Int):Int {
        return (3 + play - computerPlay) % 3
    }

    private fun pickComputerPlay(): Int {
        return Random.nextInt(0,3)
    }
}