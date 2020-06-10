package com.npcmaker;

public class HarleddaAttribut {
    private String name;
    private int t = 0;
    private int tMod = 0;

    public HarleddaAttribut(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t += t;
    }

    public int getTMod() {
        return tMod;
    }

    public void settMod(int tMod) {
        this.tMod += tMod;
    }

    public void reCountValue(){
        if(this.getTMod() > 3){
            this.settMod(-4);
            this.setT(1);
        } else if (this.getTMod() < 0){
            this.settMod(4);
            this.setT(-1);
        }
    }
    public String valueToString (){
        StringBuilder temp = new StringBuilder();
        temp.append(this.getT()).append("T6");
        if (this.getTMod() != 0){
            temp.append("+").append(this.getTMod());
        }
        return temp.toString();
    }

    public String tModToString () {
        return this.getTMod() + "";
    }

    public void changeT (int t){
        this.t = t;
    }

    public void changeTMod (int tMod) {
        this.tMod = tMod;
    }
}
