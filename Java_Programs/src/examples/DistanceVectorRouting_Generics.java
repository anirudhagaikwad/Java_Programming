package examples;
/*

Distance Vector Routing is a dynamic routing algorithm used to determine the best path for data packets 
in a network. It is based on the Bellman-Ford Algorithm and operates by exchanging distance information 
between neighboring routers. 

### Key Characteristics
1. Distributed Algorithm: Each router shares routing updates only with its direct neighbors.
2. Periodic Updates: Routers send routing tables at regular intervals.
3. Hop Count as a Metric: The number of hops (routers) determines the best path.
4. Routing by Rumor: Each router relies on its neighbors' knowledge instead of a full network view.

---

## How Distance Vector Routing Works
1. Initialization: Each router initializes its routing table with known directly connected neighbors.
2. Exchange of Routing Information:  
   - Each router periodically sends its routing table to neighboring routers.
   - Neighbors update their own tables based on the received information.
3. Path Selection (Bellman-Ford Algorithm):
   - The shortest path (minimum hop count) is chosen.
   - If multiple paths exist, the lowest-cost path is preferred.
4. Updates and Convergence:  
   - When a route changes (e.g., link failure), routers propagate the change in the next update cycle.
   - The network converges when all routers agree on the shortest paths.

---

## Example of Distance Vector Routing
Consider a simple network with four routers: A, B, C, and D.

1. Initial Routing Tables
   - A knows only its direct connections: `(A → B: 1 hop), (A → C: 2 hops)`.
   - B knows `(B → A: 1 hop), (B → D: 3 hops)`.
   - C knows `(C → A: 2 hops), (C → D: 1 hop)`.
   - D knows `(D → C: 1 hop), (D → B: 3 hops)`.

2. Exchange Updates
   - A sends its table to B and C.
   - B receives the table and updates its routes if A provides a shorter path.
   - This process continues until all routers have the best paths.

---

## Advantages of Distance Vector Routing
1. Simple and Easy to Implement  
   - No need for complex calculations like in Link-State Routing.
2. Efficient for Small Networks  
   - Works well in networks with limited routers.
3. Automatic Route Updates  
   - Adapts to topology changes automatically.

---

## Disadvantages of Distance Vector Routing
1. Slow Convergence  
   - Takes time to stabilize after network changes.
2. Count to Infinity Problem  
   - Routing loops occur when incorrect information propagates indefinitely.
   - Example: If a link fails, the routers may keep increasing hop counts indefinitely.
3. High Bandwidth Usage  
   - Routing updates are sent periodically, increasing network traffic.

---

## Solutions to Distance Vector Issues
1. Split Horizon  
   - Prevents routing loops by not sending route updates back to the source router.
2. Poison Reverse  
   - Advertises a failed route with infinity (∞) metric to stop count-to-infinity.
3. Triggered Updates  
   - Sends updates immediately when a route changes instead of waiting for periodic updates.
4. Hold-Down Timers  
   - Prevents routers from accepting incorrect updates for a certain time.

---

## Examples of Distance Vector Protocols
1. Routing Information Protocol (RIP)
   - Uses hop count as a metric (maximum 15 hops).
   - Updates every 30 seconds.
2. Interior Gateway Routing Protocol (IGRP)
   - Developed by Cisco, supports multiple metrics like bandwidth and delay.

---

## Comparison: Distance Vector vs. Link-State Routing
| Feature | Distance Vector Routing | Link-State Routing |
|---------|-------------------------|---------------------|
| Routing Information | Only from neighbors | Full network topology |
| Algorithm | Bellman-Ford | Dijkstra’s Algorithm |
| Speed of Convergence | Slow | Fast |
| Resource Usage | Low | High (More CPU & Memory) |
| Loop Prevention | Uses Split Horizon, Poison Reverse | Uses Shortest Path Tree |

---

## Conclusion
Distance Vector Routing is a simple and effective routing method for small networks but struggles with scalability and slow convergence. 
Modern networks prefer Link-State Routing (e.g., OSPF) for better efficiency.


*/

//Java Implementation of Distance Vector Routing

import java.lang.reflect.Array;

class Router<T> {
    private T routerId; // Generic Router ID
    private T[] destinations; // Generic array for destinations
    private int[] distances; // Distance array
    private int size; // Number of entries

    // Constructor
    public Router(T routerId, int capacity, Class<T> type) {
        this.routerId = routerId;
        this.destinations = (T[]) Array.newInstance(type, capacity); // Proper generic array creation
        this.distances = new int[capacity];
        this.size = 0;
    }

