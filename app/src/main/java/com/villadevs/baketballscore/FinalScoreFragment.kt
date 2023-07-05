package com.villadevs.baketballscore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.villadevs.baketballscore.databinding.FragmentFinalScoreBinding
import com.villadevs.baketballscore.databinding.FragmentScoreBinding


class FinalScoreFragment : Fragment() {


    private var _binding: FragmentFinalScoreBinding? = null
    private val binding get() = _binding!!

    private val args: FinalScoreFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentFinalScoreBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val finalLocalScore = args.finalLocaScore
        val finalVisitantScore = args.finalVisitantScore

        binding.tvLocalScoreFinal.text = finalLocalScore.toString()
        binding.tvVisistantScoreFinal.text = finalVisitantScore.toString()

        when {
            finalLocalScore > finalVisitantScore -> binding.tvLabelTeamWin.text = getString(R.string.local_won)
            finalVisitantScore > finalLocalScore -> binding.tvLabelTeamWin.text = getString(R.string.visitor_won)
            else -> binding.tvLabelTeamWin.text = getString(R.string.it_was_a_tie)
        }

    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }




}