package greedyAlgorithms;
/*
C)Task Scheduling: Given a set of tasks with their respective deadlines and profits, schedule the tasks in a way that maximizes the total profit. A task should be scheduled only if there is enough time to complete it before its deadline.

*/

import java.util.Arrays;
import java.util.Comparator;

class Task {
    int id;
    int deadline;
    int profit;

    Task(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class TaskScheduling {
    public int maxProfit(Task[] tasks) {
        Arrays.sort(tasks, Comparator.comparingInt(t -> -t.profit));

        int n = tasks.length;
        int[] slots = new int[n + 1];
        for (int i = 1; i <= n; i++) slots[i] = i;

        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            int deadline = tasks[i].deadline;
            int slot = findSlot(slots, deadline);

            if (slot > 0) {
                maxProfit += tasks[i].profit;
                slots[slot] = slot - 1;
            }
        }

        return maxProfit;
    }

    private int findSlot(int[] slots, int deadline) {
        for (int i = deadline; i > 0; i--) {
            if (slots[i] > 0) {
                return slots[i];
            }
        }

        return 0;
    }
    
    public static void main(String[] args) {
        Task[] tasks = {
            new Task(1, 4, 20),
            new Task(2, 1, 10),
            new Task(3, 1, 40),
            new Task(4, 1, 30),
            new Task(5, 1, 50)
        };

        TaskScheduling scheduler = new TaskScheduling();
        int maxProfit = scheduler.maxProfit(tasks);

        System.out.println("Maximum total profit: " + maxProfit);
    }

}//end class

/*
In this example, we define an array of Task objects representing five tasks with different deadlines and profits. We then create an instance of the TaskScheduling class and use its maxProfit method to compute the maximum total profit that can be obtained by scheduling these tasks.

This is a Java program that implements a solution to the Task Scheduling problem. The problem involves scheduling a set of tasks with given deadlines and profits, such that each task is completed before its deadline and the total profit is maximized.

The program uses the greedy approach to solve the problem. It first sorts the tasks in decreasing order of their profits, and then iterates through the tasks. For each task, it finds the latest available time slot before its deadline and assigns the task to that slot. If no such slot is available, the task is skipped.

The program uses a Task class to represent each task, with attributes for the task ID, deadline, and profit. The maxProfit method takes an array of Task objects as input and returns the maximum total profit that can be obtained by scheduling the tasks.

The findSlot method is a helper method that finds the latest available time slot before a given deadline. It iterates through the slots array in reverse order, starting from the deadline, and returns the first available slot it finds.

Overall, this program provides a simple and efficient solution to the Task Scheduling problem using the greedy approach.
*/