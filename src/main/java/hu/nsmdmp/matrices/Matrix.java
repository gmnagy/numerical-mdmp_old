package hu.nsmdmp.matrices;

import org.apfloat.Apfloat;

public final class Matrix {

	public static SimpleMatrix getSimpleMatrix(final Apfloat[][] vectorSet, final int moment) {
		SimpleMatrix matrix = new SimpleMatrix();
		matrix.create(vectorSet, moment);

		return matrix;
	}

	public static NormalizedMatrix getNormalizedMatrix(final Apfloat[][] vectorSet, final int moment) {
		NormalizedMatrix matrix = new NormalizedMatrix();
		matrix.create(vectorSet, moment);

		return matrix;
	}

	public static ChebyshevTMatrix getChebyshevTMatrix(final Apfloat[][] vectorSet, final int moment) {
		ChebyshevTMatrix matrix = new ChebyshevTMatrix();
		matrix.create(vectorSet, moment);

		return matrix;
	}

	public static ChebyshevUMatrix getChebyshevUMatrix(final Apfloat[][] vectorSet, final int moment) {
		ChebyshevUMatrix matrix = new ChebyshevUMatrix();
		matrix.create(vectorSet, moment);

		return matrix;
	}
}