    // Add a neighbor to the routing table
    public void addNeighbor(T neighborId, int distance) {
        if (size < destinations.length) {
            destinations[size] = neighborId;
            distances[size] = distance;
            size++;
        }
    }

    // Get actual size of stored destinations
    public int getSize() {
        return size;
    }

    // Get routing table (destinations array)
    public T[] getDestinations() {
        T[] validDestinations = (T[]) Array.newInstance(destinations.getClass().getComponentType(), size);
        System.arraycopy(destinations, 0, validDestinations, 0, size);
        return validDestinations;
    }

    // Get distance array
    public int[] getDistances() {
        int[] validDistances = new int[size];
        System.arraycopy(distances, 0, validDistances, 0, size);
        return validDistances;
    }

    // Get distance for a given destination
    public int getDistance(T destination) {
        for (int i = 0; i < size; i++) {
            if (destinations[i].equals(destination)) {
                return distances[i];
            }
        }
        return Integer.MAX_VALUE; // If not found, return max distance
    }

    // Update Routing Table using Distance Vector Algorithm
    public boolean updateRoutingTable(T[] neighborDestinations, int[] neighborDistances, int neighborSize, T neighborId) {
        boolean updated = false;
        int neighborDistance = getDistance(neighborId);

        // ✅ FIX: Prevent Out-of-Bounds Access
        if (neighborSize > neighborDestinations.length) {
            neighborSize = neighborDestinations.length; // Limit to actual array size
        }

        for (int i = 0; i < neighborSize; i++) { 
            if (neighborDestinations[i] == null) continue; // Prevent null access

            T destination = neighborDestinations[i];
            int newDistance = neighborDistances[i] + neighborDistance;

            boolean found = false;
            for (int j = 0; j < size; j++) {
                if (destinations[j].equals(destination)) {
                    if (newDistance < distances[j]) {
                        distances[j] = newDistance;
                        updated = true;
                    }
                    found = true;
                    break;
                }
            }

            if (!found && size < destinations.length) {
                destinations[size] = destination;
                distances[size] = newDistance;
                size++;
                updated = true;
            }
        }
        return updated;
    }

    // Display Routing Table
    public void displayRoutingTable() {
        System.out.println("Routing Table for Router " + routerId + ":");
        for (int i = 0; i < size; i++) {
            System.out.println(" -> Destination: " + destinations[i] + " | Distance: " + distances[i]);
        }
        System.out.println();
    }
}

// Main Class
public class DistanceVectorRouting_Generics {
    public static void main(String[] args) {
        // Create Routers (Capacity: 5 destinations max)
        Router<String> routerA = new Router<>("A", 5, String.class);
        Router<String> routerB = new Router<>("B", 5, String.class);
        Router<String> routerC = new Router<>("C", 5, String.class);

        // Add initial connections (neighbors with distances)
        routerA.addNeighbor("B", 2);
        routerB.addNeighbor("A", 2);
        routerB.addNeighbor("C", 3);
        routerC.addNeighbor("B", 3);

        // Display initial tables
        routerA.displayRoutingTable();
        routerB.displayRoutingTable();
        routerC.displayRoutingTable();

        // Simulate distance vector updates
        boolean updated;
        do {
            updated = false;
            updated |= routerA.updateRoutingTable(routerB.getDestinations(), routerB.getDistances(), routerB.getSize(), "B");
            updated |= routerB.updateRoutingTable(routerC.getDestinations(), routerC.getDistances(), routerC.getSize(), "C");
            updated |= routerC.updateRoutingTable(routerB.getDestinations(), routerB.getDistances(), routerB.getSize(), "B");
        } while (updated);

        // Display final routing tables
        routerA.displayRoutingTable();
        routerB.displayRoutingTable();
        routerC.displayRoutingTable();
    }
}


/*
📌 Explanation
Router<T>

Uses generic type T for router IDs.
Instead of List or Map, uses arrays (T[] destinations, int[] distances) to store routing data.
Stores only a fixed number of neighbors (configurable).
addNeighbor()

Adds direct neighbors using arrays.
updateRoutingTable()

Uses Distance Vector Algorithm without Collections.
Iterates over arrays to find the shortest path.
displayRoutingTable()

Prints the routing table for each router.
Main Class (DistanceVectorRouting)

Creates routers A, B, C.
Adds direct neighbor connections.
Performs iterative updates using Distance Vector logic.
 
*/