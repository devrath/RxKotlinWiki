package com.istudio.code.modules.module_demos.operators.transforming_operators

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class TransformingOperatorDemoVM @Inject constructor(context: Application) : AndroidViewModel(context) {

    private val subscription = CompositeDisposable()



    fun demo() {
        //TODO("Not yet implemented")
    }



    override fun onCleared() {
        super.onCleared()
        subscription.clear()
    }

}