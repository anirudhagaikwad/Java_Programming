package oop;
/*
---
# Detailed Notes on `java.time` API in Java

## Introduction to `java.time` API
- Introduced in Java 8 to replace `java.util.Date` and `java.util.Calendar`.
- Provides ISO 8601-compliant classes for date and time handling.
- Immutable and thread-safe, unlike `Date` and `Calendar`.
- Part of the `java.time` package.

---

## Why `java.time` API?
| Feature | `java.util.Date & Calendar` | `java.time` API |
|---------|-----------------------------|-----------------|
| Thread Safety | Not thread-safe | Immutable and thread-safe |
| Performance | Slower due to mutability | Faster due to immutability |
| Ease of Use | Complex and error-prone | Simple and readable API |
| Time Zones | Requires manual handling | Built-in time zone support |
| Fluent API | No method chaining | Supports method chaining |

---

## Key Classes in `java.time` API
The `java.time` package provides various classes for date and time handling.  

### Date & Time Representations
| Class | Description |
|-------|-------------|
| `LocalDate` | Represents only date (YYYY-MM-DD) without time & timezone. |
| `LocalTime` | Represents only time (HH:MM:SS) without date & timezone. |
| `LocalDateTime` | Represents date & time (YYYY-MM-DD HH:MM:SS) without timezone. |
| `ZonedDateTime` | Represents date, time & timezone. |
| `OffsetDateTime` | Represents date, time, and UTC offset. |
| `OffsetTime` | Represents time with UTC offset. |

### Time Zone & Offset Handling
| Class | Description |
|-------|-------------|
| `ZoneId` | Represents a time zone (e.g., `Asia/Kolkata`, `UTC`). |
| `ZoneOffset` | Represents a fixed offset from UTC (e.g., `+05:30`). |

###  Duration & Period
| Class | Description |
|-------|-------------|
| `Duration` | Represents an exact time-based amount (e.g., 5 hours, 30 minutes). |
| `Period` | Represents a date-based amount (e.g., 2 years, 3 months, 5 days). |

###  Date & Time Formatting
| Class | Description |
|-------|-------------|
| `DateTimeFormatter` | Formats date-time into a string and parses string into date-time. |

---

## Overview of Important Classes
### 1) `LocalDate` – Date Without Time
- Represents only a date without time and timezone.
- Example Format: `2025-02-12`.

### 2) `LocalTime` – Time Without Date
- Represents only time without date and timezone.
- Example Format: `14:30:15`.

### 3) `LocalDateTime` – Date & Time Without Timezone
- Represents both date and time but without timezone information.
- Example Format: `2025-02-12T14:30:15`.

### 4) `ZonedDateTime` – Date & Time With Timezone
- Represents date, time, and time zone information.
- Example Format: `2025-02-12T14:30:15+05:30[Asia/Kolkata]`.

### 5) `Instant` – Timestamp (UTC)
- Represents a point in time (UTC time).
- Example Format: `2025-02-12T09:00:00Z`.

### 6) `Duration` & `Period`
- `Duration` represents time-based differences (e.g., 5 hours, 10 minutes).
- `Period` represents date-based differences (e.g., 2 years, 3 months, 5 days).

### 7) `DateTimeFormatter` – Formatting & Parsing
- Provides methods to convert date-time to string and parse string to date-time.
- Supports predefined formats (ISO, RFC) and custom patterns.

---

## Use Cases Table
| Use Case | Recommended Class |
|----------|------------------|
| Current date without time | `LocalDate.now()` |
| Current time without date | `LocalTime.now()` |
| Current date & time (without timezone) | `LocalDateTime.now()` |
| Current timestamp in UTC | `Instant.now()` |
| Date-time with timezone | `ZonedDateTime.now(ZoneId.of("Asia/Kolkata"))` |
| Convert string to date-time | `LocalDate.parse("2025-02-12")` |
| Format date-time to string | `DateTimeFormatter.ofPattern("dd/MM/yyyy")` |

---

## Conclusion
- The `java.time` API provides a modern, efficient, and thread-safe way to handle date and time in Java.
- Replaces the legacy `Date` and `Calendar` classes.
- Offers built-in time zone support, better performance, and a more readable API.

---

## Date, DateTime, Calendar Class, LocalDate
### 1) `java.util.Date`
- Represents date and time in milliseconds from January 1, 1970 (Epoch Time).
- Deprecated in favor of Calendar & java.time API.

### 2) `java.util.Calendar`
- Provides more advanced date/time manipulation.
- Allows setting, adding, and rolling dates easily.
- Example: `Calendar.getInstance()` to get the current date/time.

### 3) `java.time.LocalDate & LocalDateTime`
- Introduced in Java 8.
- Immutable and thread-safe.
- Supports ISO 8601 standard.
- `LocalDate.now()` – Gets the current date.
- `LocalDateTime.now()` – Gets current date and time.

---

 
*/

