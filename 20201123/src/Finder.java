import java.util.*;

public class Finder {
    public int findKth(int[] a, int n, int K) {
        // write code here

        int res = quickSort(a,0,n-1,K);
        return res;
    }

    private int quickSort(int[] a, int start, int end, int k) {
        if (start > end){
            return -1;
        }
        int i = start;
        int j = end;
        int base = a[start];
        while (i < j){
            while (i < j && a[j] > base){
                j--;
            }
            while (i < j && a[i] <= base){
                i++;
            }
            if (i < j){
                int tmp = a[j];
                a[j] = a[i];
                a[i] = tmp;
            }
        }
        a[start] = a[i];
        a[i] = base;
        if (i == a.length-k){
            return a[i];
        }else if (i < a.length-k){
            return quickSort(a,i+1,end,k);
        }else {
            return quickSort(a,start,i-1,k);
        }
    }
}