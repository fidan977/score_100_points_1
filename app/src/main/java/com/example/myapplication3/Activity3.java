package com.example.myapplication3;

import static java.lang.Integer.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Activity3 extends AppCompatActivity {


    //страница с выводом информации

    Button button_null;

    private String[] scoreArr;

    private int scoreCount=10;//длинна top list



    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        listView=findViewById(R.id.ListView);



        scoreArr=new String[scoreCount];




        load_score(button_null);






    }

    public void setActivity2(View v){


        Intent intent= new Intent(this,Activity2.class);
        startActivity(intent);


    }




    public void load_score(View v){
        //получение списка набранных очков


        System.out.println("начало чтения ");
        try {
            FileInputStream fileInput = openFileInput("score.txt");//адрес
            InputStreamReader reader =new InputStreamReader(fileInput);//читам фаил
            BufferedReader bR=new BufferedReader(reader);//выделяем соразмерную память

            //работа с файлом

            //StringBuilder stringBuilder =new StringBuilder();//для больших массивов хранилище всех значний

            int nuberstrings=0;
            int minValue=0;
            int minValuePoint=0;
            scoreArr[0]="0";

            String lines = "";

            //&&scoreCount!=nuberstrings

            while(((lines=bR.readLine())!=null)){//если еще есть данные и не закрыт список


                System.out.println("  ");
                System.out.println("круг сортировки "+nuberstrings);
                System.out.println("minValuePoint "+minValuePoint);



                //сортировка

                String localString=lines;
                System.out.println("localString "+localString);
                if((nuberstrings<scoreCount)&&nuberstrings>1){//если значение помещается в список


                    minValuePoint=nuberstrings-1;
                    System.out.println("minValuePoint "+minValuePoint);

                    minValue=parseInt(scoreArr[minValuePoint]);//цепляемся за последний элемент
                    System.out.println("минимальный элемент установлен позиция "+minValuePoint+" значение "+minValue);

                    scoreArr[nuberstrings]= localString;
                    System.out.println("временная запись в ячейку "+nuberstrings+" значение "+(scoreArr[nuberstrings]));

                }else{
                    //System.out.println("есть отавшееся значения "+localString);
                }
                if((parseInt(localString)>minValue)){//значение больше пограничного





                    //проверка значений выше
                    int i=minValuePoint;

                    while (i>=0){//если значение не проверено с более высшим



                        //Toast.makeText(this,"значение "+i,Toast.LENGTH_SHORT).show();
                        System.out.println("сравнение с ячейкой "+i);

                        if(parseInt(localString)>parseInt((scoreArr[i]))){
                            System.out.println(scoreArr[i]+"<"+parseInt(localString));
                            //заменяем с верхним

                            scoreArr[i+1]=scoreArr[i];
                            scoreArr[i]=localString;

                            System.out.println("перенос значения в ячейку "+i+" значение "+(scoreArr[i]));


                        }else{
                            System.out.println(scoreArr[i]+"!<"+parseInt(localString));
                        }

                        i=i-1;//установка ячейки выше
                    }



                }

                nuberstrings+=1;
            }
            while(scoreCount>nuberstrings){//добивание нулями пока не закроется список
                System.out.println("добивание ячейки "+nuberstrings);

                scoreArr[nuberstrings]="0";

                nuberstrings+=1;
            }





            //scoreArr= new String[]{String.valueOf(stringBuilder)};

            ArrayAdapter<String> adapter=new ArrayAdapter<>(this, R.layout.style1,R.id.score_name,scoreArr);
            listView.setAdapter(adapter);

            if(nuberstrings>0){
                //выводимое поле
                //textView3=findViewById(R.id.textView3);
                //textView3.setText(String.valueOf(stringBuilder));

                System.out.println("сортировка завершена количество строк от 0 до "+nuberstrings);

                for(int i=0;i<scoreCount;i++){
                    System.out.println("i= "+i+"значение "+scoreArr[i]);
                }


                //Toast.makeText(this,stringBuilder,Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"Сохраниний не обнуружено",Toast.LENGTH_SHORT).show();
            }
        } catch (FileNotFoundException e) {
            Toast.makeText(this,"Нет сохранений",Toast.LENGTH_SHORT).show();


        } catch (IOException e) {
            Toast.makeText(this,"Иная ошибка",Toast.LENGTH_SHORT).show();
        }


    }
}