package com.istudio.code.modules.module_demos.operators

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
import androidx.navigation.NavController
import com.istudio.code.modules.module_selection.ModuleDemo
import com.istudio.code.ui.composables.AppButton

@Composable
fun OperatorsDemo(navController: NavController){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {


        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Create Operator", onClick = {
            navController.navigate(ModuleDemo.CreateOperatorDemo.rout)
        })


        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Do Operator", onClick = {
            navController.navigate(ModuleDemo.DoOperatorDemo.rout)
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Filter Operators", onClick = {
            navController.navigate(ModuleDemo.FilterOperatorDemo.rout)
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Transforming Operators", onClick = {
            navController.navigate(ModuleDemo.TransformingOperatorDemo.rout)
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Combining Operators", onClick = {
            navController.navigate(ModuleDemo.CombiningOperatorsDemo.rout)
        })

    }


}