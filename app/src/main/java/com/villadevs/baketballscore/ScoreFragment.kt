package com.villadevs.baketballscore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.villadevs.baketballscore.databinding.FragmentScoreBinding
import com.villadevs.baketballscore.viewmodel.BasketballViewModel


class ScoreFragment : Fragment() {

    private var _binding: FragmentScoreBinding? = null
    private val binding get() = _binding!!

    private val viewModel: BasketballViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentScoreBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.localScore.observe(viewLifecycleOwner) { newLocalScore ->
            binding.tvLocalScore.text = newLocalScore.toString()
        }

        viewModel.visitantScore.observe(viewLifecycleOwner) { newVisitantScore ->
            binding.tvVisitantScore.text = newVisitantScore.toString()
        }

        setButtons()

    }

    private fun setButtons() {
        binding.btLocalScoreMinus.setOnClickListener {
            viewModel.decreaseLocalScore()
        }

        binding.btLocalScorePlusOne.setOnClickListener {
            viewModel.addPointsToScore(1, true)
        }

        binding.btLocalScorePlusTwo.setOnClickListener {
            viewModel.addPointsToScore(2, true)
        }

        binding.btVisitantScoreMinus.setOnClickListener {
            viewModel.decreaseVisitantScore()
        }

        binding.btVisitantScorePlusOne.setOnClickListener {
            viewModel.addPointsToScore(1, false)
        }

        binding.btVisitantScorePlusTwo.setOnClickListener {
            viewModel.addPointsToScore(2, false)
        }

        binding.btResetScore.setOnClickListener {
            viewModel.resetScores()
        }

        binding.btGoToFinalScore.setOnClickListener {
            val action = ScoreFragmentDirections.actionScoreFragmentToFinalScoreFragment(
                viewModel.localScore.value!!,
                viewModel.visitantScore.value!!
            )
            this.findNavController().navigate(action)
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}