package de.pcfreak9000.noise.main;

import de.pcfreak9000.noise.noises.Noise;

public interface WeightFactorCalculator {
	
	public double calcWeight(int currentNoiseIndex, double x, double y, double z, double w, double curCompleteValue, double curCompleteWeight, Noise curnoise);
	
	public double calcWeight(int currentNoiseIndex, double x, double y, double z, double curCompleteValue, double curCompleteWeight, Noise curnoise);

	public double calcWeight(int currentNoiseIndex, double x, double y, double curCompleteValue, double curCompleteWeight, Noise curnoise);
	
	
	public static final WeightFactorCalculator WEIGHT_IS_INDEX_POWER_OF_TWO = new WeightFactorCalculator() {
		
		@Override
		public double calcWeight(int currentNoiseIndex, double x, double y, double curCompleteValue,
				double curCompleteWeight, Noise curnoise) {
			return Math.pow(2, currentNoiseIndex);
		}
		
		@Override
		public double calcWeight(int currentNoiseIndex, double x, double y, double z, double curCompleteValue,
				double curCompleteWeight, Noise curnoise) {
			return Math.pow(2, currentNoiseIndex);
		}
		
		@Override
		public double calcWeight(int currentNoiseIndex, double x, double y, double z, double w, double curCompleteValue,
				double curCompleteWeight, Noise curnoise) {
			return Math.pow(2, currentNoiseIndex);
		}
	};
}
