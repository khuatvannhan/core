package com.app.core.ui.dialog

import android.content.DialogInterface
import android.graphics.drawable.GradientDrawable
import android.view.View
import com.app.core.ui.dialog.model.DialogConfig
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class UIDialogInfor(ui: AnkoContext<View>, val dialogConfig: DialogConfig) {
    lateinit var dialog: DialogInterface
    lateinit var action1: () -> Unit
    lateinit var action2: () -> Unit

    init {
        with(ui) {
            dialog = alert {
                customView {
                    verticalLayout {
                        backgroundColor = dialogConfig.colorBorder

                    }
                }
            }.show()
        }
    }
}
