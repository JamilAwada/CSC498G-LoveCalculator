package com.jamdev.geekslovecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Declaring the global variables
    Spinner sp;
    TextView result, name;
    ImageView icon;
    Button btn;
    TableLayout tbl;

    // These lists will be used to keep track of rounds played and corresponding scores
    ArrayList<String> languages = new ArrayList<String>();
    ArrayList<String> scores = new ArrayList<String>();

    int roundsPlayed = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // These 3 lines hide the title and action bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        // Initializing the variables
        sp = findViewById(R.id.spinner_language);
        result = findViewById(R.id.text_number);
        name = findViewById(R.id.input_fullname);
        btn = findViewById(R.id.button_roll);
        icon = findViewById(R.id.img_icon);
        tbl = findViewById(R.id.table_main);

    }

    // Helper function to generate a random integer
    public int getRandomInt(){
        int min = 0;
        int max = 100;
        int randomInt = (int) Math.floor(Math.random() * (max - min + 1) + min);
        return randomInt;
    }

    // Function to add a row into the table
    public void insertRow(){
        // Custom typeface for row elements
        Typeface face = Typeface.create("casual", Typeface.NORMAL);
        TableRow tempRow = new TableRow(this);

        // Populate language column
        TextView languageCol = new TextView(this);
        languageCol.setText(languages.get(roundsPlayed).toString());
        languageCol.setTextSize(16);
        languageCol.setGravity(Gravity.CENTER);
        languageCol.setTypeface(face);
        tempRow.addView(languageCol);

        // Populate score column
        TextView scoreCol = new TextView(this);
        scoreCol.setText((scores.get(roundsPlayed).toString()));
        scoreCol.setTextSize(16);
        scoreCol.setGravity(Gravity.CENTER);
        scoreCol.setTypeface(face);
        scoreCol.setTextColor(Color.RED);
        tempRow.addView(scoreCol);

        // Add entries to table
        tbl.addView(tempRow);

        // Increment the number of rounds played for UI and data-retrieval purposes
        roundsPlayed++;
    }

    // Function to clear the entire table and reset the lists
    public void clear(View view){
        roundsPlayed = 0;
        languages.clear();
        scores.clear();
        result.setText("");

        // Remove all elements from table except for headers
        if (tbl.getRootView() != null) {
            int i = 1;
            while (tbl.getChildCount() != 1) {
                tbl.removeViewAt(i);
            }
        }
    }

    // Main function
    public void getResult(View view){
        String fullName = name.getText().toString();

        // Check if user input a name
        if (fullName.isEmpty()){
            Toast.makeText(getApplicationContext(), "Empty field, please enter your name!", Toast.LENGTH_LONG).show();
            YoYo.with(Techniques.Wobble).duration(700).repeat(0).playOn(name);
        }
        else {
            // Check if table is full
            if (roundsPlayed < 8){
                String selectedLanguage = sp.getSelectedItem().toString();
                languages.add(selectedLanguage);
                int randomInt = getRandomInt();
                scores.add(Integer.toString(randomInt) + "%");
                result.setText(randomInt + "%");

                // Check for selected language
                if (selectedLanguage.equals("Java")){
                    icon.setImageResource(R.drawable.java);
                    YoYo.with(Techniques.SlideInRight).duration(700).repeat(0).playOn(icon);
                }
                else if (selectedLanguage.equals("Kotlin")){
                    icon.setImageResource(R.drawable.kotlin);
                    YoYo.with(Techniques.SlideInRight).duration(700).repeat(0).playOn(icon);
                }
                else if (selectedLanguage.equals("Python")){
                    icon.setImageResource(R.drawable.python);
                    YoYo.with(Techniques.SlideInRight).duration(700).repeat(0).playOn(icon);
                }
                else if (selectedLanguage.equals("C")){
                    icon.setImageResource(R.drawable.c);
                    YoYo.with(Techniques.SlideInRight).duration(700).repeat(0).playOn(icon);
                }
                else if (selectedLanguage.equals("C++")){
                    icon.setImageResource(R.drawable.c__);
                    YoYo.with(Techniques.SlideInRight).duration(700).repeat(0).playOn(icon);
                }
                else if (selectedLanguage.equals("C#")){
                    icon.setImageResource(R.drawable.c_);
                    YoYo.with(Techniques.SlideInRight).duration(700).repeat(0).playOn(icon);
                }
                else if (selectedLanguage.equals("JavaScript")) {
                    icon.setImageResource(R.drawable.javascript);
                    YoYo.with(Techniques.SlideInRight).duration(700).repeat(0).playOn(icon);
                }
                if (randomInt <= 33){
                    YoYo.with(Techniques.Wobble).duration(700).repeat(5).playOn(icon);
                }
                else if (randomInt > 33 && randomInt <= 66){
                    YoYo.with(Techniques.Bounce).duration(700).repeat(5).playOn(icon);
                }
                else {
                    YoYo.with(Techniques.Pulse).duration(700).repeat(5).playOn(icon);
                }
                insertRow();
            }
            else {
                Toast.makeText(getApplicationContext(), "Too many rounds played, please clear the table!", Toast.LENGTH_LONG).show();
            }
        }
    }
}