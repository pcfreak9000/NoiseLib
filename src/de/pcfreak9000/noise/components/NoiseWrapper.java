package de.pcfreak9000.noise.components;

import de.pcfreak9000.noise.noises.Noise;

/**
 * adjust the given noise function with this class
 * @author pcfreak9000
 *
 */
public class NoiseWrapper implements Noise{
	
	private Noise noise;
	
	private double[] scales = new double[]{1,1,1,1};
	private double[] offsets = new double[]{0,0,0,0};
	
	public NoiseWrapper(Noise towrap){
		noise = towrap;
		if(noise==this){
			throw new IllegalArgumentException("Can't use myself!");
		}
	}
	
	
	@Override
	public double valueAt(double x, double y) {
		return noise.valueAt((x+offsets[0])*scales[0], (y+offsets[1])*scales[1]);
	}

	@Override
	public double valueAt(double x, double y, double z) {
		return noise.valueAt((x+offsets[0])*scales[0], (y+offsets[1])*scales[1], (z+offsets[2])*scales[2]);
	}

	@Override
	public double valueAt(double x, double y, double z, double w) {
		return noise.valueAt((x+offsets[0])*scales[0], (y+offsets[1])*scales[1], (z+offsets[2])*scales[2], (w+offsets[3])*scales[3]);
	}
	
	public NoiseWrapper setXScale(double xs){
		scales[0] = xs;
		return this;
	}
	
	public NoiseWrapper setYScale(double ys){
		scales[1] = ys;
		return this;
	}
	
	public NoiseWrapper setZScale(double zs){
		scales[2] = zs;
		return this;
	}
	
	public NoiseWrapper setWScale(double ws){
		scales[3] = ws;
		return this;
	}
	
	public NoiseWrapper setXOffset(double xo){
		offsets[0] = xo;
		return this;
	}
	
	public NoiseWrapper setYOffset(double yo){
		offsets[1] = yo;
		return this;
	}
	
	public NoiseWrapper setZOffset(double zo){
		offsets[2] = zo;
		return this;
	}
	
	public NoiseWrapper setWOffset(double wo){
		offsets[3] = wo;
		return this;
	}
	
	public double[] getOffsets(){
		return offsets;
	}
	
	public double[] getScales(){
		return scales;
	}
	
	public Noise getWrappedNoise(){
		return noise;
	}
}
