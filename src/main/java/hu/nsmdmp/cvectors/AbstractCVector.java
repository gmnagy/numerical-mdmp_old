package hu.nsmdmp.cvectors;

import org.apfloat.Apfloat;

public abstract class AbstractCVector implements ICVector {

	private Apfloat[] cVectorA;

	private double[] cVectorD;

	void create(final Apfloat[][] variations) {
		int n = variations.length;

		cVectorA = new Apfloat[n];
		cVectorD = new double[n];

		for (int i = 0; i < n; i++) {
			Apfloat d = function(variations[i]);
			cVectorA[i] = d;
			cVectorD[i] = d.doubleValue();
		}
	}

	abstract Apfloat function(final Apfloat[] variation);

	@Override
	public Apfloat[] getCVectorA() {
		return cVectorA;
	}

	@Override
	public double[] getCVectorD() {
		return cVectorD;
	}
}
