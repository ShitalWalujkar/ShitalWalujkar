import java.util.ArrayList;
import java.util.List;

public class MaximumSumPath {
    public static void main(String[] args) {
        int[] X = {3, 6, 7, 8, 10, 12, 15, 18, 100};
        int[] Y = {1, 2, 3, 5, 7, 9, 10, 11, 15, 16, 18, 25, 50};

        List<Integer> maxSumPath = findMaxSumPath(X, Y);
        int maxSum = calculateSum(maxSumPath);

        System.out.println("The maximum sum path is: " + maxSumPath);
        System.out.println("The maximum sum is: " + maxSum);
    }

    public static List<Integer> findMaxSumPath(int[] X, int[] Y) {
        int m = X.length;
        int n = Y.length;
        int i = 0, j = 0;
        int sumX = 0, sumY = 0;
        List<Integer> maxSumPath = new ArrayList<>();

        while (i < m && j < n) {
            if (X[i] < Y[j]) {
                sumX += X[i++];
            } else if (X[i] > Y[j]) {
                sumY += Y[j++];
            } else {
                maxSumPath.add(X[i]);
                maxSumPath.add(Math.max(sumX, sumY) + X[i]);
                sumX = 0;
                sumY = 0;
                i++;
                j++;
            }
        }

        while (i < m) {
            sumX += X[i++];
        }

        while (j < n) {
            sumY += Y[j++];
        }

        maxSumPath.add(Math.max(sumX, sumY));

        return maxSumPath;
    }

    public static int calculateSum(List<Integer> maxSumPath) {
        int sum = 0;
        for (int num : maxSumPath) {
            sum += num;
        }
        return sum;
    }
}

