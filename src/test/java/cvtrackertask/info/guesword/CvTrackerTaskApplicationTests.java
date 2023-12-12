package cvtrackertask.info.guesword;

import cvtrackertask.info.guesword.controller.GuessWordDisplay;
import cvtrackertask.info.guesword.service.GuessWordService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.*;

//@SpringBootTest
class CvTrackerTaskApplicationTests {
	GuessWordDisplay guessWordDisplay;

	@Mock
	GuessWordService guessWordService;

	@BeforeEach
	 void setUp()
	{
		guessWordDisplay =	 new GuessWordDisplay();
	}

	@Test
	void contextLoads() {
	}

	@Test
	void shouldMatchBrackets()
	{
		when(guessWordService.method()).thenReturn("Nimat");

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
		assertTrue("Inputs are not  an anagrams", guessWordDisplay.isAnagram("example","exempla"));
		Map<String, Integer> map= Map.of("One Hundred",100);
		Assertions.assertThat(map).containsKey("One Hundred").containsValue(100);
	}

	@Test
	@DisplayName("Running Smallest Integer Not Part Of Array")
	public void shouldReturnSmallestMissingInteger()
	{
		int[] ints = {1, 3, 6, 4, 1, 2 }; // 1, 2, 3
		assertEquals( "Smallest Integer Not Part of Array",5,guessWordDisplay.smallestInteger(ints));
	}

	@Test
	@DisplayName("Testing Matching Parentheses")
	public void shouldReturnMatchedTestTrue()
	{
		assertTrue("The braces match properly",guessWordDisplay.isMatched("{[()]}"));
	}


	@Test
	@DisplayName("Should Fail Matching Pairs")
	public void shouldReturnFalseMatch()
	{
		assertFalse("Didn't match the right input pattern", guessWordDisplay.isMatched("[}"));
	}

	@Test
	@DisplayName("Cyclic Array Rotation")
	public void shouldRotate()
	{
		int[] nums = {1,2,3,4,5}, result = {5, 1, 2, 3, 4};
		assertThat(result).containsExactly(guessWordDisplay.cyclicRotate(nums));
	}

	@Test
	@DisplayName("Should Not Rotate This Array")
	public void shouldNotRotate()
	{
		int[] nums = {2,1,3,4,5}, result = {5, 1, 2, 3, 4};
//		assertThat(result).co(guessWordDisplay.cyclicRotate(nums));
	}

	@Test
	@DisplayName("Longest Zeros")
	public void shouldReturnHighestBitSequence()
	{
		assertEquals("Longest Zeros Match", 5,guessWordDisplay.longestZeros(1041));
	}

	@Test
	@DisplayName("Zero Bits Returned")
	public void shouldReturnZeroBitSequence()
	{
		assertEquals("Zero is returned",0, guessWordDisplay.longestZeros(32));
	}

	@Test
	@DisplayName("Testing Odd Occurrence in Array")
	public void shouldReturnOddOcurreence()
	{
		int[] nums = {2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2};
		assertEquals("Displaying the Odd Occurence", 5, guessWordDisplay.oddOccurrence(nums));
	}

	@Test
	@DisplayName("Testing Minimal Steps Required")
	public void shouldReturnMinStep()
	{
		assertEquals("Minimal Jumps required passed.", 3, guessWordDisplay.minJump(10, 85,30));
	}

	@Test
	@DisplayName("Missing Element")
	public void permMissingElemTest()
	{
		int nums[] = {2,3,1,5};
		assertEquals("Returning Missing Element", 4, guessWordDisplay.permMissingElem(nums));
	}

	@Test
	@DisplayName("Tape Equilibrium Test Specification")
	public void shouldReturnEquilibrium()
	{
		int[] nums = {3,1,1};
		assertEquals("Tape Equilibrium Matches",1, guessWordDisplay.tapeEquilibrium(nums) );
	}

	@Test
	@DisplayName("Should Return Earliest Time For Jumping")
	public void shouldFrogMoreOneTest()
	{
		int nums[] = {1,3,1,4,2,3,5,4};
		assertEquals("Validating FrogMore Earliest Time", 6, guessWordDisplay.frogMore(nums, 5));
	}

	@Test
	@DisplayName("Should Check For Permutation")
	public void shouldCheckPerm()
	{
		int[] nums = {4,1,3,2};
		assertEquals("Should Return 1 For Successful Check", 1, guessWordDisplay.permCheckSet(nums));
	}

	@Test
	@DisplayName("Testing Wrong PermCheck")
	public void shouldFailPermCheck()
	{
		int[] nums = {4,1,3};
		assertEquals("Should Return Failure ", 0, guessWordDisplay.permCheckSet(nums));
	}
}
