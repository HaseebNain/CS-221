import java.io.FileNotFoundException;

/**
 * Console app to test TopoMap class for TopoMap_Part1
 * @author mvail
 */
public class TopoMapTest {
	private int passes = 0;
	private int failures = 0;
	private int total = 0;
	
	private static final double TOLERANCE = Math.pow(10, -14);

	/** @param args not used */
	public static void main(String[] args) {
		TopoMapTest tester = new TopoMapTest(); //to avoid every method being static
		tester.runTests();
	}
	
	/** Run tests on TopoMap constructor and expected methods */
	private void runTests() {
		//////////////////////////////////////////////////////////////////
		// run tests on all interface methods to confirm correct results
		// and behavior under normal and exceptional use cases
		//////////////////////////////////////////////////////////////////
		printTest("topoMapBaseInterfaceTest", topoMapBaseInterfaceTest());
		printTest("loadSampleMapTest", loadSampleMapTest());
		printTest("getBaseSampleMapTest", getBaseSampleMapTest());
		printTest("getBaseMinSampleMapTest", getBaseMinSampleMapTest());
		printTest("getBaseMaxSampleMapTest", getBaseMaxSampleMapTest());
		printTest("getBaseAvgSampleMapTest", getBaseAvgSampleMapTest());
		printTest("getSurroundingElevationsSampleMapTest", getSurroundingElevationsSampleMapTest());
		printTest("fourByFiveTest", fourByFiveTest());
		printTest("lameToStringTest", lameToStringTest());
		// testing toString() is a little challenging because unit tests should
		// be automated such that no user evaluation is necessary to determine
		// if a test has succeeded or failed - need to compare toString() output
		// to expected output

		//TODO: add tests for a second valid map that differs from
		// sampleMap.txt by not having identical row and column dimensions
		
		printTest("invalidMapTest", invalidMapTest());
		printTest("noSuchMapTest", noSuchMapTest());
		
		/////////////////
		//final verdict
		/////////////////
		printFinalSummary();
	}
		
