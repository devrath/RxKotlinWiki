package com.istudio.code.modules.module_demos.operators.create_operators.subjects.behaviour_subject

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
fun BehaviourSubjectDemo(navController: NavController){

    val viewModel : BehaviourSubjectDemoVm = hiltViewModel()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {


        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Behaviour Subject Demo", onClick = {
            viewModel.demo()
        })

    }


}