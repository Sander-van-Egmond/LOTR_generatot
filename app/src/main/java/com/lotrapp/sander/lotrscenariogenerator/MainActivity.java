package com.lotrapp.sander.lotrscenariogenerator;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
                    R.string.mainToast,
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
            scenario.putStringArrayListExtra("scenario_2",scenarioPicker(chosenDecks,2));
            scenario.putStringArrayListExtra("scenario_3",scenarioPicker(chosenDecks,3));
            scenario.putStringArrayListExtra("monster_decks", chosenDecks);

            startActivity(scenario);
        }
    }


    private ArrayList<String> scenarioPicker(ArrayList<String> decks, int scenarioNumber){

        ArrayList<ArrayList<String>> options = new ArrayList<>();
        ArrayList<String> result;

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
                }
            }
            ta.recycle(); // Important!
        }
        if (options.size() == 0){
            result = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.general_quest)));
        }else {
            Collections.shuffle(options);
            result = options.get(0);
        }

        result.set(3,generatePoints(result.get(3)));
        return result;
    }

    private String generatePoints(String init){
        String result;
        Random r = new Random();
        int old = Integer.parseInt(init);
        result = Integer.toString(old - old / 3 + r.nextInt((old / 3 * 2) + 1));
        return result;
    }

    public void showInfo(View v){
        Intent i = new Intent(MainActivity.this, InformationPopUp.class);
        i.putExtra("source",v.getTag().toString());
        startActivity(i);
    }
}
