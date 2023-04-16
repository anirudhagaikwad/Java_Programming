package PPT18;

/*
Given a sorted array and a value x, the ceiling of x is the smallest element in an array greater than or equal to x. Assume that the array is sorted in non-decreasing order. Write efficient function to find ceiling of x.

Examples :

For example, let the input array be {1, 2, 8, 10, 10, 12, 19}
For x = 0: ceil  = 1
For x = 1: ceil  = 1
For x = 5: ceil  = 8
*/

class JavaProgram1
{
    /* Function to get index of ceiling
    of x in arr[low..high] */
    static int ceilSearch(int arr[], int low, int high, int x)
    {
        int i;

	/* If x is smaller than or equal to first
		element,then return the first element */
        if(x <= arr[low])
            return low;

        /* Otherwise, linearly search for ceil value */
        for(i = low; i < high; i++)
        {
            if(arr[i] == x)
                return i;

		/* if x lies between arr[i] and arr[i+1]
		including arr[i+1], then return arr[i+1] */
            if(arr[i] < x && arr[i+1] >= x)
                return i+1;
        }

	/* If we reach here then x is greater than the
	last element of the array, return -1 in this case */
        return -1;
    }


    /*    program to check above functions */
    public static void main (String[] args)
    {
        int arr[] = {1, 2, 8, 10, 10, 12, 19};
        int n = arr.length;
        int x = 3;
        int index = ceilSearch(arr, 0, n-1, x);
        if(index == -1)
            System.out.println("Ceiling of "+x+" doesn't exist in array");
        else
            System.out.println("ceiling of "+x+" is "+arr[index]);
    }
}

