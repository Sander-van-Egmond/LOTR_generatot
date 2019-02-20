package com.lotrapp.sander.lotrscenariogenerator

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.DisplayMetrics
import android.widget.TextView

class InformationPopUp : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.popupview_scenario)

        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)

        val width = dm.widthPixels
        val height = dm.heightPixels

        val title = findViewById<TextView>(R.id.popup_title)
        val content = findViewById<TextView>(R.id.popup_content)
        content.movementMethod = ScrollingMovementMethod()
        val caller = intent

        if (caller.getStringExtra("source") == "scenario") {
            title.setText(R.string.scenario_popup_title)
            content.setText(R.string.scenario_popup_information)
        } else if (caller.getStringExtra("source") == "main") {
            title.setText(R.string.main_popup_title)
            content.setText(R.string.main_popup_information)
        }


        window.setLayout((width * .7).toInt(), (height * 0.6).toInt())
    }
}
