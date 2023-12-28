package com.istudio.code.modules.module_demos.operators.create_operators

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
import com.istudio.code.modules.module_selection.ModuleDemo
import com.istudio.code.ui.composables.AppButton
import com.istudio.code.ui.composables.AppText

@Composable
fun CreateObservableDemo(navController: NavController){

    val viewModel : CreateOperatorDemoVm = hiltViewModel()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Create Operator", onClick = {
            viewModel.initiateCreateOperatorDemo()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Single Operator", onClick = {
            viewModel.initiateSingleOperatorDemo()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Completable Operator", onClick = {
            viewModel.initiateCompletableOperatorDemo()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Maybe Operator", onClick = {
            viewModel.initiateMaybeOperatorDemo()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Subjects", onClick = {
            navController.navigate(ModuleDemo.SubjectsDemo.rout)
        })

    }
}