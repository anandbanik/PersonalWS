package com.spglobal.ratings.util.splogger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spglobal.ratings.util.splogger.core.LoggerContext;

import ch.qos.logback.core.util.StatusPrinter;

public class SPLogTest {

	
	protected static Logger logger = LoggerFactory.getLogger(SPLogTest.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SPLogTest spLogTest = new SPLogTest();
		spLogTest.testLog();
	}
	
	public void testLog()
	{
		logger.info("Test");
		
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
	    StatusPrinter.print(lc);
	    
	}

}
