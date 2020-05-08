package tn.mechatitans.forms;

import java.util.ArrayList;
import java.util.HashMap;

public class Question {
    private String name;
    private ArrayList<Choice> choices = new ArrayList<>();
    private boolean multiChoice;
    public String getQuestionName(){
        return name;
    }
    public Question(String name,boolean multiChoice){
        this.name = name;
        this.multiChoice = multiChoice;
    }
    public void addChoice(Choice c){
        choices.add(c);
    }
    public ArrayList<Choice> getChoices(){
        return choices;
    }
    public boolean isMultiChoice(){
        return multiChoice;
    }
    public boolean equals(Question q){
        return name.equals(q.getQuestionName());
    }

}
