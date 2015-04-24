package com.barlow.andy.db;

import com.barlow.andy.db.dao.albums.albumDBmethods;
import com.barlow.andy.db.dao.artists.artistDBmethods;
import com.barlow.andy.db.dao.tracks.tracksDBmethods;
import com.barlow.andy.db.entities.albums.Album;
import com.barlow.andy.db.entities.artist.Artist;
import com.barlow.andy.db.entities.tracks.Track;

import java.util.List;
import java.util.Scanner;

/**
 * Created by andy on 4/8/2015.
 *
 *
 *  Big menu to show DB functionality
 *
 *
 *
 */


public class App {
    public static void main(String[] args) {

        int menu;
        boolean exit = false;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Choose menu option");
            System.out.println("1: Artist Options");
            System.out.println("2: Track Options");
            System.out.println("3: Album Options");
            System.out.println("4: Exit");
            System.out.println();
            System.out.println();
            System.out.println();

            menu = sc.nextInt();
            switch (menu) {
                case 1:
                    artistMenu();
                    break;
                case 2:
                    trackMenu();
                    break;
                case 3:
                    albumMenu();
                    break;
                case 4:
                    exit = true;
                    System.exit(1);
                    break;
                default:
                    System.out.println("Enter a menu number!");
            }
        } while (!exit);
    }


    public static void artistMenu() {
        Scanner sc = new Scanner(System.in);
        Artist artist = new Artist();
        artistDBmethods method = new artistDBmethods();
        method.artistCreateTable();
        int menu;
        boolean exit = false;
        do {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Choose menu option");
            System.out.println("1: Insert Artist");
            System.out.println("2: Update Artist");
            System.out.println("3: Delete Artist");
            System.out.println("4: ListAll Artist's");
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
                    break;
                default:
                    System.out.println("Enter a menu number!");
            }
        } while (!exit);
    }

    public static void trackMenu() {
        Scanner sc = new Scanner(System.in);
        Track track = new Track();
        tracksDBmethods method = new tracksDBmethods();
        method.tracksCreateTable();
        int menu;
        boolean exit = false;
        do {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Choose menu option");
            System.out.println("1: Insert Track");
            System.out.println("2: Update Track");
            System.out.println("3: Delete Track");
            System.out.println("4: ListAll Track's");
            System.out.println("5: Exit");
            System.out.println();
            System.out.println();
            System.out.println();
            menu = sc.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("Enter Track name: ");
                    String trackNameInsert = sc.next();
                    System.out.println("Enter Track length..(03.45):  ");
                    double trackLengthInsert = sc.nextDouble();
                    System.out.println("Enter Album id: ");
                    int albumIdInsert = sc.nextInt();
                    System.out.println("Enter Artist id: ");
                    int artistIdInsert = sc.nextInt();
                    method.insert(new Track(artistIdInsert, albumIdInsert, trackNameInsert, trackLengthInsert));
                    break;
                case 2:
                    System.out.println("Enter Track name to update: ");
                    String trackNameUpdate = sc.next();
                    System.out.println("Enter Track length to update..(03.45):  ");
                    double trackLengthUpdate = sc.nextDouble();
                    System.out.println("Enter Album id to update: ");
                    int albumIdUpdate = sc.nextInt();
                    System.out.println("Enter Artist id to update: ");
                    int artistIdUpdate = sc.nextInt();

                    method.update(new Track(artistIdUpdate, albumIdUpdate, trackNameUpdate, trackLengthUpdate), trackNameUpdate);
                    break;
                case 3:
                    System.out.println("Enter track Title to delete");
                    String artistToDelete = sc.next();
                    method.delete(artistToDelete);
                    break;
                case 4:
                    List<Track> tracks = method.selectAll();
                    for (Track trackToShow : tracks) {
                        System.out.println(trackToShow.getID() + ": " + trackToShow.getTrackName() + ". " + trackToShow.getTrackLength());
                    }
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Enter a menu number!");
            }
        } while (!exit);
    }


    public static void albumMenu() {
        Scanner sc = new Scanner(System.in);
        Album album = new Album();
        albumDBmethods method = new albumDBmethods();
        method.albumCreateTable();
        int menu;
        boolean exit = false;
        do {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Choose menu option");
            System.out.println("1: Insert Album");
            System.out.println("2: Update Album");
            System.out.println("3: Delete Album");
            System.out.println("4: ListAll Album's");
            System.out.println("5: Exit");
            System.out.println();
            System.out.println();
            System.out.println();
            menu = sc.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("Enter Album name:  ");
                    String albumNameInsert = sc.next();

                    System.out.println("Enter Artist id: ");
                    int albumArtistIdInsert = sc.nextInt();

                    System.out.println("Enter release year: ");
                    int albumReleaseInsert = sc.nextInt();

                    method.insert(new Album(albumArtistIdInsert, albumNameInsert, albumReleaseInsert));
                    break;
                case 2:
                    System.out.println("Enter Album to Update: ");
                    String albumName = sc.next();
                    System.out.println("Enter Artist id: ");
                    int albumArtistIdUpdate = sc.nextInt();
                    System.out.println("Enter Album name:  ");
                    String albumNameUpdate = sc.next().toString();
                    System.out.println("Enter release year: ");
                    int albumReleaseUpdate = sc.nextInt();

                    method.update(new Album(albumArtistIdUpdate, albumNameUpdate, albumReleaseUpdate), albumName);
                    break;
                case 3:
                    System.out.println("Enter album Title to delete");
                    String albumToDelete = sc.next();
                    method.delete(albumToDelete);
                    break;
                case 4:
                    List<Album> albums = method.selectAll();
                    for (Album albumToShow : albums) {
                        System.out.println(albumToShow.getID() + ": " + albumToShow.getAlbumTitle() + ". " + albumToShow.getReleaseYear());
                    }
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Enter a menu number!");
            }
        } while (!exit);
    }


}

