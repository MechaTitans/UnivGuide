package tn.mechatitans.forms;

import java.util.ArrayList;

public class subChoice {
    private String text;
    private ArrayList<subDomain> domains = new ArrayList<>();

    public subChoice(String text) {
        this.text = text;
    }
    public void addSubDomain(subDomainType dt,int x){
        domains.add(new subDomain(x,dt));
    }
    public ArrayList<subDomain> getSubDomains(){
        return domains;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
