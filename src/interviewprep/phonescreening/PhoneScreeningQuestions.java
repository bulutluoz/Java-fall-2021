package interviewprep.phonescreening;

/**
 * PHONE SCREENING QUESTIONS
 *
 * Phone screens typically last 30-45 minutes and cover:
 * - Your background and experience (5-10 min)
 * - Technical fundamentals (15-20 min)
 * - Behavioral questions (5-10 min)
 * - Questions for interviewer (5 min)
 *
 * Tips:
 * - Find a quiet space with good internet connection
 * - Have resume, job description, and notepad ready
 * - Be ready to code in a shared editor (CoderPad, HackerRank, etc.)
 * - Speak clearly and think out loud
 * - It's okay to ask clarifying questions
 */
public class PhoneScreeningQuestions {

    /**
     * ===== JAVA FUNDAMENTALS =====
     */

    public static final String Q1_OOP_PRINCIPLES = """
            Q: Explain the four pillars of Object-Oriented Programming.

            A: The four pillars are:

            1. ENCAPSULATION:
               - Bundling data (fields) and methods that operate on that data within a class
               - Hiding internal state and requiring interaction through methods
               - Example: Private fields with public getters/setters

               public class BankAccount {
                   private double balance;  // Hidden from outside

                   public void deposit(double amount) {  // Controlled access
                       if (amount > 0) balance += amount;
                   }
               }

            2. INHERITANCE:
               - Mechanism where a new class (child) inherits properties and methods from existing class (parent)
               - Promotes code reuse and establishes "is-a" relationship
               - Example:

               public class Animal {
                   public void eat() { }
               }

               public class Dog extends Animal {  // Dog IS-A Animal
                   public void bark() { }
               }

            3. POLYMORPHISM:
               - Ability of objects to take many forms
               - Same method name, different implementations
               - Two types: Compile-time (overloading) and Runtime (overriding)

               Animal myDog = new Dog();  // Dog object, Animal reference
               myDog.eat();  // Calls Dog's implementation if overridden

            4. ABSTRACTION:
               - Hiding complex implementation details, showing only essential features
               - Achieved through abstract classes and interfaces
               - Example:

               public interface PaymentProcessor {
                   void processPayment(double amount);  // What to do, not how
               }
            """;

    public static final String Q2_ABSTRACT_VS_INTERFACE = """
            Q: What's the difference between abstract class and interface?

            A: Key differences:

            ABSTRACT CLASS:
            - Can have both abstract and concrete methods
            - Can have constructors
            - Can have instance variables (fields)
            - Supports access modifiers (private, protected, public)
            - Class can extend only ONE abstract class (single inheritance)
            - Use when: Classes share common code and have "is-a" relationship

            Example:
            public abstract class Vehicle {
                private String brand;  // Instance variable

                public Vehicle(String brand) {  // Constructor
                    this.brand = brand;
                }

                public abstract void start();  // Abstract method

                public void stop() {  // Concrete method
                    System.out.println("Vehicle stopped");
                }
            }

            INTERFACE:
            - All methods are abstract by default (before Java 8)
            - Java 8+: Can have default and static methods
            - Java 9+: Can have private methods
            - Cannot have constructors
            - Cannot have instance variables (only constants: public static final)
            - Class can implement MULTIPLE interfaces
            - Use when: Defining a contract, need multiple inheritance of type

            Example:
            public interface Flyable {
                void fly();  // Abstract method

                default void land() {  // Default method (Java 8+)
                    System.out.println("Landing...");
                }
            }

            public class Airplane extends Vehicle implements Flyable, Drivable {
                // Can extend one class, implement multiple interfaces
            }

            WHEN TO USE:
            - Abstract class: When you have common implementation to share
            - Interface: When you're defining capability/behavior that unrelated classes might share
            """;

