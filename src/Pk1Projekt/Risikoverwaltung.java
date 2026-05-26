package Pk1Projekt;

import java.util.*;

public class Risikoverwaltung {

    private List<Risiko> risiken;


    public Risikoverwaltung() {
        risiken = new ArrayList<>();

    }


    public void aufnehmen(Risiko r) {

        risiken.add(r);
    }

    public void zeigeRisiken () throws LeereListeException {
        if (risiken.isEmpty()) {
            throw new LeereListeException("Liste ist leer");
        } else {
            Collections.sort(risiken);
            Iterator<Risiko> risikoIterator = risiken.iterator();
            while (risikoIterator.hasNext()) {
                Risiko r = risikoIterator.next();
                r.druckDaten();
            }
        }
    }
    public Risiko sucheRisikoMitMaxRueckstellung() {
         Risiko x = risiken.get(0);
        if(risiken == null){

            System.out.println("Es gibt kein Risiko aud der Liste ");
        }
        else {
        for(int i = 1 ; i < risiken.size() ; i++){

            if( risiken.get(i).ermittleRueckstellung() > x.ermittleRueckstellung() ){
                x = risiken.get(i);
            }
             x.druckDaten();
        }
        }

        return x;
    }

    public float berechneSummeRueckstellungen() {
        float summe = 0;
        for (Risiko r : risiken) {
            summe += r.ermittleRueckstellung();

        }
        return summe;

    }

}
