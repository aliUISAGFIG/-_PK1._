package Pk1Projekt;

import javax.swing.*;

public class AkzeptabelesRisiko extends Risiko {

    public AkzeptabelesRisiko(String bezeichnung, float eintrittwahrscheilicjkeit, float kosten_im_schadenfall) {
        super(bezeichnung, eintrittwahrscheilicjkeit, kosten_im_schadenfall);
    }

    @Override
    public float ermittleRueckstellung() {
        return 0;

    }


    @Override
    public void druckDaten() {
        int monate = getErstellungsdatum().getMonthValue();
        int jahr = getErstellungsdatum().getYear();
        JOptionPane.showMessageDialog(null , "Id " + getId() + " Akzeptables Risiko " + getbezeichnung() + " aus " + monate + "/" + jahr + ";\n" +
                "Risikowert " + berechneRisikowert() + "; Rückstellung " + ermittleRueckstellung());

    }


}
