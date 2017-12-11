package de.pcfreak9000.noise.main;

public class NoiseInstanceInformation {
	
	private double[] weightfactors;
	private WeightFactorCalculator calcer;
	private NoiseGroupCalculator calcer2;
	
	public void setWeightFactors(double[] f){
		this.weightfactors = f;
	}
	
	public double[] getWeightFactors(){
		return weightfactors;
	}
	
	public boolean usesIndividualWeightsFactors(){
		return weightfactors != null && weightfactors.length>0;
	}
	
	public void setWeightCalculator(WeightFactorCalculator w){
		this.calcer = w;
	}
	
	public WeightFactorCalculator getWeightFacCalculator(){
		return calcer;
	}
	
	public boolean usesWeightCalculator(){
		return calcer!=null;
	}
	
	public void setNoiseGroupCalculator(NoiseGroupCalculator w){
		this.calcer2 = w;
	}
	
	public NoiseGroupCalculator getNoiseGroupCalculator(){
		return calcer2;
	}
	
	public boolean usesNoiseGroupCalculator(){
		return calcer2!=null;
	}
}