    public static final String Q3_STRING_IMMUTABILITY = """
            Q: Why are Strings immutable in Java? What are the benefits?

            A: String immutability means once a String object is created, it cannot be changed.

            WHY:
            1. String Pool Optimization:
               - Java maintains a String pool in heap memory
               - Identical string literals share the same object
               - Saves memory

               String s1 = "Java";
               String s2 = "Java";  // Both point to same object in pool

            2. Security:
               - Strings are used for sensitive data (passwords, URLs, file paths)
               - If mutable, one reference could change value for all references
               - Database connections, network connections use Strings

            3. Thread Safety:
               - Immutable objects are inherently thread-safe
               - No synchronization needed
               - Can be safely shared between threads

            4. Hashcode Caching:
               - String's hashcode is cached after first calculation
               - Makes Strings efficient as HashMap keys
               - Won't change because String won't change

            5. Class Loading:
               - Class names are Strings
               - If mutable, wrong class could be loaded

            IMPLICATIONS:
            - String concatenation creates new objects (use StringBuilder for loops)
            - Safe to pass Strings around without defensive copying

            Example showing immutability:
            String str = "Hello";
            str.concat(" World");  // Creates new String, doesn't modify str
            System.out.println(str);  // Still "Hello"

            str = str.concat(" World");  // Now str refers to new String
            System.out.println(str);  // "Hello World"
            """;

    public static final String Q4_EQUALS_VS_HASHCODE = """
            Q: Explain the contract between equals() and hashCode(). Why must they be overridden together?

            A: The equals-hashCode contract:

            CONTRACT RULES:
            1. If two objects are equal (equals() returns true), they MUST have the same hashCode
            2. If two objects have the same hashCode, they don't have to be equal
            3. If equals() is overridden, hashCode() MUST be overridden
            4. Both should use the same fields for comparison

            WHY IT MATTERS:
            Hash-based collections (HashMap, HashSet) use hashCode() first, then equals():
            1. Calculate hashCode() to find the bucket
            2. Use equals() to find the exact object in that bucket

            PROBLEM IF NOT BOTH OVERRIDDEN:

            class Person {
                String name;
                int age;

                // Only override equals, forget hashCode
                @Override
                public boolean equals(Object o) {
                    if (this == o) return true;
                    if (!(o instanceof Person)) return false;
                    Person p = (Person) o;
                    return age == p.age && name.equals(p.name);
                }
                // hashCode() not overridden - uses Object's default (memory address)
            }

            Person p1 = new Person("John", 30);
            Person p2 = new Person("John", 30);

            p1.equals(p2);  // true (we overrode equals)

            Set<Person> set = new HashSet<>();
            set.add(p1);
            set.contains(p2);  // FALSE! (Different hashCodes, different buckets)

            CORRECT IMPLEMENTATION:

            class Person {
                String name;
                int age;

                @Override
                public boolean equals(Object o) {
                    if (this == o) return true;
                    if (!(o instanceof Person)) return false;
                    Person p = (Person) o;
                    return age == p.age && Objects.equals(name, p.name);
                }

                @Override
                public int hashCode() {
                    return Objects.hash(name, age);  // Same fields as equals
                }
            }

            BEST PRACTICE:
            - Use IDE generation or Objects.equals() and Objects.hash()
            - Include same fields in both methods
            - Never modify fields used in hashCode after adding to hash collection
            """;

    public static final String Q5_EXCEPTION_HIERARCHY = """
            Q: Explain Java's exception hierarchy. Difference between checked and unchecked exceptions?

            A: Java Exception Hierarchy:

                        Throwable
                       /         \\
                   Error          Exception
                  /  |  \\        /         \\
               OOM  SO  etc.   Checked    RuntimeException (Unchecked)
                                 |              /    |    \\
                            IOException   NPE  IOOBE  IAE

            CHECKED EXCEPTIONS (compile-time checked):
            - Must be handled or declared
            - Recoverable conditions
            - Compiler enforces handling
            - Extend Exception (but not RuntimeException)

            Examples:
            - IOException
            - SQLException
            - FileNotFoundException
            - ClassNotFoundException

            Code must handle:
            try {
                FileReader fr = new FileReader("file.txt");  // Checked exception
            } catch (FileNotFoundException e) {
                // Handle
            }

            Or declare:
            public void readFile() throws IOException {
                FileReader fr = new FileReader("file.txt");
            }

            UNCHECKED EXCEPTIONS (runtime exceptions):
            - Not checked at compile time
            - Usually programming errors
            - Should be prevented by proper coding
            - Extend RuntimeException

            Examples:
            - NullPointerException
            - ArrayIndexOutOfBoundsException
            - IllegalArgumentException
            - ArithmeticException

            int[] arr = new int[5];
            arr[10] = 5;  // Compiles fine, fails at runtime

            ERRORS:
            - Serious problems that applications shouldn't try to catch
            - Usually external to application
            - Examples: OutOfMemoryError, StackOverflowError

            WHEN TO USE WHICH:
            - Checked: For recoverable conditions (file not found, network down)
            - Unchecked: For programming bugs (null pointer, illegal argument)

            BEST PRACTICES:
            - Don't catch Exception or Throwable (too broad)
            - Catch specific exceptions
            - Don't use exceptions for flow control
            - Always clean up resources (use try-with-resources)
            """;

