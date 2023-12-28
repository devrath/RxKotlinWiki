package com.istudio.code.modules.module_demos.operators.do_operator

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.kotlin.subscribeBy
import javax.inject.Inject


@HiltViewModel
class DoOperatorDemoVm @Inject constructor(context: Application) : AndroidViewModel(context) {

    private val subscriptions = CompositeDisposable()

    val observable = Observable.never<Any>()

    fun demo() {

        observable.doOnSubscribe {
            println(it.isDisposed)
        }.doOnDispose {
            println("Action on dispose")
        }.subscribeBy(
            onNext = {
                println("On Next")
            },
            onError = {
               println("Error thrown")
            },
            onComplete = {
                println("Complete")
            }
        ).addTo(subscriptions)

    }


}