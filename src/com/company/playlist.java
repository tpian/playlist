import java.util.*;
//class SongRecord
	 class SongRecord{
		public String title;
		public String artist;
		public int minutes;
		public int seconds;
		public SongRecord() {}
		public SongRecord(String title, String artist, int minutes, int seconds)
		{this.artist=artist;
		this.title=title;
		this.minutes=minutes;
	    this.seconds=seconds;
		}
		public void setArtist(String artist) {
			this.artist=artist;
		}
		public void setTitle(String title) {
			this.title=title;
		}
		public void setMinutes(int minutes) {
			this.minutes=minutes;
		}
		public void setSeconds(int seconds) {
			this.seconds=seconds;
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
		public String toString(){
			String song;
			song=this.title;
			while(song.length()<25)
			{song=song+" ";}
			song=song+this.artist;
			while(song.length()<50)
				{song=song+" ";}
		song=song+this.minutes +":";
			if(this.seconds<10) {
				song=song+"0"+this.seconds;
			}else
				song = song+this.seconds;
	 		return song;}}
	 
//     ........................public class play list...................
		
public class playlist extends Object{
	private SongRecord[] S=new SongRecord[50];
//			when it is empty,initialize
			 public playlist() throws Exception{
				for(int i=0;i<50;i++) {
					SongRecord song = new SongRecord();
					S[i] = song;
					song.setArtist("");
					song.setTitle("");
					song.setMinutes(0);
					song.setSeconds(0);
				}
			}
				//..........class deal with exception.......
			  class FullplaylistException extends Exception{
				 }
			 
			 
//		     ..... size......
			 public int size() {
				 int x=0;
				 while((0!=S[x].minutes)&&(0!=S[x].seconds))
						 {x++;}
				 return x;
				
			 }
		
//	         .......the method of addSong.....
			 public void addSong(SongRecord song,int position )throws Exception{
			 			
			 		if((position>-1)&&(position<size()+1)){
			 			for(int i=size()-1;i>position-1;i--) {
			 				S[i+1]=S[i];	
			 			}
			 			S[position-1].setArtist(song.getArtist());
						S[position-1].setTitle(song.getTitle());
						S[position-1].setMinutes(song.getMinutes());
						S[position-1].setSeconds(song.getSeconds());
			 			
			 		}
			 if(position>size()+1)
				 try{throw new IllegalArgumentException ();}
			 		catch(IllegalArgumentException e)
			 		{System.out.println("Invalid position for adding the new song");}
				 		if(size()==50)
				 			try {
				 				throw new FullplaylistException();
				 			}
			 		catch(FullplaylistException e){
			 				System.out.print("Invalid position for adding the new song");}
			 			}
			 		
			 public Object clone() {
				 playlist copy = null;
					try {
						copy = new playlist();
					} catch (Exception e) {
						e.printStackTrace();
					}
					for(int i = 0; i < size(); i++) {
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
				 int num = 0;
					for(int i = 0; i < size() && i + num < size(); i++) {
						if(S[i].getTitle().equals(((playlist)obj).getSong(i).getTitle())) {
							i++;
						}
						else num++;
					}
					
					if( num == 0) {
					return true;
					}
					else return false;
				
			 }
			 
			
		
//	.........the method of remove songs.............		 
			 public void removeSong(int position)throws Exception {
			try {
					if(position < size()) {
						for(int i = position; i < size(); i++) {
							S[position-1].setArtist(S[position].getArtist());
							S[position-1].setTitle(S[position].getTitle());
							S[position-1].setMinutes(S[position].getMinutes());
							S[position-1].setSeconds(S[position].getSeconds());
						}
						S[position].artist ="";
						S[position].title="";
						S[position].minutes=0;
						S[position].seconds=0;
						System.out.print("Song Removed at position "+position);
						
					}else {
						S[position-1].artist ="";
						S[position-1].title="";
						S[position-1].minutes=0;
						S[position-1].seconds=0;
					}
					}catch(IllegalArgumentException e) {
						System.out.println("No song at position "+ position + " to remove.");
					}
				
				 
				 
				 
				 
				 
				 
			 }
//	..........input position get song..............     
				public SongRecord getSong(int position) {
					return S[position-1];
				}
//   ........print all song........
				public void printAllSongs() {
					System.out.println("Song#     Title             Artist            Length");
					System.out.println("----------------------------------------------------");
					System.out.println(toString());
					
				}
//	     ........get song by artist..........
				public static playlist getSongsByArtist(playlist originalList,String artist) throws Exception {
					playlist newlist = new playlist();
				    int s = originalList.size();
					for(int i = 0, j = 0; i < s; i++) {
						if(originalList.getSong(i + 1).getArtist().equals(artist)) {
							newlist.addSong(originalList.getSong(i + 1), j + 1);
							j++;
						}
					}
					return newlist;
				}
//	      .....print the song list.......		
				public String toString() {
					String str="";
					for(int i=0;i<size();i++) {
					str=str+(i+1)+"         "+S[i].toString()+'\n';
					}
					return str;
					
				} 
				
				
				
				
				

//.......class playlistOperation............
//class playlistOparetions{
//	
//	
//	
//	
//}


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
				    SongRecord song=new SongRecord();
				
				    
				    song.getArtist();
				    song.getTitle();
				    song.getMinutes();
				    song.getSeconds();
				    
				    System.out.print(song.toString());
				    alist.printAllSongs();
				    alist.clone();
				    int pos=input.nextInt();
				    
				    
					System.out.print("A) Add Song");
				    System.out.print("B) Print Songs by Artist ");
				    System.out.print("G) Get Song");
				    System.out.print("R) Remove Song ");
				    System.out.print("P) Print All Songs ");
				    System.out.print("S) Size");
				    System.out.print("Q) Quit ");
				    System.out.print("\r\n");
				    String choice=input.next();
		//select a menu option   
				    
				    do {
					   System.out.print("Select a menu option：");
					   System.out.print("\r\n");
					  
				switch(choice) {
//				case add song
				case "A" :
				case "a":
					 song.getArtist();
					    song.getTitle();
					    song.getMinutes();
					    song.getSeconds();
					    System.out.print("Enter the song title: ");
					    String title = input.next();
					    System.out.print("Enter the song artist: ");
					    String artist = input.next();
					    System.out.print("Enter the song length(minutes): ");
//					    try{
					    	int minutes = input.nextInt();
					    	
//					    }catch(IllegalArgumentException ex) {
//					    	System.out.println(ex);
//					    } 
					    System.out.print("Enter the song length(seconds): ");
//					    try{
					    	int seconds= input.nextInt();
					    System.out.print("Enter the position:");
					    
					    System.out.print("Song Added:"+song.title +"by"+song.artist );
					    alist.addSong(song, pos);
					    break;
		//case B			    
				case"B":
				case"b":
					String Artist =new String();
					System.out.print("Enter the artist:");
					playlist.getSongsByArtist(alist,Artist);
					alist.printAllSongs();
					break;
					
		//case G
				case"G":
				case"g":
					System.out.print("Enter the position:"); 
				System.out.print(alist.getSong(pos));
				break;
		//case	R	
				case"R":
				case"r":
					System.out.print("Enter the position:");
					alist.removeSong(pos);
					break;
					
		//case   P
				case"P":
				case"p":
					alist.printAllSongs();
					break;
		//case   S
				case"S":
				case"s":
				System.out.print("There are "+ alist.size() +" song(s) in the current playlist.");	
				break;
				}
				    
				    
				  
				    }while((choice!="q")&&(choice!="Q"));
				    System.out.println("Program terminationg normally...");
		//press q or Q to the end		    
				    if ((choice=="q")||(choice=="Q")){
				    	System.exit(0);
				    	
				    }input.close();}
}




			 
			 



		    		
	
		
	
	