    /**
     * ===== COLLECTIONS FRAMEWORK =====
     */

    public static final String Q6_ARRAYLIST_VS_LINKEDLIST = """
            Q: When would you use ArrayList vs LinkedList?

            A: Key differences:

            ARRAYLIST (Dynamic Array):
            - Backed by array
            - Fast random access: O(1)
            - Slow insertion/deletion in middle: O(n)
            - Fast append (amortized): O(1)
            - Better memory locality (cache-friendly)
            - Less memory overhead per element

            USE WHEN:
            - Frequent random access by index
            - Iteration over elements
            - Adding to end
            - Memory efficiency important

            Example:
            List<String> names = new ArrayList<>();
            names.get(100);  // Fast - O(1)
            names.add("John");  // Fast at end
            names.remove(50);  // Slow - shifts elements

            LINKEDLIST (Doubly Linked List):
            - Node-based structure
            - Slow random access: O(n)
            - Fast insertion/deletion at ends: O(1)
            - Fast insertion/deletion in middle (if you have reference): O(1)
            - More memory overhead (node references)

            USE WHEN:
            - Frequent insertion/deletion at beginning or middle
            - Implementing queue or deque
            - Don't need random access
            - Size changes frequently

            Example:
            List<String> queue = new LinkedList<>();
            queue.add(0, "First");  // Fast at beginning
            queue.get(100);  // Slow - must traverse

            PERFORMANCE COMPARISON:

            Operation       | ArrayList | LinkedList
            ----------------|-----------|-----------
            get(index)      | O(1)      | O(n)
            add(element)    | O(1)*     | O(1)
            add(0, element) | O(n)      | O(1)
            remove(index)   | O(n)      | O(n)**
            remove(element) | O(n)      | O(n)
            contains()      | O(n)      | O(n)

            * Amortized - occasionally O(n) when resizing
            ** O(1) if you have iterator/reference to node

            REAL-WORLD ADVICE:
            - Default to ArrayList (95% of cases)
            - Use LinkedList only if you specifically need:
              * Queue/Deque operations
              * Frequent insertion/deletion at beginning
              * Memory usage isn't critical
            """;

    public static final String Q7_HASHMAP_INTERNALS = """
            Q: How does HashMap work internally?

            A: HashMap internals:

            BASIC STRUCTURE:
            - Array of buckets (nodes)
            - Each bucket can hold multiple entries (linked list or tree)
            - Uses key's hashCode to determine bucket
            - Uses equals() to find exact entry in bucket

            HOW PUT WORKS:
            1. Calculate hashCode of key
            2. Apply hash function to get bucket index
            3. If bucket empty, add entry
            4. If bucket has entries, check equals():
               - If key exists, replace value
               - If key doesn't exist, add to bucket

            Example:
            map.put("John", 25);

            1. "John".hashCode() → 2314539
            2. hash(2314539) % bucketArray.length → bucket 7
            3. Go to bucket 7
            4. Check if "John" exists using equals()
            5. Store Entry("John", 25)

            HOW GET WORKS:
            1. Calculate hashCode of key
            2. Find bucket using hash function
            3. Search bucket using equals()
            4. Return value if found, null otherwise

            COLLISION HANDLING:
            When two keys map to same bucket:

            Java 7: Linked List
            - O(n) worst case for retrieval

            Java 8+: Linked List → Tree (Red-Black Tree)
            - If bucket has >8 entries, convert to tree
            - O(log n) worst case
            - If entries drop to ≤6, convert back to list

            CAPACITY AND LOAD FACTOR:
            - Initial capacity: 16
            - Load factor: 0.75 (75%)
            - Rehashing: When size > capacity * loadFactor
            - Rehashing doubles capacity, redistributes all entries

            Example:
            HashMap<String, Integer> map = new HashMap<>(16, 0.75f);
            // Rehashes when size > 12 (16 * 0.75)

            TIME COMPLEXITY:
            - get(): O(1) average, O(log n) worst case (Java 8+)
            - put(): O(1) average, O(log n) worst case (Java 8+)
            - containsKey(): O(1) average

            IMPORTANT NOTES:
            - Not thread-safe (use ConcurrentHashMap for multithreading)
            - Allows one null key, multiple null values
            - Iteration order not guaranteed (use LinkedHashMap for insertion order)
            - Keys should be immutable (or at least hashCode fields shouldn't change)

            WHY HASHMAP IS FAST:
            - Direct array access using hash: O(1)
            - Good hash function distributes keys evenly
            - Tree structure handles collisions efficiently
            """;

