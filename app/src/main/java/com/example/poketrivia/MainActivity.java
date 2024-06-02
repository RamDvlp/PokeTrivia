package com.example.poketrivia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private static final int numOfCorrectAnswes = 9;
    private int[] allImages;

    private int score =0;

    private ArrayList<Integer> pos = new ArrayList<>();
    private String correctAnswer;
    private ArrayList<Q_A> questions = new ArrayList<>();
    private Button main_BTN_AnswerD;
    private Button main_BTN_AnswerC;
    private Button main_BTN_AnswerB;
    private Button main_BTN_AnswerA;
    private AppCompatImageView main_IMG_pokeImg;
    private ImageView main_IMG_pokeball1;
    private ImageView main_IMG_pokeball2;
    private ImageView main_IMG_pokeball3;
    private ImageView main_IMG_pokeball4;
    private ImageView main_IMG_pokeball5;
    private ImageView main_IMG_pokeball6;
    private ImageView main_IMG_pokeball7;
    private ImageView main_IMG_pokeball8;
    private ImageView main_IMG_pokeball9;
    private ImageView main_IMG_pokeball10;

    private ImageView[] pokeballs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initpos();
        findVies();
        getallImages();


        initViews();

    }

    private void initpos() {
        pos.add(1);
        pos.add(2);
        pos.add(3);
        pos.add(4);
        Collections.shuffle(pos);
    }

    private void initViews() {


        main_BTN_AnswerA.setText(questions.get(pos.indexOf(1)).getName());
        main_BTN_AnswerB.setText(questions.get(pos.indexOf(2)).getName());
        main_BTN_AnswerC.setText(questions.get(pos.indexOf(3)).getName());
        main_BTN_AnswerD.setText(questions.get(pos.indexOf(4)).getName());
        main_IMG_pokeImg.setImageResource(questions.get(pos.indexOf(1)).getImg());

        correctAnswer = questions.get(pos.indexOf(1)).getName();

        main_BTN_AnswerA.setOnClickListener(v -> getAnswer(main_BTN_AnswerA.getText().toString()));
        main_BTN_AnswerB.setOnClickListener(v -> getAnswer(main_BTN_AnswerB.getText().toString()));
        main_BTN_AnswerC.setOnClickListener(v -> getAnswer(main_BTN_AnswerC.getText().toString()));
        main_BTN_AnswerD.setOnClickListener(v -> getAnswer(main_BTN_AnswerD.getText().toString()));
    }

    private void getAnswer(String s) {
        if(s.equals(correctAnswer)){
            getpokeball();
        }
        setQuestion();
    }

    private void setQuestion() {
        Collections.shuffle(questions);

        updateUI();

        int correctAnswerPos = (int) ((Math.random() * (5 - 1)) + 1);
        switch (correctAnswerPos){
            case 1:
                main_BTN_AnswerA.setText(questions.get(0).getName());
                main_BTN_AnswerB.setText(questions.get(1).getName());
                main_BTN_AnswerC.setText(questions.get(2).getName());
                main_BTN_AnswerD.setText(questions.get(3).getName());
                break;
            case 2:
                main_BTN_AnswerA.setText(questions.get(1).getName());
                main_BTN_AnswerB.setText(questions.get(0).getName());
                main_BTN_AnswerC.setText(questions.get(2).getName());
                main_BTN_AnswerD.setText(questions.get(3).getName());
                break;

            case 3:
                main_BTN_AnswerA.setText(questions.get(2).getName());
                main_BTN_AnswerB.setText(questions.get(1).getName());
                main_BTN_AnswerC.setText(questions.get(0).getName());
                main_BTN_AnswerD.setText(questions.get(3).getName());
                break;

            case 4:
                main_BTN_AnswerA.setText(questions.get(3).getName());
                main_BTN_AnswerB.setText(questions.get(1).getName());
                main_BTN_AnswerC.setText(questions.get(2).getName());
                main_BTN_AnswerD.setText(questions.get(0).getName());
                break;
        }

    }

    private void updateUI() {
        main_IMG_pokeImg.setImageResource(questions.get(0).getImg());
        correctAnswer = questions.get(0).getName();
    }

    private void getpokeball() {
        pokeballs[score].setVisibility(View.VISIBLE);


        if(score == 10){
            youWin();
        }
        score++;



    }

    private void youWin() {
        main_BTN_AnswerA.setEnabled(false);
        main_BTN_AnswerB.setEnabled(false);
        main_BTN_AnswerC.setEnabled(false);
        main_BTN_AnswerD.setEnabled(false);
    }

    private void getallImages() {

        Field[] fields = R.drawable.class.getFields();
        allImages = new int[fields.length];

        for (int i = 0; i < fields.length; i++) {
            try {

                allImages[i] = fields[i].getInt(null);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }  catch (IllegalArgumentException e) {
                throw new RuntimeException(e);
            }
        }


        addAllImages();
    }

    private void addAllImages() {

        for (int i = 0; i < allImages.length; i++) {
            if(i == 54 || i == 55)
                continue;
            if(allImages[i] == R.drawable.pokeball)
                continue;
            questions.add(new Q_A().setImg(allImages[i]).setName(getResources().getResourceName(allImages[i])));


        }

        Collections.shuffle(questions);

    }


    private void findVies() {

        main_BTN_AnswerD = findViewById(R.id.main_BTN_AnswerD);
        main_BTN_AnswerC= findViewById(R.id.main_BTN_AnswerC);
        main_BTN_AnswerB= findViewById(R.id.main_BTN_AnswerB);
        main_BTN_AnswerA= findViewById(R.id.main_BTN_AnswerA);
        main_IMG_pokeImg = findViewById(R.id.main_IMG_pokeImg);
        main_IMG_pokeball1= findViewById(R.id.main_IMG_pokeball1);
        main_IMG_pokeball2= findViewById(R.id.main_IMG_pokeball2);
        main_IMG_pokeball3= findViewById(R.id.main_IMG_pokeball3);
        main_IMG_pokeball4= findViewById(R.id.main_IMG_pokeball4);
        main_IMG_pokeball5= findViewById(R.id.main_IMG_pokeball5);
        main_IMG_pokeball6= findViewById(R.id.main_IMG_pokeball6);
        main_IMG_pokeball7= findViewById(R.id.main_IMG_pokeball7);
        main_IMG_pokeball8= findViewById(R.id.main_IMG_pokeball8);
        main_IMG_pokeball9= findViewById(R.id.main_IMG_pokeball9);
        main_IMG_pokeball10= findViewById(R.id.main_IMG_pokeball10);

        pokeballs = new ImageView[]{
                main_IMG_pokeball1,
                main_IMG_pokeball2,
                main_IMG_pokeball3,
                main_IMG_pokeball4,
                main_IMG_pokeball5,
                main_IMG_pokeball6,
                main_IMG_pokeball7,
                main_IMG_pokeball8,
                main_IMG_pokeball9,
                main_IMG_pokeball10
        };


    }
}