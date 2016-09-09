package com.java.test;

import java.util.ArrayList;
import java.util.List;

import com.java.lean.bean.DVDInfo;

public class DVDInfoSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<DVDInfo> dvdInfo = new ArrayList<DVDInfo>();
		for(DVDInfo info: dvdInfo)
		{
			info.getGenre();
			System.out.println(info.getLeadActor());
		}
		
	}

}