    public static final String Q8_COMPARABLE_VS_COMPARATOR = """
            Q: What's the difference between Comparable and Comparator?

            A:

            COMPARABLE (java.lang.Comparable):
            - Interface with ONE method: compareTo()
            - Provides NATURAL ORDERING
            - Class itself implements the interface
            - Used by Collections.sort() and Arrays.sort() by default

            Example:
            public class Employee implements Comparable<Employee> {
                private String name;
                private int age;

                @Override
                public int compareTo(Employee other) {
                    return this.age - other.age;  // Sort by age (natural order)
                }
            }

            List<Employee> employees = new ArrayList<>();
            Collections.sort(employees);  // Uses compareTo() - sorts by age

            COMPARATOR (java.util.Comparator):
            - Separate interface with method: compare()
            - Provides CUSTOM ORDERING
            - External to the class being compared
            - Can have multiple comparators for different orderings
            - Used when you can't modify class or need multiple orderings

            Example:
            public class NameComparator implements Comparator<Employee> {
                @Override
                public int compare(Employee e1, Employee e2) {
                    return e1.getName().compareTo(e2.getName());
                }
            }

            public class SalaryComparator implements Comparator<Employee> {
                @Override
                public int compare(Employee e1, Employee e2) {
                    return e1.getSalary() - e2.getSalary();
                }
            }

            List<Employee> employees = new ArrayList<>();
            Collections.sort(employees, new NameComparator());  // Sort by name
            Collections.sort(employees, new SalaryComparator());  // Sort by salary

            JAVA 8+ LAMBDA APPROACH:

            // Sort by name
            employees.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));

            // Or using Comparator helper methods
            employees.sort(Comparator.comparing(Employee::getName));
            employees.sort(Comparator.comparing(Employee::getAge).reversed());

            // Chaining comparators
            employees.sort(
                Comparator.comparing(Employee::getDepartment)
                          .thenComparing(Employee::getSalary)
                          .reversed()
            );

            KEY DIFFERENCES:

            Aspect          | Comparable              | Comparator
            ----------------|-------------------------|---------------------------
            Package         | java.lang               | java.util
            Method          | compareTo(T o)          | compare(T o1, T o2)
            Location        | Same class              | Separate class/lambda
            Orderings       | One (natural)           | Multiple (custom)
            Modification    | Must modify class       | No class modification needed
            Usage           | Collections.sort(list)  | Collections.sort(list, comparator)

            WHEN TO USE:
            - Comparable: When there's ONE obvious natural ordering
            - Comparator: When you need multiple ways to sort or can't modify the class

            BEST PRACTICES:
            - compareTo should be consistent with equals
            - Use Comparator.comparing() for cleaner code
            - Consider null handling in comparators
            """;

    /**
     * ===== MULTI-THREADING =====
     */

