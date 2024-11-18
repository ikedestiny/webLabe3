import java.util.Random;
public class Shubi {
    static double formula1(int x){
        return Math.sin(Math.pow((2/3 * (3/4 - Math.cos(x))),3));
    }
    static double formula2(int x){
        return Math.log(Math.pow( 5*Math.abs(x)*(Math.abs(x) + 1),2));
    }
    static double formula3(double x){
        return Math.pow(Math.pow(Math.PI/(2/3 + Math.tan(Math.cbrt(x))), 2)/2, Math.asin(Math.exp(Math.pow(Math.cbrt(-((3+Math.abs(x))/Math.abs(x))),2))));
    }
    static void printMatrix(double[][] matrix) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 10; j++) {
                switch (Double.compare(matrix[i][j], matrix[i][j])) {
                    case (int) Double.NaN:
                        System.out.printf("%12s", "NaN");
                    case (int) Double.POSITIVE_INFINITY:
                    case (int) Double.NEGATIVE_INFINITY:
                        System.out.printf("%12s", "Infinite");
                    default:
                        System.out.printf("%12.5f", matrix[i][j]);
                }
            }
            System.out.println("\n");
        }
    }





    public static void main(String[] args) {
        long[] e;
        e = new long[9];
        for (int i = 0; i < e.length; i++) {
            e[i] = 19 - (2 * i);
        }

        double[] x;
        x = new double[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            x[i] = -11.0 + (10.0 - (-11.0)) * random.nextDouble();
        }
    }
}