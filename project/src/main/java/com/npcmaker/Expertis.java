package com.npcmaker;

public class Expertis {
    private String name;
    private int t = 0;
    private int tMod = 0;

    public Expertis(String name, int t, int tMod) {
        this.name = name;
        this.t = t;
        this.tMod = tMod;
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

    public String valueToString (){
        String str = this.getT() + "T6+" + this.getTMod();
        return str;
    }


}
