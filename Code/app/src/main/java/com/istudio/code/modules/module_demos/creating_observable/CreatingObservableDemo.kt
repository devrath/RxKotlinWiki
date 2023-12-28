package com.istudio.code.modules.module_demos.creating_observable

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
fun CreatingObservableDemo(navController : NavController) {

    val viewModel : CreatingObservableDemoVm = hiltViewModel()

    Column(
        modifier = Modifier.fillMaxSize().padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Group of Emissions", onClick = {
            viewModel.groupOfEmissions()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "List of Emissions", onClick = {
            viewModel.listOfEmissions()
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Convert list to Observable", onClick = {
            viewModel.listToObservable()
        })

    }


}