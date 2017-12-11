package de.pcfreak9000.noise.main;

import de.pcfreak9000.noise.noises.Noise;

public interface NoiseGroupCalculator {
	
	public void refresh();
	
	public double valueFor(double oldvalue, double addvalue, double weightf, Noise using, int index);
	
	public double finalValue(double value, double allweights);
	
	public static final NoiseGroupCalculator DEFAULT_NOISEGROUPCALCULATOR = new NoiseGroupCalculator() {
		
		@Override
		public double valueFor(double oldvalue, double addvalue, double weightf, Noise used, int index) {
			return oldvalue+addvalue*weightf;
		}
		
		@Override
		public double finalValue(double value, double allweights) {
			return value/allweights;
		}

		@Override
		public void refresh() {			
		}
	};
	
}