    public static final String Q9_THREAD_CREATION = """
            Q: What are the ways to create a thread in Java?

            A: Three main ways:

            METHOD 1: Extend Thread class

            public class MyThread extends Thread {
                @Override
                public void run() {
                    System.out.println("Thread running: " + Thread.currentThread().getName());
                }
            }

            // Usage
            MyThread thread = new MyThread();
            thread.start();  // Starts new thread, calls run()

            Pros: Simple
            Cons: Can't extend another class (single inheritance)

            METHOD 2: Implement Runnable interface (PREFERRED)

            public class MyRunnable implements Runnable {
                @Override
                public void run() {
                    System.out.println("Runnable running: " + Thread.currentThread().getName());
                }
            }

            // Usage
            Thread thread = new Thread(new MyRunnable());
            thread.start();

            Pros:
            - Can extend other classes
            - Better OOP design (separate task from thread)
            - Can be used with ExecutorService

            METHOD 3: Lambda expression (Java 8+)

            Thread thread = new Thread(() -> {
                System.out.println("Lambda thread: " + Thread.currentThread().getName());
            });
            thread.start();

            Or with Runnable:
            Runnable task = () -> System.out.println("Task running");
            new Thread(task).start();

            METHOD 4: ExecutorService (MODERN APPROACH)

            ExecutorService executor = Executors.newFixedThreadPool(5);

            executor.submit(() -> {
                System.out.println("Executor task");
            });

            executor.shutdown();

            Pros:
            - Thread pooling (reuse threads)
            - Better resource management
            - Supports Callable (returns result)
            - Built-in task queue

            METHOD 5: Callable and Future (when you need return value)

            Callable<Integer> task = () -> {
                return 42;
            };

            ExecutorService executor = Executors.newSingleThreadExecutor();
            Future<Integer> future = executor.submit(task);
            Integer result = future.get();  // Blocks until result available

            COMPARISON:

            Thread vs Runnable:
            - Runnable is preferred (better design)
            - Runnable can be used with ExecutorService

            ExecutorService vs Thread:
            - ExecutorService for production code
            - Thread for simple cases

            IMPORTANT NOTES:
            - Call start(), not run()
            - start() creates new thread; run() executes in current thread
            - Thread can only be started once
            - Always handle InterruptedException
            """;

    public static final String Q10_SYNCHRONIZED_KEYWORD = """
            Q: Explain the synchronized keyword. When and how to use it?

            A: synchronized prevents race conditions by allowing only one thread at a time.

            SYNCHRONIZED METHOD:

            public class Counter {
                private int count = 0;

                public synchronized void increment() {
                    count++;  // Only one thread can execute this at a time
                }

                public synchronized int getCount() {
                    return count;
                }
            }

            - Locks on the object instance (this)
            - Other synchronized methods on same object must wait
            - Non-synchronized methods can still run

            SYNCHRONIZED BLOCK (preferred for fine-grained control):

            public class BankAccount {
                private double balance;
                private final Object lock = new Object();  // Explicit lock object

                public void deposit(double amount) {
                    // Non-critical code here (not synchronized)

                    synchronized(lock) {  // Only critical section synchronized
                        balance += amount;
                    }

                    // More non-critical code
                }
            }

            Benefits:
            - Only locks critical section
            - Can use different lock objects for different operations
            - Better performance

            STATIC SYNCHRONIZED METHOD:

            public class Singleton {
                private static Singleton instance;

                public static synchronized Singleton getInstance() {
                    if (instance == null) {
                        instance = new Singleton();
                    }
                    return instance;
                }
            }

            - Locks on the Class object
            - All threads calling this method must wait

            CLASS LEVEL LOCK:

            synchronized(ClassName.class) {
                // Critical section
            }

            PROBLEMS IT SOLVES:

            Without synchronization:
            class Counter {
                private int count = 0;

                public void increment() {
                    count++;  // Not atomic! Three operations:
                              // 1. Read count
                              // 2. Add 1
                              // 3. Write back
                }
            }

            Thread 1: reads 5, calculates 6
            Thread 2: reads 5, calculates 6  (before Thread 1 writes)
            Thread 1: writes 6
            Thread 2: writes 6
            Result: 6 (should be 7!)  ← Race condition

            WHEN TO USE:
            - Modifying shared mutable state
            - Multiple threads accessing same resource
            - Need atomicity for operations

            WHEN NOT TO USE:
            - Immutable objects (no synchronization needed)
            - Thread-local variables
            - Read-only operations (though ReadWriteLock might be better)

            ALTERNATIVES (Modern Java):
            - java.util.concurrent.atomic (AtomicInteger, AtomicReference)
            - java.util.concurrent.locks (ReentrantLock, ReadWriteLock)
            - ConcurrentHashMap, CopyOnWriteArrayList

            Example with AtomicInteger:
            class Counter {
                private AtomicInteger count = new AtomicInteger(0);

                public void increment() {
                    count.incrementAndGet();  // Atomic, no synchronization needed
                }
            }

            PERFORMANCE CONSIDERATIONS:
            - Synchronization has overhead
            - Can cause contention (threads waiting)
            - Keep synchronized blocks small
            - Consider lock-free alternatives for simple operations
            """;

