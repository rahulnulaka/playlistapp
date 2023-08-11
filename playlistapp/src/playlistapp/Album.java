package playlistapp;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
	private String artist;
	private String album_name;
	private ArrayList<Song> songs;

	public Album() {
	}

	public Album(String artist, String album_name) {
		this.artist = artist;
		this.album_name = album_name;
		this.songs = new ArrayList<Song>();
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum_name() {
		return album_name;
	}

	public void setAlbum_name(String album_name) {
		this.album_name = album_name;
	}

	public ArrayList<Song> getSongs() {
		return songs;
	}

	public void setSongs(ArrayList<Song> songs) {
		this.songs = songs;
	}

	// functionalities
	public boolean FindSong(String name) {
		for (Song song : songs) {
			if (song.getTitle().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}

	public String addSong(String name, double duration) {
		if (!FindSong(name)) {
			songs.add(new Song(name, duration));
			return "Song has been added";
		}
		return "Song is already present";
	}

	public String addSongFromAlbumToPlayList(String name,
			LinkedList<Song> playlist) {
		for (Song song : songs) {
			if (song.getTitle().equalsIgnoreCase(name)) {
				playlist.add(song);
				return "Song has been added to playList";
			}
		}
		return "Song is not available";
	}

	public String addSongFromAlbumToPlayList(int songNo,
			LinkedList<Song> playlist) {
		songNo--;
		if (songNo >= 0 && songNo < songs.size()) {
			playlist.add(songs.get(songNo));
			return "Song has been added to playList";
		}
		return "Song is not available";
	}

}
