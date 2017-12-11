package de.pcfreak9000.noise.components;

import de.pcfreak9000.noise.noises.Noise;

public class Clamper implements Noise{

	private Noise noise;
	private double max=1;
	private double min=-1;
	
	public Clamper(Noise noise){
		this.noise = noise;
	}
	
	public Noise getNoise(){
		return noise;
	}
	
	public Clamper setMax(double m){
		this.max = m;
		return this;
	}
	
	public Clamper setMin(double m){
		this.min = m;
		return this;
	}
	
	
	public double getMax(){
		return max;
	}
	
	public double getMin(){
		return min;
	}
	
	@Override
	public double valueAt(double x, double y) {
		return clamp(noise.valueAt(x, y));
	}

	@Override
	public double valueAt(double x, double y, double z) {
		return clamp(noise.valueAt(x, y, z));
	}

	@Override
	public double valueAt(double x, double y, double z, double w) {
		return clamp(noise.valueAt(x, y, z, w));
	}
	
	private double clamp(double d){
		if(d>=max){
			return max;
		}
		if(d<=min){
			return min;
		}
		return d;
	}

}
