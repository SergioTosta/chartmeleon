package com.chartmeleon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Chartmeleon {

	public static List<String> getShades(int hue, int numberOfShades) {
		double lightness = 0;
		double saturation = 0;
		double lightnessSteps = numberOfShades == 1 ? 50 : 90 / numberOfShades;
		double saturationStepsDistance = 100 / Math.ceil(numberOfShades / 2.0);
		List<String> shades = new ArrayList<String>();

		for (int i = 0; i < numberOfShades; i++) {
			lightness += lightnessSteps;
			saturation += saturationStepsDistance;
			shades.add("hsl(" + hue + ", " + saturation + "%, " + lightness + "%)");
		}

		return shades;
	}

	public static List<List<String>> getColorSet(int numberOfHues, int numberOfShades, boolean random) {
		int hueStepDistance = 360 / numberOfHues;
		int hue = random == true ? new Random().ints(0, (360 + 1)).findFirst().getAsInt() : 0;
		List<List<String>> colors = new ArrayList<List<String>>();

		for (int i = 0; i < numberOfHues; i++) {
			colors.add(getShades(hue, numberOfShades));
			hue += hueStepDistance;
		}

		return colors;
	}
}