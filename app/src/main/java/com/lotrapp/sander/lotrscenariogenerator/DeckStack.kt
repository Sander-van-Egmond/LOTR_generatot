package com.lotrapp.sander.lotrscenariogenerator



object DeckStack {
    val encounterDecks = HashMap<String, EncounterDeck>()
    val scenarios = HashMap<String, QuestCard>()

    init {
        initializeScenarios()
        initializeDecks()
    }

    private fun initializeDecks() {
        var scenarios1 = createScenarioSet(arrayListOf("to_the_river"))
        var scenarios2 = createScenarioSet(arrayListOf("enchanted_vines"))
        var scenarios3 = createScenarioSet(arrayListOf("daring_rescue", "treason" ))
        var encounterDeck = EncounterDeck("footprint", scenarios1, scenarios2, scenarios3)
        encounterDecks[encounterDeck.symbol] = encounterDeck

        scenarios1 = createScenarioSet(arrayListOf("general_quest"))
        scenarios2 = createScenarioSet(arrayListOf("anduin_passage"))
        scenarios3 = createScenarioSet(arrayListOf("ambush_on_the_shore"))
        encounterDeck = EncounterDeck("river", scenarios1, scenarios2, scenarios3)
        encounterDecks[encounterDeck.symbol] = encounterDeck

        scenarios1 = createScenarioSet(arrayListOf("the_necromancers_tower"))
        scenarios2 = createScenarioSet(arrayListOf("through_the_caverns", "deep_catacombs", "the_secret_tunnel"))
        scenarios3 = createScenarioSet(arrayListOf("out_of_the_dungeons", "risen_nightmare", "an_ancient_evil"))
        encounterDeck = EncounterDeck("tower", scenarios1, scenarios2, scenarios3)
        encounterDecks[encounterDeck.symbol] = encounterDeck

        scenarios1 = createScenarioSet(arrayListOf("orc_war_party", "goblin_gate"))
        scenarios2 = createScenarioSet(arrayListOf("dark_woods", "elf_path"))
        scenarios3 = createScenarioSet(arrayListOf("the_veil_of_the_lonely_mountain", "treason"))
        encounterDeck = EncounterDeck("orc", scenarios1, scenarios2, scenarios3)
        encounterDecks[encounterDeck.symbol] = encounterDeck


        scenarios1 = createScenarioSet(arrayListOf("ancient_path", "foul_tower"))
        scenarios2 = createScenarioSet(arrayListOf("twisted_caverns"))
        scenarios3 = createScenarioSet(arrayListOf("final_stand"))
        encounterDeck = EncounterDeck("spider", scenarios1, scenarios2, scenarios3)
        encounterDecks[encounterDeck.symbol] = encounterDeck

        scenarios1 = createScenarioSet(arrayListOf("general_quest"))
        scenarios2 = createScenarioSet(arrayListOf("unhallowed"))
        scenarios3 = createScenarioSet(arrayListOf("ambush_on_the_shore"))
        encounterDeck = EncounterDeck("eye", scenarios1, scenarios2, scenarios3)
        encounterDecks[encounterDeck.symbol] = encounterDeck

        scenarios1 = createScenarioSet(arrayListOf("in_the_forest"))
        scenarios2 = createScenarioSet(arrayListOf("unhallowed"))
        scenarios3 = createScenarioSet(arrayListOf("ambush_on_the_shore"))
        encounterDeck = EncounterDeck("tree", scenarios1, scenarios2, scenarios3)
        encounterDecks[encounterDeck.symbol] = encounterDeck

        scenarios1 = createScenarioSet(arrayListOf("the_wounded_eagle"))
        scenarios2 = createScenarioSet(arrayListOf("radagasts_request"))
        scenarios3 = createScenarioSet(arrayListOf("general_quest"))
        encounterDeck = EncounterDeck("raven", scenarios1, scenarios2, scenarios3)
        encounterDecks[encounterDeck.symbol] = encounterDeck

        scenarios1 = createScenarioSet(arrayListOf("the_hills_of_emyn_muil"))
        scenarios2 = createScenarioSet(arrayListOf("unhallowed"))
        scenarios3 = createScenarioSet(arrayListOf("the_hills_of_emyn_muil_2"))
        encounterDeck = EncounterDeck("hills", scenarios1, scenarios2, scenarios3)
        encounterDecks[encounterDeck.symbol] = encounterDeck

        scenarios1 = createScenarioSet(arrayListOf("prisoner"))
        scenarios2 = createScenarioSet(arrayListOf("the_fate_of_balin"))
        scenarios3 = createScenarioSet(arrayListOf("blocked_by_shadow"))
        encounterDeck = EncounterDeck("spearman", scenarios1, scenarios2, scenarios3)
        encounterDecks[encounterDeck.symbol] = encounterDeck

        scenarios1 = createScenarioSet(arrayListOf("prisoner"))
        scenarios2 = createScenarioSet(arrayListOf("the_fate_of_balin", "goblin_patrol_2", "goblin_patrol_3"))
        scenarios3 = createScenarioSet(arrayListOf("a_way_up", "blocked_by_shadow"))
        encounterDeck = EncounterDeck("goblin", scenarios1, scenarios2, scenarios3)
        encounterDecks[encounterDeck.symbol] = encounterDeck

        scenarios1 = createScenarioSet(arrayListOf("search_for_the_chamber"))
        scenarios2 = createScenarioSet(arrayListOf("the_fate_of_balin"))
        scenarios3 = createScenarioSet(arrayListOf("treason"))
        encounterDeck = EncounterDeck("book", scenarios1, scenarios2, scenarios3)
        encounterDecks[encounterDeck.symbol] = encounterDeck

        scenarios1 = createScenarioSet(arrayListOf("general_quest"))
        scenarios2 = createScenarioSet(arrayListOf("goblin_patrol_3"))
        scenarios3 = createScenarioSet(arrayListOf("a_way_up"))
        encounterDeck = EncounterDeck("torch", scenarios1, scenarios2, scenarios3)
        encounterDecks[encounterDeck.symbol] = encounterDeck

        scenarios1 = createScenarioSet(arrayListOf("general_quest"))
        scenarios2 = createScenarioSet(arrayListOf("unhallowed"))
        scenarios3 = createScenarioSet(arrayListOf("a_way_up", "blocked_by_shadow"))
        encounterDeck = EncounterDeck("fracture", scenarios1, scenarios2, scenarios3)
        encounterDecks[encounterDeck.symbol] = encounterDeck

        scenarios1 = createScenarioSet(arrayListOf("general_quest"))
        scenarios2 = createScenarioSet(arrayListOf("unhallowed"))
        scenarios3 = createScenarioSet(arrayListOf("a_way_up", "blocked_by_shadow"))
        encounterDeck = EncounterDeck("fracture", scenarios1, scenarios2, scenarios3)
        encounterDecks[encounterDeck.symbol] = encounterDeck

        scenarios1 = createScenarioSet(arrayListOf("entering_the_mines"))
        scenarios2 = createScenarioSet(arrayListOf("goblin_patrol_1", "goblin_patrol_2", "goblin_patrol_3"))
        scenarios3 = createScenarioSet(arrayListOf("a_way_up"))
        encounterDeck = EncounterDeck("pickaxe", scenarios1, scenarios2, scenarios3)
        encounterDecks[encounterDeck.symbol] = encounterDeck

        scenarios1 = createScenarioSet(arrayListOf("presence_in_the_dark"))
        scenarios2 = createScenarioSet(arrayListOf("unhallowed"))
        scenarios3 = createScenarioSet(arrayListOf("escape_from_darkness"))
        encounterDeck = EncounterDeck("map", scenarios1, scenarios2, scenarios3)
        encounterDecks[encounterDeck.symbol] = encounterDeck

        scenarios1 = createScenarioSet(arrayListOf("prisoner"))
        scenarios2 = createScenarioSet(arrayListOf("goblin_patrol_2"))
        scenarios3 = createScenarioSet(arrayListOf("blocked_by_shadow"))
        encounterDeck = EncounterDeck("chain", scenarios1, scenarios2, scenarios3)
        encounterDecks[encounterDeck.symbol] = encounterDeck
    }

