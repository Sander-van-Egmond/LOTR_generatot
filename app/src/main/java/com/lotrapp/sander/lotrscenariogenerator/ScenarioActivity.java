package com.lotrapp.sander.lotrscenariogenerator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ScenarioActivity extends AppCompatActivity {

    ArrayList<String> quest1, quest2, quest3, monsterSymbols;
    Integer scenario;
    ImageButton nextButton, previousButton;
    TextView setupText, titleText, points, progress;
    Intent caller;
    CircleImageView qpImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenario);
        //Retrieve information
        caller = getIntent();
        quest1 = caller.getStringArrayListExtra("scenario_1");
        quest2 = caller.getStringArrayListExtra("scenario_2");
        quest3 = caller.getStringArrayListExtra("scenario_3");
        monsterSymbols = caller.getStringArrayListExtra("monster_decks");



        //set variables
        scenario = 1;
        nextButton = findViewById(R.id.nextscenario_button);
        previousButton = findViewById(R.id.previousscenario_button);
        setupText = findViewById(R.id.setup_text);
        points = findViewById(R.id.quest_points);
        progress = findViewById(R.id.progress_tv);
        setupText.setMovementMethod(new ScrollingMovementMethod());
        titleText = findViewById(R.id.title_text);
        qpImage = findViewById(R.id.qp_image);


        LinearLayout ll = findViewById(R.id.quest_symbols_ll);
        for(String symbol : monsterSymbols)
        {
            int holderId = getResources().getIdentifier("encounterdeck_" + symbol,
                    "drawable",
                    this.getPackageName());
            CircleImageView ii = new CircleImageView(this);
            ii.setImageResource(holderId);
            ll.addView(ii);
        }

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
                previousButton.setVisibility(View.INVISIBLE);
                setupText.setText(quest1.get(1));
                titleText.setText(quest1.get(0));
                points.setVisibility(View.INVISIBLE);
                qpImage.setVisibility(View.INVISIBLE);
                progress.setText(R.string.progress_1a);

                break;
            case 2:
                previousButton.setEnabled(true);
                previousButton.setVisibility(View.VISIBLE);
                setupText.setText(quest1.get(2));
                titleText.setText(quest1.get(0));
                points.setVisibility(View.VISIBLE);
                points.setText(quest1.get(3));
                qpImage.setVisibility(View.VISIBLE);
                progress.setText(R.string.progress_1b);
                break;
            case 3:
                setupText.setText(quest2.get(1));
                titleText.setText(quest2.get(0));
                points.setVisibility(View.INVISIBLE);
                qpImage.setVisibility(View.INVISIBLE);
                progress.setText(R.string.progress_2a);
                break;
            case 4:
                setupText.setText(quest2.get(2));
                titleText.setText(quest2.get(0));
                points.setVisibility(View.VISIBLE);
                points.setText(quest2.get(3));
                qpImage.setVisibility(View.VISIBLE);
                progress.setText(R.string.progress_2b);
                break;
            case 5:
                nextButton.setEnabled(true);
                nextButton.setVisibility(View.VISIBLE);
                setupText.setText(quest3.get(1));
                titleText.setText(quest3.get(0));
                points.setVisibility(View.INVISIBLE);
                qpImage.setVisibility(View.INVISIBLE);
                progress.setText(R.string.progress_3a);
                break;
            case 6:
                nextButton.setEnabled(false);
                nextButton.setVisibility(View.INVISIBLE);
                setupText.setText(quest3.get(2));
                titleText.setText(quest3.get(0));
                points.setVisibility(View.VISIBLE);
                points.setText(quest3.get(3));
                qpImage.setVisibility(View.VISIBLE);
                progress.setText(R.string.progress_3b);
                break;
        }
    }

    public void onClickInfo(View v){
        Intent i = new Intent(ScenarioActivity.this, InformationPopUp.class);
        i.putExtra("source",v.getTag().toString());
        startActivity(i);
    }
}
