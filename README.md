# Mini Hospital Emergency Management System

## Project Description

A Java console application for managing emergency patients, treatment records, and patient visit histories. This CIT300 assignment demonstrates four data structures implemented from scratch without Java collection classes for the core logic.

## Objectives

- Store and search patient records using a Binary Search Tree.
- Manage emergency arrivals with a FIFO queue.
- Track completed treatments with a LIFO stack.
- Keep a separate singly linked visit history for every patient.
- Apply input validation and object-oriented design in a small, understandable system.

## Technologies Used

- Java 17 or later
- `Scanner` for console input
- No external libraries
- No `ArrayList`, `HashMap`, `TreeMap`, `TreeSet`, or Java `Stack` for the core structures

## Data Structures and Features

### Binary Search Tree

`PatientBST` stores `Patient` objects using `patientId` as the key. It supports insertion, duplicate prevention, search, deletion, and ascending in-order display. Deletion handles leaf nodes, nodes with one child, and nodes with two children by replacing the deleted node with its in-order successor.

### Emergency Queue

`EmergencyQueue` uses `QueueNode` objects with `front` and `rear` references. New patients are linked at the rear and treatment calls remove patients from the front, demonstrating FIFO order.

### Treatment Stack

`TreatmentStack` uses `StackNode` objects and a `top` reference. Completed `TreatmentRecord` objects are pushed at the top and popped from the top, demonstrating LIFO order.

### Patient Visit History

Each `Patient` owns one `VisitHistory`. The history is a custom singly linked list of `VisitNode` objects. Visits can be appended, searched by visit ID, removed, and traversed.

## Class Structure

```text
src/
├── Main.java
├── DataStructureDemo.java
├── Patient.java
├── PatientNode.java
├── PatientBST.java
├── QueueNode.java
├── EmergencyQueue.java
├── TreatmentRecord.java
├── StackNode.java
├── TreatmentStack.java
├── Visit.java
├── VisitNode.java
└── VisitHistory.java
```

## How to Compile and Run

From the project folder:

```text
javac -d out src\\*.java
java -cp out Main
```

Run the repeatable data-structure demonstration:

```text
java -cp out DataStructureDemo
```

## Main Workflow

1. Register a patient. The patient is inserted into the BST.
2. Add the patient to the emergency queue.
3. Call the next patient. The queue removes the earliest arrival.
4. Complete the treatment. A record is pushed onto the treatment stack.
5. Add, search, remove, or display visits for the patient.

## Sample Operations

The `DataStructureDemo` class:

- Inserts five patients with IDs 30, 10, 50, 20, and 40.
- Displays them in ascending order.
- Searches for an existing and missing patient.
- Deletes patient 30.
- Enqueues three patients and dequeues them in FIFO order.
- Pushes three treatments and pops them in LIFO order.
- Adds three visits, searches for one, removes one, and displays the updated history.
- Tests empty queue, empty stack, and missing visit behavior.

## Testing Scenarios

- Enter letters at a numeric menu or ID prompt.
- Try an age below 1 or above 120.
- Register two patients with the same ID.
- Search for and delete a missing patient.
- View or dequeue an empty queue.
- View or pop an empty treatment stack.
- Add duplicate visit IDs to one patient.
- Search for or remove a missing visit.
- Submit an empty name or other required field.

## Suggested GitHub Commit Sequence

1. Initial project structure
2. Added Patient class
3. Implemented Patient BST insertion
4. Added BST search and traversal
5. Added BST deletion
6. Implemented emergency queue
7. Implemented treatment stack
8. Implemented patient visit linked list
9. Added input validation and main menu
10. Added automated demonstration tests
11. Updated README

These are suggestions only. Create the commits yourself so the development history remains authentic.

## Author

Student: ____________________  
Course: CIT300 - Data Structures and Algorithms
