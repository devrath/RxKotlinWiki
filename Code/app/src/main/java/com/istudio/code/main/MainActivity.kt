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
import com.istudio.code.modules.module_demos.operators.create_operators.CreateObservableDemo
import com.istudio.code.modules.module_demos.creating_observable.CreatingObservableDemo
import com.istudio.code.modules.module_demos.observing_observable.ObservingObservableDemo
import com.istudio.code.modules.module_demos.operators.OperatorsDemo
import com.istudio.code.modules.module_demos.operators.combining_operators.CombiningOperatorsDemo
import com.istudio.code.modules.module_demos.operators.do_operator.DoOperatorDemo
import com.istudio.code.modules.module_demos.operators.create_operators.subjects.SubjectsDemo
import com.istudio.code.modules.module_demos.operators.create_operators.subjects.behaviour_subject.BehaviourSubjectDemo
import com.istudio.code.modules.module_demos.operators.create_operators.subjects.publish_subject.PublishSubjectDemo
import com.istudio.code.modules.module_demos.operators.create_operators.subjects.replay_subject.ReplaySubjectDemo
import com.istudio.code.modules.module_demos.operators.filter_operators.FilterOperatorDemo
import com.istudio.code.modules.module_demos.operators.transforming_operators.TransformingOperatorDemo
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
                        // Operators Demo
                        composable(ModuleDemo.OperatorsDemo.rout) {
                            OperatorsDemo(navController = navController)
                        }
                        // Create Observable Demo
                        composable(ModuleDemo.CreateOperatorDemo.rout) {
                            CreateObservableDemo(navController = navController)
                        }
                        // Do Operator Demo
                        composable(ModuleDemo.DoOperatorDemo.rout) {
                            DoOperatorDemo(navController = navController)
                        }
                        // Subjects Demo
                        composable(ModuleDemo.SubjectsDemo.rout) {
                            SubjectsDemo(navController = navController)
                        }
                        // Publish Subject demo
                        composable(ModuleDemo.PublishSubjectDemo.rout) {
                            PublishSubjectDemo(navController = navController)
                        }
                        // Behaviour Subject demo
                        composable(ModuleDemo.BehaviourSubjectDemo.rout) {
                            BehaviourSubjectDemo(navController = navController)
                        }
                        // Replay Subject Demo
                        composable(ModuleDemo.ReplaySubjectDemo.rout) {
                            ReplaySubjectDemo(navController = navController)
                        }
                        // Filter Operators demo
                        composable(ModuleDemo.FilterOperatorDemo.rout) {
                            FilterOperatorDemo(navController = navController)
                        }
                        // Transforming Operators demo
                        composable(ModuleDemo.TransformingOperatorDemo.rout) {
                            TransformingOperatorDemo(navController = navController)
                        }
                        // Combining Operators demo
                        composable(ModuleDemo.CombiningOperatorsDemo.rout) {
                            CombiningOperatorsDemo(navController = navController)
                        }
                        composable(ModuleDemo.ObservingObservableDemo.rout) {
                            ObservingObservableDemo(navController = navController)
                        }
                    }
                }
            }
        }
    }
}