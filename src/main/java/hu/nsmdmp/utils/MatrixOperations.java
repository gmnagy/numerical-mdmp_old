package hu.nsmdmp.utils;

import org.apfloat.Apfloat;

public class MatrixOperations {

	public static final Apfloat ZERO = new Apfloat(0, Precision.SCALE);

	public static final Apfloat ONE = new Apfloat(1, Precision.SCALE);

	public static final Apfloat TWO = new Apfloat(2, Precision.SCALE);

	public static void normalize(final Apfloat[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {

			Apfloat min = ZERO;
			Apfloat max = ZERO;

			for (int j = 0; j < matrix[i].length; j++) {
				Apfloat x = matrix[i][j];

				if (x.compareTo(min) < 0) {
					min = x;
				}

				if (x.compareTo(max) > 0) {
					max = x;
				}
			}

			// (min + max) / 2;
			Apfloat mid = min.add(max).divide(TWO);

			for (int j = 0; j < matrix[i].length; j++) {

				// 2 * (vSet[i][j] - mid)
				Apfloat a = matrix[i][j].subtract(mid).multiply(TWO);

				// max - min
				Apfloat b = max.subtract(min);

				// a / b
				matrix[i][j] = a.divide(b);
			}
		}
	}

	public static String print(final Apfloat[][] m) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < m.length; i++) {
			sb.append("{");
			for (int j = 0; j < m[i].length; j++) {
				if (j < m[i].length - 1) {
					sb.append(String.format("%s, ", m[i][j]));
				} else {
					sb.append(String.format("%s", m[i][j]));
				}
			}
			sb.append("}\n");
		}

		return sb.toString();
	}
}
