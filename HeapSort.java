import java.util.*;
public class Assignment_1_Heap {
    public void heapify(int arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
 
        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;
 
        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;
 
        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
    public static void main(String args[])
    {
        Assignment_1_Heap ob=new Assignment_1_Heap();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of values:");
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
        System.out.println("Enter the value:");
        arr[i]=sc.nextInt();
        }
        System.out.println("Before sorting");
        for(int i=0;i<n;i++)
        {
        System.out.println(arr[i]);
        }
        


        for (int i = n / 2 - 1; i >= 0; i--)
            ob.heapify(arr, n, i);
 
        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            // call max heapify on the reduced heap
            ob.heapify(arr, i, 0);
        }
        System.out.println("After sorting");
        for(int i=0;i<n;i++)
        {
        System.out.println(arr[i]);
        }
        
        sc.close();
    }
}
