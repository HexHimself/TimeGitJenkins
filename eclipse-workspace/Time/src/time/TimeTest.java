package time;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {
	
	// ICE 3 -------------------------------------------------------------------
	
	@Test
	void testGetMillisecondsGood() {
		int milliseconds = Time.getMilliseconds("12:05:05:005");
		assertTrue(milliseconds == 5,
				"The milliseconds were not calculated properly.");
	}
	
	@Test
	void testGetMillisecondsBad() {
		assertThrows(NumberFormatException.class,
				()-> {Time.getMilliseconds("12:05:05:1500");});
	}

	@Test
	void testGetMillisecondsBoundary() {
		int milliseconds = Time.getMilliseconds("12:05:05:999");
		assertTrue(milliseconds == 999,
				"The milliseconds were not calculated properly.");
	}
	
	//--------------------------------------------------------------------------
	

	@Test
	void testGetTotalSecondsGood() {
		int seconds = Time.getTotalSeconds("05:05:05");
		assertTrue(seconds == 18305, 
				"The seconds were not calculated properly.");
	}
	
	@Test
	void testGetTotalSecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class,
				()-> {Time.getTotalSeconds("10:00");});
	}
	
	@Test
	void testGetTotalSecondsBoundary() {
		int seconds = Time.getTotalSeconds("00:00:00");
		assertTrue(seconds == 0,
				"The seconds were not calculated properly.");
		
	}
	
	@Test
	void testGetSecondsGood() {
		int seconds = Time.getSeconds("00:00:30");
		assertTrue(seconds == 30,
				"The seconds were not calculated properly.");
		
	}
	
	@Test
	void testGetSecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class,
				()-> {Time.getSeconds("00:79");});
		
	}
	
	@Test
	void testGetSecondsBoundary() {
		int seconds = Time.getSeconds("00:00:59");
		assertTrue(seconds == 59,
				"The seconds were not calculated properly.");
		
	}

	
	@Test
	void testGetTotalMinutesGood() {
		int minutes = Time.getTotalMinutes("00:06:00");
		assertTrue(minutes == 6,
				"The minutes were not calculated properly.");
		
	}
	
	@Test
	void testGetTotalMinutesBad() {
		assertThrows(StringIndexOutOfBoundsException.class,
				()-> {Time.getTotalMinutes("77");});
		
	}
	
	@Test
	void testGetTotalMinutesBoundary() {
		int minutes = Time.getTotalMinutes("00:59:00");
		assertTrue(minutes == 59,
				"The minutes were not calculated properly.");
		
	}

	@ParameterizedTest
	@ValueSource(strings = {"06:00:00", "06:50:50", "06:59:59"})
	void testGetTotalHours(String candidate) {
		int hours = Time.getTotalHours(candidate);
		assertTrue(hours == 6,
				"The hours were not calculated properly.");
	}
	
	
}
