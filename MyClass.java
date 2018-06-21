import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MyClass {
    static int findPos(ArrayList<Integer> temp, int x, int start, int end) {
        int mid = (end - start) >> 1;
        if (mid == start) return end;
        Integer midValue = temp.get(mid);
        if (x == midValue) return mid;
        if (x > midValue) return findPos(temp, x, mid + 1, end);
        return findPos(temp, x, start, mid - 1);
    }

    static void printMedians(int[] a) {
        int n = a.length;
        ArrayList<Integer> temp = new ArrayList<Integer>(n);
        temp.add(0, a[0]);
        System.out.println(String.format("%.1f", (double) a[0]));

        for (int i = 1; i < n; ++i) {
            int x = a[i];
            temp.add(findPos(temp, x, 0, temp.size()), x);
            if (temp.size() % 2 == 1) {
                System.out.println(String.format("%.1f", (double) temp.get((temp.size() - 1) >> 1)));
            } else {
                System.out.println(String.format("%.1f", (temp.get(temp.size() >> 1) + temp.get((temp.size() >> 1) - 1)) / 2.));
            }
        }

    }

    public static void main(String[] args) throws Exception {
        int[] a = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        printMedians(a);
    }
}
