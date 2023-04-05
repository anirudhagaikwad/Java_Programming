package greedyAlgorithms;

import java.util.Arrays;

/*
B)Minimum Platforms: Given arrival and departure times of trains at a station, find the minimum number of platforms required to handle the traffic.
*/
class MinimumPlatforms {
/*
In this example, we define two arrays of integers representing the arrival and departure times of six trains. We then create an instance of the MinimumPlatforms class and use its minPlatforms method to compute the minimum number of platforms required for the train station.
*/
	
	public int minPlatforms(int[] arrival, int[] departure) {
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int n = arrival.length;
        int i = 0, j = 0;
        int platforms = 0, maxPlatforms = 0;

        while (i < n && j < n) {
            if (arrival[i] <= departure[j]) {
                platforms++;
                i++;
            } else {
                platforms--;
                j++;
            }

            maxPlatforms = Math.max(maxPlatforms, platforms);
        }

        return maxPlatforms;
    }
    
    public static void main(String[] args) {
        int[] arrival = {900, 940, 950, 1100, 1500, 1800};
        int[] departure = {910, 1200, 1120, 1130, 1900, 2000};

        MinimumPlatforms platformFinder = new MinimumPlatforms();
        int minPlatforms = platformFinder.minPlatforms(arrival, departure);

        System.out.println("Minimum number of platforms required: " + minPlatforms);
    }

} //end class

/*
This is a Java program that implements a solution to the Minimum Platforms problem. The problem involves determining the minimum number of platforms required for a train station given the arrival and departure times of trains.

The program uses a greedy approach to solve the problem. It first sorts the arrival and departure arrays in non-decreasing order, and then iterates through the arrays using two pointers i and j. The i pointer represents the current train that has arrived and the j pointer represents the current train that has departed.

For each train, the program checks if it has arrived before or at the same time as the currently departing train. If so, a platform is required for this train and the platforms count is incremented. If the current train has departed before the next train arrives, a platform is no longer required and the platform count is decremented.

During the iteration, the program keeps track of the maximum number of platforms required at any point in time, which is the solution to the problem.

The minPlatforms method takes two arrays of integers as input, representing the arrival and departure times of trains, respectively, and returns the minimum number of platforms required for the train station.

Overall, this program provides a simple and efficient solution to the Minimum Platforms problem using the greedy approach.

Note that this program assumes that the arrival and departure times are already sorted in non-decreasing order. If the input arrays are unsorted, additional sorting steps may be required. 

*/