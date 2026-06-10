package Pk1Projekt;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class AkzeptabelesRisiko extends Risiko {
    private static final long serialVersionUID= 100L;
    public AkzeptabelesRisiko(String bezeichnung, float eintrittwahrscheilicjkeit, float kosten_im_schadenfall) {
        super(bezeichnung, eintrittwahrscheilicjkeit, kosten_im_schadenfall);
    }

    @Override
    public float ermittleRueckstellung() {
        return 0;

    }


    @Override
    public void druckDaten(OutputStream stream) {

        PrintStream ps = new PrintStream(stream);
            int monate = getErstellungsdatum().getMonthValue();
            int jahr = getErstellungsdatum().getYear();
            ps.printf("Id %d Akzeptables Risiko %s aus %d/%d;%nRisikowert %.2f; Rückstellung %.2f%n",
                    getId(),
                    getbezeichnung(),
                    monate,
                    jahr,
                    berechneRisikowert(),
                    ermittleRueckstellung());

    }


}
