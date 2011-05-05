package hu.nsmdmp.mosek;

import hu.nsmdmp.matrixmath.MatrixMath;

import org.apfloat.Apfloat;

public final class SparseMatrix {

	/**
	 * Contains the non-zero values.
	 */
	double[][] aval;

	/**
	 * Contains the row index of these non-zeros.
	 */
	int[][] asub;

	SparseMatrix(final Apfloat[][] matrix) {
		assign(matrix);
	}

	private void assign(final Apfloat[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		aval = new double[n][0];
		asub = new int[n][0];

		for (int j = 0; j < n; j++) {
			for (int i = 0; i < m; i++) {
				if (MatrixMath.ZERO.compareTo(matrix[i][j]) != 0) {
					int s = aval[j].length;

					double[] a = new double[s + 1];
					System.arraycopy(aval[j], 0, a, 0, s);
					aval[j] = a;
					aval[j][s] = matrix[i][j].doubleValue();

					int[] b = new int[s + 1];
					System.arraycopy(asub[j], 0, b, 0, s);
					asub[j] = b;
					asub[j][s] = i;
				}
			}
		}
	}
}