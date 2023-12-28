package com.istudio.code.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.istudio.code.modules.module_demos.cancelling_observable.CancellingObservableDemo
import com.istudio.code.modules.module_demos.context_specific_observables.create_observable.CreateObservableDemo
import com.istudio.code.modules.module_demos.creating_observable.CreatingObservableDemo
import com.istudio.code.modules.module_selection.ModuleDemo
import com.istudio.code.modules.module_selection.ModuleSelectionScreen
import com.istudio.code.ui.theme.CodeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = ModuleDemo.DemoSelection.rout
                    ) {
                        // Selection Screen
                        composable(ModuleDemo.DemoSelection.rout) {
                            ModuleSelectionScreen(navController = navController)
                        }
                        // Creating a observable
                        composable(ModuleDemo.CreatingObservableDemo.rout) {
                            CreatingObservableDemo(navController = navController)
                        }
                        // Cancelling a observable
                        composable(ModuleDemo.CancellingObservableDemo.rout) {
                            CancellingObservableDemo(navController = navController)
                        }
                        // Create Observable Demo
                        composable(ModuleDemo.ContextSpecificObservableDemo.rout) {
                            CreateObservableDemo(navController = navController)
                        }
                    }
                }
            }
        }
    }
}