    private fun createScenarioSet(scenarioStrings: ArrayList<String>): ArrayList<QuestCard> {
        val scenarioSet = ArrayList<QuestCard>()
        for (string: String in scenarioStrings) {
            scenarioSet.add(scenarios[string]!!)
        }
        return scenarioSet
    }

    private fun initializeScenarios() {
        var scenario = QuestCard(R.string.to_the_river_title, R.string.to_the_river_a, R.string.to_the_river_b, 8)
        scenarios["to_the_river"] = scenario

        scenario = QuestCard(R.string.anduin_passage_title, R.string.anduin_passage_a, R.string.anduin_passage_b, 16)
        scenarios["anduin_passage"] = scenario

        scenario = QuestCard(R.string.the_necromancers_tower_title, R.string.the_necromancers_tower_a, R.string.the_necromancers_tower_b, 9)
        scenarios["the_necromancers_tower"] = scenario

        scenario = QuestCard(R.string.through_the_caverns_title, R.string.through_the_caverns_a, R.string.through_the_caverns_b, 15)
        scenarios["through_the_caverns"] = scenario

        scenario = QuestCard(R.string.out_of_the_dungeons_title, R.string.out_of_the_dungeons_a, R.string.out_of_the_dungeons_b, 7)
        scenarios["out_of_the_dungeons"] = scenario

        scenario = QuestCard(R.string.orc_war_party_title, R.string.orc_war_party_a, R.string.orc_war_party_b, 8)
        scenarios["orc_war_party"] = scenario

        scenario = QuestCard(R.string.dark_woods_title, R.string.dark_woods_a, R.string.dark_woods_b, 8)
        scenarios["dark_woods"] = scenario

        scenario = QuestCard(R.string.daring_rescue_title, R.string.daring_rescue_a, R.string.daring_rescue_b, 8)
        scenarios["daring_rescue"] = scenario

        scenario = QuestCard(R.string.ancient_path_title, R.string.ancient_path_a, R.string.ancient_path_b, 9)
        scenarios["ancient_path"] = scenario

        scenario = QuestCard(R.string.deep_catacombs_title, R.string.deep_catacombs_a, R.string.deep_catacombs_b, 8)
        scenarios["deep_catacombs"] = scenario

        scenario = QuestCard(R.string.risen_nightmare_title, R.string.risen_nightmare_a, R.string.risen_nightmare_b, 6)
        scenarios["risen_nightmare"] = scenario

        scenario = QuestCard(R.string.goblin_gate_title, R.string.goblin_gate_a, R.string.goblin_gate_b, 12)
        scenarios["goblin_gate"] = scenario

        scenario = QuestCard(R.string.elf_path_title, R.string.elf_path_a, R.string.elf_path_b, 5)
        scenarios["elf_path"] = scenario

        scenario = QuestCard(R.string.the_veil_of_the_lonely_mountain_title, R.string.the_veil_of_the_lonely_mountain_a, R.string.the_veil_of_the_lonely_mountain_b, 10)
        scenarios["the_veil_of_the_lonely_mountain"] = scenario

        scenario = QuestCard(R.string.foul_tower_title, R.string.foul_tower_a, R.string.foul_tower_b, 10)
        scenarios["foul_tower"] = scenario

        scenario = QuestCard(R.string.twisted_caverns_title, R.string.twisted_caverns_a, R.string.twisted_caverns_b, 10)
        scenarios["twisted_caverns"] = scenario

        scenario = QuestCard(R.string.final_stand_title, R.string.final_stand_a, R.string.final_stand_b, 10)
        scenarios["final_stand"] = scenario

        scenario = QuestCard(R.string.the_wounded_eagle_title, R.string.the_wounded_eagle_a, R.string.the_wounded_eagle_b, 8)
        scenarios["the_wounded_eagle"] = scenario

        scenario = QuestCard(R.string.radagasts_request_title, R.string.radagasts_request_a, R.string.radagasts_request_b, 12)
        scenarios["radagasts_request"] = scenario

        scenario = QuestCard(R.string.in_the_forest_title, R.string.in_the_forest_a, R.string.in_the_forest_b, 8)
        scenarios["in_the_forest"] = scenario

        scenario = QuestCard(R.string.enchanted_vines_title, R.string.enchanted_vines_a, R.string.enchanted_vines_b, 2)
        scenarios["enchanted_vines"] = scenario

        scenario = QuestCard(R.string.the_secret_tunnel_title, R.string.the_secret_tunnel_a, R.string.the_secret_tunnel_b, 10)
        scenarios["the_secret_tunnel"] = scenario

        scenario = QuestCard(R.string.an_ancient_evil_title, R.string.an_ancient_evil_a, R.string.an_ancient_evil_b, 12)
        scenarios["an_ancient_evil"] = scenario

        scenario = QuestCard(R.string.the_hills_of_emyn_muil_title, R.string.the_hills_of_emyn_muil_a, R.string.the_hills_of_emyn_muil_b, 1)
        scenarios["the_hills_of_emyn_muil"] = scenario

        scenario = QuestCard(R.string.the_hills_of_emyn_muil_2_title, R.string.the_hills_of_emyn_muil_2_a, R.string.the_hills_of_emyn_muil_2_b, 1)
        scenarios["the_hills_of_emyn_muil_2"] = scenario

        scenario = QuestCard(R.string.search_for_the_chamber_title, R.string.search_for_the_chamber_a, R.string.search_for_the_chamber_b, 15)
        scenarios["search_for_the_chamber"] = scenario

        scenario = QuestCard(R.string.entering_the_mines_title, R.string.entering_the_mines_a, R.string.entering_the_mines_b, 7)
        scenarios["entering_the_mines"] = scenario

        scenario = QuestCard(R.string.a_presence_in_the_dark_title, R.string.a_presence_in_the_dark_a, R.string.a_presence_in_the_dark_b, 0)
        scenarios["a_presence_in_the_dark"] = scenario

        //all time general quests
        scenario = QuestCard(R.string.general_quest_title, R.string.general_quest_a, R.string.general_quest_b, 8)
        scenarios["general_quest"] = scenario

        // 1st general quests
        scenario = QuestCard(R.string.prisoner_title, R.string.prisoner_a, R.string.prisoner_b, 10)
        scenarios["prisoner"] = scenario

        // 2nd general quests
        scenario = QuestCard(R.string.unhallowed_title, R.string.unhallowed_a, R.string.unhallowed_b, 4)
        scenarios["unhallowed"] = scenario

        scenario = QuestCard(R.string.the_fate_of_balin_title, R.string.the_fate_of_balin_a, R.string.the_fate_of_balin_b, 17)
        scenarios["the_fate_of_balin"] = scenario

        scenario = QuestCard(R.string.goblin_patrol_title, R.string.goblin_patrol_a, R.string.goblin_patrol_b1, 11)
        scenarios["the_goblin_patrol_1"] = scenario

        scenario = QuestCard(R.string.goblin_patrol_title, R.string.goblin_patrol_a, R.string.goblin_patrol_b2, 11)
        scenarios["the_goblin_patrol_2"] = scenario

        scenario = QuestCard(R.string.goblin_patrol_title, R.string.goblin_patrol_a, R.string.goblin_patrol_b3, 11)
        scenarios["the_goblin_patrol_3"] = scenario

        // 3rd general quests
        scenario = QuestCard(R.string.treason_title, R.string.treason_a, R.string.treason_b, 0)
        scenarios["treason"] = scenario

        scenario = QuestCard(R.string.ambush_on_the_shore_title, R.string.ambush_on_the_shore_a, R.string.ambush_on_the_shore_b, 0)
        scenarios["ambush_on_the_shore"] = scenario

        scenario = QuestCard(R.string.a_way_up_title, R.string.a_way_up_a, R.string.a_way_up_b, 12)
        scenarios["a_way_up"] = scenario

        scenario = QuestCard(R.string.blocked_by_shadow_title, R.string.blocked_by_shadow_a, R.string.blocked_by_shadow_b, 10)
        scenarios["blocked_by_shadow"] = scenario
    }
}