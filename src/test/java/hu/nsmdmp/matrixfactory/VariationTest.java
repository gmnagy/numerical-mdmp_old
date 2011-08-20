package hu.nsmdmp.matrixfactory;

import hu.nsmdmp.matrix.MatrixUtils;
import hu.nsmdmp.utils.Converters;

import org.apfloat.Apfloat;
import org.junit.Assert;
import org.junit.Test;

/**
 * Check variation of vector set.
 * 
 * @author nzcs
 * 
 */
public class VariationTest {

	@Test
	public void variationTest1() {
		double[][] vSet = { { 1, 2, 3, 4 }, { 0, 1, 2, 3 } };

		Apfloat[][] variation = Variation.createVariation(Converters.convert(vSet));
		double[][] expected = { { 1, 0 }, { 2, 0 }, { 3, 0 }, { 4, 0 }, { 1, 1 }, { 2, 1 }, { 3, 1 }, { 4, 1 }, { 1, 2 }, { 2, 2 }, { 3, 2 }, { 4, 2 }, { 1, 3 }, { 2, 3 }, { 3, 3 }, { 4, 3 } };

		if (!MatrixUtils.equals(Converters.convert(expected), variation)) {
			System.out.println(MatrixUtils.print(expected));
			System.err.println(MatrixUtils.print(variation));

			Assert.assertTrue(false);
		}
	}

	@Test
	public void variationTest2() {
		double[][] vSet = { { 0 - 4, 1 - 4, 2 - 4, 3 - 4 }, { 0, 1, 2, 3 } };

		Apfloat[][] variation = Variation.createVariation(Converters.convert(vSet));
		double[][] expected = { { -4, 0 }, { -3, 0 }, { -2, 0 }, { -1, 0 }, { -4, 1 }, { -3, 1 }, { -2, 1 }, { -1, 1 }, { -4, 2 }, { -3, 2 }, { -2, 2 }, { -1, 2 }, { -4, 3 }, { -3, 3 }, { -2, 3 },
				{ -1, 3 } };

		if (!MatrixUtils.equals(Converters.convert(expected), variation)) {
			System.out.println(MatrixUtils.print(expected));
			System.err.println(MatrixUtils.print(variation));

			Assert.assertTrue(false);
		}
	}

	@Test
	public void variationTest3() {
		double[][] vSet = { { 1, 2, 3 }, { 1, 2 }, { 5 }, { 6, 7 } };

		Apfloat[][] variation = Variation.createVariation(Converters.convert(vSet));
		double[][] expected = { { 1, 1, 5, 6 }, { 2, 1, 5, 6 }, { 3, 1, 5, 6 }, { 1, 2, 5, 6 }, { 2, 2, 5, 6 }, { 3, 2, 5, 6 }, { 1, 1, 5, 7 }, { 2, 1, 5, 7 }, { 3, 1, 5, 7 }, { 1, 2, 5, 7 },
				{ 2, 2, 5, 7 }, { 3, 2, 5, 7 } };

		if (!MatrixUtils.equals(Converters.convert(expected), variation)) {
			System.out.println(MatrixUtils.print(expected));
			System.err.println(MatrixUtils.print(variation));

			Assert.assertTrue(false);
		}
	}
}