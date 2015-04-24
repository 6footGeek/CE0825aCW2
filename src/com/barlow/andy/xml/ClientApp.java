package com.barlow.andy.xml;

/**
 * Created by Andy on 23/04/15.
 *
 * Simple client app frontend that generates and reads an XML file.
 *
 */
public class ClientApp {
    public static void main(String[] args) {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("This file creates an xml file based on some artists.");

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        CreateXML xml = new CreateXML();
        xml.CreateXML();
        xml.ReadXML();
    }
}
