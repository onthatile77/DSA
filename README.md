# Data Structures and Algorithms (Java)

Core data structures and algorithms implemented **from scratch in Java**, without relying on the built-in `java.util` collections. The aim is to understand how these structures work internally, and how the choice of underlying structure affects behaviour.

I also support second-year students in Data Structures and Algorithms (Java) as a Student Assistant at North-West University.

## What's inside

| File | Description |
| --- | --- |
| `MyArrayList.java` | Dynamic array-backed list |
| `MyLinkedList.java` | Linked list built from nodes |
| `MyStackAsArrayList.java` | Stack implemented on top of `MyArrayList` |
| `MyStackAsLinkedList.java` | Stack implemented on top of `MyLinkedList` |
| `QueueAsMyArrayList.java` | Queue implemented on top of `MyArrayList` |
| `QueueAsMyLinkedList.java` | Queue implemented on top of `MyLinkedList` |
| `MySort.java` | Sorting algorithms [list which ones, e.g. bubble, insertion, merge, quick] |

## Design approach

- **Build the foundations first.** `MyArrayList` and `MyLinkedList` are written from scratch.
- **Reuse them.** Stacks and queues are each built twice, once on the array-backed list and once on the linked list, so the two designs can be compared side by side.
- **Keep the abstractions clean.** The stack and queue classes expose only the operations a stack or queue should have (for example push/pop and enqueue/dequeue), built on the underlying list.

## Tech stack

- Java ([version, e.g. 17])
- Object-oriented design: encapsulation, composition, [generics, if used]

## Getting started

### Prerequisites

- JDK [version] or later

### Compile and run

```bash
# Clone the repository
git clone https://github.com/onthatile77/DSA.git
cd DSA

# Compile everything
javac *.java

# Run [your main/demo class, if you have one]
java [MainClassName]
```

## Example usage

```java
// Replace with a short snippet from your own code
MyStackAsLinkedList<Integer> stack = new MyStackAsLinkedList<>();
stack.push(1);
stack.push(2);
System.out.println(stack.pop()); // 2
```

> Adjust the class names, generics and method names above to match your code.

## What I learned

- How array-backed and node-based structures differ in memory layout and in the cost of common operations
- How to build higher-level structures (stacks, queues) by composing lower-level ones
- How sorting algorithms work step by step, and how to compare them
- How generics help in the reduction of code redundancy since one class can handle multiple types without specifying them.

## Author

**Moila Leatile Onthatile**, BSc Information Technology, North-West University
GitHub: [@onthatile77](https://github.com/onthatile77) | Email: onthatile.0318@gmail.com
