package com.lti.dao;

import com.lti.entity.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AlbumSongDao extends GenericDao{
	
	//fetch all songs sung by Arijit Singh.
	public List<Song> fetchSongsByArtist(String artist)
	{
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try
		{
		emf = Persistence.createEntityManagerFactory("hibernate-app");
		em = emf.createEntityManager();
		String jpql ="select sg from Song sg where sg.artist = :artist ";
		Query q =em.createQuery(jpql);
		q.setParameter("artist", artist);
		List<Song> list = q.getResultList();
		return list;
		}
		finally
		{
		em.close();
		emf.close();
		}
	}
	public List<Album> fetchAlbumsByReleaseYear(int year)
	{
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try
		{
			emf = Persistence.createEntityManagerFactory("hibernate-app");
			em = emf.createEntityManager();
			
			String jpql ="select distinct al from Album al where year(al.releaseDate) = :yr ";//internally using extract function
			Query q =em.createQuery(jpql);
			q.setParameter("yr",year);
			List<Album> list = q.getResultList();
			return list;
		}
		finally 
		{
		em.close();
		emf.close();
		}

	}
	
	// fetch albums sung by Arijit
	//SQL->>> select album.name from tbl_song song join tbl_album album on album.id = song.album_id where song.artist = 'Arijit';
	//JPQL ->> select a from Album a inner join a.songs s where s.artist =:Arjiit;
	
	public List<Album> fetchAlbumNameByArtist(String artist)
	{
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try
		{
			emf = Persistence.createEntityManagerFactory("hibernate-app");
			em = emf.createEntityManager();
			String jpql ="select  al from Album al inner join al.songs s where s.artist= :artist ";
			Query q =em.createQuery(jpql);
			q.setParameter("artist",artist);
			List<Album> list = q.getResultList();
			return list;
		}
		finally 
		{
		em.close();
		emf.close();
		}
	}

	//fetch all songs copyrighted by T-series
	public List<Song> fetchSongByCopyright(String copyright)
	{
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try
		{
			emf = Persistence.createEntityManagerFactory("hibernate-app");
			em = emf.createEntityManager();
			String jpql ="select s from Song s inner join s.album a where a.copyright = :copyright ";
			Query q =em.createQuery(jpql);
			q.setParameter("copyright",copyright);
			List<Song> list = q.getResultList();
			return list;
		}
		finally 
		{
		em.close();
		emf.close();
		}
	}
	
	//fetch only the name of the album and title of the song where artist is Arijit Singh
	//SQL -> select a.name, s.title from tbl_album a inner join tbl_song s on a.id=s.album_id where s.artist = 'Arijit';
	public List<Object[]> fetchByArtist(String artist)
	{
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try
		{
			emf = Persistence.createEntityManagerFactory("hibernate-app");
			em = emf.createEntityManager();
		  //String jpql ="select  a from Album a inner join a.songs s where s.artist= :artist ";
			String jpql ="select a.name,s.title from Album a join a.songs s where s.artist = :artist ";
			Query q =em.createQuery(jpql);
			q.setParameter("artist",artist);
			List<Object[]> list = q.getResultList();
			return list;
		}
		finally 
		{
		em.close();
		emf.close();
		}
	}
	
}
