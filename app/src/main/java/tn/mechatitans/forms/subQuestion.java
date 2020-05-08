package tn.mechatitans.forms;

import java.util.ArrayList;

public class subQuestion {
    private String name;
    private ArrayList<subChoice> choices = new ArrayList<>();
    private boolean multiChoice;
    public String getQuestionName(){
        return name;
    }
    public subQuestion(String name,boolean multiChoice){
        this.name = name;
        this.multiChoice = multiChoice;
    }
    public void addChoice(subChoice c){
        choices.add(c);
    }
    public ArrayList<subChoice> getChoices(){
        return choices;
    }
    public boolean isMultiChoice(){
        return multiChoice;
    }

}
