package hu.nsmdmp.moments;

import hu.nsmdmp.ApfloatUtils;
import hu.nsmdmp.utils.IOFile;
import hu.nsmdmp.utils.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apfloat.Apfloat;
import org.junit.Assert;
import org.junit.Test;

public class MultivariateMomentsTest {

	/**
	 * n=4. m=2. Dimensional = 1.
	 * 
	 */
	@Test
	public void testCreateBinomialMoments1() throws IOException {
		Apfloat[] probabilities = IOFile.read("prob.txt");

		List<Moment> binomMoms = MultivariateMoments.createBinomialMoments(probabilities, 4, 2, 1);

		List<Moment> expected = new ArrayList<Moment>();
		expected.add(new Moment(new int[] { 0 }, ApfloatUtils.ONE));
		expected.add(new Moment(new int[] { 1 }, ApfloatUtils.valueOf(1.059)));
		expected.add(new Moment(new int[] { 2 }, ApfloatUtils.valueOf(1.271)));

		if (!Utils.equals(expected, binomMoms)) {
			System.out.println(expected);
			System.err.println(binomMoms);

			Assert.assertTrue(false);
		}
	}

	/**
	 * n=4. m=2. Dimensional = 2.
	 * 
	 */
	@Test
	public void testCreateBinomialMoments2() throws IOException {
		Apfloat[] probabilities = IOFile.read("prob.txt");

		List<Moment> binomMoms = MultivariateMoments.createBinomialMoments(probabilities, 4, 2, 2);

		List<Moment> expected = new ArrayList<Moment>();
		expected.add(new Moment(new int[] { 0, 0 }, ApfloatUtils.ONE));
		expected.add(new Moment(new int[] { 1, 0 }, ApfloatUtils.valueOf(0.597)));
		expected.add(new Moment(new int[] { 2, 0 }, ApfloatUtils.valueOf(0.224)));
		expected.add(new Moment(new int[] { 0, 1 }, ApfloatUtils.valueOf(0.462)));
		expected.add(new Moment(new int[] { 1, 1 }, ApfloatUtils.valueOf(0.897)));
		expected.add(new Moment(new int[] { 0, 2 }, ApfloatUtils.valueOf(0.15)));

		if (!Utils.equals(expected, binomMoms)) {
			System.out.println(expected);
			System.err.println(binomMoms);

			Assert.assertTrue(false);
		}
	}

	/**
	 * n=6. m=3. Dimensional = 2.
	 * 
	 */
	@Test
	public void testCreateBinomialMoments3() throws IOException {
		Apfloat[] probabilities = IOFile.read("prob.txt");

		List<Moment> binomMoms = MultivariateMoments.createBinomialMoments(probabilities, 6, 3, 2);

		List<Moment> expected = new ArrayList<Moment>();
		expected.add(new Moment(new int[] { 0, 0 }, ApfloatUtils.ONE));
		expected.add(new Moment(new int[] { 1, 0 }, ApfloatUtils.valueOf(0.754)));
		expected.add(new Moment(new int[] { 2, 0 }, ApfloatUtils.valueOf(0.62)));
		expected.add(new Moment(new int[] { 3, 0 }, ApfloatUtils.valueOf(0.157)));
		expected.add(new Moment(new int[] { 0, 1 }, ApfloatUtils.valueOf(0.774)));
		expected.add(new Moment(new int[] { 1, 1 }, ApfloatUtils.valueOf(1.922)));
		expected.add(new Moment(new int[] { 2, 1 }, ApfloatUtils.valueOf(0.986)));
		expected.add(new Moment(new int[] { 0, 2 }, ApfloatUtils.valueOf(0.457)));
		expected.add(new Moment(new int[] { 1, 2 }, ApfloatUtils.valueOf(0.849)));
		expected.add(new Moment(new int[] { 0, 3 }, ApfloatUtils.valueOf(0.09)));

		if (!Utils.equals(expected, binomMoms)) {
			System.out.println(expected);
			System.err.println(binomMoms);

			Assert.assertTrue(false);
		}
	}

	/**
	 * n=6. m=3. Dimensional = 2. 
	 * 
	 */
	@Test
	public void testCreatePowerMoments1() throws IOException {
		Apfloat[] probabilities = IOFile.read("prob.txt");

		List<Moment> binomMoms = MultivariateMoments.createBinomialMoments(probabilities, 6, 3, 2);
		MultivariateMoments.convertBinomMomToPowerMom(binomMoms);
	}
}
