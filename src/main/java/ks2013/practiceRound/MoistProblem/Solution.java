package ks2013.practiceRound.MoistProblem;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCases = in.nextInt();
        for (int i = 0; i < numTestCases; i++) {
            int ans = 0;
            String prevName = "", currName;
            int numberOfNames = in.nextInt();
            in.nextLine();
            for (int j = 0; j < numberOfNames; j++) {
                currName = in.nextLine();
                Boolean isNotEmpty = !prevName.isEmpty();
                Boolean isLessThan = prevName.compareTo(currName) > 0;
                if (isNotEmpty && isLessThan) {
                    if (prevName.compareTo(currName) > 0) ans++;
                }else{
                    prevName = currName;
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + ans);
        }
    }
}
