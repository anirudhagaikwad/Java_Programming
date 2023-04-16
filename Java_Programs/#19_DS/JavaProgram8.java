package PPT19;
/*
Given an array representation of min Heap, convert it to max Heap.

Examples:

Input: arr[] = {3, 5, 9, 6, 8, 20, 10, 12, 18, 9}
Output: arr[] = {20, 18, 10, 12, 9, 9, 3, 5, 6, 8}

*/

class JavaProgram8 {
    // To heapify a subtree with root at given index
    static void MaxHeapify(int arr[], int i, int N)
    {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest = i;
        if (l < N && arr[l] > arr[i])
            largest = l;
        if (r < N && arr[r] > arr[largest])
            largest = r;
        if (largest != i) {
            // swap arr[i] and arr[largest]
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            MaxHeapify(arr, largest, N);
        }
    }

    // This function basically builds max heap
    static void convertMaxHeap(int arr[], int N)
    {
        // Start from bottommost and rightmost
        // internal node and heapify all internal
        // nodes in bottom up way
        for (int i = (N - 2) / 2; i >= 0; --i)
            MaxHeapify(arr, i, N);
    }

    // A utility function to print a given array
    // of given size
    static void printArray(int arr[], int size)
    {
        for (int i = 0; i < size; ++i)
            System.out.print(arr[i] + " ");
    }

    public static void main(String[] args)
    {
        // array representing Min Heap
        int arr[] = { 3, 5, 9, 6, 8, 20, 10, 12, 18, 9 };
        int N = arr.length;

        System.out.print("Min Heap array : ");
        printArray(arr, N);

        // Function call
        convertMaxHeap(arr, N);

        System.out.print("\nMax Heap array : ");
        printArray(arr, N);
    }
}

