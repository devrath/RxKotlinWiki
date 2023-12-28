package com.istudio.code.modules.module_demos.context_specific_observables.create_observable

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
import com.istudio.code.ui.composables.AppText

@Composable
fun CreateObservableDemo(navController: NavController){

    val viewModel : CreateObservableDemoVm = hiltViewModel()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        AppText(text = "DEMOS")

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Create Observable Demo", onClick = {
            viewModel.initiateCreateObservableDemo()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Single Observable Demo", onClick = {
            viewModel.initiateSingleObservableDemo()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Completable Observable Demo", onClick = {
            viewModel.initiateCompletableObservableDemo()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Maybe Observable Demo", onClick = {
            viewModel.initiateMaybeObservableDemo()
        })

    }
}