package com.npcmaker;

public class GrundAttribut {
    private String namn;
    private int t = 0;
    private int tMod =0;

    public GrundAttribut(String namn) {
        this.namn = namn;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
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

    public void changeT (int t){
        this.t = t;
    }

    public void changeTMod (int tMod) {
        this.tMod = tMod;
    }
}
