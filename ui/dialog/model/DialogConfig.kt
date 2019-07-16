package com.app.core.ui.dialog.model

class DialogConfig(val title: String?, val content: String?) {
    var txtBt1: String = ""
    var txtBt2: String = ""
    var txtBt3: String = ""
    var onBorder: Boolean = false
    var radius: Int = 0
    var colorText: Int = 0
    var textSize: Int = 0
    var colorBorder: Int = 0

    var textHint: String = ""
    var listTextRadio: MutableList<RadioBt> = arrayListOf()
    var onCheckBox: Boolean = false
}

data class RadioBt(val textRadioBt: String, val onRadioBt: Boolean)
