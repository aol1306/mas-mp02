package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Cemetery c = new Cemetery("Cmentarz główny");
        var g1 = new Grave();
        var g2 = new Grave();
        g1.setCemetery(c);
        g2.setCemetery(c);
        System.out.println(c);
        Cemetery d = new Cemetery("Cmentarz centralny");
        var g3 = new Grave();
        g3.setCemetery(d);
        g3.setCemetery(c);
        System.out.println(c);

        var deadman1 = new Deadman("Jan", "Kowalski");
        var funeral1 = new Funeral(new Date());
        funeral1.addDeadman(deadman1);
        funeral1.addGrave(g3);

        System.out.println(funeral1);

        Region region = new Region();
        region.addCemetery(c);

        System.out.println(region.getCemetery("Cmentarz główny"));

        Grave decorated = new Grave();
        decorated.setCemetery(d);

        var decorationFlowers = GraveDecoration.createDecoration(decorated, "flowers");
        decorated.addDecoration(decorationFlowers);
        g3.addDecoration(decorationFlowers);
    }
}

/* asocjacje

- "zwykła"
nie może być zapętlenia, automatyczne dodawanie
- z atrybutem
zapamiętowanie dodatkowych informacji przy tworzeniu asocjacji
realizujemy przez klasę asocjacji
- kwalifikowana
kwalifikator - atrybut jednoznacznie identyfikujący obiekt w ramach asocjacji
umożliwia szybkie otrzymanie obiektu z drugiej strony powiązania na podstawie kwalifikatora
- kompozycja
opisuje zależność część - całość
część nie może być współdzielona (liczności - 1-*, 1 po stronie całości)
część nie może istnieć bez całości (całość może)
usunięcie całości oznacza usunięcie wszystkich jej części


w każdym przypadku: liczność 1-* lub *-* oraz automatyczne tworzenie połączenia zwrotnego
 */