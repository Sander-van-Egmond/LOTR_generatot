package com.example.sander.lotrscenariogenerator;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> monsterDecks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        monsterDecks = new ArrayList<>();
    }

    public void onClickMonsterDeck(View v){
        if (monsterDecks.contains(v.getContentDescription().toString())){
            v.setAlpha((float) 1.0);
            monsterDecks.remove(v.getContentDescription().toString());

        }else {
            v.setAlpha((float) 0.5);
            monsterDecks.add(v.getContentDescription().toString());
        }
    }

    public void generate(View v){
        if (monsterDecks.size() < 3){
            Toast.makeText(getApplicationContext(),
                    "Select at least 3 monster decks",
                    Toast.LENGTH_LONG).show();
        }else{
            Intent scenario = new Intent();
            scenario.setClass(this, ScenarioActivity.class);
            Random r = new Random();
            Collections.shuffle(monsterDecks);

            ArrayList<String> chosenDecks;
            if (r.nextBoolean() && monsterDecks.size() > 3){
                chosenDecks =  new ArrayList<>(monsterDecks.subList(0,4));
            }else{
                chosenDecks = new ArrayList<>(monsterDecks.subList(0,3));
            }


            scenario.putStringArrayListExtra("scenario_1",scenarioPicker(chosenDecks,1));


            startActivity(scenario);
        }
    }


    private ArrayList<String> scenarioPicker(ArrayList<String> decks, int scenarioNumber){

        ArrayList<ArrayList<String>> options = new ArrayList<ArrayList<String>>();

        for (String deck : decks) {

            int holderId = getResources().getIdentifier(deck + "_" + Integer.toString(scenarioNumber),
                    "array",
                    this.getPackageName());
            TypedArray ta = getResources().obtainTypedArray(holderId);

            int n = ta.length();
            for (int i = 0; i < n; ++i) {
                int id = ta.getResourceId(i, 0);
                if (id > 0) {
                    options.add(new ArrayList<>(Arrays.asList(getResources().getStringArray(id))));
                } else {
                    // something wrong with the XML
                }
            }
            ta.recycle(); // Important!
        }
        Collections.shuffle(options);
        return options.get(0);

    }


}
