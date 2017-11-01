package com.andersen.study.collectionsAPI;

import java.util.ArrayList;
import java.util.Arrays;

class MergeSortDemo {
    public static void main(String[] args) {
        int[] A, B, C;
        A = new int[10];
        B = new int[10];
        for (int i = 0; i < 10; i++)
            A[i] = i + 1;
        for (int i = 0; i < 10; i++)
            B[i] = i + 11;

        MergeSortDemo merge = new MergeSortDemo();
        C = merge.merge(A, B);
        System.out.println(" A\t B\t C");
        for (int i = 0; i < 20; i++) {
            if (i >= A.length)
                if (i >= B.length)
                    System.out.println("  \t  \t" + C[i]);
                else System.out.println("  \t" + B[i] + "\t" + C[i]);
            else System.out.println(A[i] + "\t" + B[i] + "\t" + C[i]);
        }
    }

    int[] merge(int[] A, int[] B) {
        int[] Res = new int[A.length + B.length];
        Arrays.sort(A);
        Arrays.sort(B);
        ArrayList<Integer> Aa = new ArrayList<>();
        for (int i = 0; i < A.length; i++)
            Aa.add(i, A[i]);
        ArrayList<Integer> Bb = new ArrayList<>();
        for (int i = 0; i < B.length; i++)
            Bb.add(i, B[i]);
        if (Aa.isEmpty())
            return B;
        if (Bb.isEmpty())
            return A;
        int maxIndex = A.length + B.length, i = 0, tempIndexA = 0, tempIndexB = 0;
        while (i < maxIndex) {
            if (tempIndexA < A.length && tempIndexB < B.length) {
                if (Aa.get(tempIndexA) < Bb.get(tempIndexB)) {
                    Res[i] = Aa.get(tempIndexA);
                    tempIndexA++;
                } else {
                    Res[i] = Bb.get(tempIndexB);
                    tempIndexB++;
                }
            }
            else if (tempIndexA < A.length) {
                Res[i] = Aa.get(tempIndexA);
                tempIndexA++;
            }
            else if (tempIndexB < B.length) {
                Res[i] = Bb.get(tempIndexB);
                tempIndexB++;
            }
            i++;
        }
        return Res;
    }
}
