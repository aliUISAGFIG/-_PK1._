package Pk1Projekt;

import java.io.*;
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
                r.druckDaten(System.out);
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

        }
            x.druckDaten(System.out);
        }

        return x;
    }
    public void List_in_datei_Speichern(File file) throws IOException {
                try (  FileOutputStream fil = new FileOutputStream(file);
                       ObjectOutputStream obj = new ObjectOutputStream(fil)){
                    obj.writeObject(risiken);

                }


    }

    public void ListVonDateiLesen(File file) throws IOException, ClassNotFoundException {
        List<Risiko> geladeneRisiken;
        try (FileInputStream fil = new FileInputStream(file);
             ObjectInputStream les = new ObjectInputStream(fil)){

            geladeneRisiken = (List<Risiko>) les.readObject();
            this.risiken = geladeneRisiken;
        }


    }

    public void druckeRisikenInDatei(File file) throws IOException, LeereListeException {
        if(risiken.isEmpty()){throw new LeereListeException("Liste ist leer");}

       try (FileOutputStream st = new FileOutputStream(file)){
           for(Risiko r : risiken){
               r.druckDaten(st);
       }

        }
    }



    public float berechneSummeRueckstellungen() {
        float summe = 0;
        for (Risiko r : risiken) {
            summe += r.ermittleRueckstellung();

        }
        return summe;

    }

}
