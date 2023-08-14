package cvtrackertask.info.guesword;

import cvtrackertask.info.guesword.controller.GuessWordDisplay;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
class CvTrackerTaskApplicationTests {
	GuessWordDisplay guessWordDisplay;

	@BeforeEach
	 void setUp()
	{
		guessWordDisplay =	 new GuessWordDisplay();
	}

	@Test
	void contextLoads() {
	}

	void shouldMatchBrackets()
	{
		String validString ="";

		assertTrue(validString,true);
	}

	@Test()
	@DisplayName(value = "Verifying Swapping Tests...")
	void shouldReturnSwappedResult()
	{
		assertEquals("String Swapping Operation","AaAaaA", guessWordDisplay.swapCase("aAaAAa"));
	}

	@Test
	@DisplayName(value = "Validating inputs as Anagrams...")
	public void shouldBeAnagram()
	{
		assertTrue("Inputs are not  an anagrams", guessWordDisplay.isAnagram("needs","dense"));
	}
}
