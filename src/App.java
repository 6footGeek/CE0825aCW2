import com.barlow.andy.db.dao.artists.artistDBmethods;
import com.barlow.andy.db.entities.artist.Artist;

import java.util.List;
import java.util.Scanner;

/**
 * Created by andy on 4/8/2015.
 *
 *
 *      Just some usage code for showing DB functionality
 *
 *
 */


public class App {
    public static void main(String[] args) {



        Scanner sc = new Scanner(System.in);
        Artist artist = new Artist();
        artistDBmethods method = new artistDBmethods();


//        System.out.println("1: Insert Contact");
//        System.out.println("2: Update Contact");
//        System.out.println("3: Delete Contact");
//        System.out.println("4: ListAll Contacts");
//        System.out.println("5: Exit");

        int menu;
        boolean exit = false;
        do {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Choose menu option");
            System.out.println("1: Insert Contact");
            System.out.println("2: Update Contact");
            System.out.println("3: Delete Contact");
            System.out.println("4: ListAll Contacts");
            System.out.println("5: Exit");
            System.out.println();
            System.out.println();
            System.out.println();
            menu = sc.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("Enter artist name: ");
                    String artistNameInsert = sc.next();
                    System.out.println("Enter first name: ");
                    String firstNameInsert = sc.next();
                    System.out.println("Enter last name: ");
                    String lastNameInsert = sc.next();
                    method.insert(new Artist(artistNameInsert, firstNameInsert, lastNameInsert));
                    break;
                case 2:

                    System.out.println("Enter artist name to update: ");
                    String artistNameUpdate = sc.next();
                    System.out.println("Enter first name to update: ");
                    String firstNameUpdate = sc.next();
                    System.out.println("Enter last name to update: ");
                    String lastNameUpdate = sc.next();

                    method.update(new Artist(artistNameUpdate, firstNameUpdate, lastNameUpdate), artistNameUpdate);
                    break;
                case 3:
                    System.out.println("Enter artist to delete");
                    String artistToDelete = sc.next();
                    method.delete(artistToDelete);
                    break;
                case 4:
                    List<Artist> artists = method.selectAll();
                    for (Artist artistToShow : artists) {
                        System.out.println(artistToShow.getID() + ": " + artistToShow.getArtistName() + ". " + artistToShow.getFirstName() + " " + artistToShow.getLastName());
                    }
                    break;
                case 5:
                    exit = true;
                    System.exit(1);
                    break;
                default:
                    System.out.println("Enter a menu number!");
            }
        } while (!exit);
    }




















//        //make x db methods object
//        artistDBmethods x = new artistDBmethods();
//
//
//        //create table
//    //    x.artistCreateTable();
//
//
//        //add data to table
//       Artist artist = new Artist("Ginger", "Andy", "Barlow");
//       x.insert(artist);
//
//
//        //delete by id
////        x.delete(11);
//
//        //list all db entries
//        List<Artist> contacts = x.selectAll();
//            for(Artist contact : contacts) {
//                System.out.println(contact.getID() + ": " + contact.getFirstName() + " " + contact.getLastName());
//            }
//
//        //update contact by id
////        Contact contact = new Contact("Andy", "Barlow");
////        x.update(contact, 6);

    }

