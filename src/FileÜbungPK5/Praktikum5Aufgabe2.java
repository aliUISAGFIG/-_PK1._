package FileÜbungPK5;
import java.io.*;

public class Praktikum5Aufgabe2 {

    static void cat(File quelle) throws IOException{
        RandomAccessFile rand = null;
        try {

          rand = new RandomAccessFile(quelle , "r");
          String s;
          while((s = rand.readLine()) != null){
             System.out.println(s);

          }
        }
        catch (IOException e){
            e.printStackTrace();
            throw e;
        }
        finally {
            try {
                if (rand != null){rand.close();}
            }catch (IOException ee){
                ee.printStackTrace();

            }
        }


    }
}
