package com.example.sander.lotrscenariogenerator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
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

            scenario.putStringArrayListExtra("deck", chosenDecks);
            startActivity(scenario);
        }
    }
    //    private String scenarioPicker(ArrayList<String> decks, int scenarioNumber){
//        ArrayList<String> options = new ArrayList<>();
//        Class<R.array> res = R.array.class;
//        Field field;
//        for (String deck : decks) {
//            try {
//                field = res.getField(deck + "_" + Integer.toString(scenarioNumber));
//                options.addAll(Arrays.asList(context.getStringArray(field.getInt(null))));
//            }catch (Exception e){
//                Toast.makeText(this,
//                        "No such field",
//                        Toast.LENGTH_SHORT).show();
//            }
//        }
//        Collections.shuffle(options);
//        return options.get(0);
//    }
}
