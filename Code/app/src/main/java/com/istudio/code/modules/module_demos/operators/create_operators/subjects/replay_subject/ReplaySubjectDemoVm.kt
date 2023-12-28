package com.istudio.code.modules.module_demos.operators.create_operators.subjects.replay_subject

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import episodeI
import episodeII
import episodeIII
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.subjects.ReplaySubject
import javax.inject.Inject

@HiltViewModel
class ReplaySubjectDemoVm @Inject constructor(context: Application) : AndroidViewModel(context) {

    private val disposable = CompositeDisposable()

    private val subject = ReplaySubject.create<String>(2)

    fun demo() {
        // Subscriber - 1
        subject.subscribeBy(
            onNext = { println("Subscriber-1:-> $it") },
            onError = { println("Subscriber-1:-> Error") },
            onComplete = { println("Subscriber-1:-> Complete") }
        ).addTo(disposable)

        subject.onNext(episodeI)

        // Subscriber - 2
        subject.subscribeBy(
            onNext = { println("Subscriber-2:-> $it") },
            onError = { println("Subscriber-2:-> Error") },
            onComplete = { println("Subscriber-2:-> Complete") }
        ).addTo(disposable)

        subject.onNext(episodeII)

        // Subscriber - 3
        subject.subscribeBy(
            onNext = { println("Subscriber-3:-> $it") },
            onError = { println("Subscriber-3:-> Error") },
            onComplete = { println("Subscriber-3:-> Complete") }
        ).addTo(disposable)

        subject.onNext(episodeIII)

        // Indicate onComplete of the publish subject
        subject.onComplete()
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}