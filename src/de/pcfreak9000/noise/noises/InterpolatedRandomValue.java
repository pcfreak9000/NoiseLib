package de.pcfreak9000.noise.noises;

import java.util.Random;

/**
 * 
 * @author pcfreak9000
 *
 */
public class InterpolatedRandomValue implements Noise{

	private int seed = 0;
	private Random r = new Random();
	private double xfactor=10000;//86758;
	private double yfactor=10000;//42356;
	
	/**
	 * a simple noise
	 * 
	 * @param seed
	 */
	public InterpolatedRandomValue(int seed) {
		this.seed = seed;
	}

	
	public InterpolatedRandomValue(){
		this(new Random().nextInt());
	}
	
	/**
	 * the value for xy
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	double getValue(double x, double y) {
		return getInterpolated(x, y);
	}

	private double getInterpolated(double x, double y){
		long lx = (long) x;
		long ly = (long) y;
		double fracx = x- lx;
		double fracy = y - ly;
		
		double v1 = getSmoothRaw(lx, ly);
		double v2 = getSmoothRaw(lx + 1, ly);
		double v3 = getSmoothRaw(lx, ly + 1);
		double v4 = getSmoothRaw(lx + 1, ly + 1);
		double i1 = interpolate(v1, v2, fracx);
		double i2 = interpolate(v3, v4, fracx);
		return interpolate(i1, i2, fracy);
	}
	
	private double getSmoothRaw(double x, double y) {
		double corners = (getRaw(x - 1, y - 1) + getRaw(x + 1, y - 1) + getRaw(x - 1, y + 1) + getRaw(x + 1, y + 1))
				/ 16f;
		double sides = (getRaw(x - 1, y) + getRaw(x + 1, y) + getRaw(x, y + 1) + getRaw(x, y - 1)) / 8f;
		double center = getRaw(x, y)/4f;
		return (corners + sides + center);
	}

	private double getRaw(double x, double y) {
		r.setSeed(Math.round(x * xfactor + y * yfactor + seed));
		return r.nextDouble()*2.0-1.0;
	}
	
	private double interpolate(double a, double b, double blend){
		double theta = blend * Math.PI;
		double f = (1.0 - Math.cos(theta)) * 0.5;
		return a * (1.0 - f) + b * f;
	}
	
	
	public void setXFactor(double xf){
		this.xfactor=xf;
	}
	
	public void setYFactor(double yf){
		this.yfactor = yf;
	}


	@Override
	public double valueAt(double x, double y) {
		return getValue(x, y);
	}


	/**
	 * ignores z
	 */
	@Override
	public double valueAt(double x, double y, double z) {
		return getValue(x, y);
	}


	/**
	 * ignores z and w
	 */
	@Override
	public double valueAt(double x, double y, double z, double w) {
		return getValue(x, y);
	}
}
