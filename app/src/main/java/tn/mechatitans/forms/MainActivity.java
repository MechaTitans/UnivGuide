package tn.mechatitans.forms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import java.util.ArrayList;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    public subDomain[] subdomains = new subDomain[5];
    ArrayList<Question> questionList = new ArrayList<>();
    ArrayList<CheckBox> checkBoxes = new ArrayList<>();
    int current = 0;
    ArrayList<subQuestion> sql0 = new ArrayList<>();
    boolean part = false;
    TextView currentQuestion;
    Domain mainDomains[] = new Domain[3];
    HashMap<DomainType,Integer> scores = new HashMap<>();
    HashMap<subDomainType,Integer> subscores = new HashMap<>();
    HashMap<DomainType,ArrayList<subQuestion>> subquestions = new HashMap<>();
    int currentDomain = 0;
    public boolean questionAnswered(Question q){
        for(int i = 0;i<current;i++){
            if(questionList.get(i).equals(q))return true;
        }
        return false;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Animation fadeinwithmvt = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadeinwithmvt);
        Animation fadeinwithdownmvt = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadeinwithdownmvt);
        Button home = (Button) findViewById(R.id.home);
        for(int i = 0;i<subDomainType.values().length;i++){
           subscores.put(subDomainType.values()[i],0);       }
        currentQuestion =(TextView)findViewById(R.id.question);
        checkBoxes.add((CheckBox) findViewById(R.id.checkBox0));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBox1));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBox2));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBox3));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBox4));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBox5));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBox6));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBox7));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBox8));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBox9));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBox10));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBox11));
        for(int i = 0;i<DomainType.values().length;i++){
            scores.put(DomainType.values()[i],0);
        }
        buildQuestions();
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainMenu.class));
                overridePendingTransition(R.anim.transition_in,R.anim.fade_out);
            }
        });
    }
    public void buildQuestions() {
        Question q = new Question("Which of the following fields of study you see yourself in ?", true);
        Choice c00 = new Choice("Arts and Humanity");
        Choice c01 = new Choice("Business");
        Choice c02 = new Choice("Sports");
        Choice c03 = new Choice("Literature");
        Choice c04 = new Choice("Engineering");
        Choice c05 = new Choice("Science");
        Choice c06 = new Choice("Health and Medicine");
        c00.addDomain(DomainType.ARTS_AND_HUMANITIES,1);
        c01.addDomain(DomainType.BUSINESS,1);
        c02.addDomain(DomainType.SPORTS,1);
        c03.addDomain(DomainType.LITERATURE,1);
        c04.addDomain(DomainType.ENGINEERING,1);
        c05.addDomain(DomainType.SCIENCE,1);
        c06.addDomain(DomainType.HEALTH,1);
        q.addChoice(c00);
        q.addChoice(c01);
        q.addChoice(c02);
        q.addChoice(c03);
        q.addChoice(c04);
        q.addChoice(c05);
        q.addChoice(c06);
        Question q1 = new Question("In which field do you practise or want to practise extracurricular ?", true);
        Choice c10 = new Choice("Technology");
        Choice c11 = new Choice("Arts");
        Choice c12 = new Choice("Sports");
        Choice c13 = new Choice("Politics");
        Choice c14 = new Choice("Science Club");
        Choice c15 = new Choice("Astronomy");
        Choice c16 = new Choice("Marketing and Business");
        Choice c17 = new Choice("Volunteering");
        Choice c18 = new Choice("Events Club");
        Choice c19 = new Choice("Culture (History and Geography)");
        c10.addDomain(DomainType.ENGINEERING,1);
        c10.addDomain(DomainType.SCIENCE,1);
        c11.addDomain(DomainType.ARTS_AND_HUMANITIES,1);
        c11.addDomain(DomainType.LITERATURE,1);
        c12.addDomain(DomainType.SPORTS,1);
        c12.addDomain(DomainType.HEALTH,1);
        c13.addDomain(DomainType.LITERATURE,1);
        c13.addDomain(DomainType.ARTS_AND_HUMANITIES,1);
        c14.addDomain(DomainType.SCIENCE,1);
        c14.addDomain(DomainType.ENGINEERING,1);
        c14.addDomain(DomainType.HEALTH,1);
        c15.addDomain(DomainType.SCIENCE,1);
        c15.addDomain(DomainType.ENGINEERING,1);
        c16.addDomain(DomainType.BUSINESS,2);
        c17.addDomain(DomainType.HEALTH,1);
        c17.addDomain(DomainType.BUSINESS,1);
        c18.addDomain(DomainType.ARTS_AND_HUMANITIES,1);
        c18.addDomain(DomainType.BUSINESS,1);
        c18.addDomain(DomainType.LITERATURE,1);
        c19.addDomain(DomainType.ARTS_AND_HUMANITIES,1);
        c19.addDomain(DomainType.LITERATURE,1);
        q1.addChoice(c10);
        q1.addChoice(c11);
        q1.addChoice(c12);
        q1.addChoice(c13);
        q1.addChoice(c14);
        q1.addChoice(c15);
        q1.addChoice(c16);
        q1.addChoice(c17);
        q1.addChoice(c18);
        q1.addChoice(c19);
        Question q2 = new Question("What's your orientation ?", false);
        Choice c20 = new Choice("Technology");
        Choice c21 = new Choice("Maths");
        Choice c22 = new Choice("Experimental Science");
        Choice c23 = new Choice("Sports");
        Choice c24 = new Choice("Literature");
        Choice c25 = new Choice("Computer Science");
        Choice c26 = new Choice("Economy");
        c20.addDomain(DomainType.ENGINEERING,1);
        c21.addDomain(DomainType.ENGINEERING,1);
        c21.addDomain(DomainType.HEALTH,1);
        c21.addDomain(DomainType.SCIENCE,1);
        c21.addDomain(DomainType.BUSINESS,1);
        c22.addDomain(DomainType.SCIENCE,1);
        c22.addDomain(DomainType.HEALTH,1);
        c23.addDomain(DomainType.SPORTS,3);
        c24.addDomain(DomainType.LITERATURE,1);
        c24.addDomain(DomainType.ARTS_AND_HUMANITIES,1);
        c24.addDomain(DomainType.BUSINESS,1);
        c25.addDomain(DomainType.ENGINEERING,1);
        c25.addDomain(DomainType.SCIENCE,1);
        c26.addDomain(DomainType.BUSINESS,1);
        c26.addDomain(DomainType.LITERATURE,1);
        c26.addDomain(DomainType.ARTS_AND_HUMANITIES,1);
        q2.addChoice(c20);
        q2.addChoice(c21);
        q2.addChoice(c22);
        q2.addChoice(c23);
        q2.addChoice(c24);
        q2.addChoice(c25);
        q2.addChoice(c26);
        Question q3 = new Question("Which of the following subject groups do you like the most ?", false);
        Choice c30 = new Choice("Technology, Physics");
        Choice c31 = new Choice("Maths, Physics, Experimental Science");
        Choice c32 = new Choice("Humanities and Languages");
        Choice c33 = new Choice("Maths, Physics, Computer Science");
        Choice c34 = new Choice("Economy, Math, Humanity");
        Choice c35 = new Choice("Sports, Biology");
        Choice c36 = new Choice("Philosophy, Arts");
        c30.addDomain(DomainType.ENGINEERING,2);
        c31.addDomain(DomainType.ENGINEERING,1);
        c31.addDomain(DomainType.HEALTH,1);
        c31.addDomain(DomainType.SCIENCE,1);
        c32.addDomain(DomainType.LITERATURE,1);
        c33.addDomain(DomainType.ENGINEERING,2);
        c33.addDomain(DomainType.SCIENCE,1);
        c34.addDomain(DomainType.BUSINESS,1);
        c35.addDomain(DomainType.SPORTS,3);
        c36.addDomain(DomainType.ARTS_AND_HUMANITIES,2);
        q3.addChoice(c30);
        q3.addChoice(c31);
        q3.addChoice(c32);
        q3.addChoice(c33);
        q3.addChoice(c34);
        q3.addChoice(c35);
        q3.addChoice(c36);
        Question q4 = new Question("Which of the following subject groups do you score the most  ?", false);
        Choice c40 = new Choice("Technology, Physics");
        Choice c41 = new Choice("Maths, Physics, Experimental Science");
        Choice c42 = new Choice("Humanities and Languages");
        Choice c43 = new Choice("Maths, Physics, Computer Science");
        Choice c44 = new Choice("Economy, Math, Humanity");
        Choice c45 = new Choice("Sports, Biology");
        Choice c46 = new Choice("Philosophy, Arts");
        c40.addDomain(DomainType.ENGINEERING,2);
        c40.addDomain(DomainType.SCIENCE,1);
        c41.addDomain(DomainType.ENGINEERING,1);
        c41.addDomain(DomainType.HEALTH,1);
        c41.addDomain(DomainType.SCIENCE,2);
        c42.addDomain(DomainType.LITERATURE,1);
        c43.addDomain(DomainType.ENGINEERING,2);
        c43.addDomain(DomainType.SCIENCE,1);
        c44.addDomain(DomainType.BUSINESS,1);
        c45.addDomain(DomainType.SPORTS,3);
        c46.addDomain(DomainType.ARTS_AND_HUMANITIES,2);
        q4.addChoice(c40);
        q4.addChoice(c41);
        q4.addChoice(c42);
        q4.addChoice(c43);
        q4.addChoice(c44);
        q4.addChoice(c45);
        q4.addChoice(c46);
        Question q5 = new Question("What's your most preferred subject ?", false);
        Choice c50 = new Choice("Maths");
        Choice c51 = new Choice("Arts");
        Choice c52 = new Choice("Biology");
        Choice c53 = new Choice("Economy");
        Choice c54 = new Choice("Computer Science");
        Choice c55 = new Choice("Technology");
        Choice c56 = new Choice("Sports");
        Choice c57 = new Choice("Humanities");
        Choice c58 = new Choice("Philosophy");
        Choice c59 = new Choice("Physics");
        Choice c500 = new Choice("Languages");
        c50.addDomain(DomainType.ENGINEERING,2);
        c50.addDomain(DomainType.BUSINESS,1);
        c50.addDomain(DomainType.SCIENCE,2);
        c51.addDomain(DomainType.ARTS_AND_HUMANITIES,2);
        c51.addDomain(DomainType.LITERATURE,1);
        c52.addDomain(DomainType.SCIENCE,2);
        c52.addDomain(DomainType.ENGINEERING,1);
        c52.addDomain(DomainType.HEALTH,2);
        c53.addDomain(DomainType.BUSINESS,2);
        c54.addDomain(DomainType.ENGINEERING,2);
        c54.addDomain(DomainType.BUSINESS,1);
        c54.addDomain(DomainType.SCIENCE,1);
        c55.addDomain(DomainType.ENGINEERING,2);
        c56.addDomain(DomainType.SPORTS,2);
        c57.addDomain(DomainType.ARTS_AND_HUMANITIES,2);
        c57.addDomain(DomainType.LITERATURE,2);
        c58.addDomain(DomainType.LITERATURE,2);
        c58.addDomain(DomainType.ARTS_AND_HUMANITIES,2);
        c59.addDomain(DomainType.ENGINEERING,2);
        c59.addDomain(DomainType.SCIENCE,3);
        c500.addDomain(DomainType.LITERATURE,2);
        q5.addChoice(c50);
        q5.addChoice(c51);
        q5.addChoice(c52);
        q5.addChoice(c53);
        q5.addChoice(c54);
        q5.addChoice(c55);
        q5.addChoice(c56);
        q5.addChoice(c57);
        q5.addChoice(c58);
        q5.addChoice(c59);
        q5.addChoice(c500);
        Question q6 = new Question("How do you describe your problem solving skills ?", false);
        Choice c60 = new Choice("Excellent");
        c60.addDomain(DomainType.ENGINEERING,2);
        c60.addDomain(DomainType.BUSINESS,2);
        Choice c61 = new Choice("Good");
        c61.addDomain(DomainType.ENGINEERING,1);
        c61.addDomain(DomainType.BUSINESS,1);
        Choice c62 = new Choice("Average");
        c62.addDomain(DomainType.BUSINESS,1);
        Choice c63 = new Choice("Bad");
        c62.addDomain(DomainType.BUSINESS,0);
        q6.addChoice(c60);
        q6.addChoice(c61);
        q6.addChoice(c62);
        q6.addChoice(c63);
        Question q7 = new Question("How do you describe your ability to work in groups", false);
        Choice c70 = new Choice("Excellent");
        c70.addDomain(DomainType.ENGINEERING,2);
        c70.addDomain(DomainType.SPORTS,2);
        Choice c71 = new Choice("Good");
        c71.addDomain(DomainType.ENGINEERING,1);
        c71.addDomain(DomainType.SPORTS,1);
        Choice c72 = new Choice("Average");
        c72.addDomain(DomainType.SPORTS,1);
        Choice c73 = new Choice("Bad");
        c62.addDomain(DomainType.BUSINESS,0);
        q7.addChoice(c70);
        q7.addChoice(c71);
        q7.addChoice(c72);
        q7.addChoice(c73);
        Question q8 = new Question("Which of the following fields of study don't you see yourself in ?", true);
        Choice c80 = new Choice("Arts and Humanity");
        Choice c81 = new Choice("Business");
        Choice c82 = new Choice("Sports");
        Choice c83 = new Choice("Literature");
        Choice c84 = new Choice("Engineering");
        Choice c85 = new Choice("Science");
        Choice c86 = new Choice("Health and Medicine");
        c80.addDomain(DomainType.ARTS_AND_HUMANITIES,-2);
        c81.addDomain(DomainType.BUSINESS,-2);
        c82.addDomain(DomainType.SPORTS,-2);
        c83.addDomain(DomainType.LITERATURE,-2);
        c84.addDomain(DomainType.ENGINEERING,-2);
        c85.addDomain(DomainType.SCIENCE,-2);
        c86.addDomain(DomainType.HEALTH,-2);
        q8.addChoice(c80);
        q8.addChoice(c81);
        q8.addChoice(c82);
        q8.addChoice(c83);
        q8.addChoice(c84);
        q8.addChoice(c85);
        q8.addChoice(c86);
        questionList.add(q);
        questionList.add(q1);
        questionList.add(q2);
        questionList.add(q3);
        questionList.add(q4);
        questionList.add(q5);
        questionList.add(q6);
        questionList.add(q7);
        questionList.add(q8);
        subQuestion sq0 = new subQuestion("On a scale from 1 to 5 how do you grade your logical reasoning skills",false);
        subChoice sc00 = new subChoice("4 or Above");
        sc00.addSubDomain(subDomainType.COMPUTER_SCIENCE,1);
        subChoice sc01 = new subChoice("2 to 4");
        sc01.addSubDomain(subDomainType.COMPUTER_SCIENCE,1);
        subChoice sc02 = new subChoice("Below 2");
        sq0.addChoice(sc00);
        sq0.addChoice(sc01);
        sq0.addChoice(sc02);
        subQuestion sq1 = new subQuestion("Do you have any knowlegde in programming",false);
        subChoice sc10 = new subChoice("Yes");
        sc10.addSubDomain(subDomainType.COMPUTER_SCIENCE,2);
        subChoice sc11 = new subChoice("No");
        sq1.addChoice(sc10);
        sq1.addChoice(sc11);
        subQuestion sq2 = new subQuestion("How much do you often score at maths",false);
        subChoice sc20 = new subChoice("18 or above");
        sc20.addSubDomain(subDomainType.COMPUTER_SCIENCE,1);
        subChoice sc21 = new subChoice("13 to 18");
        sc21.addSubDomain(subDomainType.COMPUTER_SCIENCE,1);
        subChoice sc22 = new subChoice("Below 13");
        sq2.addChoice(sc20);
        sq2.addChoice(sc21);
        sq2.addChoice(sc22);

        sql0.add(sq0);
        sql0.add(sq1);
        sql0.add(sq2);

        subQuestion sq3 = new subQuestion("Do you have any knowledge in programming ?",false);
        subChoice sc30 = new subChoice("Yes");
        sc30.addSubDomain(subDomainType.ELECTRICAL_ENGINEERING,1);
        subChoice sc31 = new subChoice("No");
        sq3.addChoice(sc30);
        sq3.addChoice(sc31);
        subQuestion sq4= new subQuestion("Did you ever maintain an electrical device ?",false);
        subChoice sc40 = new subChoice("Yes");
        sc40.addSubDomain(subDomainType.ELECTRICAL_ENGINEERING,1);
        subChoice sc41 = new subChoice("No");
        sq4.addChoice(sc40);
        sq4.addChoice(sc41);
        subQuestion sq5 = new subQuestion("How do you describe your knowledge in electronics",false);
        subChoice sc50 = new subChoice("Excellent");
        sc50.addSubDomain(subDomainType.ELECTRICAL_ENGINEERING,2);
        subChoice sc51 = new subChoice("Basics");
        sc50.addSubDomain(subDomainType.ELECTRICAL_ENGINEERING,1);
        subChoice sc52 = new subChoice("Null");
        sq5.addChoice(sc50);
        sq5.addChoice(sc51);
        sq5.addChoice(sc52);
        sql0.add(sq3);
        sql0.add(sq4);
        sql0.add(sq5);


        subQuestion sq6 = new subQuestion("Do you think you have a solid 3D perception ?",false);
        subChoice sc60 = new subChoice("Yes");
        sc30.addSubDomain(subDomainType.MECHANICAL_ENGINEERING,1);
        subChoice sc61 = new subChoice("No");
        sq6.addChoice(sc60);
        sq6.addChoice(sc61);
        subQuestion sq7= new subQuestion("Have you ever worked on a 3D modeling Software (SolidWorks/3DS Max)",false);
        subChoice sc70 = new subChoice("Yes");
        sc70.addSubDomain(subDomainType.MECHANICAL_ENGINEERING,2);
        subChoice sc71 = new subChoice("No");
        sq7.addChoice(sc70);
        sq7.addChoice(sc71);
        subQuestion sq8 = new subQuestion("Do you think of yourself as someone curious about how things work",false);
        subChoice sc80 = new subChoice("Yes");
        sc80.addSubDomain(subDomainType.MECHANICAL_ENGINEERING,1);
        subChoice sc81 = new subChoice("No");
        sq8.addChoice(sc80);
        sq8.addChoice(sc81);
        sql0.add(sq6);
        sql0.add(sq7);
        sql0.add(sq8);



        subQuestion sq9 = new subQuestion("What do you think about New York city skyscrapers and bridges",false);
        subChoice sc90 = new subChoice("A piece of art");
        sc90.addSubDomain(subDomainType.CIVIL_ENGINEERING,1);
        subChoice sc91 = new subChoice("Just like any other building");
        sq9.addChoice(sc90);
        sq9.addChoice(sc91);
        subQuestion sq10= new subQuestion("Have you ever dreamed of creating big buildings",false);
        subChoice sc100 = new subChoice("Yes");
        sc100.addSubDomain(subDomainType.CIVIL_ENGINEERING,2);
        subChoice sc101 = new subChoice("No");
        sq10.addChoice(sc100);
        sq10.addChoice(sc101);
        subQuestion sq11 = new subQuestion("Are you interested in conducting a research about soil quality",false);
        subChoice sc110 = new subChoice("Yes");
        sc110.addSubDomain(subDomainType.CIVIL_ENGINEERING,1);
        subChoice sc111 = new subChoice("No");
        sq11.addChoice(sc110);
        sq11.addChoice(sc111);
        sql0.add(sq9);
        sql0.add(sq10);
        sql0.add(sq11);



        subQuestion sq12 = new subQuestion("Does the Lab Work interest you",false);
        subChoice sc120 = new subChoice("Yes");
        sc120.addSubDomain(subDomainType.CHEMICAL_ENGINEERING,1);
        subChoice sc121 = new subChoice("No");
        sq12.addChoice(sc120);
        sq12.addChoice(sc121);
        subQuestion sq13= new subQuestion("Do you have a good memory",false);
        subChoice sc130 = new subChoice("Yes");
        sc130.addSubDomain(subDomainType.CHEMICAL_ENGINEERING,1);
        subChoice sc131 = new subChoice("No");
        sq13.addChoice(sc130);
        sq13.addChoice(sc131);
        subQuestion sq14 = new subQuestion("What do you think about chemistry",false);
        subChoice sc140 = new subChoice("I love that subject");
        sc140.addSubDomain(subDomainType.CHEMICAL_ENGINEERING,2);
        subChoice sc141 = new subChoice("Pretty Interesting");
        sc141.addSubDomain(subDomainType.CHEMICAL_ENGINEERING,1);
        subChoice sc142 = new subChoice("Boring");
        sq14.addChoice(sc140);
        sq14.addChoice(sc141);
        sq14.addChoice(sc142);
        sql0.add(sq12);
        sql0.add(sq13);
        sql0.add(sq14);
        for(int i = 0;i< sql0.size();i++){
            System.out.println(sql0.get(i).getQuestionName());
        }
        subquestions.put(DomainType.ENGINEERING,sql0);
        ArrayList<subQuestion> sql1 = new ArrayList<>();
        subQuestion sq15 = new subQuestion("Do you think you're interested in how the human body works",false);
        subChoice c150 = new subChoice("Yes");
        subChoice c151 = new subChoice("No");
        c150.addSubDomain(subDomainType.MEDICAL_STUDIES,1);
        sq15.addChoice(c150);
        sq15.addChoice(c151);

        subQuestion sq16 = new subQuestion("Are you interested in saving lives",false);
        subChoice c160 = new subChoice("Yes");
        subChoice c161 = new subChoice("No");
        c160.addSubDomain(subDomainType.MEDICAL_STUDIES,2);
        sq16.addChoice(c160);
        sq16.addChoice(c161);

        subQuestion sq17 = new subQuestion("Would you bear seeing blood or any types or injuries",false);
        subChoice c170 = new subChoice("Yes");
        subChoice c171 = new subChoice("No");
        c170.addSubDomain(subDomainType.MEDICAL_STUDIES,1);
        sq17.addChoice(c170);
        sq17.addChoice(c171);


        subQuestion sq18 = new subQuestion("Are you interested in pursuing a career in the medicines industry",false);
        subChoice c180 = new subChoice("Yes");
        subChoice c181 = new subChoice("No");
        c180.addSubDomain(subDomainType.PHARMACY,1);
        c181.addSubDomain(subDomainType.PHARMACY,-2);
        sq18.addChoice(c180);
        sq18.addChoice(c181);

        subQuestion sq19 = new subQuestion("Which of the following best describes the micro-world to you (Bacteria,Microbes...)",false);
        subChoice c190 = new subChoice("Amazing");
        subChoice c191 = new subChoice("Interesting");
        subChoice c192 = new subChoice("Not Interesting at all");
        c190.addSubDomain(subDomainType.PHARMACY,2);
        c191.addSubDomain(subDomainType.PHARMACY,1);
        sq19.addChoice(c190);
        sq19.addChoice(c191);
        sq19.addChoice(c192);

        subQuestion sq20 = new subQuestion("What do you think about Chemistry",false);
        subChoice c200 = new subChoice("I love that subject");
        subChoice c201 = new subChoice("Interesting");
        subChoice c202 = new subChoice("Boring");
        c200.addSubDomain(subDomainType.PHARMACY,2);
        c201.addSubDomain(subDomainType.PHARMACY,1);
        sq20.addChoice(c200);
        sq20.addChoice(c201);
        sq20.addChoice(c202);
        sql1.add(sq15);
        sql1.add(sq16);
        sql1.add(sq17);
        sql1.add(sq18);
        sql1.add(sq19);
        sql1.add(sq20);
        subquestions.put(DomainType.HEALTH,sql1);



        subQuestion sq21 = new subQuestion("Do you think of yourself as someone curious about how things work ?",false);
        subChoice c210 = new subChoice("Yes");
        subChoice c211 = new subChoice("No");
        c210.addSubDomain(subDomainType.PHYSICS,1);
        sq21.addChoice(c210);
        sq21.addChoice(c211);

        subQuestion sq22 = new subQuestion("Does the idea of time travelling interests you ?",false);
        subChoice c220 = new subChoice("Yes");
        subChoice c221 = new subChoice("No");
        c220.addSubDomain(subDomainType.PHYSICS,1);
        sq22.addChoice(c220);
        sq22.addChoice(c221);

        subQuestion sq23 = new subQuestion("Which of the following best describes your knowledge about Quantum Physics ?",false);
        subChoice c230 = new subChoice("I'm very interested in it");
        subChoice c231 = new subChoice("I know a couple things about it");
        subChoice c232 = new subChoice("I don't have any idea about it");
        c230.addSubDomain(subDomainType.PHYSICS,2);
        c231.addSubDomain(subDomainType.PHYSICS,1);
        sq23.addChoice(c230);
        sq23.addChoice(c231);
        sq23.addChoice(c232);



        subQuestion sq24 = new subQuestion("On a scale from 1 to 5 how do you grade your logical reasoning skills",false);
        subChoice sc240 = new subChoice("4 or Above");
        sc00.addSubDomain(subDomainType.MATHS,2);
        subChoice sc241 = new subChoice("2 to 4");
        sc01.addSubDomain(subDomainType.MATHS,1);
        subChoice sc242 = new subChoice("Below 2");
        sq24.addChoice(sc240);
        sq24.addChoice(sc241);
        sq24.addChoice(sc242);

        subQuestion sq25 = new subQuestion("How much do you often score at maths",false);
        subChoice sc250 = new subChoice("18 or above");
        sc250.addSubDomain(subDomainType.MATHS,1);
        subChoice sc251 = new subChoice("13 to 18");
        sc251.addSubDomain(subDomainType.MATHS,1);
        subChoice sc252 = new subChoice("Below 13");
        sq25.addChoice(sc250);
        sq25.addChoice(sc251);
        sq25.addChoice(sc252);

        subQuestion sq26 = new subQuestion("Do you see yourself able to explaning any algebra of geometry topic to your classmates",false);
        subChoice c260 = new subChoice("Yes");
        subChoice c261 = new subChoice("No");
        c261.addSubDomain(subDomainType.MATHS,1);
        sq26.addChoice(c260);
        sq26.addChoice(c261);

        subQuestion sq27 = new subQuestion("What's the last planet in the solar system ?",false);
        subChoice c270 = new subChoice("Neptune");
        subChoice c271 = new subChoice("Pluto");
        subChoice c272 = new subChoice("Saturn");
        c270.addSubDomain(subDomainType.ASTRONOMY,2);
        sq27.addChoice(c270);
        sq27.addChoice(c271);
        sq27.addChoice(c272);

        subQuestion sq28 = new subQuestion("Did you ever dream of becoming an astronaut ?",false);
        subChoice c280 = new subChoice("Yes");
        subChoice c281 = new subChoice("No");
        c280.addSubDomain(subDomainType.ASTRONOMY,2);
        sq28.addChoice(c280);
        sq28.addChoice(c281);

        subQuestion sq29 = new subQuestion("Do you have any knowledge about black holes ?",false);
        subChoice c290 = new subChoice("Yes");
        subChoice c291 = new subChoice("No");
        c290.addSubDomain(subDomainType.ASTRONOMY,1);
        sq29.addChoice(c290);
        sq29.addChoice(c291);

        ArrayList<subQuestion> sql2 = new ArrayList<>();
        sql2.add(sq21);
        sql2.add(sq22);
        sql2.add(sq23);
        sql2.add(sq24);
        sql2.add(sq25);
        sql2.add(sq26);
        sql2.add(sq27);
        sql2.add(sq28);
        sql2.add(sq29);
        subquestions.put(DomainType.SCIENCE,sql2);




        subQuestion sq30 = new subQuestion("Do you think you have some trouble conveying your ideas in a foreign Language ?",false);
        subChoice c300 = new subChoice("Yes");
        subChoice c301 = new subChoice("No");
        c301.addSubDomain(subDomainType.LANGUAGES,1);
        sq30.addChoice(c300);
        sq30.addChoice(c301);

        subQuestion sq31 = new subQuestion("How do you describe your english speaking and writing skills ?",false);
        subChoice c310 = new subChoice("Excellent");
        subChoice c311 = new subChoice("Average");
        subChoice c312 = new subChoice("Bad");
        c311.addSubDomain(subDomainType.LANGUAGES,1);
        c310.addSubDomain(subDomainType.LANGUAGES,2);
        sq31.addChoice(c310);
        sq31.addChoice(c311);
        sq31.addChoice(c312);

        subQuestion sq32 = new subQuestion("Did you ever consider pursuing a career in teaching languages",false);
        subChoice c320 = new subChoice("Yes");
        subChoice c321 = new subChoice("No");
        c320.addSubDomain(subDomainType.LANGUAGES,1);
        c321.addSubDomain(subDomainType.LANGUAGES,-2);
        sq32.addChoice(c320);
        sq32.addChoice(c321);


        subQuestion sq33 = new subQuestion("Do you happen to generate your own visions concerning a certain situation or problem",false);
        subChoice c330 = new subChoice("Yes");
        subChoice c331 = new subChoice("No");
        c330.addSubDomain(subDomainType.PHILOSOPHY,1);
        sq33.addChoice(c330);
        sq33.addChoice(c331);

        subQuestion sq34 = new subQuestion("Do you often read philosophy ?",false);
        subChoice c340 = new subChoice("Yes");
        subChoice c341 = new subChoice("No");
        c340.addSubDomain(subDomainType.PHILOSOPHY,2);
        sq34.addChoice(c340);
        sq34.addChoice(c341);

        subQuestion sq35 = new subQuestion("Do you happen to wonder wonder about life and existence ?",false);
        subChoice c350 = new subChoice("Yes");
        subChoice c351 = new subChoice("No");
        c350.addSubDomain(subDomainType.PHILOSOPHY,1);
        sq35.addChoice(c350);
        sq35.addChoice(c351);

        subQuestion sq36 = new subQuestion("Do you think that you have your own sense of justice ?",false);
        subChoice c360 = new subChoice("Yes");
        subChoice c361 = new subChoice("No");
        c360.addSubDomain(subDomainType.LAW,1);
        sq36.addChoice(c360);
        sq36.addChoice(c361);

        subQuestion sq37 = new subQuestion("How do you feel about defending innocents",false);
        subChoice c370 = new subChoice("Very noble");
        subChoice c371 = new subChoice("Doesn't concern me");
        c370.addSubDomain(subDomainType.LAW,1);
        sq37.addChoice(c370);
        sq37.addChoice(c371);

        subQuestion sq38 = new subQuestion("What do you think about your debate skills",false);
        subChoice c380 = new subChoice("Excellent");
        subChoice c381 = new subChoice("Average");
        subChoice c382 = new subChoice("Bad");
        c380.addSubDomain(subDomainType.LAW,2);
        c381.addSubDomain(subDomainType.LAW,1);
        sq38.addChoice(c380);
        sq38.addChoice(c381);
        sq38.addChoice(c382);

        subQuestion sq39 = new subQuestion("Do you define yourself as someone stereotyped ?",false);
        subChoice c390 = new subChoice("Yes");
        subChoice c391 = new subChoice("No");
        c391.addSubDomain(subDomainType.LAW,1);
        sq39.addChoice(c390);
        sq39.addChoice(c391);
        ArrayList<subQuestion> sql3 = new ArrayList<>();
        sql3.add(sq30);
        sql3.add(sq31);
        sql3.add(sq32);
        sql3.add(sq33);
        sql3.add(sq34);
        sql3.add(sq35);
        sql3.add(sq36);
        sql3.add(sq37);
        sql3.add(sq38);
        sql3.add(sq39);
        subquestions.put(DomainType.LITERATURE,sql3);

        subQuestion sq40 = new subQuestion("Do you play an instrument",false);
        subChoice c400 = new subChoice("Yes");
        subChoice c401 = new subChoice("No");
        c400.addSubDomain(subDomainType.ARTS,1);
        sq40.addChoice(c400);
        sq40.addChoice(c401);

        subQuestion sq41 = new subQuestion("Do you care about appearances",false);
        subChoice c410 = new subChoice("Yes");
        subChoice c411 = new subChoice("No");
        c410.addSubDomain(subDomainType.ARTS,1);
        sq41.addChoice(c410);
        sq41.addChoice(c411);

        subQuestion sq42 = new subQuestion("Do you see yourself as a creative person",false);
        subChoice c420 = new subChoice("Yes");
        subChoice c421 = new subChoice("No");
        c420.addSubDomain(subDomainType.ARTS,2);
        sq42.addChoice(c420);
        sq42.addChoice(c421);

        subQuestion sq43 = new subQuestion("Do you see yourself as a creative person",false);
        subChoice c430 = new subChoice("Yes");
        subChoice c431 = new subChoice("No");
        c430.addSubDomain(subDomainType.ARTS,2);
        sq43.addChoice(c430);
        sq43.addChoice(c431);

        subQuestion sq44 = new subQuestion("What do you think about your debate skills",false);
        subChoice c440 = new subChoice("Excellent");
        subChoice c441 = new subChoice("Average");
        subChoice c442 = new subChoice("Bad");
        c440.addSubDomain(subDomainType.POIITICS,2);
        c441.addSubDomain(subDomainType.POIITICS,1);
        sq44.addChoice(c440);
        sq44.addChoice(c441);
        sq44.addChoice(c442);

        subQuestion sq45 = new subQuestion("Do you often take the lead when it comes to working within groups ?",false);
        subChoice c450 = new subChoice("Yes");
        subChoice c451 = new subChoice("No");
        c450.addSubDomain(subDomainType.POIITICS,1);
        sq45.addChoice(c450);
        sq45.addChoice(c451);

        subQuestion sq46 = new subQuestion("Do you find yourself able to reconcile conflicting parties?",false);
        subChoice c460 = new subChoice("Yes");
        subChoice c461 = new subChoice("No");
        c460.addSubDomain(subDomainType.POIITICS,2);
        c461.addSubDomain(subDomainType.POIITICS,-1);
        sq46.addChoice(c460);
        sq46.addChoice(c461);

        subQuestion sq47 = new subQuestion("Are you a fan of ancient civilizations ?",false);
        subChoice c470 = new subChoice("Yes");
        subChoice c471 = new subChoice("No");
        c470.addSubDomain(subDomainType.HISTORY,2);
        sq47.addChoice(c470);
        sq47.addChoice(c471);

        subQuestion sq48 = new subQuestion("Do you often watch archeology related documentaries ?",false);
        subChoice c480 = new subChoice("Yes");
        subChoice c481 = new subChoice("No");
        c480.addSubDomain(subDomainType.HISTORY,1);
        sq48.addChoice(c480);
        sq48.addChoice(c481);

        subQuestion sq49 = new subQuestion("Are you interested in pursuing a career in archeology or History ?",false);
        subChoice c490 = new subChoice("Yes");
        subChoice c491 = new subChoice("No");
        c490.addSubDomain(subDomainType.HISTORY,2);
        sq49.addChoice(c490);
        sq49.addChoice(c491);

        ArrayList<subQuestion> sql4 = new ArrayList<>();
        sql4.add(sq40);
        sql4.add(sq41);
        sql4.add(sq42);
        sql4.add(sq43);
        sql4.add(sq44);
        sql4.add(sq45);
        sql4.add(sq46);
        sql4.add(sq47);
        sql4.add(sq48);
        sql4.add(sq49);
        subquestions.put(DomainType.ARTS_AND_HUMANITIES,sql4);



        subQuestion sq50 = new subQuestion("Do you like working with numbers",false);
        subChoice c501 = new subChoice("Yes");
        subChoice c502 = new subChoice("No");
        c501.addSubDomain(subDomainType.ACCOUNTING,1);
        sq50.addChoice(c501);
        sq50.addChoice(c502);

        subQuestion sq51 = new subQuestion("Are you able to make accurate calculations",false);
        subChoice c511 = new subChoice("Yes");
        subChoice c512 = new subChoice("No");
        c511.addSubDomain(subDomainType.ACCOUNTING,1);
        sq51.addChoice(c511);
        sq51.addChoice(c512);

        subQuestion sq52 = new subQuestion("Do you see yourself as an accountant in the future",false);
        subChoice c521 = new subChoice("Yes");
        subChoice c522 = new subChoice("No");
        c521.addSubDomain(subDomainType.ACCOUNTING,2);
        c522.addSubDomain(subDomainType.ACCOUNTING,-2);
        sq52.addChoice(c521);
        sq52.addChoice(c522);

        subQuestion sq53 = new subQuestion("Do you think of yourself as someone who can lead a team ?",false);
        subChoice c531 = new subChoice("Yes");
        subChoice c532 = new subChoice("No");
        c531.addSubDomain(subDomainType.ENTREPRENEURSHIP,1);
        sq53.addChoice(c531);
        sq53.addChoice(c532);

        subQuestion sq54 = new subQuestion("Do you see yourself as someone who can come up with innovative ideas ?",false);
        subChoice c541 = new subChoice("Yes");
        subChoice c542 = new subChoice("No");
        c541.addSubDomain(subDomainType.ENTREPRENEURSHIP,2);
        c542.addSubDomain(subDomainType.ENTREPRENEURSHIP,-1);
        sq54.addChoice(c541);
        sq54.addChoice(c542);

        subQuestion sq55 = new subQuestion("Did you ever think about establishing your own company/startup ?",false);
        subChoice c551 = new subChoice("Yes");
        subChoice c552 = new subChoice("No");
        c551.addSubDomain(subDomainType.ENTREPRENEURSHIP,2);
        c552.addSubDomain(subDomainType.ENTREPRENEURSHIP,-2);
        sq55.addChoice(c551);
        sq55.addChoice(c552);

        subQuestion sq56 = new subQuestion("Did you ever sell or participate in selling the product ?",false);
        subChoice c561 = new subChoice("Yes");
        subChoice c562 = new subChoice("No");
        c561.addSubDomain(subDomainType.MARKETING,1);
        sq56.addChoice(c561);
        sq56.addChoice(c562);

        subQuestion sq57 = new subQuestion("Do see yourself as someone persuasive ?",false);
        subChoice c571 = new subChoice("Yes");
        subChoice c572 = new subChoice("No");
        c571.addSubDomain(subDomainType.MARKETING,2);
        c572.addSubDomain(subDomainType.MARKETING,-1);
        sq57.addChoice(c571);
        sq57.addChoice(c572);

        subQuestion sq58 = new subQuestion("Are you interested in developing new techniques to attract customers to buying a products ?",false);
        subChoice c581 = new subChoice("Yes");
        subChoice c582 = new subChoice("No");
        c581.addSubDomain(subDomainType.MARKETING,2);
        c582.addSubDomain(subDomainType.MARKETING,-1);
        sq58.addChoice(c581);
        sq58.addChoice(c582);

        subQuestion sq59 = new subQuestion("Which business field do you see yourself into the most ?",false);
        subChoice c591 = new subChoice("Marketing");
        subChoice c592 = new subChoice("Accounting");
        subChoice c593 = new subChoice("Entrepreneurship");
        c591.addSubDomain(subDomainType.MARKETING,1);
        c593.addSubDomain(subDomainType.ENTREPRENEURSHIP,1);
        c592.addSubDomain(subDomainType.ACCOUNTING,1);
        sq59.addChoice(c591);
        sq59.addChoice(c592);
        sq59.addChoice(c593);
        ArrayList<subQuestion> sql5 = new ArrayList<>();
        sql5.add(sq50);
        sql5.add(sq51);
        sql5.add(sq52);
        sql5.add(sq53);
        sql5.add(sq54);
        sql5.add(sq55);
        sql5.add(sq56);
        sql5.add(sq57);
        sql5.add(sq58);
        sql5.add(sq59);
        subquestions.put(DomainType.BUSINESS,sql5);
        currentQuestion.setText(questionList.get(current).getQuestionName());
        int i = 0;
        for(;i<questionList.get(current).getChoices().size();i++){
            checkBoxes.get(i).setText(questionList.get(current).getChoices().get(i).getText());
            checkBoxes.get(i).setChecked(false);
            checkBoxes.get(i).setVisibility(View.VISIBLE);

        }
        for(;i<checkBoxes.size();i++){
            checkBoxes.get(i).setChecked(false);
            checkBoxes.get(i).setVisibility(View.INVISIBLE);
        }
        }

        public void onButtonClick (View view){

            int i = 0;
            if(part){
                System.out.println(mainDomains[currentDomain].getType().toString());
                if(subquestions.get(mainDomains[currentDomain].getType())==null)return;
                for (; i < subquestions.get(mainDomains[currentDomain].getType()).get(current).getChoices().size(); i++) {
                    if (checkBoxes.get(i).isChecked()) {
                        ArrayList<subDomain> domains = subquestions.get(mainDomains[currentDomain].getType()).get(current).getChoices().get(i).getSubDomains();
                        for (int j = 0; j < domains.size(); j++) {
                            subDomainType dt = domains.get(j).getType();
                            int x = domains.get(j).getPoints();
                            subscores.put(dt, subscores.get(dt) + x);
                            System.out.println(dt.toString() + " : " + subscores.get(dt));
                        }
                    }
                }
            }
            else {
                for (; i < questionList.get(current).getChoices().size(); i++) {
                    if (checkBoxes.get(i).isChecked()) {
                        ArrayList<Domain> domains = questionList.get(current).getChoices().get(i).getDomains();
                        for (int j = 0; j < domains.size(); j++) {
                            DomainType dt = domains.get(j).getType();
                            int x = domains.get(j).getPoints();
                            scores.put(dt, scores.get(dt) + x);
                            System.out.println(dt.toString() + " : " + scores.get(dt));
                        }
                    }
                }
            }
            current++;
            if(part&&current==subquestions.get(mainDomains[currentDomain].getType()).size()){
                if(currentDomain<2) {
                    currentDomain++;
                    current=0;
                    if(mainDomains[currentDomain].getType()==DomainType.SPORTS){
                        Button b = (Button)findViewById(R.id.button4);
                        b.setVisibility(View.INVISIBLE);
                        subDomain d[] = new subDomain[subDomainType.values().length];
                        for(int j = 0;j<subDomainType.values().length;j++){
                            d[j] = new subDomain(subscores.get(subDomainType.values()[j]),subDomainType.values()[j]);
                        }
                        for(int j = 0 ;j<d.length;j++){
                            for(int k = j;k<d.length;k++){
                                if (d[j].getPoints() < d[k].getPoints()) {
                                    subDomain temp = d[j];
                                    d[j] = d[k];
                                    d[k] = temp;
                                }
                            }

                        }
                        results.i1 = d[0].getPoints();
                        results.s1 = d[0].getType().toString();
                        results.i2 = d[1].getPoints();
                        results.s2 = d[1].getType().toString();
                        results.i3 = d[2].getPoints();
                        results.s3 = d[2].getType().toString();
                        results.i4 = d[3].getPoints();
                        results.s4 = d[3].getType().toString();
                        results.i5 = mainDomains[2].getPoints();
                        results.s5= subDomainType.SPORTS.toString();
                        subdomains[0] = d[0];
                        subdomains[1] = d[1];
                        subdomains[2] = d[2];
                        subdomains[3] = d[3];
                        subdomains[4] = new subDomain(0,subDomainType.SPORTS);
                        System.out.println(subdomains[0].getType().toString());
                        System.out.println(subdomains[1].getType().toString());
                        System.out.println(subdomains[2].getType().toString());
                        System.out.println(subdomains[3].getType().toString());
                        System.out.println(subdomains[4].getType().toString());
                        Intent intent = new Intent(this,results.class);
                        startActivity(intent);
                    }
                    return;
                }
                else {
                    Button b = (Button)findViewById(R.id.button4);
                    b.setVisibility(View.INVISIBLE);
                    subDomain d[] = new subDomain[subDomainType.values().length];
                    for(int j = 0;j<subDomainType.values().length;j++){
                        d[j] = new subDomain(subscores.get(subDomainType.values()[j]),subDomainType.values()[j]);
                    }
                    for(int j = 0 ;j<d.length;j++){
                        for(int k = j;k<d.length;k++){
                            if (d[j].getPoints() < d[k].getPoints()) {
                                subDomain temp = d[j];
                                d[j] = d[k];
                                d[k] = temp;
                            }
                        }

                    }
                    subdomains[0] = d[0];
                    subdomains[1] = d[1];
                    subdomains[2] = d[2];
                    subdomains[3] = d[3];
                    subdomains[4] = d[4];
                    results.i1 = d[0].getPoints();
                    results.s1 = d[0].getType().toString();
                    results.i2 = d[1].getPoints();
                    results.s2 = d[1].getType().toString();
                    results.i3 = d[2].getPoints();
                    results.s3 = d[2].getType().toString();
                    results.i4 = d[3].getPoints();
                    results.s4 = d[3].getType().toString();
                    results.i5 = d[4].getPoints();
                    results.s5 = d[4].getType().toString();
                    System.out.println(d[0].getType().toString());
                    System.out.println(d[1].getType().toString());
                    System.out.println(d[2].getType().toString());
                    System.out.println(d[3].getType().toString());
                    System.out.println(d[4].getType().toString());
                    Intent intent = new Intent(this,results.class);
                    startActivity(intent);

                }
            }
            if(part){
                if (current < subquestions.get(mainDomains[currentDomain].getType()).size()) {
                    currentQuestion.setText(subquestions.get(mainDomains[currentDomain].getType()).get(current).getQuestionName());
                    i = 0;
                    for (; i < subquestions.get(mainDomains[currentDomain].getType()).get(current).getChoices().size(); i++) {

                        checkBoxes.get(i).setText(subquestions.get(mainDomains[currentDomain].getType()).get(current).getChoices().get(i).getText());
                        checkBoxes.get(i).setChecked(false);
                        checkBoxes.get(i).setVisibility(View.VISIBLE);

                    }
                    for (; i < checkBoxes.size(); i++) {
                        checkBoxes.get(i).setChecked(false);
                        checkBoxes.get(i).setVisibility(View.INVISIBLE);
                    }
                }
                
            }
            else {
                if (current < questionList.size()) {
                    currentQuestion.setText(questionList.get(current).getQuestionName());
                    i = 0;
                    for (; i < questionList.get(current).getChoices().size(); i++) {

                        checkBoxes.get(i).setText(questionList.get(current).getChoices().get(i).getText());
                        checkBoxes.get(i).setChecked(false);
                        checkBoxes.get(i).setVisibility(View.VISIBLE);

                    }
                    for (; i < checkBoxes.size(); i++) {
                        checkBoxes.get(i).setChecked(false);
                        checkBoxes.get(i).setVisibility(View.INVISIBLE);
                    }
                }
                if (current == questionList.size()) {
                    Domain domains[] = new Domain[DomainType.values().length];
                    for (int j = 0; j < DomainType.values().length; j++) {
                        System.out.println(DomainType.values()[j].toString() + " : " + scores.get(DomainType.values()[j]));
                        domains[j] = new Domain(scores.get(DomainType.values()[j]), DomainType.values()[j]);
                    }
                    for (int j = 0; j < domains.length; j++) {
                        for (int k = j; k < domains.length; k++) {
                            if (domains[j].getPoints() < domains[k].getPoints()) {
                                Domain temp = domains[j];
                                domains[j] = domains[k];
                                domains[k] = temp;
                            }
                        }
                    }
                    System.out.println(domains[0].getType().toString());
                    System.out.println(domains[1].getType().toString());
                    System.out.println(domains[2].getType().toString());
                    mainDomains[0] = domains[0];
                    mainDomains[1] = domains[1];
                    mainDomains[2] = domains[2];

                    current =0;
                    part = true;
                    currentQuestion.setText(subquestions.get(mainDomains[0].getType()).get(current).getQuestionName());
                    i = 0;
                    for (; i < subquestions.get(mainDomains[0].getType()).get(current).getChoices().size(); i++) {

                        checkBoxes.get(i).setText(subquestions.get(mainDomains[0].getType()).get(current).getChoices().get(i).getText());
                        checkBoxes.get(i).setChecked(false);
                        checkBoxes.get(i).setVisibility(View.VISIBLE);

                    }
                    for (; i < checkBoxes.size(); i++) {
                        checkBoxes.get(i).setChecked(false);
                        checkBoxes.get(i).setVisibility(View.INVISIBLE);
                    }
                }
            }
    }

    public void onCheckClick(View view) {
        if(part)
        {

                for(int i = 0;i<checkBoxes.size();i++){
                    checkBoxes.get(i).setChecked(false);
                }
                ((CheckBox)view).setChecked(true);

        }
        else
        if(!questionList.get(current).isMultiChoice()){
        for(int i = 0;i<checkBoxes.size();i++){
            checkBoxes.get(i).setChecked(false);
        }
        ((CheckBox)view).setChecked(true);
    }}
}
