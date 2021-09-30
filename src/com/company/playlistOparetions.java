package com.company;

import java.util.Scanner;

public class playlistOparetions {
    //		       .......main function........
    public static  void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

//				    }catch(IllegalArgumentException ex) {
//				    	System.out.println(ex);
//			    }
//				    SongRecord s1=new SongRecord(title,artist,minutes,seconds);
//				    s1.getArtist();
//				    s1.getArtist();
//				    s1.getMinutes();
//				    s1.getSeconds();


        playlist alist=new playlist();
//
//
//        song.getArtist();
//        song.getTitle();
//        song.getMinutes();
//        song.getSeconds();
//
//        System.out.print(song.toString());
//        alist.printAllSongs();
//        alist.clone();



        System.out.println("A) Add Song");
        System.out.println("B) Print Songs by Artist ");
        System.out.println("G) Get Song");
        System.out.println("R) Remove Song ");
        System.out.println("P) Print All Songs ");
        System.out.println("S) Size");
        System.out.println("Q) Quit ");
        System.out.print("Select a menu option：");
        String choice=input.nextLine();

        do {

            //select a menu option

            switch(choice.toLowerCase()) {
//				case add song
                case "a":
                    System.out.print("Enter the song title: ");
                    String title = input.nextLine();
                    System.out.print("Enter the song artist: ");
                    String artist = input.nextLine();
                    System.out.print("Enter the song length(minutes): ");
                    int minutes = input.nextInt();
                    System.out.print("Enter the song length(seconds): ");
                    int seconds= input.nextInt();
                    System.out.print("Enter the position:");
                    int pos = input.nextInt();
                    String waste = input.nextLine();
                    SongRecord song=new SongRecord();
                    try{
                        song.setTitle(title);
                        song.setArtist(artist);
                        song.setMinutes(minutes);
                        song.setSeconds(seconds);
                        alist.addSong(song,pos);
                        System.out.println("Song Added: "+song.getTitle() +" by "+song.getArtist() );
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }catch (FullplaylistException e){
                        System.out.print("There is no more room inside of the Playlist");
                    }
                    break;
                //case B
                case"b":
                    System.out.print("Enter the artist:");
                    String Artist = input.nextLine();
                    playlist artistPL = playlist.getSongsByArtist(alist,Artist);
                    artistPL.printAllSongs();
                    break;
                //case G
                case"g":
                    System.out.print("Enter the position:");
                    int getPos = input.nextInt();
                    String gwaste = input.nextLine();
                    try{
                        SongRecord getSong=new SongRecord();
                        getSong = alist.getSong(getPos);
                        playlist getList = new playlist();
                        getList.addSong(getSong,1);
                        getList.printAllSongs();
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                //case	R
                case"r":
                    System.out.print("Enter the position:");
                    int rmPos = input.nextInt();
                    String rwaste = input.nextLine();
                    try{
                        alist.removeSong(rmPos);
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                //case   P
                case"p":
                    alist.printAllSongs();
                    break;
                //case   S
                case"s":
                    System.out.println("There are "+ alist.size() +" song(s) in the current playlist.");
                    break;
                case"q":
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
            if (!choice.equals("q")) {
                System.out.print("Select a menu option：");
                if (input.hasNextLine()) {
                    choice = input.nextLine();
                }
            }
        }while((!choice.equals("q"))&&(!choice.equals("Q")));
        System.out.println("Program terminationg normally...");
        //press q or Q to the end
        if ((choice=="q")||(choice=="Q")){
            input.close();
            System.exit(0);

        }}
}
