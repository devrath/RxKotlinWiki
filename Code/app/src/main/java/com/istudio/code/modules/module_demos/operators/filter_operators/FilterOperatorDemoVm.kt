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
        ).addTo(subscription)
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

    /** ****************** OPERATOR: Filter *************************** **/

    // Create the observable
    private val filterSubject = PublishSubject.create<String>()

    // Create the subscriber
    private fun subscribeFilterAt(){
        filterSubject.filter { it==episodeII }.subscribeBy(
            onNext = { println("Element printed:-> $it") },
            onError = { println("Error Triggered") },
            onComplete = { println("Complete Triggered") }
        ).addTo(subscription)
    }

    fun filterDemo() {
        // Subscribe the observer to the observable
        subscribeFilterAt()
        // Publish some elements
        filterSubject.onNext(episodeI)
        filterSubject.onNext(episodeII)
        filterSubject.onNext(episodeIII)
        // Indicate completion of stream
        filterSubject.onComplete()
    }
    /** ****************** OPERATOR: Filter *************************** **/


    /** ****************** OPERATOR: DistinctUntilChanged ************ **/

    // Create the observable
    private val distinctUntilChangedSubject = PublishSubject.create<String>()

    // Create the subscriber
    private fun subscribeDistinctUntilChanged(){
        distinctUntilChangedSubject.distinctUntilChanged().subscribeBy(
            onNext = { println("Element printed:-> $it") },
            onError = { println("Error Triggered") },
            onComplete = { println("Complete Triggered") }
        ).addTo(subscription)
    }

    fun distinctUntilChangedDemo() {
        // Subscribe the observer to the observable
        subscribeDistinctUntilChanged()
        // Publish some elements
        distinctUntilChangedSubject.onNext(episodeI)
        distinctUntilChangedSubject.onNext(episodeI)
        distinctUntilChangedSubject.onNext(episodeI)
        distinctUntilChangedSubject.onNext(episodeII)
        distinctUntilChangedSubject.onNext(episodeII)
        distinctUntilChangedSubject.onNext(episodeIII)
        distinctUntilChangedSubject.onNext(episodeIII)
        distinctUntilChangedSubject.onNext(episodeIII)
        // Indicate completion of stream
        distinctUntilChangedSubject.onComplete()

    }

    /** ****************** OPERATOR: DistinctUntilChanged ************ **/


    override fun onCleared() {
        super.onCleared()
        subscription.clear()
    }

}