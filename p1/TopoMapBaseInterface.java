/*
 * TopoMapBaseInterface.java
 * Part of TopoMap Enhancement Project: Part 1
 * COMPSCI 221
 */

/**
 * Interface required for a class that can read in a two-dimensional array of doubles
 * (the base map) and calculate the sums of surrounding elevations for each original
 * array element.
 * 
 * @author mvail
 */
public interface TopoMapBaseInterface {

	/**
	 * @return the base map's minimum value
	 */
	public double getBaseMin();
	/**
	 * @return the base map's maximum value
	 */
	public double getBaseMax();
	/**
	 * @return the base map's average value
	 */
	public double getBaseAvg();
	/**
	 * @return base map
	 */
	public double[][] getBaseMap();
	
	/**
	 * Returns a map with the same dimensions as the base map, but each element
	 * is the sum of the 4 surrounding positions in the base map (with edges
	 * "mirrored"). This method is public, for testing purposes, but will be
	 * made a private utility method in the final TopoMap class.
	 * 
	 * @return map containing sums of surrounding elevations
	 */
	public double[][] getSurroundingElevationsMap();
}