    /**
     * ===== DESIGN PATTERNS (Quick Overview) =====
     */

    public static final String Q11_SINGLETON_PATTERN = """
            Q: Explain Singleton pattern and how to implement it in Java.

            A: Singleton ensures only ONE instance of a class exists.

            USE CASES:
            - Database connection pool
            - Configuration manager
            - Logger
            - Cache
            - Thread pool

            IMPLEMENTATION 1: Eager Initialization (simple, thread-safe)

            public class Singleton {
                private static final Singleton INSTANCE = new Singleton();

                private Singleton() {  // Private constructor
                }

                public static Singleton getInstance() {
                    return INSTANCE;
                }
            }

            Pros: Simple, thread-safe
            Cons: Created even if never used

            IMPLEMENTATION 2: Lazy Initialization (not thread-safe)

            public class Singleton {
                private static Singleton instance;

                private Singleton() {
                }

                public static Singleton getInstance() {
                    if (instance == null) {
                        instance = new Singleton();
                    }
                    return instance;
                }
            }

            Problem: Multiple threads can create multiple instances

            IMPLEMENTATION 3: Thread-Safe Lazy (synchronized method)

            public class Singleton {
                private static Singleton instance;

                private Singleton() {
                }

                public static synchronized Singleton getInstance() {
                    if (instance == null) {
                        instance = new Singleton();
                    }
                    return instance;
                }
            }

            Pros: Thread-safe
            Cons: Synchronization overhead on every call

            IMPLEMENTATION 4: Double-Checked Locking (RECOMMENDED)

            public class Singleton {
                private static volatile Singleton instance;  // volatile is crucial

                private Singleton() {
                }

                public static Singleton getInstance() {
                    if (instance == null) {  // First check (no locking)
                        synchronized (Singleton.class) {
                            if (instance == null) {  // Second check (with locking)
                                instance = new Singleton();
                            }
                        }
                    }
                    return instance;
                }
            }

            Pros: Lazy, thread-safe, minimal synchronization
            Note: volatile prevents instruction reordering

            IMPLEMENTATION 5: Bill Pugh (Inner Static Helper)

            public class Singleton {
                private Singleton() {
                }

                private static class SingletonHelper {
                    private static final Singleton INSTANCE = new Singleton();
                }

                public static Singleton getInstance() {
                    return SingletonHelper.INSTANCE;
                }
            }

            Pros: Lazy, thread-safe (classloader handles synchronization), no synchronization overhead
            Best choice for most cases

            IMPLEMENTATION 6: Enum (MOST RECOMMENDED)

            public enum Singleton {
                INSTANCE;

                public void someMethod() {
                    // Your singleton behavior
                }
            }

            // Usage
            Singleton.INSTANCE.someMethod();

            Pros:
            - Simplest
            - Thread-safe by default
            - Prevents reflection attacks
            - Handles serialization automatically

            PITFALLS TO AVOID:
            1. Reflection can break singleton (except enum)
            2. Serialization can create new instance (need readResolve())
            3. Cloning can create new instance (override clone() to throw exception)

            TESTING CHALLENGES:
            - Singletons are hard to mock
            - Consider dependency injection instead
            - For testing, make getInstance() mockable
            """;

    /**
     * ===== COMMON CODING QUESTIONS (Quick) =====
     */

