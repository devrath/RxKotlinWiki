package com.istudio.code.modules.module_demos.creating_observable

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import demoOf
import episodeI
import episodeII
import episodeIII
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.toObservable
import javax.inject.Inject


@HiltViewModel
class CreatingObservableDemoVm @Inject constructor( ) : ViewModel() {

    /**
     * Here it emits one emission from the observable with just one element
     */
    fun oneEmission() {
        val oneMovie : Observable<String> = Observable.just(episodeI)
    }

    /**
     * Here the observable emits a sequence of emissions
     */
    fun groupOfEmissions() {
        val collectionOfMovies = Observable.just(episodeI,episodeII,episodeIII)
    }

    /**
     * Creating a observable from a list of strings
     */
    fun listOfEmissions() {
        val lostOfMovies = Observable.just(listOf( episodeI, episodeII, episodeIII ))
    }

    /**
     * Converting a list to observable using toObservable
     */
    fun listToObservable() {
        val observableMovieList = listOf( episodeI, episodeII, episodeIII ).toObservable()
    }

}