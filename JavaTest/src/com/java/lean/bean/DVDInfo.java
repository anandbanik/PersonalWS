package com.java.lean.bean;

public class DVDInfo implements Comparable<DVDInfo>
{
	String title;
	String genre;
	String leadActor;
	
	public DVDInfo()
	{
		title = "SampleTitle";
		genre = "SampleGenre";
		leadActor = "SampleActor";
	}
	public String toString() {
		return title + " " + genre + " " + leadActor + "\n";
	}
	
	public int compareTo(DVDInfo dvdInfo)
	{
		return title.compareTo(dvdInfo.getTitle());
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLeadActor() {
		return leadActor;
	}

	public void setLeadActor(String leadActor) {
		this.leadActor = leadActor;
	}
}
