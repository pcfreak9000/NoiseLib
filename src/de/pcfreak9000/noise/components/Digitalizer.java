package de.pcfreak9000.noise.components;

import de.pcfreak9000.noise.noises.Noise;

/**
 * returns +1 if the value >= the threshhold otherwise -1
 * @author pcfreak9000
 *
 */
public class Digitalizer implements Noise{
	
	private Noise noise;
	private double threshhold=0;
	
	public Digitalizer(Noise n){
		this.noise = n;
		if(noise==this){
			throw new IllegalArgumentException("Can't use myself!");
		}
	}
	
	@Override
	public double valueAt(double x, double y) {
		return calc(noise.valueAt(x, y));
	}

	@Override
	public double valueAt(double x, double y, double z) {
		return calc(noise.valueAt(x, y, z));
	}

	@Override
	public double valueAt(double x, double y, double z, double w) {
		return calc(noise.valueAt(x, y, z, w));
	}
	
	private double calc(double v){
		return v>=threshhold?+1:-1;
	}
	
	public Digitalizer setThreshhold(double t){
		this.threshhold = t;
		return this;
	}
	
	public Noise getDigitalizedNoise(){
		return noise;
	}
}
