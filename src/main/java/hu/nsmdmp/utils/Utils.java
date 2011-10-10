package hu.nsmdmp.utils;

import hu.nsmdmp.matrix.Matrix;

import java.util.Collection;
import java.util.Iterator;

import org.apfloat.Apfloat;

public final class Utils {

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

		sb.deleteCharAt(sb.length() - 1);

		return sb.toString();
	}

	public static String print(final Apfloat[] v) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");

		for (int i = 0; i < v.length; i++) {
			if (i < v.length - 1) {
				sb.append(String.format("%s, ", v[i]));
			} else {
				sb.append(String.format("%s", v[i]));
			}
		}

		sb.append("}");

		return sb.toString();
	}

	public static String print(final double[][] m) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < m.length; i++) {
			sb.append("{");
			for (int j = 0; j < m[i].length; j++) {
				if (j < m[i].length - 1) {
					sb.append(String.format("%s, ", m[i][j]));
				} else {
					sb.append(String.format("%s}\n", m[i][j]));
				}
			}
		}

		return sb.toString();
	}

	public static String print(final int[][] m) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < m.length; i++) {
			sb.append("{");
			for (int j = 0; j < m[i].length; j++) {
				if (j < m[i].length - 1) {
					sb.append(String.format("%s, ", m[i][j]));
				} else {
					sb.append(String.format("%s}\n", m[i][j]));
				}
			}
		}

		return sb.toString();
	}

	public static String print(final double[] v) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");

		for (int i = 0; i < v.length; i++) {
			if (i < v.length - 1) {
				sb.append(String.format("%s, ", v[i]));
			} else {
				sb.append(String.format("%s", v[i]));
			}
		}

		sb.append("}");

		return sb.toString();
	}

	public static String print(final int[] v) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");

		for (int i = 0; i < v.length; i++) {
			if (i < v.length - 1) {
				sb.append(String.format("%s, ", v[i]));
			} else {
				sb.append(String.format("%s", v[i]));
			}
		}

		sb.append("}");

		return sb.toString();
	}

	public static boolean equals(final Apfloat[][] a, final Apfloat[][] b) {

		if (a.length != b.length) {
			return false;
		}

		for (int i = 0; i < a.length; i++) {
			if (a[i].length != b[i].length) {
				return false;
			}

			for (int j = 0; j < a[i].length; j++) {
//				System.out.println(String.format("[%d, %d] %s != %s", i, j, a[i][j], b[i][j]));
				if (!a[i][j].equals(b[i][j])) {
					System.err.println(String.format("[%d, %d] %s != %s", i, j, a[i][j], b[i][j]));
					return false;
				}
			}
		}

		return true;
	}

	public static boolean equals(final Apfloat[] a, final Apfloat[] b) {

		if (a.length != b.length) {
			return false;
		}

		for (int i = 0; i < a.length; i++) {
			if (!a[i].equals(b[i])) {
				System.err.println(String.format("%s != %s", a[i], b[i]));

				return false;
			}
		}

		return true;
	}

	public static boolean equals(final double[][] a, final double[][] b) {

		if (a.length != b.length) {
			return false;
		}

		for (int i = 0; i < a.length; i++) {
			if (a[i].length != b[i].length) {
				return false;
			}

			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] != b[i][j]) {
					System.err.println(String.format("[%d, %d] %s != %s", i, j, a[i][j], b[i][j]));
					return false;
				}
			}
		}

		return true;
	}

	public static boolean equals(final int[][] a, final int[][] b) {
		if (a.length != b.length) {
			return false;
		}

		for (int i = 0; i < a.length; i++) {
			if (a[i].length != b[i].length) {
				return false;
			}

			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] != b[i][j]) {
					System.err.println(String.format("[%d, %d] %s != %s", i, j, a[i][j], b[i][j]));
					return false;
				}
			}
		}

		return true;
	}

	public static boolean equals(final double[] a, final double[] b) {

		if (a.length != b.length) {
			return false;
		}

		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				System.err.println(String.format("%s != %s", a[i], b[i]));

				return false;
			}
		}

		return true;
	}

	public static boolean equals(final Matrix A, final Matrix B) {
		return equals(A.getArray(), B.getArray());
	}

	public static <T> boolean equals(final Collection<T> a, final Collection<T> b) {
		if (a.size() != b.size()) {
			return false;
		}

		Iterator<T> ita = a.iterator();
		Iterator<T> itb = b.iterator();

		while (ita.hasNext()) {
			if (!ita.next().equals(itb.next())) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Convert an array of strings to one string. Put the 'separator' string between each element.
	 * 
	 */
	public static String arrayToString(int[] a, String separator) {
		StringBuffer result = new StringBuffer();
		if (a.length > 0) {
			result.append(a[0]);
			for (int i = 1; i < a.length; i++) {
				result.append(separator);
				result.append(a[i]);
			}
		}
		return result.toString();
	}
}