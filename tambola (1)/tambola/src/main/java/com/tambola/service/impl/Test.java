package com.tambola.service.impl;//package com.example.demo;

import java.util.*;

public class Test {

    static Random rand = new Random();

    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            System.out.println();
            helper();
            System.out.println();
        }
    }

    public static int getRandom(int start, int end) {
        return rand.nextInt(end - start) + start;
    }

    public static void helper() {
        try {
            System.out.println("hweeee");
            List<List<Integer>> v = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j < 9; j++) {
                    row.add(0);
                }
                v.add(row);
            }

            for (int i = 0; i < 9; i++) {
                int start = i * 9;
                int end = start + 3;
                for (int j = 0; j < 3; j++) {
                    int rdno = getRandom(start, end);
                    end += 3;
                    start += 3;
                    v.get(j).set(i, rdno);
                }
            }

            for (int i = 0; i < 3; i++) {

                while (true) {
                    Random random = new Random();
                    int col=random.nextInt(9);;
                    if (v.get(i).get(col) != 0) {
                        int countZero = 0;
                        for (int k = 0; k < 3; k++) {
                            if (v.get(k).get(col) == 0)
                                countZero++;
                        }
                        if (countZero == 2) {
                            continue;
                        }
                        int zero = 0;
                        for (int x = 0; x < 9; x++) {
                            if (v.get(i).get(x) == 0) zero++;

                        }
                        if (zero == 4) break;
                        v.get(i).set(col, 0);

                    }
                }
            }

            for (List<Integer> row : v) {
                for (int num : row) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}