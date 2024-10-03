import java.util.Arrays;

public class ModelEvaluation {
    
    // Method to calculate MAE
    public static double calculateMAE(double[] actual, double[] predicted) {
        double sum = 0.0;
        for (int i = 0; i < actual.length; i++) {
            sum += Math.abs(predicted[i] - actual[i]);
        }
        return sum / actual.length;
    }

    // Method to calculate RMSE
    public static double calculateRMSE(double[] actual, double[] predicted) {
        double sum = 0.0;
        for (int i = 0; i < actual.length; i++) {
            sum += Math.pow(predicted[i] - actual[i], 2);
        }
        return Math.sqrt(sum / actual.length);
    }

    // Method to calculate R² Score
    public static double calculateR2(double[] actual, double[] predicted) {
        double meanActual = Arrays.stream(actual).average().orElse(0.0);
        double ssTotal = 0.0, ssResidual = 0.0;
        for (int i = 0; i < actual.length; i++) {
            ssTotal += Math.pow(actual[i] - meanActual, 2);
            ssResidual += Math.pow(actual[i] - predicted[i], 2);
        }
        return 1 - (ssResidual / ssTotal);
    }

    // Main method to run evaluations for different models
    public static void main(String[] args) {
        double[] actual = {5.0, 3.2, 4.5, 7.8, 6.5}; // Example actual values

        // GRU model predictions
        double[] gruPredictions = {5.1, 3.0, 4.6, 7.7, 6.3};
        System.out.println("GRU Model:");
        System.out.println("MAE: " + calculateMAE(actual, gruPredictions));
        System.out.println("RMSE: " + calculateRMSE(actual, gruPredictions));
        System.out.println("R² Score: " + calculateR2(actual, gruPredictions));

        // LSTM model predictions
        double[] lstmPredictions = {5.0, 3.1, 4.7, 7.6, 6.4};
        System.out.println("\nLSTM Model:");
        System.out.println("MAE: " + calculateMAE(actual, lstmPredictions));
        System.out.println("RMSE: " + calculateRMSE(actual, lstmPredictions));
        System.out.println("R² Score: " + calculateR2(actual, lstmPredictions));

        // Random Forest model predictions
        double[] rfPredictions = {4.8, 2.9, 4.4, 7.4, 6.1};
        System.out.println("\nRandom Forest Model:");
        System.out.println("MAE: " + calculateMAE(actual, rfPredictions));
        System.out.println("RMSE: " + calculateRMSE(actual, rfPredictions));
        System.out.println("R² Score: " + calculateR2(actual, rfPredictions));

        // SVM model predictions
        double[] svmPredictions = {4.7, 2.8, 4.3, 7.3, 6.0};
        System.out.println("\nSVM Model:");
        System.out.println("MAE: " + calculateMAE(actual, svmPredictions));
        System.out.println("RMSE: " + calculateRMSE(actual, svmPredictions));
        System.out.println("R² Score: " + calculateR2(actual, svmPredictions));
    }
}
