import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream fis=new FileInputStream("input.txt");
            System.setIn(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] val = new int[n];
            int[] state = new int[n];
            int[] stateVal = new int[n];
            int maxSum = 0;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                val[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                int temp = sc.nextInt();
                state[i] = temp;
                if (temp == 1) {
                    sum += val[i];
                    stateVal[i] = (i > 0) ? stateVal[i - 1] : 0;
                } else {
                    stateVal[i] = (i > 0) ? stateVal[i - 1] + val[i] : val[i];
                }
            }
            for (int i = 0; i < state.length; i++) {
                if (state[i] == 0) {
                    maxSum = Math.max(maxSum, sum + stateVal[Math.min(i + k - 1,n-1)] - stateVal[i - 1]);
                }
            }
            System.out.println(maxSum);
        }
    }
}
