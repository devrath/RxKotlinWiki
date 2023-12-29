package com.istudio.code.modules.module_demos.operators.filter_operators

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import episodeI
import episodeII
import episodeIII
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.subjects.PublishSubject
import javax.inject.Inject

@HiltViewModel
class FilterOperatorDemoVm @Inject constructor(context: Application) : AndroidViewModel(context) {

    private val subscription = CompositeDisposable()

    /** ****************** OPERATOR: Ignore Elements ****************** **/

    // Create the observable
    private val ignoreElementsPublishSubject = PublishSubject.create<String>()

    // Create the observer
    private fun subscribeIgnoreElementsPublishSubject(){
        ignoreElementsPublishSubject.ignoreElements().subscribeBy(
            onError = { println("Error Triggered") },
            onComplete = { println("Complete Triggered") }
        ).addTo(subscription)
    }

    // Demo
    fun ignoreElementsDemo() {
        // Attach the observer to observable publish subject
        subscribeIgnoreElementsPublishSubject()
        // Publish some elements
        ignoreElementsPublishSubject.onNext(episodeI)
        ignoreElementsPublishSubject.onNext(episodeII)
        // Indicate completion of stream
        ignoreElementsPublishSubject.onComplete()
    }

    /** ****************** OPERATOR: Ignore Elements ****************** **/


    /** ****************** OPERATOR: ElementAt ************************ **/

    // Create the observable
    private val elementAtObservable = PublishSubject.create<String>()

    // Create the observer
    private fun subscribeElementAt(){
        elementAtObservable.elementAt(1).subscribeBy(
            onSuccess = { println("Element printed:-> $it") },
            onError = { println("Error Triggered") },
            onComplete = { println("Complete Triggered") }
        )
    }

    fun elementAtDemo() {
        // Subscribe the observer to the observable
        subscribeElementAt()
        // Publish some elements
        elementAtObservable.onNext(episodeI)
        elementAtObservable.onNext(episodeII)
        elementAtObservable.onNext(episodeIII)
        // Indicate completion of stream
        elementAtObservable.onComplete()
    }

    /** ****************** OPERATOR: ElementAt ************************ **/





    override fun onCleared() {
        super.onCleared()
    }

}