package com.lti.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.lti.dao.AlbumSongDao;
import com.lti.dao.GenericDao;
import com.lti.dao.UserDao;
import com.lti.entity.Album;
import com.lti.entity.Song;
import com.lti.entity.User;

public class AlbumSongTest {
	
	@Test
	public void addAlbum()
	{
		Album al = new Album();
		al.setName("Kuch Kuch Hota Hai");
		al.setCopyright("Red Chillies Production");
		al.setReleaseDate(LocalDate.of(2000, 05, 12));
		
		GenericDao dao = new GenericDao();
		dao.save(al);
	}
	
	@Test
	public void addSongToAnAlbum()
	{
		GenericDao dao = new GenericDao();
		Album al = dao.fetchById(Album.class, 42);
		Song sg = new Song();
		sg.setArtist("Arijit");
		sg.setTitle("Kuch Kuch Hota Hai");
		sg.setDuration(LocalTime.of(00,06, 23));
		sg.setAlbum(al);
		dao.save(sg);
		
	}
	
	@Test
	public void addAlbumAlongWithSongs()
	{
		GenericDao dao = new GenericDao();
		Album al = new Album();
		al.setReleaseDate(LocalDate.of(2007, 10,30));
		al.setName("Mujhe kuch kehna hai");
		al.setCopyright("Dharma Productions");
		
		List<Song> songs = new ArrayList<>();
		Song s1 = new Song();
		s1.setArtist("Mohit");
		s1.setTitle("Tamasha");
		s1.setDuration(LocalTime.of(0, 5));
		s1.setAlbum(al);
		songs.add(s1);
		
		al.setSongs(songs);
		dao.save(al);

	}
	
	@Test
	
	   public void fetchSong()
	   {
		   AlbumSongDao dao= new AlbumSongDao();
		   List<Song> list = dao.fetchSongsByArtist("Neha Kakkar");
		   for(Song s: list)
		   {
			   System.out.println(s.getTitle());
		   }
	   }
	
	   @Test
	   public void fetchAlbum()
	   {
		   AlbumSongDao dao= new AlbumSongDao();
		   List<Album> list = dao.fetchAlbumsByReleaseYear(2000);
		   for(Album al: list)
		   {
			   System.out.println(al.getName()+"\t" +al.getCopyright());
		   }
	   }
	   
	   @Test
	   public void fetchAlbumByJoin()
	   {
		   AlbumSongDao dao= new AlbumSongDao();
		   List<Album> list = dao.fetchAlbumNameByArtist("Arijit");
		   for(Album al: list)
		   {
			   System.out.println(al.getName()+"\t" +al.getCopyright());
		   }
	   }
	   
	   @Test
	   public void fetchSongsByCopyright()
	   {
		   AlbumSongDao dao= new AlbumSongDao();
		   List<Song> list = dao.fetchSongByCopyright("T-series");
		   for(Song al: list)
		   {
			   System.out.println(al.getTitle()+"\t" +al.getArtist());
		   }
	   }
	   
	   @Test
		public void findAlbumAndSongByArtist() {
			AlbumSongDao dao=new AlbumSongDao();
			List<Object[]> list=dao.fetchByArtist("Arijit");
			for( Object[] obj:list)
				System.out.println(Arrays.toString(obj));
		}
	

}
