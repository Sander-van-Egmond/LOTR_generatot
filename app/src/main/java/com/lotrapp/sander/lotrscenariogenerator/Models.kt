package com.lotrapp.sander.lotrscenariogenerator

data class Scenario(val title: Int, val aSide: Int, val bSide: Int, val victoryPoints: Int)

data class EncounterDeck(val symbol: String, val scenarios1: ArrayList<Scenario>, val scenarios2: ArrayList<Scenario>, val scenarios3: ArrayList<Scenario>) {
    override fun toString(): String {
        return symbol
    }
}