package com.lotrapp.sander.lotrscenariogenerator;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<View> includedDecks;
    ArrayList<View> optionalDecks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        optionalDecks = new ArrayList<>();
        includedDecks = new ArrayList<>();
    }

    public void onClickMonsterDeck(View v){
        if (optionalDecks.contains(v)){
            optionalDecks.remove(v);
            includedDecks.add(v);
            updateVisual(v);
        }else if (includedDecks.contains(v)){
            includedDecks.remove(v);
            updateVisual(v);
        }else{
            optionalDecks.add(v);
            updateVisual(v);
        }
    }

    private void updateVisual(View v){
        GradientDrawable gd = new GradientDrawable();
        gd.setShape(GradientDrawable.OVAL);
        if (optionalDecks.contains(v)){
            gd.setColor(Color.TRANSPARENT);
            v.setAlpha((float) 1.0);
            v.setBackground(gd);
        }else if (includedDecks.contains(v)){
            v.setAlpha((float) 1.0);
            gd.setColor(Color.BLACK);
            v.setBackground(gd);
        }else{
            clearVisual(v);
        }
    }

    private void clearVisual(View v){
        GradientDrawable gd = new GradientDrawable();
        gd.setShape(GradientDrawable.OVAL);
        v.setAlpha((float) 0.5);
        gd.setColor(Color.TRANSPARENT);
        v.setBackground(gd);
    }


    public void generate(View v){
        if (optionalDecks.size() + includedDecks.size() < 3){
            Toast.makeText(getApplicationContext(),
                    R.string.notEnoughToast,
                    Toast.LENGTH_LONG).show();
        }else if(includedDecks.size() > 4) {
            Toast.makeText(getApplicationContext(),
                    R.string.tooMuchToast,
                    Toast.LENGTH_LONG).show();
        }else{
            Intent scenario = new Intent();
            scenario.setClass(this, ScenarioActivity.class);

            ArrayList<View> chosenDecks = new ArrayList<>(includedDecks);

            if (chosenDecks.size() != 4) {
                Random r = new Random();
                Collections.shuffle(optionalDecks);



                if (r.nextBoolean() && optionalDecks.size() + includedDecks.size() > 3) {
                    chosenDecks.addAll(optionalDecks.subList(0, 4 - chosenDecks.size()));
                } else if(chosenDecks.size() != 3){
                    chosenDecks.addAll(optionalDecks.subList(0, 3 -chosenDecks.size()));
                }
            }

            scenario.putStringArrayListExtra("scenario_1",scenarioPicker(chosenDecks,1));
            scenario.putStringArrayListExtra("scenario_2",scenarioPicker(chosenDecks,2));
            scenario.putStringArrayListExtra("scenario_3",scenarioPicker(chosenDecks,3));
            scenario.putStringArrayListExtra("monster_decks",viewToString(chosenDecks));

            startActivity(scenario);
        }
    }

    private ArrayList<String> viewToString(ArrayList<View> inViews){
        ArrayList<String> outStrings = new ArrayList<>();
        for (View v : inViews){
            outStrings.add(v.getContentDescription().toString());
        }
        return outStrings;
    }


    private ArrayList<String> scenarioPicker(ArrayList<View> decks, int scenarioNumber){

        ArrayList<ArrayList<String>> options = new ArrayList<>();
        ArrayList<String> result;

        for (View v : decks) {
            ArrayList<ArrayList<String>> subOptions = new ArrayList<>();
            String deck = v.getContentDescription().toString();
            int holderId = getResources().getIdentifier(deck + "_" + Integer.toString(scenarioNumber),
                    "array",
                    this.getPackageName());
            TypedArray ta = getResources().obtainTypedArray(holderId);

            int n = ta.length();
            for (int i = 0; i < n; ++i) {
                int id = ta.getResourceId(i, 0);
                if (id > 0) {
                    subOptions.add(new ArrayList<>(Arrays.asList(getResources().getStringArray(id))));
                }
            }
            ta.recycle(); // Important!

            // zorgt ervoor dat alle encounter sets een evengrote kans hebben om gekozen te worden
            Collections.shuffle(subOptions);
            options.add(subOptions.get(0));
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

    public void deselectAll(View input){
        for (View v : includedDecks){
            clearVisual(v);
        }
        for (View v : optionalDecks){
            clearVisual(v);
        }
        includedDecks.clear();
        optionalDecks.clear();
    }

    public void selectAll(View input){
        ViewGroup grid = findViewById(R.id.button_grid);
        ArrayList<View> deckButtons = getViewsByTag(grid, "image_button");
        includedDecks.clear();
        optionalDecks = deckButtons;
        for (View deck : optionalDecks){
            updateVisual(deck);
        }

    }


    private static ArrayList<View> getViewsByTag(ViewGroup root, String tag){
        ArrayList<View> views = new ArrayList<>();
        final int childCount = root.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = root.getChildAt(i);
            if (child instanceof ViewGroup) {
                views.addAll(getViewsByTag((ViewGroup) child, tag));
            }

            final Object tagObj = child.getTag();
            if (tagObj != null && tagObj.equals(tag)) {
                views.add(child);
            }

        }
        return views;
    }
}
