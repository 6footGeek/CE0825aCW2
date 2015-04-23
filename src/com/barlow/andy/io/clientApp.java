package com.barlow.andy.io;


/**
 * Created by Andy on 11/03/15.
 */
public class clientApp {


    public static void main(String[] args) {


        fileIO x = new fileIO();
      //  x.fileWriter("This is writing..");
        x.fileAppend("This is appending..");
        x.fileRead();

    }
}
