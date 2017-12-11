package de.pcfreak9000.noise.main;

import de.pcfreak9000.noise.noises.Noise;

/**
 * connect multiple noise functions
 * @author pcfreak9000
 *
 */
public class NoiseGroup implements Noise{
	
	private Noise[] noises;
	private NoiseInstanceInformation info;
	private boolean usesWeightInfo=false;
	
	
	public NoiseGroup(Noise... noises){
		this(null, noises);
	}
	
	public NoiseGroup(NoiseInstanceInformation info, Noise... noises){
		this.noises = noises;
		this.info = info;
		usesWeightInfo = info != null;
		if(info!=null&&info.usesIndividualWeightsFactors()&&info.getWeightFactors().length<noises.length){
			throw new IllegalArgumentException("Not enough weightfactors!");
		}
	}
	
	double get(double x, double y){
		double ret = 0;
		double totalweight = 0;
		double thisweight = 1;
		NoiseGroupCalculator mycalcer = usesWeightInfo&&info.usesNoiseGroupCalculator()?info.getNoiseGroupCalculator():NoiseGroupCalculator.DEFAULT_NOISEGROUPCALCULATOR;
		mycalcer.refresh();
		for(int i=0; i<noises.length; i++){
			if(noises[i]!=null){
				if(usesWeightInfo){
					if(info.usesIndividualWeightsFactors()){
						thisweight = info.getWeightFactors()[i];
					}else if(info.usesWeightCalculator()){
						thisweight = info.getWeightFacCalculator().calcWeight(i, x, y, ret, totalweight, noises[i]);
					}
				}else{
					thisweight = 1;
				}
				ret = mycalcer.valueFor(ret, noises[i].valueAt(x, y), thisweight, noises[i], i);
				totalweight += thisweight;
			}
		}
		return mycalcer.finalValue(ret, totalweight);
	}
	
	double get(double x, double y, double z){
		double ret = 0;
		double totalweight = 0;
		double thisweight = 1;
		NoiseGroupCalculator mycalcer = usesWeightInfo&&info.usesNoiseGroupCalculator()?info.getNoiseGroupCalculator():NoiseGroupCalculator.DEFAULT_NOISEGROUPCALCULATOR;
		mycalcer.refresh();
		for(int i=0; i<noises.length; i++){
			if(noises[i]!=null){
				if(usesWeightInfo){
					if(info.usesIndividualWeightsFactors()){
						thisweight = info.getWeightFactors()[i];
					}else if(info.usesWeightCalculator()){
						thisweight = info.getWeightFacCalculator().calcWeight(i, x, y, z, ret, totalweight, noises[i]);
					}
				}else{
					thisweight = 1;
				}
				ret = mycalcer.valueFor(ret, noises[i].valueAt(x, y, z), thisweight, noises[i], i);
				totalweight += thisweight;
			}
		}
		return mycalcer.finalValue(ret, totalweight);
	}
	
	double get(double x, double y, double z, double w){
		double ret = 0;
		double totalweight = 0;
		double thisweight = 1;
		NoiseGroupCalculator mycalcer = usesWeightInfo&&info.usesNoiseGroupCalculator()?info.getNoiseGroupCalculator():NoiseGroupCalculator.DEFAULT_NOISEGROUPCALCULATOR;
		mycalcer.refresh();
		for(int i=0; i<noises.length; i++){
			if(noises[i]!=null){
				if(usesWeightInfo){
					if(info.usesIndividualWeightsFactors()){
						thisweight = info.getWeightFactors()[i];
					}else if(info.usesWeightCalculator()){
						thisweight = info.getWeightFacCalculator().calcWeight(i, x, y, z, w, ret, totalweight, noises[i]);
					}
				}else{
					thisweight = 1;
				}
				ret = mycalcer.valueFor(ret, noises[i].valueAt(x, y, z, w), thisweight, noises[i], i);
				totalweight += thisweight;
			}
		}
		return mycalcer.finalValue(ret, totalweight);
	}

	@Override
	public double valueAt(double x, double y) {
		return get(x, y);
	}

	@Override
	public double valueAt(double x, double y, double z) {
		return get(x, y, z);
	}

	@Override
	public double valueAt(double x, double y, double z, double w) {
		return get(x, y, z, w);
	}
	
	public Noise[] getNoises(){
		return noises;
	}
	
}
