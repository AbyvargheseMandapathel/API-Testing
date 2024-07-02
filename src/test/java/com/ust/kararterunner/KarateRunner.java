package com.ust.kararterunner;


import com.intuit.karate.junit5.Karate;

public class KarateRunner {
	@Karate.Test
	Karate karateTest() {
		return Karate.run("pet.feature").tags("@get,@delete").relativeTo(getClass());		
	}
}
