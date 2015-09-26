package com.example.user.p1m1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class EasyGame extends AppCompatActivity {

    // Sonucu yazd�rmak i�in kullan�lan de�i�ken
    TextView result;

    // Kullan�c�n�n tahminini g�steren k�s�m i�in kullan�lan de�i�kenler
    TextView guess_disp1, guess_disp2, guess_disp3, guess_disp4;

    // Kullan�c�ya tahmininde yard�mc� olmas� i�in konulan k�s�m i�in kullan�lan de�i�kenler
    TextView note1, note2, note3, note4, note5, note6, note7, note8, note9, note0;

    // Onayla butonu i�in kullan�lan de�i�ken
    Button confirm;

    // Kullan�c� say� giri�i i�in kullan�lan butonlar�n de�i�kenleri
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;

    // Kullan�c� tahmininin depoland��� de�i�kenler
    int guess1=0, guess2=0, guess3=0, guess4=0;

    // Bilgisayar�n tahmininin depoland��� de�i�kenler
    int AI_given1=0, AI_given2=0, AI_given3=0, AI_given4=0;

    // Kullan�c�n�n ayn� say� girmesinin engellemek amac�yla konulan anahtar
    int flag=1;

    // Hesaplanan say�lar�n g�sterilmesi i�in kullan�lan de�i�kenler
    String total_sum = "", sum = "";

    // Kullan�c�n�n tahmini i�in kullan�lan de�i�kenler
    String guess_no1="", guess_no2="", guess_no3="", guess_no4="";


    // Kullan�c�n�n tahmini ve bilgisayar�n tahmininin kar��la�t�r�ld��� alt fonksiyon
    //
    // guess[]    : Kullan�c�n�n tahminini i�eren ve 4 eleman� bulunan dizi
    // AI_given[] : Bilgisayar�n tahminini i�eren ve 4 eleman� bulunan dizi

    public String control_number(int guess[], int AI_given[]) {

        String r = "";

        for (int i = 0; i < 4; i++) {
            if (guess[i] == AI_given[i]) {
                r = r + " +1";
            }
            else {
                int j = 0;
                int flag2 = 0;
                while (j < 4) {
                    if (guess[i] == AI_given[j]) {
                        r = r + " -1";
                        flag2 = 1;
                    }
                    j++;
                }
                if (flag2 == 0) {
                    r = r + " 0";
                }
            }

        }


        return r;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.easygame_layout);

        // Layouttaki elemanlar�n id si ile de�i�kenlere ba�lanmas�

        result = (TextView) findViewById(R.id.result_single1);

        note1 = (TextView) findViewById(R.id.deneme_num_1);
        note2 = (TextView) findViewById(R.id.deneme_num_2);
        note3 = (TextView) findViewById(R.id.deneme_num_3);
        note4 = (TextView) findViewById(R.id.deneme_num_4);
        note5 = (TextView) findViewById(R.id.deneme_num_5);
        note6 = (TextView) findViewById(R.id.deneme_num_6);
        note7 = (TextView) findViewById(R.id.deneme_num_7);
        note8 = (TextView) findViewById(R.id.deneme_num_8);
        note9 = (TextView) findViewById(R.id.deneme_num_9);
        note0 = (TextView) findViewById(R.id.deneme_num_0);


        confirm = (Button) findViewById(R.id.confirm_single1);

        btn1= (Button) findViewById(R.id.btn1);
        btn2= (Button) findViewById(R.id.btn2);
        btn3= (Button) findViewById(R.id.btn3);
        btn4= (Button) findViewById(R.id.btn4);
        btn5= (Button) findViewById(R.id.btn5);
        btn6= (Button) findViewById(R.id.btn6);
        btn7= (Button) findViewById(R.id.btn7);
        btn8= (Button) findViewById(R.id.btn8);
        btn9= (Button) findViewById(R.id.btn9);
        btn0= (Button) findViewById(R.id.btn0);

        guess_disp1 = (TextView) findViewById(R.id.num_1);
        guess_disp2 = (TextView) findViewById(R.id.num_2);
        guess_disp3 = (TextView) findViewById(R.id.num_3);
        guess_disp4 = (TextView) findViewById(R.id.num_4);


        // Kullan�c�ya yard�mc� olmas� i�in konulan k�s�m
        // Say�lar ilk olarak siyah renkte gelmekte,
        // textview �zerine ilk t�kland���nda ye�il, ikinci t�kland���nda transparan, ���nc� t�kland���nda siyaha geri d�nmekte.

        note1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (note1.getCurrentTextColor()== Color.BLACK){
                    note1.setTextColor(Color.GREEN);
                }
                else if (note1.getCurrentTextColor()==Color.GREEN){
                    note1.setTextColor(Color.argb(50, 0, 0, 0));
                }
                else {
                    note1.setTextColor(Color.BLACK);
                }

            }
        });

        note2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (note2.getCurrentTextColor()==Color.BLACK){
                    note2.setTextColor(Color.GREEN);
                }
                else if (note2.getCurrentTextColor()==Color.GREEN){
                    note2.setTextColor(Color.argb(50, 0, 0, 0));
                }
                else {
                    note2.setTextColor(Color.BLACK);
                }

            }
        });

        note3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (note3.getCurrentTextColor()==Color.BLACK){
                    note3.setTextColor(Color.GREEN);
                }
                else if (note3.getCurrentTextColor()==Color.GREEN){
                    note3.setTextColor(Color.argb(50, 0, 0, 0));
                }
                else {
                    note3.setTextColor(Color.BLACK);
                }

            }
        });

        note4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (note4.getCurrentTextColor()==Color.BLACK){
                    note4.setTextColor(Color.GREEN);
                }
                else if (note4.getCurrentTextColor()==Color.GREEN){
                    note4.setTextColor(Color.argb(50, 0, 0, 0));
                }
                else {
                    note4.setTextColor(Color.BLACK);
                }

            }
        });

        note5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (note5.getCurrentTextColor()==Color.BLACK){
                    note5.setTextColor(Color.GREEN);
                }
                else if (note5.getCurrentTextColor()==Color.GREEN){
                    note5.setTextColor(Color.argb(50, 0, 0, 0));
                }
                else {
                    note5.setTextColor(Color.BLACK);
                }

            }
        });

        note6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (note6.getCurrentTextColor()==Color.BLACK){
                    note6.setTextColor(Color.GREEN);
                }
                else if (note6.getCurrentTextColor()==Color.GREEN){
                    note6.setTextColor(Color.argb(50, 0, 0, 0));
                }
                else {
                    note6.setTextColor(Color.BLACK);
                }

            }
        });

        note7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (note7.getCurrentTextColor()==Color.BLACK){
                    note7.setTextColor(Color.GREEN);
                }
                else if (note7.getCurrentTextColor()==Color.GREEN){
                    note7.setTextColor(Color.argb(50, 0, 0, 0));
                }
                else {
                    note7.setTextColor(Color.BLACK);
                }

            }
        });

        note8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (note8.getCurrentTextColor()==Color.BLACK){
                    note8.setTextColor(Color.GREEN);
                }
                else if (note8.getCurrentTextColor()==Color.GREEN){
                    note8.setTextColor(Color.argb(50, 0, 0, 0));
                }
                else {
                    note8.setTextColor(Color.BLACK);
                }

            }
        });

        note9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (note9.getCurrentTextColor()==Color.BLACK){
                    note9.setTextColor(Color.GREEN);
                }
                else if (note9.getCurrentTextColor()==Color.GREEN){
                    note9.setTextColor(Color.argb(50, 0, 0, 0));
                }
                else {
                    note9.setTextColor(Color.BLACK);
                }

            }
        });

        note0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (note0.getCurrentTextColor()==Color.BLACK){
                    note0.setTextColor(Color.GREEN);
                }
                else if (note0.getCurrentTextColor()==Color.GREEN){
                    note0.setTextColor(Color.argb(50, 0, 0, 0));
                }
                else {
                    note0.setTextColor(Color.BLACK);
                }

            }
        });



        // Kullan�c� giri�inin sa�land��� butonlar
        // Kullan�c� ilgili butona t�klad���nda o butonun g�sterdi�i say� ilk bo� alana gelmekte

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (guess_no1=="") {

                    guess_no1="1";
                    guess_disp1.setText(guess_no1);

                }
                else if (guess_no2=="") {

                    guess_no2="1";
                    guess_disp2.setText(guess_no2);

                }
                else if (guess_no3=="") {

                    guess_no3="1";
                    guess_disp3.setText(guess_no3);

                }
                else if (guess_no4=="") {

                    guess_no4="1";
                    guess_disp4.setText(guess_no4);

                }

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (guess_no1=="") {

                    guess_no1="2";
                    guess_disp1.setText(guess_no1);

                }
                else if (guess_no2=="") {

                    guess_no2="2";
                    guess_disp2.setText(guess_no2);

                }
                else if (guess_no3=="") {

                    guess_no3="2";
                    guess_disp3.setText(guess_no3);

                }
                else if (guess_no4=="") {

                    guess_no4="2";
                    guess_disp4.setText(guess_no4);

                }

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (guess_no1=="") {

                    guess_no1="3";
                    guess_disp1.setText(guess_no1);

                }
                else if (guess_no2=="") {

                    guess_no2="3";
                    guess_disp2.setText(guess_no2);

                }
                else if (guess_no3=="") {

                    guess_no3="3";
                    guess_disp3.setText(guess_no3);

                }
                else if (guess_no4=="") {

                    guess_no4="3";
                    guess_disp4.setText(guess_no4);

                }

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (guess_no1=="") {

                    guess_no1="4";
                    guess_disp1.setText(guess_no1);

                }
                else if (guess_no2=="") {

                    guess_no2="4";
                    guess_disp2.setText(guess_no2);

                }
                else if (guess_no3=="") {

                    guess_no3="4";
                    guess_disp3.setText(guess_no3);

                }
                else if (guess_no4=="") {

                    guess_no4="4";
                    guess_disp4.setText(guess_no4);

                }

            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (guess_no1=="") {

                    guess_no1="5";
                    guess_disp1.setText(guess_no1);

                }
                else if (guess_no2=="") {

                    guess_no2="5";
                    guess_disp2.setText(guess_no2);

                }
                else if (guess_no3=="") {

                    guess_no3="5";
                    guess_disp3.setText(guess_no3);

                }
                else if (guess_no4=="") {

                    guess_no4="5";
                    guess_disp4.setText(guess_no4);

                }

            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (guess_no1=="") {

                    guess_no1="6";
                    guess_disp1.setText(guess_no1);

                }
                else if (guess_no2=="") {

                    guess_no2="6";
                    guess_disp2.setText(guess_no2);

                }
                else if (guess_no3=="") {

                    guess_no3="6";
                    guess_disp3.setText(guess_no3);

                }
                else if (guess_no4=="") {

                    guess_no4="6";
                    guess_disp4.setText(guess_no4);

                }

            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (guess_no1=="") {

                    guess_no1="7";
                    guess_disp1.setText(guess_no1);

                }
                else if (guess_no2=="") {

                    guess_no2="7";
                    guess_disp2.setText(guess_no2);

                }
                else if (guess_no3=="") {

                    guess_no3="7";
                    guess_disp3.setText(guess_no3);

                }
                else if (guess_no4=="") {

                    guess_no4="7";
                    guess_disp4.setText(guess_no4);

                }

            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (guess_no1=="") {

                    guess_no1="8";
                    guess_disp1.setText(guess_no1);

                }
                else if (guess_no2=="") {

                    guess_no2="8";
                    guess_disp2.setText(guess_no2);

                }
                else if (guess_no3=="") {

                    guess_no3="8";
                    guess_disp3.setText(guess_no3);

                }
                else if (guess_no4=="") {

                    guess_no4="8";
                    guess_disp4.setText(guess_no4);

                }

            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (guess_no1=="") {

                    guess_no1="9";
                    guess_disp1.setText(guess_no1);

                }
                else if (guess_no2=="") {

                    guess_no2="9";
                    guess_disp2.setText(guess_no2);

                }
                else if (guess_no3=="") {

                    guess_no3="9";
                    guess_disp3.setText(guess_no3);

                }
                else if (guess_no4=="") {

                    guess_no4="9";
                    guess_disp4.setText(guess_no4);

                }

            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (guess_no1=="") {

                    guess_no1="0";
                    guess_disp1.setText(guess_no1);

                }
                else if (guess_no2=="") {

                    guess_no2="0";
                    guess_disp2.setText(guess_no2);

                }
                else if (guess_no3=="") {

                    guess_no3="0";
                    guess_disp3.setText(guess_no3);

                }
                else if (guess_no4=="") {

                    guess_no4="0";
                    guess_disp4.setText(guess_no4);

                }

            }
        });


        // Kullan�c� giri�inin yap�ld��� say�lar �zerine t�kland���nda ilgili k�s�m�n silinmesi

        guess_disp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guess_no1="";
                guess_disp1.setText("-");

            }
        });

        guess_disp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guess_no2="";
                guess_disp2.setText("-");

            }
        });

        guess_disp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guess_no3="";
                guess_disp3.setText("-");

            }
        });

        guess_disp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guess_no4="";
                guess_disp4.setText("-");

            }
        });


        // Bilgisayar�n tahmini olarak, basamaklar� birbirinden farkl� rasgele 4 basamakl� say� se�imi

        Random rand = new Random();
        AI_given1 = rand.nextInt(10);
        AI_given2 = rand.nextInt(10);

        while (AI_given1==AI_given2){
            AI_given2 = rand.nextInt(10);
        }

        AI_given3 = rand.nextInt(10);

        while ((AI_given1==AI_given3)||(AI_given2==AI_given3)){
            AI_given3 = rand.nextInt(10);
        }

        AI_given4 = rand.nextInt(10);

        while ((AI_given1==AI_given4)||(AI_given2==AI_given4)||(AI_given3==AI_given4)){
            AI_given4 = rand.nextInt(10);
        }

        // Bilgisayar�n tahmini olan AI_Given[] dizisinin olu�turulmas�

        final int AI_given[] = {AI_given1, AI_given2, AI_given3, AI_given4};



        //Onayla butonuna bas�lmas�

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // String olan de�i�kenlerin integer a �evrimi

                guess1 = Integer.parseInt(guess_no1);
                guess2 = Integer.parseInt(guess_no2);
                guess3 = Integer.parseInt(guess_no3);
                guess4 = Integer.parseInt(guess_no4);


                // sum de�i�kenine kullan�c�n�n tahmininin yaz�lmas�

                sum = "" + guess1 + guess2 + guess3 + guess4;


                // Kullan�c� tahmini olan guess[] dizisinin olu�turulmas�

                int guess[] = {guess1, guess2, guess3, guess4};

                // Kullan�c�n�n girdi�i say�lar�n�n birbirinden farkl� olmas�n�n kontrol�

                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (i != j) {
                            if (guess[i] == guess[j]) {
                                flag = 0;
                                break;
                            }
                        }
                    }
                }

                // Kullan�c� ayn� say�lar� girerse, uyar� verilmesi
                if (flag == 0) {

                    Toast.makeText(getApplicationContext(), "Please Enter Different Numbers", Toast.LENGTH_LONG).show();

                    flag = 1;

                    // Kullan�c� farkl� say�lar girerse control_number alt fonksiyonu ile kullan�c�n�n say�s� ve bilgisayar�n say�s�n�n kar��la�t�r�lmas�
                    // ve kullan�c�ya g�sterilmesi

                } else {


                    total_sum = "" + sum + "        " + control_number(guess, AI_given) + "\n" + total_sum;
                    result.setText("" + total_sum);


                }

                // Yeni say� giri�i i�in de�i�kenlerin s�f�rlanmas� ve ekranda g�sterilmesi

                guess_no1 = "";
                guess_no2 = "";
                guess_no3 = "";
                guess_no4 = "";

                guess_disp1.setText("-");
                guess_disp2.setText("-");
                guess_disp3.setText("-");
                guess_disp4.setText("-");


            }
        });

    }
}

