import java.util.*;

class Solution {

    private static double X = 1;
    private static double Y = 1;

    private static final List<double[]> SETS = new ArrayList<>();
    private static int[] PROBABILITES;

    private final List<Double> xCoordinates;
    private final List<Double> yCoordinates;

    private final Random random = new Random();


    Solution() {
        xCoordinates = new ArrayList<>();
        yCoordinates = new ArrayList<>();

        // leaf
//        SETS.add(new double[]{0.0, 0.0, 0.0, 0.16, 0.0, 0.0, 0.01});
//        SETS.add(new double[]{0.2, -0.26, 0.23, 0.22, 0.0, 1.6, 0.07});
//        SETS.add(new double[]{-0.15, 0.28, 0.26, 0.24, 0.0, 0.44, 0.07});
//        SETS.add(new double[]{0.85, 0.04, -0.04, 0.85, 0.0, 1.6, 0.85});


        SETS.add(new double[]{0.000, 0.000, 0.000, 0.600, 0.00, -0.065, 0.1});
        SETS.add(new double[]{0.440, 0.000, 0.000, 0.550, 0.00, 0.200, 0.18});
        SETS.add(new double[]{0.343, -0.248, 0.199, 0.429, -0.03, 0.100, 0.18});
        SETS.add(new double[]{0.343, 0.248, -0.199, 0.429, 0.03, 0.100, 0.18});
        SETS.add(new double[]{0.280, -0.350, 0.280, 0.350, -0.05, 0.000, 0.18});
        SETS.add(new double[]{0.280, 0.350, -0.280, 0.350, 0.05, 0.000, 0.18});
        PROBABILITES = generateProbabilities();
        updateSetWithProbabilities();
    }

    void addCoordinates(int n) {

        for (int i = 0; i < n; i++) {
            generateFractal();
        }
    }


    private void generateFractal() {

        double[] SET = SETS.get(random.nextInt(SETS.size()));

        X = (SET[0] * X) + (SET[1] * Y) + SET[4];
        Y = (SET[2] * X) + (SET[3] * Y) + SET[5];

        xCoordinates.add(X * 1700 + 400);
        yCoordinates.add(Y * 1700 + 300);


    }

    private int[] generateProbabilities() {
        int[] probabilities = new int[SETS.size()];

        for (int i = 0; i < SETS.size(); i++) {
            double[] set = SETS.get(i);
            probabilities[i] = (int) (set[6] * 100);
        }

        return probabilities;
    }

    void updateSetWithProbabilities() {
        for (int i = 0; i < PROBABILITES.length; i++) {

            int probability = PROBABILITES[i] - 1;
            double[] setToUpdate = SETS.get(i);

            for (int j = 0; j < probability; j++) {
                SETS.add(setToUpdate);
            }
        }
    }

    public List<Double> getxCoordinates() {
        return xCoordinates;
    }

    public List<Double> getyCoordinates() {
        return yCoordinates;
    }
}
