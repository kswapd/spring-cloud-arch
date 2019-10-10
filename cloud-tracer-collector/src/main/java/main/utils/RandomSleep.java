package main.utils;

import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public  class RandomSleep {
	private static Logger log = LoggerFactory.getLogger(RandomSleep.class);

	public static void Sleep()
	{
		try {
			int milliSec = (int)(new Random().nextFloat() * 100);
			log.info("Sleeping {} milliseconds", milliSec);
			Thread.sleep(milliSec);

		}catch (InterruptedException e){
			;
		}

	}
}
