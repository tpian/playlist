package com.company;

import java.util.*;
//class SongRecord
	 class SongRecord{
		private String title;
		private String artist;
		private int minutes;
		private int seconds;
//		public SongRecord() {}
//		public SongRecord(String title, String artist, int minutes, int seconds)
//		{this.artist=artist;
//		this.title=title;
//		this.minutes=minutes;
//	    this.seconds=seconds;
//		}
		public void setArtist(String artist) {
			this.artist=artist;
		}
		public void setTitle(String title) {
			this.title=title;
		}
		public void setMinutes(int minutes) throws IllegalArgumentException {
			this.minutes=minutes;
			if (minutes<0){
				throw new IllegalArgumentException("Invalid song length");
			}
		}
		public void setSeconds(int seconds) throws IllegalArgumentException {
			this.seconds=seconds;
			if (seconds<0 || seconds>59){
				throw new IllegalArgumentException("Invalid song length");
			}
		}
		public String getArtist() {
			return artist;}
		public String getTitle() {
			return title;}
		public int getMinutes() {
//			if (minutes<0) {
//				throw new IllegalArgumentException(minutes + " is not valid!");
//			}
			return minutes;}
		public int getSeconds() {
//			if(seconds<0||seconds>59) {
//			throw new IllegalArgumentException(seconds + " is not valid!");}
			return seconds;}
//override string methods for output
		public String toString() {
			return String.format("%-26s%-26s%d:%02d",title,artist,minutes,seconds);
//			String song;
//			song=this.title;
//			while(song.length()<25)
//			{song=song+" ";}
//			song=song+this.artist;
//			while(song.length()<50)
//				{song=song+" ";}
//		song=song+this.minutes +":";
//			if(this.seconds<10) {
//				song=song+"0"+this.seconds;
//			}else
//				song = song+this.seconds;
//	 		return song;}
		}
	 }
	 
//     ........................public class playlist...................
		
public class playlist extends Object {
	private SongRecord[] S;

	//			when it is empty,initialize
	public playlist() {
		this.S = new SongRecord[50];
	}
//			 public playlist() throws Exception{
//				for(int i=0;i<50;i++) {
//					SongRecord song = new SongRecord();
//					S[i] = song;
//					song.setArtist("");
//					song.setTitle("");
//					song.setMinutes(0);
//					song.setSeconds(0);
//				}
//			}


	//		     ..... size......
	public int size() {
		int x=0;
		while(S[x]!=null)
		{x++;}
		return x;
	}

	//	         .......the method of addSong.....
	public void addSong(SongRecord song, int position) throws IllegalArgumentException, FullplaylistException {
		if (size() >= 50) {
			throw new FullplaylistException();
		} else if ((position >= 1) && (position <= size() + 1)) {
			for (int i = size() - 1; i > position-2 ; i--) {
				S[i + 1] = S[i];
			}
			S[position-1] = song;
		} else {
			throw new IllegalArgumentException("Invalid position for adding the new song");
		}
	}

	public Object clone() {
		playlist copy = new playlist();
		for (int i = 0; i < size(); i++) {
			try {
				copy.addSong(S[i], i + 1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return copy;

	}

	//			 decide whether the songs are same
	public boolean equals(Object obj) {
		if (obj.equals(null) || (!(obj instanceof playlist))) {
			return false;
		} else {
			playlist cmp = (playlist) obj;
			boolean flag = true; //note whether the playlist is same till now
			for (int i = 0; i < size(); i++) {
				if (!(S[i].getTitle().equals(cmp.S[i].getArtist())
						&& S[i].getTitle().equals(cmp.S[i].getArtist())
						&& S[i].getMinutes() == cmp.S[i].getMinutes()
						&& S[i].getSeconds() == cmp.S[i].getSeconds()
				)) {
					flag = false;
					break;
				}
			}
			return flag;
		}
	}


	//	.........the method of remove songs.............
	public void removeSong(int position) throws IllegalArgumentException {
		if ((position >= 1) && (position <= size())) {

			for (int i = position; i < size(); i++) {
				S[i - 1].setArtist(S[i].getArtist());
				S[i - 1].setTitle(S[i].getTitle());
				S[i - 1].setMinutes(S[i].getMinutes());
				S[i - 1].setSeconds(S[i].getSeconds());
			}
			S[size() - 1] = null;
			System.out.print("Song Removed at position " + position);
		} else {
			throw new IllegalArgumentException("No song at position " + position + " to remove.");
		}
	}

	//	..........input position get song..............
	public SongRecord getSong(int position) {
		if ((position < 1) || (position > size())) {
			throw new IllegalArgumentException("No song at position " + position );
		}
		return S[position - 1];
	}

	//   ........print all song........
	public void printAllSongs() {
		System.out.println(String.format("%-10s%-26s%-26s%-10s", "Song#", "Title", "Artist", "Length"));
		System.out.println("-----------------------------------------------------------------------");
		System.out.println(toString());

	}

	//	     ........get song by artist..........
	public static playlist getSongsByArtist(playlist originalList, String artist) throws FullplaylistException {
		playlist newlist = new playlist();
		int s = originalList.size();
		for (int i = 0, j = 0; i < s; i++) {
			if (originalList.getSong(i + 1).getArtist().equals(artist)) {
				newlist.addSong(originalList.getSong(i + 1), j + 1);
				j++;
			}
		}
		return newlist;
	}

	//	      .....print the song list.......
	public String toString() {
		String str = "";
		for (int i = 0; i < size(); i++) {
			str = str + String.format("%-10d%s\n", i + 1, S[i].toString());
		}
		return str;

	}
}






			 
			 



		    		
	
		
	
	