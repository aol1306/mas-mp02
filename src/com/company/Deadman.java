package com.company;

// Deadman-Grave z atrybutem (klasa asocjacji Funeral)
public class Deadman {
    private String name;
    private String surname;
    private Funeral funeral;

    public Deadman(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void setFuneral(Funeral funeral) {
        if(this.funeral == funeral) return;
        if(this.funeral != null) {
            this.funeral.removeDeadman(this);
        }
        this.funeral = funeral;
        if(funeral != null) {
            funeral.addDeadman(this);
        }
    }

    @Override
    public String toString() {
        return "Deadman: " + name + " " + surname;
    }
}