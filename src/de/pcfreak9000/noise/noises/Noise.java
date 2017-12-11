package de.pcfreak9000.noise.noises;

public interface Noise {
	
	/**
	 * returns a value for the coordinates
	 * @param x
	 * @param y
	 * @return
	 */
	public double valueAt(double x, double y);
	
	/**
	 * returns a value for the coordinates
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 */
	public double valueAt(double x, double y, double z);
	
	/**
	 * returns a value for the coordinates
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @return
	 */
	public double valueAt(double x, double y, double z, double w);
	
}
