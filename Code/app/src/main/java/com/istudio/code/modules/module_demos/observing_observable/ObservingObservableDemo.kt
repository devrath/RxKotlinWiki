package com.istudio.code.modules.module_demos.observing_observable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.istudio.code.ui.composables.AppButton

@Composable
fun ObservingObservableDemo(navController: NavController) {

    val viewModel : ObservingObservableDemoVm = hiltViewModel()

    Column(
        modifier = Modifier.fillMaxSize().padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Subscribe to observable", onClick = {
            viewModel.subscribingToObserve()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Subscribe using subscribeBy", onClick = {
            viewModel.subscribeUsingSubscribeBy()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Subscribe empty observable", onClick = {
            viewModel.subscribeEmptyObservable()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Observable that never completes", onClick = {
            viewModel.observableThatNeverCompletes()
        })

    }


}