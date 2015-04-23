package com.barlow.andy.io;

import java.io.*;

/**
 * Created by Andy on 11/03/15.
 */
public class fileIO {
    BufferedReader bufferedRead;
    PrintWriter printWrite;

    File f = new File("file.txt");


    public void fileWriter(String toWrite) {
        try {

            printWrite = new PrintWriter(new BufferedWriter(new FileWriter(f, false)));
            printWrite.println(toWrite);


        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("writing to textfile failed");
        } finally {
            printWrite.close();
        }
    }

    public void fileRead() {

        String line = null;
        try {

            BufferedReader br = new BufferedReader(new FileReader(f));

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();

        } catch (IOException e) {
            System.out.println("File could not be found!");
        }
    }


    public void fileAppend(String toAppend) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(f, true)));
            out.println(toAppend);
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }


//endgame
}
