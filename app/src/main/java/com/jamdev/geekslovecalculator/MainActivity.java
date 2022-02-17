package com.jamdev.geekslovecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {

    // Declaring the global variables
    Spinner sp;
    TextView result, name;
    ImageView icon;
    Button btn;

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
        btn = findViewById(R.id.button);
        icon = findViewById(R.id.img_icon);

    }

    public int getRandomInt(){
        int min = 0;
        int max = 100;
        int randomInt = (int) Math.floor(Math.random() * (max - min + 1) + min);
        return randomInt;
    }

    public void getResult(View view){
        String fullName = name.getText().toString();
        // Check if user input a name
        if (fullName.isEmpty()){
            Toast.makeText(getApplicationContext(), "Empty field, please enter your name!", Toast.LENGTH_LONG).show();
            YoYo.with(Techniques.Wobble).duration(700).repeat(0).playOn(name);
        }
        else {
            String selectedLanguage = sp.getSelectedItem().toString();
            int randomInt = getRandomInt();
            result.setText(randomInt + "%");
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
        }
    }
}