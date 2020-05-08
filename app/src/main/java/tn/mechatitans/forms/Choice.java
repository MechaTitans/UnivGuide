package tn.mechatitans.forms;

import java.util.ArrayList;

public class Choice {
    private String text;
    private ArrayList<Domain> domains = new ArrayList<>();

    public Choice(String text) {
        this.text = text;
    }
    public void addDomain(DomainType dt,int x){
        domains.add(new Domain(x,dt));
    }
    public ArrayList<Domain> getDomains(){
        return domains;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
