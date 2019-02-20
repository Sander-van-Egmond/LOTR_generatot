package com.lotrapp.sander.lotrscenariogenerator

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class QuestActivity : AppCompatActivity() {

    private var scenario: Int = 1
    private var nextButton: ImageButton = findViewById(R.id.nextscenario_button)
    private var previousButton: ImageButton =  findViewById(R.id.previousscenario_button)
    private var setupText: TextView = findViewById(R.id.setup_text)
    private var titleText: TextView = findViewById(R.id.title_text)
    private var points: TextView = findViewById(R.id.quest_points)
    private var progress: TextView = findViewById(R.id.progress_tv)

    private var qpImage: CircleImageView = findViewById(R.id.qp_image)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scenario)
        //Retrieve information
        val caller = intent
        val monsterSymbols = caller.getStringArrayListExtra("monster_decks")



        setupText.movementMethod = ScrollingMovementMethod()

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

    fun nextScenario(v: View) {
        scenario += 1
        updateScenario()
    }


    fun previousScenario(v: View) {
        scenario -= 1
        updateScenario()
    }


    private fun updateScenario() {
        if (scenario % 2 == 1) {
            points.visibility = View.INVISIBLE
            qpImage.visibility = View.INVISIBLE
            setupText.text = Scenario.questCards[(scenario+1)/2].aSide.toString()
        } else {
            points.visibility = View.VISIBLE
            qpImage.visibility = View.VISIBLE
            setupText.text = Scenario.questCards[(scenario+1)/2].bSide.toString()
            points.text = Scenario.victoryPoints[scenario/2].toString()
        }
        titleText.text = Scenario.questCards[(scenario+1)/2].title.toString()

        when (scenario) {
            1 -> {
                previousButton.isEnabled = false
                previousButton.visibility = View.INVISIBLE
                progress.setText(R.string.progress_1a)
            }
            2 -> {
                previousButton.isEnabled = true
                previousButton.visibility = View.VISIBLE
                progress.setText(R.string.progress_1b)
            }
            3 -> {
                progress.setText(R.string.progress_2a)
            }
            4 -> {
                progress.setText(R.string.progress_2b)
            }
            5 -> {
                nextButton.isEnabled = true
                nextButton.visibility = View.VISIBLE
                progress.setText(R.string.progress_3a)
            }
            6 -> {
                nextButton.isEnabled = false
                nextButton.visibility = View.INVISIBLE
                progress.setText(R.string.progress_3b)
            }
        }
        setupText.setTextIsSelectable(true)
    }

    fun onClickInfo(v: View) {
        val i = Intent(this@QuestActivity, InformationPopUp::class.java)
        i.putExtra("source", v.tag.toString())
        startActivity(i)
    }
}
