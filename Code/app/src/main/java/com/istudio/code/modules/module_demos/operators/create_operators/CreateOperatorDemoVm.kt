package com.istudio.code.modules.module_demos.operators.create_operators

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import episodeI
import episodeII
import episodeIII
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.kotlin.subscribeBy
import javax.inject.Inject

@HiltViewModel
class CreateOperatorDemoVm @Inject constructor(context: Application) : AndroidViewModel(context) {

    /**
     * <-------------------------- CREATE OBSERVABLE -------------------------->
     */
    private val subscriptions = CompositeDisposable()

    private val observable = Observable.create<String> { emit ->
        emit.onNext(episodeI)
        emit.onNext(episodeII)
        emit.onNext(episodeIII)
        emit.onComplete()
    }

    fun initiateCreateOperatorDemo() {

        observable.subscribeBy (
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

    fun cancel(){
        if(!subscriptions.isDisposed){
            subscriptions.dispose()
        }
    }

    /**
     * <-------------------------- CREATE OBSERVABLE -------------------------->
     */

    /**
     * <-------------------------- SINGLE OBSERVABLE -------------------------->
     */

    private val singleDemoSubscriptions = CompositeDisposable()

    private val singleObservable = Single.create<String> { emitter ->
        val fileName = "demo.txt"

        // Here we perform a reading of file
        try {
            // Open the file in the assets folder
            val inputStream = context.assets.open(fileName)

            // Read the file into a ByteArray
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            val result = String(buffer, Charsets.UTF_8)

            // Send the success
            emitter.onSuccess(result)
        } catch (e: Exception) {
            // Send the error
            emitter.onError(e)
        }
    }

    fun initiateSingleOperatorDemo() {
        singleObservable.subscribeBy (
            onSuccess = {
                println("Result-> $it")
            },
            onError = {
                println("ErrorMessage-> ${it.localizedMessage}")
            },
        ).addTo(singleDemoSubscriptions)
    }

    /**
     * <-------------------------- SINGLE OBSERVABLE -------------------------->
     */

    /**
     * <-------------------------- COMPLETABLE OBSERVABLE -------------------------->
     */

    private val completableDemoSubscriptions = CompositeDisposable()

    private val completableObservable = Completable.create { emitter ->
        val fileName = "demo.txt"

        // Here we perform a reading of file
        try {
            // Open the file in the assets folder
            val inputStream = context.assets.open(fileName)

            // Read the file into a ByteArray
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            val result = String(buffer, Charsets.UTF_8)

            // Send the success
            emitter.onComplete()
        } catch (e: Exception) {
            // Send the error
            emitter.onError(e)
        }
    }

    fun initiateCompletableOperatorDemo() {
        completableObservable.subscribeBy (
            onError = {
                println("ErrorMessage-> ${it.localizedMessage}")
            },
            onComplete = {
                println("Completed")
            }
        ).addTo(completableDemoSubscriptions)
    }

    /**
     * <-------------------------- COMPLETABLE OBSERVABLE -------------------------->
     */

    /**
     * <-------------------------- MAYBE OBSERVABLE -------------------------->
     */

    private val maybeDemoSubscriptions = CompositeDisposable()

    private val maybeObservable = Maybe.create<String> { emitter ->
        val fileName = "demo.txt"

        // Here we perform a reading of file
        try {
            // Open the file in the assets folder
            val inputStream = context.assets.open(fileName)

            // Read the file into a ByteArray
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            val result = String(buffer, Charsets.UTF_8)

            // Send the success
            emitter.onSuccess(result)
            // Send the complete event
            emitter.onComplete()
        } catch (e: Exception) {
            // Send the error
            emitter.onError(e)
        }
    }

    fun initiateMaybeOperatorDemo() {
        maybeObservable.subscribeBy (
            onSuccess = {
                println("Result-> $it")
            },
            onError = {
                println("ErrorMessage-> ${it.localizedMessage}")
            },
            onComplete = {
                println("Completed")
            }
        ).addTo(maybeDemoSubscriptions)
    }

    /**
     * <-------------------------- MAYBE OBSERVABLE -------------------------->
     */

}