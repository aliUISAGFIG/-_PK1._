package Pk1Projekt;

import javax.swing.*;
import java.util.Objects;

public class InakzeptabelesRisiko extends Risiko {
    private String massnahme;

    public InakzeptabelesRisiko(String bezeichnung, float eintrittwahrscheilicjkeit, float kosten_im_schadenfall, String massnahme) {
        super(bezeichnung, eintrittwahrscheilicjkeit, kosten_im_schadenfall);
        this.massnahme = massnahme;


    }

    @Override
    public float ermittleRueckstellung() {
        return berechneRisikowert();
    }

    public String getMassnahme() {

        return massnahme;

    }


    @Override
    public void druckDaten() {
        int monate = getErstellungsdatum().getMonthValue();
        int jahr = getErstellungsdatum().getYear();
        JOptionPane.showMessageDialog(null , "Id " + getId() + " Inakzeptables Risiko " + getbezeichnung() + " aus " + monate + "/" + jahr + ";\n" +
                "Risikowert " + berechneRisikowert() + "; Rückstellung " + ermittleRueckstellung() + ";\n" +
                "Maßnahme " + getMassnahme());
    }

    @Override
    public boolean equals(Object o) {

        if (!super.equals(o)) return false;
        InakzeptabelesRisiko obj = (InakzeptabelesRisiko) o;
        return massnahme.equals(obj.massnahme);

    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), massnahme);

    }


}
