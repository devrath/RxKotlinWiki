package com.istudio.code.modules.module_demos.operators.combining_operators

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.kotlin.subscribeBy
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class CombiningOperatorsVm @Inject constructor(context: Application) : AndroidViewModel(context) {

    private val subscription = CompositeDisposable()


    /**
     * <-------------------------- Concat Operator -------------------------->
     */

    private val observable1 = Observable.just(1,2,3)
    private val observable2 = Observable.just(4,5,6)
    private val observable3 = Observable.just(7,8,9)
    private val observable4 = Observable.just(10,11,12)

    private val concatObservable = Observable.concat(observable1,observable2,observable3,observable4)

    fun concat() {
        concatObservable.subscribeBy(
            onNext = { println("Result-> $it") },
            onError = { println("ErrorMessage-> ${it.localizedMessage}") },
            onComplete = { println("Emissions are complete") }
        ).addTo(subscription)
    }
    /**
     * <-------------------------- Concat Operator -------------------------->
     */

    /**
     * <-------------------------- Merge Operator -------------------------->
     */
    private val observableMerge1 = Observable.interval(1, TimeUnit.SECONDS).take(3)
    private val observableMerge2 = Observable.interval(2, TimeUnit.SECONDS).take(3)

    // Merging the two Observables
    private val mergedObservable = Observable.merge(observableMerge1, observableMerge2)

    fun merge() {
        // Subscribing to the merged Observable
        mergedObservable.subscribeBy(
            onNext = { value -> println("Received: $value") },
            onError = { error -> println("Error: $error") },
            onComplete = { println("Merging completed") }
        )
    }
    /**
     * <-------------------------- Merge Operator -------------------------->
     */


    /**
     * <-------------------------- Zip Operator ---------------------------->
     */
    private val observableZip1 = Observable.just(1, 2, 3)
    private val observableZip2 = Observable.just("Red", "Green", "Blue")

    // Combining the two Observables using the zip operator
    private val zippedObservable = Observable.zip(
        observableZip1,
        observableZip2
    ) { number, color -> "Number: $number, Color: $color" }

    fun zip() {
        // Subscribing to the zipped Observable
        zippedObservable.subscribeBy(
            onNext = { result -> println("Received: $result") },
            onError = { error -> println("Error: $error") },
            onComplete = { println("Zip completed") }
        )
    }
    /**
     * <-------------------------- Zip Operator ---------------------------->
     */


    override fun onCleared() {
        super.onCleared()
        subscription.clear()
    }




}