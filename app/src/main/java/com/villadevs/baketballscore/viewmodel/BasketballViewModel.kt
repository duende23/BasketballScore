package com.villadevs.baketballscore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BasketballViewModel : ViewModel() {

    private val _localScore = MutableLiveData(0)
    val localScore: LiveData<Int>
        get() = _localScore

    private val _visitantScore = MutableLiveData(0)
    val visitantScore: LiveData<Int>
        get() = _visitantScore


    init {
        resetScores()
    }

    fun resetScores() {
        _localScore.value = 0
        _visitantScore.value = 0
    }


    fun addPointsToScore(points: Int, isLocal: Boolean) {
        if (isLocal) {
            _localScore.value = _localScore.value!!.plus(points)
        } else {
            _visitantScore.value = _visitantScore.value!!.plus(points)
        }
    }

    fun decreaseLocalScore() {
        if (localScore.value!! > 0) {
            _localScore.value = _localScore.value!!.minus(1)
        }

    }

    fun decreaseVisitantScore() {
        if (visitantScore.value!! > 0) {
            _visitantScore.value = _visitantScore.value!!.minus(1)
        }

    }


}