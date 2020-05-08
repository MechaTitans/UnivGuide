package tn.mechatitans.forms;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import lecho.lib.hellocharts.listener.PieChartOnValueSelectListener;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;


public class results extends AppCompatActivity implements PieChartOnValueSelectListener{

    PieChartView pieChartView;
    TextView Title1,Title2,Title3,Title4,Title5,Text1,Text2,Text3,Text4,Text5;
    public static String s1,s2,s3,s4,s5;
    public static int i1,i2,i3,i4,i5;
    public int total = i1+i2+i3+i4+i5;
    FileOutputStream outputStream;
    String latestTitle0 = "lat_title0.mt";
    String latestTitle1 = "lat_title1.mt";
    String latestTitle2 = "lat_title2.mt";
    String latestTitle3 = "lat_title3.mt";
    String latestTitle4 = "lat_title4.mt";
    String latestfile = "latest1.mt";
    String latestfile2 = "latest2.mt";
    String latestfile3 = "latest3.mt";
    String latestfile4 = "latest4.mt";
    String latestfile5 = "latest5.mt";
    LinearLayout title;
    Button home;
    TextView h1, h2;
    HashMap<String,String> hashMap = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_act);
        Animation fadeinwithmvt = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadeinwithmvt);
        Animation fadeinwithdownmvt = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadeinwithdownmvt);
        title =(LinearLayout) findViewById(R.id.title);
        h1 = (TextView) findViewById(R.id.h1);
        h2 = (TextView) findViewById(R.id.h2);
        home = (Button) findViewById(R.id.home);
        title.startAnimation(fadeinwithdownmvt);
        h1.startAnimation(fadeinwithdownmvt);
        h2.startAnimation(fadeinwithdownmvt);
        Title1 = (TextView)findViewById(R.id.title1);
        Title2 = (TextView)findViewById(R.id.title2);
        Title3 = (TextView)findViewById(R.id.title3);
        Title4 = (TextView)findViewById(R.id.title4);
        Title5 = (TextView)findViewById(R.id.title5);
        Text1 = (TextView)findViewById(R.id.text1);
        Text2 = (TextView)findViewById(R.id.text2);
        Text3 = (TextView)findViewById(R.id.text3);
        Text4 = (TextView)findViewById(R.id.text4);
        Text5 = (TextView)findViewById(R.id.text5);
        hashMap.put("COMPUTER_SCIENCE","Computer Science");
        hashMap.put("MECHANICAL_ENGINEERING","Mechanical Engineering");
        hashMap.put("CHEMICAL_ENGINEERING","Chemical Engineering");
        hashMap.put("CIVIL_ENGINEERING","Civil Engineering");
        hashMap.put("ELECTRICAL_ENGINEERING","Electrical Engineering");
        hashMap.put("MARKETING","Marketing");
        hashMap.put("ENTREPRENEURSHIP","Entrepreneurship");
        hashMap.put("ACCOUNTING","Accounting");
        hashMap.put("ARTS","Arts");
        hashMap.put("POIITICS","Politics");
        hashMap.put("HISTORY","History");
        hashMap.put("LANGUAGES","Literature");
        hashMap.put("LAW","Law");
        hashMap.put("SPORTS","Sports");
        hashMap.put("ASTRONOMY","Astronomy");
        hashMap.put("MATHS","Math");
        hashMap.put("PHYSICS","Physics");
        hashMap.put("PHILOSOPHY","Philosophy");
        hashMap.put("MEDICAL_STUDIES","Medical Studies");
        hashMap.put("PHARMACY","Pharmacy");

        Typeface montserrat_reg = ResourcesCompat.getFont(this, R.font.montserrat_regular);
        Typeface montserrat_bold = ResourcesCompat.getFont(this, R.font.montserrat_bold);
        pieChartView = findViewById(R.id.chart);
        System.out.println(i1+";"+i2+";"+i3+";"+i4+";"+i5);
        final List pieData = new ArrayList<>();
        total = i1+i2+i3+i4+i5;
        pieData.add(new SliceValue(i1*100/total, Color.rgb(255, 245, 0)).setLabel(hashMap.get(s1)));
        pieData.add(new SliceValue(i2*100/total, Color.rgb(0, 102, 159)).setLabel(hashMap.get(s2)));
        pieData.add(new SliceValue(i3*100/total, Color.rgb(91, 255, 157)).setLabel(hashMap.get(s3)));
        pieData.add(new SliceValue(i4*100/total, Color.rgb(255, 87, 87)).setLabel(hashMap.get(s4)));
        pieData.add(new SliceValue(i5*100/total, Color.rgb(0, 163, 255)).setLabel(hashMap.get(s5)));

        final PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true).setValueLabelTypeface(montserrat_reg);
        pieChartData.setValueLabelTextSize(14);
       // pieChartData.setHasCenterCircle(true).setCenterText1("Top 5 best majors for you:").setCenterText1FontSize(17).setCenterText1Color(Color.parseColor("#444444"));
        pieChartView.setPieChartData(pieChartData);
        pieChartView.setOnValueTouchListener(this);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(results.this, MainMenu.class));
                overridePendingTransition(R.anim.transition_in,R.anim.fade_out);
            }
        });
    }

        @Override
        public void onValueSelected(int arcIndex, SliceValue value) {
            char[] slice = pieChartView.getPieChartData().getValues().get(arcIndex).getLabelAsChars();
            System.out.println("" + Arrays.toString(slice));
            String line = "";
            String Final = "";
            boolean title;
            boolean o = true;
            String a = "Engineering";
            String b = "Medical Science";
            String c = "Arts";
            String d = "Computer Science";
            String s = new String(slice);

            if (s.equals(a)) {
                System.out.print(a);
            } else if (s.equals(b)) {
                System.out.print(b);
            } else if (s.equals(c)) {
                System.out.print(c);
            } else if (s.equals(d)) {
                System.out.print(s);
            }
            try {
                FileInputStream in = openFileInput("base.unv");
                InputStreamReader inputStreamReader = new InputStreamReader(in);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                try {
                    line = bufferedReader.readLine();
                    mainloop:
                    while (o) {
                        if (line != null) {
                            if (line.substring(Math.min(1, line.length()), Math.min(s.length() + 1, line.length())).equals(s)) {
                                for (int i = 0; i < 5; i++) {
                                    line = bufferedReader.readLine();
                                    title = true;
                                    Final = "";
                                    for (int n = 1; n < line.length(); n++) {
                                        if (line.charAt(n) == '#') {
                                            if (title) {
                                                switch (i) {
                                                    case 0:
                                                        Title1.setText(Final);
                                                        outputStream = openFileOutput(latestTitle0, Context.MODE_PRIVATE);
                                                        outputStream.write(Final.getBytes());
                                                        outputStream.close();
                                                        break;
                                                    case 1:
                                                        Title2.setText(Final);
                                                        outputStream = openFileOutput(latestTitle1, Context.MODE_PRIVATE);
                                                        outputStream.write(Final.getBytes());
                                                        outputStream.close();
                                                        break;
                                                    case 2:
                                                        Title3.setText(Final);
                                                        outputStream = openFileOutput(latestTitle2, Context.MODE_PRIVATE);
                                                        outputStream.write(Final.getBytes());
                                                        outputStream.close();
                                                        break;
                                                    case 3:
                                                        Title4.setText(Final);
                                                        outputStream = openFileOutput(latestTitle3, Context.MODE_PRIVATE);
                                                        outputStream.write(Final.getBytes());
                                                        outputStream.close();
                                                        break;
                                                    case 4:
                                                        Title5.setText(Final);
                                                        outputStream = openFileOutput(latestTitle4, Context.MODE_PRIVATE);
                                                        outputStream.write(Final.getBytes());
                                                        outputStream.close();
                                                        break;
                                                    default:
                                                        break;
                                                }
                                                title = false;
                                                Final = "";
                                            }else Final = Final +"\n";

                                        } else {
                                            Final = Final + line.charAt(n);
                                        }
                                    }
                                    switch (i) {
                                        case 0:
                                            Text1.setText(Final);
                                            String str1 = Final.replace("\n","#");
                                            outputStream = openFileOutput(latestfile, Context.MODE_PRIVATE);
                                            outputStream.write(str1.getBytes());
                                            outputStream.close();
                                            break;
                                        case 1:
                                            Text2.setText(Final);
                                            String str2 = Final.replace("\n","#");
                                            outputStream = openFileOutput(latestfile2, Context.MODE_PRIVATE);
                                            outputStream.write(str2.getBytes());
                                            outputStream.close();
                                            break;
                                        case 2:
                                            Text3.setText(Final);
                                            String str3 = Final.replace("\n","#");
                                            outputStream = openFileOutput(latestfile3, Context.MODE_PRIVATE);
                                            outputStream.write(str3.getBytes());
                                            outputStream.close();
                                            break;
                                        case 3:
                                            Text4.setText(Final);
                                            String str4 = Final.replace("\n","#");
                                            outputStream = openFileOutput(latestfile4, Context.MODE_PRIVATE);
                                            outputStream.write(str4.getBytes());
                                            outputStream.close();
                                            break;
                                        case 4:
                                            Text5.setText(Final);
                                            String str5 = Final.replace("\n","#");
                                            outputStream = openFileOutput(latestfile5, Context.MODE_PRIVATE);
                                            outputStream.write(str5.getBytes());
                                            outputStream.close();
                                            break mainloop;
                                            default:
                                                break;
                                    }
                                }

                            } else line = bufferedReader.readLine();

                        } else line = bufferedReader.readLine();
                    }

                } catch (IOException ie) {
                }
            } catch (FileNotFoundException e) {
            }
        }

    @Override
    public void onValueDeselected() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }}


