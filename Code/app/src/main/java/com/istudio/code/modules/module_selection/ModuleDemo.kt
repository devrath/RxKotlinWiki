package com.istudio.code.modules.module_selection

sealed class ModuleDemo(val rout: String) {

    data object DemoSelection : ModuleDemo("DemoSelection")
    data object CreatingObservableDemo : ModuleDemo("CreatingObservableDemo")
    data object ObservingObservableDemo : ModuleDemo("ObservingObservableDemo")
    data object CancellingObservableDemo : ModuleDemo("CancellingObservableDemo")
    data object OperatorsDemo : ModuleDemo("OperatorsDemo")
    data object CreateOperatorDemo : ModuleDemo("CreateOperatorDemo")
    data object DoOperatorDemo : ModuleDemo("DoOperatorDemo")
    data object SubjectsDemo : ModuleDemo("SubjectsDemo")
    data object PublishSubjectDemo : ModuleDemo("PublishSubjectDemo")
    data object BehaviourSubjectDemo : ModuleDemo("BehaviourSubjectDemo")
}