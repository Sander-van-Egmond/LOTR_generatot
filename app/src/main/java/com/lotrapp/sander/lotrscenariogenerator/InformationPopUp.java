package com.lotrapp.sander.lotrscenariogenerator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class InformationPopUp extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popupview_scenario);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        TextView title = findViewById(R.id.popup_title);
        TextView content = findViewById(R.id.popup_content);
        content.setMovementMethod(new ScrollingMovementMethod());
        Intent caller = getIntent();

        if (caller.getStringExtra("source").equals("scenario")){
            title.setText(R.string.scenario_popup_title);
            content.setText(R.string.scenario_popup_information);
        }else if (caller.getStringExtra("source").equals("main")){
            title.setText(R.string.main_popup_title);
            content.setText(R.string.main_popup_information);
        }


        getWindow().setLayout((int) (width * .7),(int) (height * 0.6));
    }
}
