package ru.ifmo.diplom.kirilchuk.jawelet.util;

public final class AnalyzeUtils {

	private AnalyzeUtils() {
	}

	/**
	 * Calculates peak signal-to-noise ratio The PSNR is most commonly used as a
	 * measure of quality of reconstruction of lossy compression codecs (e.g.,
	 * for image compression). The signal in this case is the original data, and
	 * the noise is the error introduced by compression.
	 * 
	 * <p>
	 * PSNR = (max^2 * width * heigth) / summ(|x-y|^2)
	 * 
	 * <p>
	 * expected to be Infinity if original and actual are the same
	 * 
	 * @param max
	 * @param original
	 * @param actual
	 * @return
	 */
	public static double calculatePSNR(double[][] original, double[][] actual, int max) {
		int heigth = original.length;
		Assert.argNotNull(original, actual);
		Assert.argCondition(heigth == actual.length, "Sizes must be same");
		Assert.argCondition(heigth > 0, "original data must be non empty");

		int width = original[0].length;
		Assert.argCondition(width == actual[0].length, "Sizes must be same");

		long numerator = max * max * width * heigth;
		
		double denominator = 0;
		double absDifference = 0;
		for (int row = 0; row < heigth; ++row) {
			for (int col = 0; col < width; ++col) {
				absDifference = Math.abs(original[row][col] - actual[row][col]);
				denominator += (absDifference * absDifference);
			}
		}

		double result = 10 * Math.log10(numerator/denominator);
		
		return result;
	}
}
