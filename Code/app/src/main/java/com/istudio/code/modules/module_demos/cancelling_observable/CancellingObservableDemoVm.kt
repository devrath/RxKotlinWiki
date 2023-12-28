package com.istudio.code.modules.module_demos.cancelling_observable

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.kotlin.subscribeBy
import javax.inject.Inject

@HiltViewModel
class CancellingObservableDemoVm @Inject constructor( ) : ViewModel() {

    private val subscriptions = CompositeDisposable()

    /**
     * Cancelling single observable
     */
    fun cancelSingleObservableDemo() {
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
        ).addTo(subscriptions)
    }

    fun performCanceling(){
        if(!subscriptions.isDisposed){
            subscriptions.dispose()
        }
        val isDisposed = subscriptions.isDisposed
        println("Subscriptions disposed: ->$isDisposed")
    }


}