import java.time.LocalDate;               // For handling date (YYYY-MM-DD)
import java.time.LocalTime;               // For handling time (HH:MM:SS)
import java.time.LocalDateTime;           // For handling date and time together
import java.time.ZonedDateTime;           // Date-Time with Time Zone
import java.time.ZoneId;                  // Represents time zones
import java.time.Duration;                // For time-based differences
import java.time.Period;                  // For date-based differences
import java.time.format.DateTimeFormatter; // For formatting date and time

import java.time.YearMonth;
import java.time.DayOfWeek;


public class P29_DateTime {
	    public static void main(String[] args) {
	        // ✅ Get the current date
	        LocalDate today = LocalDate.now();
	        System.out.println("Current Date: " + today);

	        // ✅ Get the current time
	        LocalTime time = LocalTime.now();
	        System.out.println("Current Time: " + time);

	        // ✅ Get both date and time
	        LocalDateTime dateTime = LocalDateTime.now();
	        System.out.println("Current DateTime: " + dateTime);

	        // ✅ Format date and time
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	        System.out.println("Formatted DateTime: " + dateTime.format(formatter));

	        // ✅ Add 10 days to the current date
	        LocalDate futureDate = today.plusDays(10);
	        System.out.println("Date after 10 days: " + futureDate);

	        // ✅ Get time in different time zones
	        ZonedDateTime newYorkTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
	        System.out.println("Time in New York: " + newYorkTime);

	        // ✅ Difference between two dates
	        Period period = Period.between(today, futureDate);
	        System.out.println("Days between: " + period.getDays());

	        // ✅ Difference between two time instances
	        Duration duration = Duration.between(LocalTime.of(10, 0), LocalTime.of(12, 30));
	        System.out.println("Hours Difference: " + duration.toHours());
	        
	        printCalendar(2024, 2); // Example: Print calendar for February 2024
	        
            // Example: Date Conversion
            String dateStr = "15-02-2025"; // DD-MM-YYYY format
            LocalDate date = stringToDate(dateStr);
            String newDateStr = dateToString(date);

            System.out.println("String to Date: " + date);
            System.out.println("Date to String: " + newDateStr);

            // Example: Time Conversion
            String timeStr = "14:30:45"; // HH:mm:ss format
            LocalTime time1 = stringToTime(timeStr);
            String newTimeStr = timeToString(time1);

            System.out.println("String to Time: " + time1);
            System.out.println("Time to String: " + newTimeStr);
	    }
	     

	        /**
	         * Prints the calendar for a given year and month.
	         * @param year  The year (e.g., 2024)
	         * @param month The month (1 to 12)
	         */
	        static void printCalendar(int year, int month) {
	            // Get the first day of the given month and year
	            YearMonth yearMonth = YearMonth.of(year, month);
	            LocalDate firstDay = yearMonth.atDay(1);
	            
	            // Find the day of the week the month starts on
	            DayOfWeek startDay = firstDay.getDayOfWeek();
	            
	            // Get the total number of days in the month
	            int daysInMonth = yearMonth.lengthOfMonth();
	            
	            System.out.println("\n📅 Calendar for " + yearMonth);
	            System.out.println("Sun Mon Tue Wed Thu Fri Sat");
	            
	            // Print leading spaces for the first week
	            int startDayValue = startDay.getValue() % 7; // Adjust Sunday to be at index 0
	            for (int i = 0; i < startDayValue; i++) {
	                System.out.print("    "); // 4 spaces
	            }

	            // Print all days of the month
	            for (int day = 1; day <= daysInMonth; day++) {
	                System.out.printf("%3d ", day); // Print day with padding
	                if ((day + startDayValue) % 7 == 0) { // Move to next line after Saturday
	                    System.out.println();
	                }
	            }
	            System.out.println(); // Newline for spacing
	        }

	
	            /**
	             * Converts a String to LocalDate in "DD-MM-YYYY" format
	             * @param dateStr The date string in format "dd-MM-yyyy"
	             * @return LocalDate object
	             */
	            static LocalDate stringToDate(String dateStr) {
	                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	                return LocalDate.parse(dateStr, formatter);
	            }

	            /**
	             * Converts a LocalDate to String in "DD-MM-YYYY" format
	             * @param date LocalDate object
	             * @return String representation in "dd-MM-yyyy"
	             */
	            static String dateToString(LocalDate date) {
	                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	                return date.format(formatter);
	            }

	            /**
	             * Converts a String to LocalTime in "HH:mm:ss" format
	             * @param timeStr The time string in format "HH:mm:ss"
	             * @return LocalTime object
	             */
	            static LocalTime stringToTime(String timeStr) {
	                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	                return LocalTime.parse(timeStr, formatter);
	            }

	            /**
	             * Converts a LocalTime to String in "HH:mm:ss" format
	             * @param time LocalTime object
	             * @return String representation in "HH:mm:ss"
	             */
	            static String timeToString(LocalTime time) {
	                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	                return time.format(formatter);
	            }
              	    
	    
	}
	