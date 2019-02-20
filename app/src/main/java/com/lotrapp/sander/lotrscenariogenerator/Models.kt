package com.lotrapp.sander.lotrscenariogenerator

data class QuestCard(val title: Int, val aSide: Int, val bSide: Int, val victoryPoints: Int)

data class EncounterDeck(val symbol: String, val scenarios1: ArrayList<QuestCard>, val scenarios2: ArrayList<QuestCard>, val scenarios3: ArrayList<QuestCard>) {
    override fun toString(): String {
        return symbol
    }
}