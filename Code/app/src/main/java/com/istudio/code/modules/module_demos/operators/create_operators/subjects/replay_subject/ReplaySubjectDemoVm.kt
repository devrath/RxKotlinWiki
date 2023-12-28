package com.istudio.code.modules.module_demos.operators.create_operators.subjects.replay_subject

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class ReplaySubjectDemoVm @Inject constructor(context: Application) : AndroidViewModel(context) {

    private val disposable = CompositeDisposable()

    fun demo() {

    }

}