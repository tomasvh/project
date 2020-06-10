package com.npcmaker;

import javafx.beans.property.*;

public class JavaFXTableData {
    private StringProperty name = new SimpleStringProperty();
    private ObjectProperty<Integer> t = new SimpleObjectProperty<>(0);
    private ObjectProperty<Integer> tmod = new SimpleObjectProperty<>(0);
    private final ObjectProperty<Integer> id = new SimpleObjectProperty<>(null);

    public JavaFXTableData(){

    }

    public JavaFXTableData(String name, Integer t, Integer tmod, Integer id) {
        this.name.set(name);
        this.t.set(t);
        this.tmod.set(tmod);
        this.id.set(id);

    }


    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public Integer getT() {
        return t.getValue();
    }

    public ObjectProperty<Integer> tProperty() {
        return t;
    }

    public void setT(Integer t) {
        this.t.set(t);
    }

    public Integer getTmod() {
        return tmod.getValue();
    }

    public ObjectProperty<Integer> tmodProperty() {
        return tmod;
    }

    public void setTmod(Integer tmod) {
        this.tmod.set(tmod);
    }

    public Integer getId() {
        return id.getValue();
    }

    public ObjectProperty<Integer> idProperty() {
        return id;
    }

    public void setId(Integer id) {
        this.id.set(id);
    }
}
