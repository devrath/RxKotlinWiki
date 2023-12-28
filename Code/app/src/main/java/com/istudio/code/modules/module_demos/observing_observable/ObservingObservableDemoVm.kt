package com.istudio.code.modules.module_demos.observing_observable

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import episodeI
import episodeII
import episodeIII
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.kotlin.toObservable
import javax.inject.Inject

@HiltViewModel
class ObservingObservableDemoVm @Inject constructor( ) : ViewModel() {


    /**
     * Subscribing to observable
     */
    fun subscribingToObserve() {
        val observable = listOf( episodeI, episodeII, episodeIII ).toObservable()

        observable.subscribe{
            println("Result-> $it")
        }
    }

    /**
     * Subscribing to observable using subscribeBy
     */
    fun subscribeUsingSubscribeBy() {
        val observable = listOf( episodeI, episodeII, episodeIII ).toObservable()

        observable.subscribeBy(
            onNext = {
                println("Result-> $it")
                     },
            onError = {
                println("ErrorMessage-> ${it.localizedMessage}")
            },
            onComplete = {
                println("Emissions are complete")
            }
        )
    }


    /**
     * It does not emit a onNext event but directly emits onComplete event
     */
    fun subscribeEmptyObservable() {
        val observable = Observable.empty<Unit>()

        observable.subscribeBy(
            onNext = {
                println("Result-> $it")
            },
            onError = {
                println("ErrorMessage-> ${it.localizedMessage}")
            },
            onComplete = {
                println("Emissions are complete")
            }
        )

    }

    /**
     * Observable that never completes, Infinite observable
     */
    fun observableThatNeverCompletes() {
        val observable = Observable.never<Any>()

        observable.subscribeBy(
            onNext = {
                println("Result-> $it")
            },
            onError = {
                println("ErrorMessage-> ${it.localizedMessage}")
            },
            onComplete = {
                println("Emissions are complete")
            }
        )
    }

}