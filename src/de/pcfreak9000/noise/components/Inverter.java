package de.pcfreak9000.noise.components;

import de.pcfreak9000.noise.noises.Noise;

public class Inverter implements Noise{
	
	private Noise noise;
	
	public Inverter(Noise invert){
		this.noise = invert;
		if(noise==this){
			throw new IllegalArgumentException("Can't use myself!");
		}
	}

	@Override
	public double valueAt(double x, double y) {
		return invert(noise.valueAt(x, y));
	}

	@Override
	public double valueAt(double x, double y, double z) {
		return invert(noise.valueAt(x, y, z));
	}

	@Override
	public double valueAt(double x, double y, double z, double w) {
		return invert(noise.valueAt(x, y, z, w));
	}
	
	
	private double invert(double d){
		return d*-1;
	}
}
