package fi.arcada.codechallenge;

import java.util.ArrayList;
import java.util.Collections;

public class Statistics {

    public static double calcMedian(ArrayList<Double> values) {
        ArrayList<Double> sorted = new ArrayList<>(values);
        Collections.sort(sorted);
        int midIndex = sorted.size() / 2;
        return sorted.get(midIndex);
    }

    public static double calcMean(ArrayList<Double> values) {
        double sum = 0;
        for (int i = 0; i < values.size(); i++) {
            sum += values.get(i);
        }
        return sum / values.size();
    }

    public static double calcStdev(ArrayList<Double> values) {
        double mean = calcMean(values);
        double sumDeviation = 0;
        for (int i = 0; i < values.size(); i++) {
            sumDeviation += Math.pow(values.get(i) - mean, 2);
        }
        return Math.sqrt(sumDeviation / values.size());
    }

    public static double calcLQ(ArrayList<Double> values) {
        return calcQuartile(values, 0.25);
    }

    public static double calcUQ(ArrayList<Double> values) {
        return calcQuartile(values, 0.75);
    }

    public static double calcIQR(ArrayList<Double> values) {
        double lowerQuartile = calcLQ(values);
        double upperQuartile = calcUQ(values);
        return upperQuartile - lowerQuartile;
    }

    public static double calcQuartile(ArrayList<Double> values, double quartile) {
        ArrayList<Double> sorted = new ArrayList<>(values);
        Collections.sort(sorted);
        int index = (int) Math.ceil(quartile * (sorted.size() + 1)) - 1;
        return sorted.get(index);
    }
}