package com.istudio.code.modules.module_demos.operators.transforming_operators

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.subjects.PublishSubject
import javax.inject.Inject

@HiltViewModel
class TransformingOperatorDemoVM @Inject constructor(context: Application) : AndroidViewModel(context) {

    private val subscription = CompositeDisposable()

    /** ****************** OPERATOR: Map *********************** **/

    private val mapSubject = PublishSubject.create<String>()

    private fun subscribeMapOperation(){
        mapSubject.map {
            Integer.valueOf(it)
        }.subscribeBy(
            onNext = {
                if (it is Int) {
                    println("Element printed:-> $it")
                }
            },
            onError = { println("Error Triggered") },
            onComplete = { println("Complete Triggered") }
        ).addTo(subscription)
    }

    fun demoMap() {
        // Subscribe
        subscribeMapOperation()
        // Emit elements
        mapSubject.onNext("1")
        mapSubject.onNext("2")
        mapSubject.onNext("3")
        mapSubject.onComplete()
    }
    /** ****************** OPERATOR: Map *********************** **/


    /** ****************** OPERATOR: FlatMap ******************* **/


    private val flatMapObservable = Observable.just("USA","RUSSIA","AUSTRALIA")

    fun demoFlatMap() {

        flatMapObservable
            .flatMap{ input ->
                /**
                 * 1) Here we shall receive the string one by one
                 * 2) Pass it into a new observable
                 * 3) Get the result from the observable
                 */
                // <----------- Observable ----------->
                performFlatMapLongOperation(input)
            }
            .subscribe{
                // Finally the result of all the observables are flattened into a string on new emission
                println("Received-> $it")
            }

    }

    private fun performFlatMapLongOperation(input : String) : Observable<String> {

        return Observable.create {

            // Perform some operation (Let us assume long running operation)
            it.onNext("$input - observable")

            // Complete the current observable
            it.onComplete()
        }

    }

    /** ****************** OPERATOR: FlatMap ******************* **/

    override fun onCleared() {
        super.onCleared()
        subscription.clear()
    }


}