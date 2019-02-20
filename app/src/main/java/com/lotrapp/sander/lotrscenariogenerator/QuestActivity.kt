package com.lotrapp.sander.lotrscenariogenerator

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.LinearLayout
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_scenario.*

class QuestActivity : AppCompatActivity() {

    private var scenario: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scenario)
        //Retrieve information
        val caller = intent
        val monsterSymbols = caller.getStringArrayListExtra("monster_decks")



        setup_text.movementMethod = ScrollingMovementMethod()

        val ll = findViewById<LinearLayout>(R.id.quest_symbols_ll)
        for (symbol in monsterSymbols) {
            val holderId = resources.getIdentifier("encounterdeck_$symbol",
                    "drawable",
                    this.packageName)
            val ii = CircleImageView(this)
            ii.setImageResource(holderId)
            ll.addView(ii)
        }

        updateScenario()
    }

    fun nextScenario(@Suppress("UNUSED_PARAMETER") v: View) {
        scenario += 1
        updateScenario()
    }


    fun previousScenario(@Suppress("UNUSED_PARAMETER") v: View) {
        scenario -= 1
        updateScenario()
    }


    private fun updateScenario() {
        if (scenario % 2 == 0) {
            quest_points.visibility = View.INVISIBLE
            qp_image.visibility = View.INVISIBLE
            setup_text.setText(Scenario.questCards[scenario/2].aSide)
        } else {
            quest_points.visibility = View.VISIBLE
            qp_image.visibility = View.VISIBLE
            setup_text.setText(Scenario.questCards[scenario/2].bSide)
            quest_points.text = Scenario.victoryPoints[scenario/2].toString()
        }
        title_text.setText(Scenario.questCards[scenario/2].title)

        when (scenario) {
            0 -> {
                previousscenario_button.isEnabled = false
                previousscenario_button.visibility = View.INVISIBLE
                progress_tv.setText(R.string.progress_1a)
            }
            1 -> {
                previousscenario_button.isEnabled = true
                previousscenario_button.visibility = View.VISIBLE
                progress_tv.setText(R.string.progress_1b)
            }
            2 -> {
                progress_tv.setText(R.string.progress_2a)
            }
            3 -> {
                progress_tv.setText(R.string.progress_2b)
            }
            4 -> {
                nextscenario_button.isEnabled = true
                nextscenario_button.visibility = View.VISIBLE
                progress_tv.setText(R.string.progress_3a)
            }
            5 -> {
                nextscenario_button.isEnabled = false
                nextscenario_button.visibility = View.INVISIBLE
                progress_tv.setText(R.string.progress_3b)
            }
        }
        setup_text.setTextIsSelectable(true)
    }

    fun onClickInfo(v: View) {
        val i = Intent(this@QuestActivity, InformationPopUp::class.java)
        i.putExtra("source", v.tag.toString())
        startActivity(i)
    }
}
