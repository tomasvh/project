package com.npcmaker;

public class Startkapital {
    int T = 0;
    int TMod = 0;

    public Startkapital(int t, int TMod) {
        T = t;
        this.TMod = TMod;
    }

    public int getT() {
        return T;
    }

    public void setT(int t) {
        T += t;
    }

    public int getTMod() {
        return TMod;
    }

    public void setTMod(int TMod) {
        this.TMod += TMod;
    }
}
