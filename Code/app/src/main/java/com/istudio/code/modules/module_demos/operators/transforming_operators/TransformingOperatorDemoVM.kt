package com.istudio.code.modules.module_demos.operators.transforming_operators

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
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




    override fun onCleared() {
        super.onCleared()
        subscription.clear()
    }



}