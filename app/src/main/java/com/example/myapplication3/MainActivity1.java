package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class MainActivity1 extends AppCompatActivity {

    //private EditText textView2score;
    public int activpos1=0;
    public int pos1=0;
    public int valuepos1;

    public int maxvalue=100;

    public Button lastbuttonMyId;

    public int score=0;

    public int maxrandom=20;

    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);



        //автоматический сброс при входе




        activpos1=0;//отмена сохраненной выделенной
        score=0;//очистка очков

        textView2=findViewById(R.id.textView2);
        textView2.setText(String.valueOf(score));



        Button buttonLocal;

        for(int i=11; i <=44; i=i+10){

            for(int i2=0; i2 <4; i2=i2+1){


                int poslocal=i+i2;
                System.out.println(poslocal);

                Random random = new Random();

                int randomNumber = random.nextInt(maxrandom)+1;

                buttonLocal = findViewById(getResources().getIdentifier("button"+poslocal, "id", getPackageName()));//запись текщего значения

                buttonLocal.setText(String.valueOf(randomNumber));//замена значения на кнопке

                buttonLocal.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#1E60E4")));//возварщение исходного цвета//замена цвета

            }

        }



    }

    //вызываемые функции


    public void save_score(View v){


        //textView2 = findViewById(R.id.textView2);


        String scoretxt= textView2.getText().toString();//запись значения в строку

        try {
            //работа с записью очков //MODE_PRIVATE //
            FileOutputStream fileOutput =openFileOutput("score.txt",MODE_APPEND);

            fileOutput.write((scoretxt+"\n").getBytes());//запись очков с отступом строки в память

            fileOutput.close();


            Toast.makeText(this,"очков набрано "+scoretxt, Toast.LENGTH_SHORT).show();


        } catch (FileNotFoundException e) {

            Toast.makeText(this,"ошибка записи", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {

            Toast.makeText(this,"ошибка записи", Toast.LENGTH_SHORT).show();
        }


    }



    public void setActivity2(View v){


        Intent intent= new Intent(this,Activity2.class);
        startActivity(intent);


    }



    public void BtnClick2(View v) {

        Button button0;//создание переменной

        button0 = findViewById(R.id.button0);//запись текщего значения

        //преобразование значение в числовойформат
        int num1 = Integer.parseInt(button0.getText().toString());

        num1=num1+1;//прибаление значения

        //button0.setText(String.valueOf(num1));//замена значения на кнопке
        button0.setText(String.valueOf(v.getId()));//замена значения на кнопке
        //switch (v.getId()){



        //}


    }











    public void reset(View v) {

        if(score>0){
            //сохраняются очки >0
            save_score(v);//фунция записи очков
        }



        activpos1=0;//отмена сохраненной выделенной
        score=0;//очистка очков


        textView2.setText(String.valueOf(score));

        Button buttonLocal;

        for(int i=11; i <=44; i=i+10){

            for(int i2=0; i2 <4; i2=i2+1){


                int poslocal=i+i2;
                System.out.println(poslocal);

                Random random = new Random();

                int randomNumber = random.nextInt(maxrandom)+1;

                buttonLocal = findViewById(getResources().getIdentifier("button"+poslocal, "id", getPackageName()));//запись текщего значения

                buttonLocal.setText(String.valueOf(randomNumber));//замена значения на кнопке

                buttonLocal.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#1E60E4")));//возварщение исходного цвета//замена цвета

            }

        }


        //buttonLocal = findViewById(getResources().getIdentifier("button"+poslocal, "id", getPackageName()));//запись текщего значения
        //buttonLocal.setText(String.valueOf(0));//замена значения на кнопке

    }

    public void BtnClickMatMath(Button buttonMyId,int buttonNuberMat) {



        //преобразование значение в числовойформат

        int value1 = Integer.parseInt(buttonMyId.getText().toString());
        //num1=num1+1;//прибаление значения

        //buttonMyId.setText(String.valueOf(num1));//замена значения на кнопке


        //проверка значений

        //проверка первой позиции для выбора

        if(value1<maxvalue) {

            if(activpos1!=1) {
                pos1 = buttonNuberMat;
                activpos1=1;
                valuepos1=value1;

                lastbuttonMyId=buttonMyId;

                //buttonMyId.setBackgroundTintList(ColorStateList.valueOf(Color.GRAY));

                buttonMyId.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));

                //buttonMyId.setBackgroundTintList(ColorStateList.valueOf(Color.TRANSPARENT));

                //buttonMyId.setBackgroundTintList(ColorStateList.valueOf(Color.GRAY));//изменение цвета для максимальной ячейки

                //buttonMyId.setBackgroundColor(getTitleColor());

                //запись цвета поверх всех
                //button0.setBackgroundColor(getTitleColor());//возварщение исходного цвета



            }else{


                if(valuepos1+value1<=maxvalue){



                    System.out.println(valuepos1+value1+"число удовлетворяет");






                    //проверка 2 позиции для замены
                    if (buttonNuberMat == pos1 - 10 || buttonNuberMat == pos1 + 10 || buttonNuberMat == pos1 - 1 || buttonNuberMat == pos1 + 1)
                    {

                        //кнопка является прилежащей


                        int sum=valuepos1+value1;



                        activpos1=0;
                        String str0="button";
                        String str1=String.valueOf(str0+pos1);//название кнопки из
                        String str2=String.valueOf(str0+buttonNuberMat);//название кнопки в какую

                        System.out.println("перенос из "+str1+" в ячейку "+str2);
                        //System.out.println(str0.concat(str2));

                        buttonMyId.setText(String.valueOf(sum));//замена значения на кнопке



                        Button button0;




                        button0 = findViewById(getResources().getIdentifier(str1, "id", getPackageName()));//запись текщего значения
                        button0.setText(String.valueOf(0));//замена значения на кнопке


                        button0.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#1E60E4")));//возварщение исходного цвета



                        if(valuepos1+value1==maxvalue){


                            score=score+1000;//добавление очков за ячейку

                            textView2=findViewById(R.id.textView2);
                            textView2.setText(String.valueOf(score));



                            buttonMyId.setBackgroundTintList(ColorStateList.valueOf(Color.GRAY));//изменение цвета для максимальной ячейки


                        }


                        //добавление очков после сложения

                        score=score+sum;//изменения колчиества очков

                        textView2=findViewById(R.id.textView2);
                        textView2.setText(String.valueOf(score));

                        //код после сложения клеток

                        //поиск координат ячеек выше



                        for(int i=pos1; i >14; i=i-10) {
                            System.out.println(i);

                            //получение значения ячейки выше i

                            int iplus=i-10;

                            Button button00;

                            button00 = findViewById(getResources().getIdentifier("button"+iplus, "id", getPackageName()));//запись местоположения

                            int num4 = Integer.parseInt(button00.getText().toString());

                            System.out.println("перенос из"+iplus);

                            System.out.println("значение кнопки"+num4);

                            //buttonl0.setText(String.valueOf(0));//замена значения на кнопке

                            Button button01;

                            button01 = findViewById(getResources().getIdentifier("button"+i, "id", getPackageName()));//запись местоположения

                            button01.setText(String.valueOf(num4));//замена значения на кнопке

                            button00.setText(String.valueOf(0));//обнуление (необязательное)



                            Random random = new Random();

                            int randomNumber = random.nextInt(maxrandom)+1;


                            button00.setText(String.valueOf(randomNumber));//запись случайного числа

                            System.out.println("выпавшее значение pt1 " + randomNumber);

                            //смена цветов перенесенных ячеек


                            if(num4==maxvalue){//перенос цветов при падении

                                button01.setBackgroundTintList(ColorStateList.valueOf(Color.GRAY));//изменение цвета для максимальной ячейки

                            }else{


                                button01.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#1E60E4")));//возварщение исходного цвета


                            }

                            if(iplus<=14){
                                button00.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#1E60E4")));//возварщение исходного цвета
                            }




                        }

                        if(pos1<=14) {//заполнение шапки


                            Button button00;

                            button00 = findViewById(getResources().getIdentifier("button"+pos1, "id", getPackageName()));//запись местоположения

                            Random random = new Random();

                            int randomNumber = random.nextInt(maxrandom)+1;


                            button00.setText(String.valueOf(randomNumber));//запись случайного числа

                            System.out.println("выпавшее значениеpt2 " + randomNumber);





                        }

                    }else{

                        //отмена выделения
                        System.out.println("число превышает максимальное");

                        activpos1=0;
                        lastbuttonMyId.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#1E60E4")));//возварщение исходного цвета


                    }

                }else{

                    //отмена выделения
                    System.out.println("число превышает максимальное");

                    activpos1=0;
                    lastbuttonMyId.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#1E60E4")));//возварщение исходного цвета


                }


            }
        }else{


            if(value1==maxvalue&&activpos1==0){

                //не отменять выделение число равно максимальному



            }else{
                //отмена выделения
                activpos1=0;
                lastbuttonMyId.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#1E60E4")));//возварщение исходного цвета
            }






        }

    }
    public void BtnClickMat11(View v) {

        int buttonNuberMat;

        buttonNuberMat=11;

        Button button0;

        button0 = findViewById(R.id.button11);//запись текщего значения

        BtnClickMatMath(button0,buttonNuberMat);

    }
    public void BtnClickMat12(View v) {

        int buttonNuberMat;

        buttonNuberMat=12;

        Button button0;

        button0 = findViewById(R.id.button12);//запись текщего значения

        BtnClickMatMath(button0,buttonNuberMat);

    }
    public void BtnClickMat13(View v) {

        int buttonNuberMat;

        buttonNuberMat=13;

        Button button0;

        button0 = findViewById(R.id.button13);//запись текщего значения

        BtnClickMatMath(button0,buttonNuberMat);

    }
    public void BtnClickMat14(View v) {

        int buttonNuberMat;

        buttonNuberMat=14;

        Button button0;

        button0 = findViewById(R.id.button14);//запись текщего значения

        BtnClickMatMath(button0,buttonNuberMat);

    }
    public void BtnClickMat21(View v) {

        int buttonNuberMat;

        buttonNuberMat=21;

        Button button0;

        button0 = findViewById(R.id.button21);//запись текщего значения

        BtnClickMatMath(button0,buttonNuberMat);

    }
    public void BtnClickMat22(View v) {

        int buttonNuberMat;

        buttonNuberMat=22;

        Button button0;

        button0 = findViewById(R.id.button22);//запись текщего значения

        BtnClickMatMath(button0,buttonNuberMat);

    }
    public void BtnClickMat23(View v) {

        int buttonNuberMat;

        buttonNuberMat=23;

        Button button0;

        button0 = findViewById(R.id.button23);//запись текщего значения

        BtnClickMatMath(button0,buttonNuberMat);

    }
    public void BtnClickMat24(View v) {

        int buttonNuberMat;

        buttonNuberMat=24;

        Button button0;

        button0 = findViewById(R.id.button24);//запись текщего значения

        BtnClickMatMath(button0,buttonNuberMat);

    }
    public void BtnClickMat31(View v) {

        int buttonNuberMat;

        buttonNuberMat=31;

        Button button0;

        button0 = findViewById(R.id.button31);//запись текщего значения

        BtnClickMatMath(button0,buttonNuberMat);

    }
    public void BtnClickMat32(View v) {

        int buttonNuberMat;

        buttonNuberMat=32;

        Button button0;

        button0 = findViewById(R.id.button32);//запись текщего значения

        BtnClickMatMath(button0,buttonNuberMat);

    }
    public void BtnClickMat33(View v) {

        int buttonNuberMat;

        buttonNuberMat=33;

        Button button0;

        button0 = findViewById(R.id.button33);//запись текщего значения

        BtnClickMatMath(button0,buttonNuberMat);

    }
    public void BtnClickMat34(View v) {

        int buttonNuberMat;

        buttonNuberMat=34;

        Button button0;

        button0 = findViewById(R.id.button34);//запись текщего значения

        BtnClickMatMath(button0,buttonNuberMat);

    }
    public void BtnClickMat41(View v) {

        int buttonNuberMat;

        buttonNuberMat=41;

        Button button0;

        button0 = findViewById(R.id.button41);//запись текщего значения

        BtnClickMatMath(button0,buttonNuberMat);

    }
    public void BtnClickMat42(View v) {

        int buttonNuberMat;

        buttonNuberMat=42;

        Button button0;

        button0 = findViewById(R.id.button42);//запись текщего значения

        BtnClickMatMath(button0,buttonNuberMat);

    }
    public void BtnClickMat43(View v) {

        int buttonNuberMat;

        buttonNuberMat=43;

        Button button0;

        button0 = findViewById(R.id.button43);//запись текщего значения

        BtnClickMatMath(button0,buttonNuberMat);

    }
    public void BtnClickMat44(View v) {

        int buttonNuberMat;

        buttonNuberMat=44;

        Button button0;

        button0 = findViewById(R.id.button44);//запись текщего значения

        BtnClickMatMath(button0,buttonNuberMat);

    }

}