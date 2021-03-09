package com.epam.parking.services;

import java.time.Instant;

public class GetTimestamp {

	public long getCurrentTime() {
		Instant instant = Instant.now();
		return instant.getEpochSecond();
	}
	
}
