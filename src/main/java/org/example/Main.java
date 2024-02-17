package org.example;

import java.util.*;

public class Main {

    private static int sumValues(Map<String, Integer> map) {
        int sum = 0;
        for (int value : map.values()) {
            sum += value;
        }
        return sum;
    }

    private static int countVietnamese(String input) {
        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            char next = (i + 1 < input.length()) ? input.charAt(i + 1) : ' ';

            String str = "";
            if (current == 'a' && (next == 'w' || next == 'a')) {
                str = String.valueOf(current) + next;
                i++;
            } else if (current == 'd' && next == 'd') {
                str = "dd";
                i++;
            } else if (current == 'e' && next == 'e') {
                str = "ee";
                i++;
            } else if (current == 'o' && (next == 'o' || next == 'w')) {
                str = String.valueOf(current) + next;
                i++;
            } else if (current == 'w') {
                str = "w";
            }

            if (!str.isEmpty()) {
                m.put(str, m.getOrDefault(str, 0) + 1);
            }
        }

        return sumValues(m);
    }

    public static void main(String[] args) {
        while (true) {
            Scanner i = new Scanner(System.in);
            System.out.printf("Nhap: ");
            String str = i.nextLine();
            System.out.println("Ket qua: " + countVietnamese(str));
        }
    }
}