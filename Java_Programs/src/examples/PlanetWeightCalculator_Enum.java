package examples;

import java.util.Scanner;
/*
A person’s weight on Earth is affected by gravity, which differs from planet to planet. 
Given a user’s weight on Earth, write a Java program using enum 
to calculate and display their weight on different planets in the solar system.
 */
//Enum representing planets and their gravity relative to Earth
enum Planet {
 MERCURY(0.38), VENUS(0.91), EARTH(1.0), MARS(0.38),
 JUPITER(2.34), SATURN(1.06), URANUS(0.92), NEPTUNE(1.19);

 private final double gravity; // Gravitational force relative to Earth

 // Constructor to initialize gravity for each planet
 Planet(double gravity) {
     this.gravity = gravity;
 }

 // Method to calculate weight on a given planet
 public double calculateWeight(double earthWeight) {
     return earthWeight * gravity;
 }

 // Getter for gravity
 public double getGravity() {
     return gravity;
 }
}

public class PlanetWeightCalculator_Enum {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     // Taking user input for weight on Earth
     System.out.print("Enter your weight on Earth (kg): ");
     double earthWeight = scanner.nextDouble();

     System.out.println("\n=== Your Weight on Different Planets ===");
     
     // Iterating through all planets using values() method
     for (Planet planet : Planet.values()) {
         // Calculating weight on the current planet
         double weightOnPlanet = planet.calculateWeight(earthWeight);
         
         // Displaying details using name() and ordinal()
         System.out.printf("%-8s (Ordinal: %d) -> Gravity: %.2f | Weight: %.2f kg%n", 
             planet.name(), planet.ordinal(), planet.getGravity(), weightOnPlanet);
     }

     // Closing scanner to prevent memory leak
     scanner.close();
 }
}

/*
Enum with Constructor & Fields
Each enum constant represents a planet and stores its gravity relative to Earth.
The constructor Planet(double gravity) assigns the gravity for each planet.

### What is `0.38` in the Enum Constants?
In the `Planet` enum, each planet has an associated gravity factor relative to Earth. The number (e.g., `0.38`) represents the gravitational acceleration ratio of that planet compared to Earth's gravity.

#### How is it Determined?
Each planet's gravity is a fraction (or multiple) of Earth's gravity. For example:

- Earth's gravity is taken as 1.00 (100%)
- Mercury's gravity is `0.38` → 38% of Earth's gravity
- Jupiter's gravity is `2.34` → 234% of Earth's gravity

---

### Gravitational Acceleration on Different Planets (in terms of Earth)
| Planet   | Gravity Ratio (Relative to Earth) |
|----------|-----------------------------------|
| Mercury  | 0.38 (38% of Earth's gravity) |
| Venus    | 0.91 (91% of Earth's gravity) |
| Earth    | 1.00 (100% - baseline) |
| Mars     | 0.38 (38% of Earth's gravity) |
| Jupiter  | 2.34 (234% of Earth's gravity) |
| Saturn   | 1.06 (106% of Earth's gravity) |
| Uranus   | 0.92 (92% of Earth's gravity) |
| Neptune  | 1.19 (119% of Earth's gravity) |

---

### How is it Used in Calculation?
When calculating weight on another planet:
```java
public double calculateWeight(double earthWeight) {
    return earthWeight * gravity;
}
```
For example, if you weigh 60 kg on Earth, your weight on Mars (0.38) is:
```
60 * 0.38 = 22.8 kg
```

---

### Why Use These Values?
These values are scientifically derived from each planet’s surface gravity, measured in m/s² (meters per second squared). The values are normalized by dividing them by Earth's gravity (`9.81 m/s²`).

#### Example Calculation for Mercury
- Mercury’s gravity = 3.7 m/s²
- Earth’s gravity = 9.81 m/s²
- Relative gravity = `3.7 / 9.81 = 0.38`

Thus, the value `0.38` means Mercury's gravity is 38% of Earth's gravity.

---

*/