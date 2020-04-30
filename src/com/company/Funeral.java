package com.company;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// atrybut do asocjacji Deadman-Grave
public class Funeral {
    Date funeralDate;
    private List<Deadman> deadmans = new ArrayList<>();
    private List<Grave> graves = new ArrayList<>(); // TODO: na odwrót. kolekcje po klasach zewnętrznych

    // TODO: połączenia powinny być tworzone w tym konstruktorze
    public Funeral(Date funeralDate) {
        this.funeralDate = funeralDate;
    }

    public void addGrave(Grave grave) {
        if(!graves.contains(grave)) {
            graves.add(grave);
            grave.setFuneral(this);
        }
    }

    public void removeGrave(Grave grave) {
        if(graves.contains(grave)) {
            graves.remove(grave);
            grave.setCemetery(null);
        }
    }

    public void addDeadman(Deadman deadman) {
        if(!deadmans.contains(deadman)) {
            deadmans.add(deadman);
            deadman.setFuneral(this);
        }
    }

    public void removeDeadman(Deadman deadman) {
        if(deadmans.contains(deadman)) {
            deadmans.remove(deadman);
            deadman.setFuneral(null);
        }
    }
}