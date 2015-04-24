package com.barlow.andy.xml;

/**
 * Created by Andy on 23/04/15.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


public class CreateXML {

   protected void CreateXML() {
        DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder icBuilder;
        try {
            icBuilder = icFactory.newDocumentBuilder();
            Document doc = icBuilder.newDocument();
            Element mainRootElement = doc.createElementNS("Andys xml file", "MusicLibrary");
            doc.appendChild(mainRootElement);

            // append child elements to root element
            mainRootElement.appendChild(getArtist(doc, "1", "Snoop Dog", "that", "dude"));
            mainRootElement.appendChild(getArtist(doc, "2", "Eminem", "marshall", "marthers"));
            mainRootElement.appendChild(getArtist(doc, "3", "JayZ", "jay", "Z"));

            // output DOM XML to console
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            DOMSource source = new DOMSource(doc);
            StreamResult file = new StreamResult(new File("artists.xml"));
            StreamResult console = new StreamResult(System.out);
            //output to file and console
            transformer.transform(source, file);
            transformer.transform(source, console);

            System.out.println("\nXML DOM Created Successfully..");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Node getArtist(Document doc, String id, String artistName, String firstName, String lastName) {
        Element artist = doc.createElement("Artist");
        artist.setAttribute("id", id);
        artist.appendChild(getArtistElements(doc, artist, "Artist", artistName));
        artist.appendChild(getArtistElements(doc, artist, "FirstName", firstName));
        artist.appendChild(getArtistElements(doc, artist, "LastName", lastName));
        return artist;
    }

    // utility method to create text node
    private Node getArtistElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }


    public void ReadXML() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("artists.xml");
            XMLInputFactory xmlInFact = XMLInputFactory.newInstance();
            XMLStreamReader reader = xmlInFact.createXMLStreamReader(fis);
            while(reader.hasNext()) {
                reader.next();
                System.out.println(reader.getTextCharacters());

            }
        }
        catch(IOException exc) {
            exc.printStackTrace();
        }
        catch(XMLStreamException exc) {
        exc.printStackTrace();
        }
    }
}


