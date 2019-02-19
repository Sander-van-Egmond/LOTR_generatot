package com.lotrapp.sander.lotrscenariogenerator



object DeckStack {
    val encounterDecks = HashMap<String, EncounterDeck>()
    val scenarios = HashMap<String, Scenario>()

    init {
        initializeScenarios()
        initializeDecks()
    }

    private fun initializeDecks() {
        var scenarios1 = ArrayList<Scenario>()
        scenarios1.add(scenarios["to_the_river"]!!)
        var scenarios2 = ArrayList<Scenario>()
        scenarios2.add(scenarios["enchanted_vines"]!!)
        var scenarios3 = ArrayList<Scenario>()

        var encounterDeck = EncounterDeck("footprint", scenarios1, scenarios2, scenarios3)
    }

    private fun initializeScenarios() {
        var scenario = Scenario(R.string.to_the_river_title, R.string.to_the_river_a, R.string.to_the_river_b, 8)
        scenarios["to_the_river"] = scenario

        scenario = Scenario(R.string.anduin_passage_title, R.string.anduin_passage_a, R.string.anduin_passage_b, 16)
        scenarios["anduin_passage"] = scenario

        scenario = Scenario(R.string.the_necromancers_tower_title, R.string.the_necromancers_tower_a, R.string.the_necromancers_tower_b, 9)
        scenarios["the_necromancers_tower"] = scenario

        scenario = Scenario(R.string.through_the_caverns_title, R.string.through_the_caverns_a, R.string.through_the_caverns_b, 15)
        scenarios["through_the_caverns"] = scenario

        scenario = Scenario(R.string.out_of_the_dungeons_title, R.string.out_of_the_dungeons_a, R.string.out_of_the_dungeons_b, 7)
        scenarios["out_of_the_dungeons"] = scenario

        scenario = Scenario(R.string.orc_war_party_title, R.string.orc_war_party_a, R.string.orc_war_party_b, 8)
        scenarios["orc_war_party"] = scenario

        scenario = Scenario(R.string.dark_woods_title, R.string.dark_woods_a, R.string.dark_woods_b, 8)
        scenarios["dark_woods"] = scenario

        scenario = Scenario(R.string.daring_rescue_title, R.string.daring_rescue_a, R.string.daring_rescue_b, 8)
        scenarios["daring_rescue"] = scenario

        scenario = Scenario(R.string.ancient_path_title, R.string.ancient_path_a, R.string.ancient_path_b, 9)
        scenarios["ancient_path"] = scenario

        scenario = Scenario(R.string.deep_catacombs_title, R.string.deep_catacombs_a, R.string.deep_catacombs_b, 8)
        scenarios["deep_catacombs"] = scenario

        scenario = Scenario(R.string.risen_nightmare_title, R.string.risen_nightmare_a, R.string.risen_nightmare_b, 6)
        scenarios["risen_nightmare"] = scenario

        scenario = Scenario(R.string.goblin_gate_title, R.string.goblin_gate_a, R.string.goblin_gate_b, 12)
        scenarios["goblin_gate"] = scenario

        scenario = Scenario(R.string.elf_path_title, R.string.elf_path_a, R.string.elf_path_b, 5)
        scenarios["elf_path"] = scenario

        scenario = Scenario(R.string.the_veil_of_the_lonely_mountain_title, R.string.the_veil_of_the_lonely_mountain_a, R.string.the_veil_of_the_lonely_mountain_b, 10)
        scenarios["the_veil_of_the_lonely_mountain"] = scenario

        scenario = Scenario(R.string.foul_tower_title, R.string.foul_tower_a, R.string.foul_tower_b, 10)
        scenarios["foul_tower"] = scenario

        scenario = Scenario(R.string.twisted_caverns_title, R.string.twisted_caverns_a, R.string.twisted_caverns_b, 10)
        scenarios["twisted_caverns"] = scenario

        scenario = Scenario(R.string.final_stand_title, R.string.final_stand_a, R.string.final_stand_b, 10)
        scenarios["final_stand"] = scenario

        scenario = Scenario(R.string.the_wounded_eagle_title, R.string.the_wounded_eagle_a, R.string.the_wounded_eagle_b, 8)
        scenarios["the_wounded_eagle"] = scenario

        scenario = Scenario(R.string.radagasts_request_title, R.string.radagasts_request_a, R.string.radagasts_request_b, 12)
        scenarios["radagasts_request"] = scenario

        scenario = Scenario(R.string.in_the_forest_title, R.string.in_the_forest_a, R.string.in_the_forest_b, 8)
        scenarios["in_the_forest"] = scenario

        scenario = Scenario(R.string.enchanted_vines_title, R.string.enchanted_vines_a, R.string.enchanted_vines_b, 2)
        scenarios["enchanted_vines"] = scenario

        scenario = Scenario(R.string.the_secret_tunnel_title, R.string.the_secret_tunnel_a, R.string.the_secret_tunnel_b, 10)
        scenarios["the_secret_tunnel"] = scenario

        scenario = Scenario(R.string.an_ancient_evil_title, R.string.an_ancient_evil_a, R.string.an_ancient_evil_b, 12)
        scenarios["an_ancient_evil"] = scenario

        scenario = Scenario(R.string.the_hills_of_emyn_muil_title, R.string.the_hills_of_emyn_muil_a, R.string.the_hills_of_emyn_muil_b, 1)
        scenarios["the_hills_of_emyn_muil"] = scenario

        scenario = Scenario(R.string.the_hills_of_emyn_muil_2_title, R.string.the_hills_of_emyn_muil_2_a, R.string.the_hills_of_emyn_muil_2_b, 1)
        scenarios["the_hills_of_emyn_muil_2"] = scenario

        scenario = Scenario(R.string.search_for_the_chamber_title, R.string.search_for_the_chamber_a, R.string.search_for_the_chamber_b, 15)
        scenarios["search_for_the_chamber"] = scenario

        scenario = Scenario(R.string.entering_the_mines_title, R.string.entering_the_mines_a, R.string.entering_the_mines_b, 7)
        scenarios["entering_the_mines"] = scenario

        scenario = Scenario(R.string.a_presence_in_the_dark_title, R.string.a_presence_in_the_dark_a, R.string.a_presence_in_the_dark_b, 0)
        scenarios["a_presence_in_the_dark"] = scenario

        //all time general quests
        scenario = Scenario(R.string.general_quest_title, R.string.general_quest_a, R.string.general_quest_b, 8)
        scenarios["general_quest"] = scenario

        // 1st general quests
        scenario = Scenario(R.string.prisoner_title, R.string.prisoner_a, R.string.prisoner_b, 10)
        scenarios["prisoner"] = scenario

        // 2nd general quests
        scenario = Scenario(R.string.unhallowed_title, R.string.unhallowed_a, R.string.unhallowed_b, 4)
        scenarios["unhallowed"] = scenario

        scenario = Scenario(R.string.the_fate_of_balin_title, R.string.the_fate_of_balin_a, R.string.the_fate_of_balin_b, 17)
        scenarios["the_fate_of_balin"] = scenario

        scenario = Scenario(R.string.goblin_patrol_title, R.string.goblin_patrol_a, R.string.goblin_patrol_b1, 11)
        scenarios["the_goblin_patrol_1"] = scenario

        scenario = Scenario(R.string.goblin_patrol_title, R.string.goblin_patrol_a, R.string.goblin_patrol_b2, 11)
        scenarios["the_goblin_patrol_2"] = scenario

        scenario = Scenario(R.string.goblin_patrol_title, R.string.goblin_patrol_a, R.string.goblin_patrol_b3, 11)
        scenarios["the_goblin_patrol_3"] = scenario

        // 3rd general quests
        scenario = Scenario(R.string.treason_title, R.string.treason_a, R.string.treason_b, 0)
        scenarios["treason"] = scenario

        scenario = Scenario(R.string.ambush_on_the_shore_title, R.string.ambush_on_the_shore_a, R.string.ambush_on_the_shore_b, 0)
        scenarios["ambush_on_the_shore"] = scenario

        scenario = Scenario(R.string.a_way_up_title, R.string.a_way_up_a, R.string.a_way_up_b, 12)
        scenarios["a_way_up"] = scenario

        scenario = Scenario(R.string.blocked_by_shadow_title, R.string.blocked_by_shadow_a, R.string.blocked_by_shadow_b, 10)
        scenarios["blocked_by_shadow"] = scenario
    }
}