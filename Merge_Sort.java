import java.util.Scanner;
public class Merge_Sort {
    public static void main(String[] args) {
        // int a[] = {7, 5, 4, 9, 1};
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        mergesort(a, 0, a.length - 1); // low=0, high=arr.length-1

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+"  ");
        }
    }

    public static void mergesort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergesort(arr, low, mid);
            mergesort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
         int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];
        
        for (int i = 0; i < n1; ++i)
            left[i] = arr[low + i];
            
        for (int j = 0; j < n2; ++j)
            right[j] = arr[mid + 1 + j];

        int i = 0, j = 0;
        int k = low;
        while (i < n1 && j < n2){
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } 
            else {
                arr[k++] = right[j++];
            }
        }
        while (i < n1) {
            arr[k++] = left[i++];
        }

        while (j < n2) {
            arr[k++] = right[j++];
        }
    }
}