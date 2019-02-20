package com.lotrapp.sander.lotrscenariogenerator

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    private var includedDecks: ArrayList<View> = ArrayList()
    private var optionalDecks: ArrayList<View> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickMonsterDeck(v: View) {
        when {
            optionalDecks.contains(v) -> {
                optionalDecks.remove(v)
                includedDecks.add(v)
                updateVisual(v)
            }
            includedDecks.contains(v) -> {
                includedDecks.remove(v)
                updateVisual(v)
            }
            else -> {
                optionalDecks.add(v)
                updateVisual(v)
            }
        }
    }

    private fun updateVisual(v: View) {
        val gd = GradientDrawable()
        gd.shape = GradientDrawable.OVAL
        when {
            optionalDecks.contains(v) -> {
                gd.setColor(Color.TRANSPARENT)
                v.alpha = 1.0.toFloat()
                v.background = gd
            }
            includedDecks.contains(v) -> {
                v.alpha = 1.0.toFloat()
                gd.setColor(Color.BLACK)
                v.background = gd
            }
            else -> clearVisual(v)
        }
    }

    private fun clearVisual(v: View) {
        val gd = GradientDrawable()
        gd.shape = GradientDrawable.OVAL
        v.alpha = 0.5.toFloat()
        gd.setColor(Color.TRANSPARENT)
        v.background = gd
    }


    fun generate(@Suppress("UNUSED_PARAMETER") v: View) {
        when {
            optionalDecks.size + includedDecks.size < 3 -> Toast.makeText(applicationContext,
                    R.string.notEnoughToast,
                    Toast.LENGTH_LONG).show()
            includedDecks.size > 4 -> Toast.makeText(applicationContext,
                    R.string.tooMuchToast,
                    Toast.LENGTH_LONG).show()
            else -> {
                val scenario = Intent()
                scenario.setClass(this, QuestActivity::class.java)

                val chosenDecks = ArrayList(includedDecks)

                if (chosenDecks.size != 4) {
                    val r = Random()
                    optionalDecks.shuffle()



                    if (r.nextBoolean() && optionalDecks.size + includedDecks.size > 3) {
                        chosenDecks.addAll(optionalDecks.subList(0, 4 - chosenDecks.size))
                    } else if (chosenDecks.size != 3) {
                        chosenDecks.addAll(optionalDecks.subList(0, 3 - chosenDecks.size))
                    }
                }
                for (i in 0..2){
                    scenarioPicker(chosenDecks, i)
                }
                scenario.putStringArrayListExtra("monster_decks", viewToString(chosenDecks))

                startActivity(scenario)
            }
        }
    }

    private fun viewToString(inViews: ArrayList<View>): ArrayList<String> {
        val outStrings = ArrayList<String>()
        for (v in inViews) {
            outStrings.add(v.contentDescription.toString())
        }
        return outStrings
    }


    private fun scenarioPicker(decks: ArrayList<View>, scenarioNumber: Int) {

        val options = ArrayList<QuestCard>()
        val chosenQuestCard: QuestCard

        for (v in decks) {

            val deck = v.contentDescription.toString()

            val subOptions = when (scenarioNumber) {
                0 -> DeckStack.encounterDecks[deck]?.scenarios1
                1 -> DeckStack.encounterDecks[deck]?.scenarios2
                2 -> DeckStack.encounterDecks[deck]?.scenarios3
                else -> null
            }
            subOptions?.shuffle()
            options.add(subOptions!![0])
        }
        chosenQuestCard = if (options.size == 0) {
            DeckStack.scenarios["general_quest"]!!
        } else {
            options.shuffle()
            options[0]
        }
        if (Scenario.questCards.lastIndex < scenarioNumber){
            Scenario.questCards.add(chosenQuestCard)
            Scenario.victoryPoints.add(generatePoints(chosenQuestCard.victoryPoints))
        }else {
            Scenario.questCards[scenarioNumber] = chosenQuestCard
            Scenario.victoryPoints[scenarioNumber] = generatePoints(chosenQuestCard.victoryPoints)
        }
    }

    private fun generatePoints(init: Int): Int {
        val r = Random()
        return (init - init / 3 + r.nextInt(init / 3 * 2 + 1))
    }

    fun showInfo(v: View) {
        val i = Intent(this@MainActivity, InformationPopUp::class.java)
        i.putExtra("source", v.tag.toString())
        startActivity(i)
    }

    fun deselectAll(@Suppress("UNUSED_PARAMETER") input: View) {
        for (v in includedDecks) {
            clearVisual(v)
        }
        for (v in optionalDecks) {
            clearVisual(v)
        }
        includedDecks.clear()
        optionalDecks.clear()
    }

    fun selectAll(@Suppress("UNUSED_PARAMETER") input: View) {
        val grid = findViewById<ViewGroup>(R.id.button_grid)
        val deckButtons = getViewsByTag(grid, "image_button")
        includedDecks.clear()
        optionalDecks = deckButtons
        for (deck in optionalDecks) {
            updateVisual(deck)
        }

    }


    private fun getViewsByTag(root: ViewGroup, tag: String?): ArrayList<View> {
        val views = ArrayList<View>()
        val childCount = root.childCount
        for (i in 0 until childCount) {
            val child = root.getChildAt(i)
            if (child is ViewGroup) {
                views.addAll(getViewsByTag(child, tag))
            }

            val tagObj = child.tag
            if (tagObj != null && tagObj == tag) {
                views.add(child)
            }

        }
        return views
    }
}