    public static final String Q12_REVERSE_STRING = """
            Q: Write a method to reverse a string.

            A: Multiple approaches:

            APPROACH 1: Using StringBuilder (BEST)

            public static String reverseString(String str) {
                return new StringBuilder(str).reverse().toString();
            }

            Time: O(n), Space: O(n)
            Pros: Built-in, efficient, readable

            APPROACH 2: Two-pointer swap

            public static String reverseString(String str) {
                char[] chars = str.toCharArray();
                int left = 0, right = chars.length - 1;

                while (left < right) {
                    char temp = chars[left];
                    chars[left] = chars[right];
                    chars[right] = temp;
                    left++;
                    right--;
                }

                return new String(chars);
            }

            Time: O(n), Space: O(n) for char array

            APPROACH 3: Recursive

            public static String reverseString(String str) {
                if (str.isEmpty()) {
                    return str;
                }
                return reverseString(str.substring(1)) + str.charAt(0);
            }

            Time: O(n²) due to substring, Space: O(n) recursion stack
            Not recommended for production

            APPROACH 4: Stream API (Java 8+)

            public static String reverseString(String str) {
                return str.chars()
                    .mapToObj(c -> (char) c)
                    .reduce("", (s, c) -> c + s, (s1, s2) -> s2 + s1);
            }

            Readable but less efficient

            For interview: Use StringBuilder unless asked to implement manually,
            then use two-pointer approach.
            """;

    public static final String Q13_PALINDROME_CHECK = """
            Q: Check if a string is a palindrome.

            A:

            public static boolean isPalindrome(String str) {
                // Clean and normalize
                str = str.toLowerCase().replaceAll("[^a-z0-9]", "");

                int left = 0;
                int right = str.length() - 1;

                while (left < right) {
                    if (str.charAt(left) != str.charAt(right)) {
                        return false;
                    }
                    left++;
                    right--;
                }

                return true;
            }

            Time: O(n), Space: O(n) for cleaned string

            Test cases:
            "A man a plan a canal Panama" → true
            "race a car" → false
            "Was it a car or a cat I saw?" → true
            """;

    /**
     * ===== QUESTIONS YOU SHOULD ASK =====
     */

    public static final String QUESTIONS_TO_ASK_INTERVIEWER = """
            ABOUT THE ROLE:
            1. What would my typical day look like?
            2. What technologies does the team use?
            3. What are the biggest challenges for this role in the first 3 months?
            4. How would you describe the team culture?

            ABOUT THE TEAM:
            1. How large is the team?
            2. What's the experience level of team members?
            3. How does the team collaborate (remote/in-person)?

            ABOUT THE COMPANY:
            1. What excites you most about the company's future?
            2. How does the company support professional development?

            ABOUT NEXT STEPS:
            1. What are the next steps in the interview process?
            2. When can I expect to hear back?
            3. Is there anything else I can provide?

            DON'T ASK (in phone screen):
            - Salary/benefits (unless they bring it up)
            - "What does your company do?" (research this beforehand!)
            - Too many questions about work-life balance (might seem like red flag)
            """;

    /**
     * ===== TIPS FOR PHONE SCREEN SUCCESS =====
     */

    public static final String PHONE_SCREEN_TIPS = """
            BEFORE THE CALL:
            ✓ Research the company thoroughly
            ✓ Review your resume and prepare to discuss each point
            ✓ Review job description and match your experience
            ✓ Prepare your environment (quiet space, good connection)
            ✓ Have notepad, pen, and water ready
            ✓ Test screen sharing if coding expected

            DURING THE CALL:
            ✓ Answer clearly and concisely
            ✓ Think out loud when solving problems
            ✓ Ask clarifying questions before solving coding problems
            ✓ Admit when you don't know something
            ✓ Show enthusiasm for the role
            ✓ Take notes about the role/company

            FOR TECHNICAL QUESTIONS:
            ✓ Restate the question to confirm understanding
            ✓ Discuss approach before coding
            ✓ Start with a working solution, then optimize
            ✓ Test your solution with examples
            ✓ Discuss time and space complexity

            AFTER THE CALL:
            ✓ Send thank-you email within 24 hours
            ✓ Mention specific topics discussed
            ✓ Reiterate your interest
            ✓ Note any questions you struggled with for future prep

            RED FLAGS TO AVOID:
            ✗ Badmouthing previous employers
            ✗ Being unprepared ("What does your company do?")
            ✗ Only caring about salary/benefits
            ✗ Not having any questions
            ✗ Being late or unprepared
            ✗ Getting defensive about feedback
            """;
}
