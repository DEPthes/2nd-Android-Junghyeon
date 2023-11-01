package com.example.myapplication

class Presenter(var viewInterface: ViewInterface) {
    val model = Model(0)

    fun clickButton(){
        model.plus()
        viewInterface.toastMessage(model.count)
        viewInterface.plusCount(model.count)
    }
}
