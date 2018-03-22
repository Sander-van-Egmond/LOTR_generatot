package com.example.sander.lotrscenariogenerator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ScenarioActivity extends AppCompatActivity {

    ArrayList<String> monsterdecks;
    ListView listView ;
    Integer scenario;
    Button nextButton, previousButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenario);
        //Retrieve information
        Intent caller = getIntent();
        monsterdecks = caller.getStringArrayListExtra("deck");

        //set variables
        scenario = 0;
        nextButton = findViewById(R.id.nextscenario_button);
        previousButton = findViewById(R.id.previousscenario_button);
        previousButton.setEnabled(false);


        listView = findViewById(R.id.list);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                monsterdecks);

        listView.setAdapter(adapter);


    }

    public void nextScenario(View v){
        if (scenario ==0){
            previousButton.setEnabled(true);
        }else if(scenario == 4){
            nextButton.setEnabled(false);
        }
        scenario += 1;
    }


    public void previousScenario(View v){
        if (scenario==5){
            nextButton.setEnabled(true);
        }else if (scenario == 1){
            previousButton.setEnabled(false);
        }
        scenario -= 1;
    }
}
