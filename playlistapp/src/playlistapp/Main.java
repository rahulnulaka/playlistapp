package playlistapp;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Album arjithAlbum = new Album("arijith", "Love songs");
		Album atifAlbum = new Album("Atif Aslam", "melodious songs");

		arjithAlbum.addSong("Tum hi ho", 4.50);
		arjithAlbum.addSong("Rabta", 5);
		arjithAlbum.addSong("Humsafar", 3.46);
		arjithAlbum.addSong("Roka na ruke", 5.00);

		atifAlbum.addSong("tu jane na", 5);
		atifAlbum.addSong("Tere Sang Yara", 4);
		atifAlbum.addSong("Kun Faya Kun", 3.40);
		atifAlbum.addSong("Dil Diya Galla", 5.56);

		LinkedList<Song> playList = new LinkedList<Song>();

		System.out.println(arjithAlbum.addSongFromAlbumToPlayList("Tum hi ho",
				playList));
		System.out.println(arjithAlbum.addSongFromAlbumToPlayList(3, playList));

		System.out.println(atifAlbum.addSongFromAlbumToPlayList(2, playList));
		System.out.println(atifAlbum.addSongFromAlbumToPlayList("tu jane na",
				playList));
		play(playList);
	}

	private static void play(LinkedList<Song> playList) {
		// TODO Auto-generated method stub
		ListIterator<Song> itr = playList.listIterator();
		System.out.println(itr.next());
		boolean quit = false;
		Scanner scanner = new Scanner(System.in);
		printmenu();
		while (!quit) {
			System.out.println("Choose an option");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				printmenu();
				break;
			case 2:
				if (playList.size() != 0 && itr.hasNext())
					System.out.println(itr.next());
				else {
					System.out.println(itr.previous());
					itr.next();
				}
				break;
			case 3:
				if (playList.size() != 0 && itr.hasPrevious())
					System.out.println(itr.previous());
				else {
					System.out.println("there is no previous song");
				}
				break;
			case 4:
				playall(playList);
				break;
			case 5:
				if (playList.size() != 0 && itr != null) {
					System.out.println(itr.previous());
					itr.next();
				} else
					System.out.println("playlist is empty");
				break;
			case 6:
				if (playList.size() != 0 && itr != null)
					itr.remove();
				break;
			case 7:
				quit = true;
				break;
			default:
				System.out.println("Inter a valid no");
				break;
			}
			scanner.close();
		}
	}

	private static void playall(LinkedList<Song> playList) {
		// TODO Auto-generated method stub
		for (Song song : playList)
			System.out.println(song);
	}

	private static void printmenu() {
		// TODO Auto-generated method stub
		System.out.println("1: show menu again");
		System.out.println("2: play next song");
		System.out.println("3: play prev song");
		System.out.println("4: play all songs");
		System.out.println("5: play the same song");
		System.out.println("6: delete curr song");
		System.out.println("7: exit from the playlist");
	}

}
