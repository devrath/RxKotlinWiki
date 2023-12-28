package com.istudio.code.modules.module_demos.subjects

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SubjectsDemoVm @Inject constructor(context: Application) : AndroidViewModel(context) {

}