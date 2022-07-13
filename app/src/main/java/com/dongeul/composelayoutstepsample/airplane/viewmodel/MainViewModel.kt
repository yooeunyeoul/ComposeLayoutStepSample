package com.dongeul.composelayoutstepsample.airplane.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dongeul.composelayoutstepsample.airplane.di.DongeulPatcher
import com.dongeul.composelayoutstepsample.airplane.model.ExploreModel
import com.dongeul.composelayoutstepsample.airplane.repository.DestinationsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.random.Random

const val MAX_PEOPLE =4

@HiltViewModel
class MainViewModel @Inject constructor(
    private val destinationsRepository: DestinationsRepository,
    @DongeulPatcher private val dongeulPatcher: CoroutineDispatcher
) : ViewModel() {

    val hotels: List<ExploreModel> = destinationsRepository.hotels
    val restaurants: List<ExploreModel> = destinationsRepository.restaurants

    private val _suggestedDestinations = MutableStateFlow<List<ExploreModel>>(emptyList())

    val suggestedDestinations: StateFlow<List<ExploreModel>>
        get() = _suggestedDestinations

    init {
        _suggestedDestinations.value = destinationsRepository.destinations
        registerLogin()

    }

    fun registerLogin() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = destinationsRepository.registerLogin()
                Log.d("registerLogin",response.toString())
            } catch (th: Throwable) {
                Log.e("registerLogin",th.message?:"")
            }
        }
    }

    fun updatePeople(people: Int) {
        viewModelScope.launch {
            if (people > MAX_PEOPLE) {
                _suggestedDestinations.value = emptyList()
            } else {
                val newDestinations = withContext(dongeulPatcher){
                    destinationsRepository.destinations.shuffled(Random(people *(1..100).shuffled().first()))
                }
                _suggestedDestinations.value = newDestinations
            }
        }
    }
}