package fi.arcada.codechallenge;

import java.util.ArrayList;
import java.util.Collections;

public class Statistics {

    public static double calcMedian(ArrayList<Double> values) {

        // vi skapar en kopia av values
        ArrayList<Double> sorted = new ArrayList<>(values);
        // sedan sorterar vi kopian. Annars sorteras ursprungliga datamängden!
        Collections.sort(sorted);

        // Detta funkar, ännu bättre skulle vara att kolla skilt för jämna datamängder
        // med medelvärde av de två mittersta
        int midIndex = sorted.size()/2;

        // medianen är dett mittersta värdet i vår sorterade datamängd!
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
            sumDeviation += Math.pow(values.get(i)-mean, 2);
        }

        return Math.sqrt(sumDeviation / values.size());

    }
}
