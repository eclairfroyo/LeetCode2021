package com.test.hackerrank;

import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] arr_A = br.readLine().split(" ");
            int[] A = new int[N];
            for(int i_A = 0; i_A < arr_A.length; i_A++)
            {
                A[i_A] = Integer.parseInt(arr_A[i_A]);
            }
            int X = Integer.parseInt(br.readLine().trim());

            long out_ = count_pairs(N, A, X);
            System.out.println(out_);

        }

        wr.close();
        br.close();
    }
    static long count_pairs(int N, int[] A, int X){
        // Write your code here
        long result = 0;
        Map<Integer, Map<Integer, Integer>> indexMap = new HashMap<>();

        for(int i = 0; i < A.length; i++) {
            // A[i] -> current element.
            Map<Integer, Integer> valueMap = new HashMap<>();
            int curMod = (i + 1) % X;
            if(indexMap.containsKey(A[i])) {
                valueMap = indexMap.get(A[i]);
                if(curMod == 0) {
                    result += valueMap.getOrDefault(-1, 0);
                }
                else {
                    int searchVal = (X / curMod) % X;
                    result += valueMap.getOrDefault(searchVal, 0);
                }
            }
            int curModFreq = valueMap.getOrDefault(curMod, 0);
            int totalFreq = valueMap.getOrDefault(-1, 0);
            valueMap.put(curMod, curModFreq + 1);
            valueMap.put(-1, totalFreq + 1);

            indexMap.put(A[i], valueMap);
        }
        return result;
    }
}
