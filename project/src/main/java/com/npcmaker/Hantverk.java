package com.npcmaker;

public class Hantverk {
    private String name;
    private int t = 0;
    private int tMod = 0;

    public Hantverk(String name, int t, int TMod) {
        this.name = name;
        this.t = t;
        this.tMod = TMod;
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

    public void setTMod(int TMod) {
        this.tMod += TMod;
    }

    public String valueToString (){
        StringBuilder temp = new StringBuilder();
        temp.append(this.getT()).append("T6");
        if (this.getTMod() != 0){
            temp.append("+").append(this.getTMod());
        }
        return temp.toString();
    }


}
