package com.example.sander.lotrscenariogenerator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ScenarioActivity extends AppCompatActivity {

    ArrayList<String> quest1, quest2, quest3;
    Integer scenario;
    Button nextButton, previousButton;
    TextView setupText, titleText;
    Intent caller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenario);
        //Retrieve information
        caller = getIntent();
        quest1 = caller.getStringArrayListExtra("scenario_1");
        quest2 = caller.getStringArrayListExtra("scenario_2");
        quest3 = caller.getStringArrayListExtra("scenario_3");

        //set variables
        scenario = 1;
        nextButton = findViewById(R.id.nextscenario_button);
        previousButton = findViewById(R.id.previousscenario_button);
        setupText = findViewById(R.id.setup_text);
        titleText = findViewById(R.id.title_text);

        updateScenario();
    }

    public void nextScenario(View v){
        scenario += 1;
        updateScenario();
    }


    public void previousScenario(View v){
        scenario -= 1;
        updateScenario();
    }

    private void updateScenario(){
        switch (scenario) {
            case 1:
                previousButton.setEnabled(false);
                setupText.setText(quest1.get(1));
                titleText.setText(quest1.get(0));
                break;
            case 2:
                previousButton.setEnabled(true);
                setupText.setText(quest1.get(2));
                titleText.setText(quest1.get(0));
                break;
            case 3:
                setupText.setText(quest2.get(1));
                titleText.setText(quest2.get(0));
                break;
            case 4:
                setupText.setText(quest2.get(2));
                titleText.setText(quest2.get(0));
                break;
            case 5:
                nextButton.setEnabled(true);
                setupText.setText(quest3.get(1));
                titleText.setText(quest3.get(0));
                break;
            case 6:
                nextButton.setEnabled(false);
                setupText.setText(quest3.get(2));
                titleText.setText(quest3.get(0));
                break;
        }
    }
}