	/** Confirm that TopoMap implements TopoMapBaseInterface */
	private boolean topoMapBaseInterfaceTest() {
		boolean success = true;
		
		try {
			TopoMap tmap = null;
			//if TopoMap does not implement TopoMapBaseInterface, the following
			// invalid assignment will prevent the test class from even compiling
			TopoMapBaseInterface tmapInterface = tmap;
		} catch (Exception e) {
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** Call TopoMap constructor with "sampleMap.txt" */
	private boolean loadSampleMapTest() {
		final String testFile = "sampleMap.txt";
		boolean success = true;
		
		try {			
			TopoMap tmap = new TopoMap(testFile); //should load without Exception
		} catch (Exception e) {
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** Compare map from getBaseMap() to expected map from "sampleMap.txt" */
	private boolean getBaseSampleMapTest() {
		final double[][] expectedMap = {
			{2, 10, 7},
			{4, 5, 8},
			{5, 6, 9}};
		final String testFile = "sampleMap.txt";
		boolean success = true;
		
		try {			
			TopoMap tmap = new TopoMap(testFile);

			if(!equivalentMapArrays(expectedMap, tmap.getBaseMap())) {
				success = false;
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** Compare result from getBaseMin() to expected minimum value from "sampleMap.txt" */
	private boolean getBaseMinSampleMapTest() {
		final String testFile = "sampleMap.txt";
		final double baseMin = 2;
		boolean success = true;
		
		try {			
			TopoMap tmap = new TopoMap(testFile);
			
			double result = tmap.getBaseMin();

			if(!isClose(baseMin, result)) {
				System.out.printf("getBaseMin(): expected = %f, result = %f\b", baseMin, result);
				success = false;
			}			
		} catch (Exception e) {
			System.out.println("getBaseMinSampleMapTest: no Exception expected");
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** Compare result from getBaseMax() to expected maximum value from "sampleMap.txt" */
	private boolean getBaseMaxSampleMapTest() {
		final String testFile = "sampleMap.txt";
		final double baseMax = 10;
		boolean success = true;
		
		try {			
			TopoMap tmap = new TopoMap(testFile);
			
			double result = tmap.getBaseMax();

			if(!isClose(baseMax, result)) {
				System.out.printf("getBaseMax(): expected = %f, result = %f\b", baseMax, result);
				success = false;
			}			
		} catch (Exception e) {
			System.out.println("getBaseMaxSampleMapTests: no Exception expected");
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** Compare result from getBaseAvg() to expected average value from "sampleMap.txt" */
	private boolean getBaseAvgSampleMapTest() {
		final String testFile = "sampleMap.txt";
		final double baseAvg = 6.222222222222222;
		boolean success = true;
		
		try {			
			TopoMap tmap = new TopoMap(testFile);
			
			double result = tmap.getBaseAvg();

			if(!isClose(baseAvg, result)) {
				System.out.printf("getBaseAvg(): expected = %f, result = %f\b", baseAvg, result);
				success = false;
			}			
		} catch (Exception e) {
			System.out.println("getBaseMaxSampleMapTests: no Exception expected");
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** Compare result from getSurroundingElevationsMap() to expected map for "sampleMap.txt" */
	private boolean getSurroundingElevationsSampleMapTest() {
		final double[][] expectedMap = {
			{18, 24, 32}, 
			{16, 28, 29}, 
			{20, 25, 32}};
		final String testFile = "sampleMap.txt";
		boolean success = true;
		
		try {			
			TopoMap tmap = new TopoMap(testFile);
			
			if(!equivalentMapArrays(expectedMap, tmap.getSurroundingElevationsMap())) {
				success = false;
			}
		} catch (Exception e) {
			System.out.println("getSurroundingElevationsMapSampleMapTests: no Exception expected");
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}
	
	/** Compare result from getSurroundingElevationsMap() to expected map for "sampleMap.txt" */
	private boolean fourByFiveTest() {
		final double[][] expectedMap = {
			{9, 21, 24, 25, 20	}, 
			{20, 20, 31, 26, 23	}, 
			{17, 28, 29, 30, 25	},
			{17, 22, 30, 31, 28	}};
		final String testFile = "sampleMap4x5.txt";
		boolean success = true;
		
		try {			
			TopoMap tmap = new TopoMap(testFile);
			
			if(!equivalentMapArrays(expectedMap, tmap.getSurroundingElevationsMap())) {
				success = false;
			}
		} catch (Exception e) {
			System.out.println("getSurroundingElevationsMapSampleMapTests: no Exception expected");
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** Exercise toString() after loading "sampleMap.txt" */
	private boolean lameToStringTest() {
		final String testFile = "sampleMap.txt";
		boolean success = true;
		
		try {			
			TopoMap tmap = new TopoMap(testFile);

			String str = tmap.toString();
			System.out.printf("toString() output:\n%s\n", str);
			if(str.length() == 0 || str.startsWith("TopoMap@")) {
				success = false;
			}
		} catch (Exception e) {
			System.out.println("lameToStringTest: no Exception expected");
			e.printStackTrace(System.out);
			success = false;
		}
		return success;
	}

	/** Confirm that InvalidFileFormatException is thrown when TopoMap constructor called with "invalidMap.txt" */
	private boolean invalidMapTest() {
		final String testFile = "invalidMap.txt";
		boolean success = true;
		
		try {			
			TopoMap tmap = new TopoMap(testFile);
			System.out.println("invalidMapTest: InvalidFileFormatException expected");
			success = false;
		} catch (InvalidFileFormatException iffe) {
			System.out.println(iffe.getMessage());
		} catch (Exception e) {	//We expect a specific exception
			System.out.println("invalidMapTest: InvalidFileFormatException expected");
			System.out.println(e.getMessage());
			success = false;
		}
		return success;
	}

	/** Confirm that FileNotFoundException is thrown when TopoMap constructor is called with "noSuchMap.txt" */
	private boolean noSuchMapTest() {
		final String testFile = "noSuchMap.txt";
		boolean success = true;
		
		try {			
			TopoMap tmap = new TopoMap(testFile);
			System.out.println("noSuchMapTest: FileNotFoundException expected");
			success = false;
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {	//We expect a specific exception
			System.out.println("noSuchMapTest: FileNotFoundException expected");
			e.printStackTrace(System.out);
			success = false;
		}
		System.out.println();
		return success;
	}

	/** Print test results in a consistent format
	 * @param testDesc description of the test
	 * @param result indicates if the test passed or failed
	 */
	private void printTest(String testDesc, boolean result) {
		total++;
		if (result) {
			passes++;
		} else {
			failures++;
		}
		System.out.printf("%-46s\t%s\n", testDesc, (result ? "   PASS" : "***FAIL***"));
	}

	/** Print a final summary */
	private void printFinalSummary() {
		System.out.printf("\nTotal Tests: %d,  Passed: %d,  Failed: %d\n", total, passes, failures);
	}
	
	/** Compare two doubles and return true if they are within TOLERANCE, else false
	 * @param v1 first value to compare
	 * @param v2 second value to compare
	 * @return true if v1 and v2 are within TOLERANCE, else false
	 */
	private boolean isClose(double v1, double v2) {
		return (Math.abs(v1 - v2) < TOLERANCE);
	}

	/** Compare two two-dimensional double arrays for equivalence.
	 * @param a1 first double[][]
	 * @param a2 second double[][]
	 * @return true if all values in a1 and a2 are within the given tolerance, else false
	 */
	private boolean equivalentMapArrays(double[][] a1, double[][] a2) {
		boolean equivalent = true;
		if (a1.length != a2.length || (a1.length > 1 && a1[0].length != a2[0].length)) {
			equivalent = false;
		} else {
			for (int row = 0; row < a1.length; row++) {
				for (int col = 0; col < a1[0].length; col++) {
					if (row >= a2.length || a1[row].length != a2[row].length) {
						equivalent = false;
					} else {
						if (!isClose(a1[row][col],  a2[row][col])) {
							equivalent = false;
						}
					}
				}
			}
		}
		return equivalent;
	}
}
