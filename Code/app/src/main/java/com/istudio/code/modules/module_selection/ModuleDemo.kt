package com.istudio.code.modules.module_selection

sealed class ModuleDemo(val rout: String) {

    data object DemoSelection : ModuleDemo("DemoSelection")
    data object CreatingObservableDemo : ModuleDemo("CreatingObservableDemo")
    data object ObservingObservableDemo : ModuleDemo("ObservingObservableDemo")
    data object CancellingObservableDemo : ModuleDemo("CancellingObservableDemo")
}