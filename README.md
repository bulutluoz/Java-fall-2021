# Java Bootcamp Fall 2021 - Enhanced Edition

![snake gif](https://github.com/bulutluoz/Java-fall-2021/blob/output/github-contribution-grid-snake.gif)

> **Comprehensive Java learning resource from bootcamp fundamentals to FAANG interview preparation**

[![Java Version](https://img.shields.io/badge/Java-11-orange.svg)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg)](CONTRIBUTING.md)

## 📚 Overview

This repository contains a complete Java learning journey, starting from basic programming concepts learned during a 2021 bootcamp and enhanced with professional-grade interview preparation materials for FAANG and top-tier tech companies.

### What's Inside?

1. **48-Day Bootcamp Curriculum** - Progressive learning from variables to advanced OOP
2. **Interview Preparation Package** - Behavioral, technical, and whiteboard questions
3. **FAANG Coding Patterns** - Common algorithms and problem-solving strategies
4. **System Design** - Practical implementations of scalable system components

## 🚀 Quick Start

### Prerequisites

- Java Development Kit (JDK) 11 or higher
- Maven 3.6+ (for build management)
- Your favorite IDE (IntelliJ IDEA, Eclipse, or VS Code)

### Clone & Build

```bash
# Clone the repository
git clone https://github.com/0zturkSamet/Java-fall-2021.git
cd Java-fall-2021

# Build with Maven
mvn clean compile

# Run tests (if available)
mvn test
```

### Running Examples

```bash
# Run a specific class
java -cp target/classes day01_02_Variables.C01_Variables

# Run interview prep examples
java -cp target/classes interviewprep.whiteboard.WhiteboardProblems

# Run system design examples
java -cp target/classes systemdesign.URLShortener
```

## 📖 Repository Structure

```
Java-fall-2021/
├── src/
│   ├── day01_02_Variables/          # Variables and data types
│   ├── day03_Scanner/               # User input handling
│   ├── ...                          # Days 04-47
│   ├── day48_maps_TheEND/           # Final bootcamp module
│   │
│   ├── interviewprep/               # 🆕 INTERVIEW PREPARATION
│   │   ├── behavioral/              # Behavioral questions with STAR examples
│   │   ├── phonescreening/          # Phone interview technical questions
│   │   ├── whiteboard/              # 20+ coding problems with solutions
│   │   ├── faang/                   # FAANG-specific patterns & strategies
│   │   └── README.md                # Interview prep guide
│   │
│   └── systemdesign/                # 🆕 SYSTEM DESIGN
│       ├── URLShortener.java        # TinyURL-style service design
│       ├── LRUCache.java            # LRU/LFU cache implementations
│       ├── RateLimiter.java         # API rate limiting algorithms
│       └── README.md                # System design guide
│
├── pom.xml                          # 🆕 Maven build configuration
├── .gitignore                       # 🆕 Git ignore rules
├── CHANGELOG.md                     # 🆕 Version history
└── README.md                        # This file

```

## 🎓 Bootcamp Curriculum (48 Days)

### Fundamentals (Days 1-15)
- **Variables & Data Types** - Primitives, wrappers, type conversion
- **Operators** - Arithmetic, logical, comparison, ternary
- **Control Flow** - If/else, switch/case, nested conditionals
- **String Manipulation** - Methods, StringBuilder, formatting
- **Methods** - Creation, parameters, return types, overloading

### Loops & Arrays (Days 16-25)
- **Loops** - For, while, do-while, nested loops
- **Arrays** - 1D, 2D, manipulation, searching, sorting
- **Collections** - ArrayList, List interface, iteration

### Object-Oriented Programming (Days 26-39)
- **Classes & Objects** - Constructors, this keyword
- **Encapsulation** - Access modifiers, getters/setters
- **Inheritance** - Extends, super, polymorphism
- **Abstraction** - Abstract classes, interfaces
- **Static Members** - Static variables, methods, blocks
- **Immutability** - Immutable classes, final keyword

### Advanced Topics (Days 40-48)
- **Exception Handling** - Try-catch, throws, custom exceptions
- **Error Handling** - Checked vs unchecked, best practices
- **Collections Framework** - Set, Map, Queue, Deque
- **Iterators** - Iterator, ListIterator patterns
- **Date & Time API** - LocalDate, LocalTime, DateTime
- **Advanced Strings** - StringBuilder, varargs

## 🎯 Interview Preparation

### 1. Behavioral Questions (`interviewprep/behavioral/`)

**20 comprehensive STAR-method examples covering:**
- Leadership & Influence
- Conflict & Disagreement
- Failure & Learning
- Problem Solving & Innovation
- Deadlines & Pressure
- Collaboration & Teamwork
- Amazon Leadership Principles

**Example Structure:**
```java
public static final String LEADERSHIP_DIFFICULT_PROJECT = """
    Situation: [Context of the challenge]
    Task: [Your responsibility]
    Action: [What YOU did - specific steps]
    Result: [Quantified outcome]
    """;
```

### 2. Phone Screening (`interviewprep/phonescreening/`)

**Technical fundamentals covering:**
- OOP Principles (Encapsulation, Inheritance, Polymorphism, Abstraction)
- Abstract Classes vs Interfaces
- String Immutability & Internals
- Equals & HashCode Contract
- Exception Hierarchy
- Collections Framework (ArrayList vs LinkedList, HashMap internals)
- Comparable vs Comparator
- Multi-threading Basics
- Synchronized Keyword
- Design Patterns (Singleton)

### 3. Whiteboard Coding (`interviewprep/whiteboard/`)

**20+ solved problems with multiple approaches:**
- Arrays & Strings (Two Sum, Best Time to Buy Stock, Longest Substring)
- Linked Lists (Reverse, Detect Cycle, Merge Sorted)
- Trees (Max Depth, Validate BST, Level Order Traversal)
- Dynamic Programming (Climbing Stairs, House Robber, Coin Change)
- Binary Search (Search in Rotated Array, Find Peak)
- Backtracking (Generate Parentheses, Permutations)

**Each problem includes:**
- Problem statement with examples
- Multiple solution approaches
- Time & space complexity analysis
- Working code with test cases

### 4. FAANG Patterns (`interviewprep/faang/`)

**10 essential coding patterns:**
1. Sliding Window
2. Two Pointers
3. Fast & Slow Pointers
4. Merge Intervals
5. Top K Elements (Heap)
6. Modified Binary Search
7. Tree DFS & BFS
8. Graph BFS & DFS
9. Dynamic Programming
10. Backtracking

**Plus:**
- Company-specific focus areas (Google, Meta, Amazon, Apple, Netflix)
- 12-week study plan
- 150-200 LeetCode problem roadmap

## 🏗️ System Design

### Implementations

#### URL Shortener (`systemdesign/URLShortener.java`)
- Three encoding approaches (Counter, Hash, Random)
- Base62 encoding/decoding
- Custom aliases & expiration
- Click analytics
- Production considerations (sharding, caching, rate limiting)

#### LRU Cache (`systemdesign/LRUCache.java`)
- O(1) get and put operations
- HashMap + Doubly Linked List implementation
- LinkedHashMap alternative
- LFU Cache comparison
- Thread safety considerations

#### Rate Limiter (`systemdesign/RateLimiter.java`)
- **5 Algorithm Implementations:**
  - Token Bucket (burst support)
  - Leaky Bucket (constant rate)
  - Fixed Window (simple, boundary issues)
  - Sliding Window Log (accurate, memory intensive)
  - Sliding Window Counter (balanced)
- Multi-user support
- Distributed rate limiting (Redis)
- Production deployment strategies

### System Design Resources

See [`systemdesign/README.md`](src/systemdesign/README.md) for:
- System design interview framework (7-step process)
- Capacity estimation guide
- Key latency/availability numbers
- Common interview questions (Easy → Hard)
- Recommended reading & resources

## 🛠️ Build & Development

### Maven Commands

```bash
# Compile the project
mvn compile

# Run tests
mvn test

# Package as JAR
mvn package

# Clean build artifacts
mvn clean

# Install to local Maven repository
mvn install
```

### IDE Setup

**IntelliJ IDEA:**
1. Open → Select `pom.xml` → Open as Project
2. Wait for Maven import
3. Mark `src` as Sources Root
4. Run any main method

**Eclipse:**
1. File → Import → Existing Maven Projects
2. Select repository folder
3. Finish import
4. Right-click project → Maven → Update Project

**VS Code:**
1. Install "Extension Pack for Java"
2. Open folder
3. Java extension auto-detects Maven project

## 📊 Statistics

- **Total Java Files:** 261+ files
- **Lines of Code:** 9,000+ LOC (bootcamp) + 3,000+ LOC (interview prep)
- **Learning Modules:** 48 progressive days
- **Interview Questions:** 50+ behavioral, 30+ technical, 20+ coding
- **System Design Patterns:** 3 complete implementations
- **Code Patterns:** 10 FAANG-specific algorithm patterns

## 🎯 Learning Path

### For Beginners
1. Start with `day01_02_Variables` through `day48`
2. Complete exercises in each module
3. Build small projects combining concepts
4. Move to interview prep when comfortable with OOP

### For Interview Prep
1. Review `interviewprep/README.md`
2. Prepare 5-7 STAR stories from `behavioral/`
3. Master fundamental concepts in `phonescreening/`
4. Practice 2-3 problems daily from `whiteboard/`
5. Study patterns in `faang/`
6. Review system design basics in `systemdesign/`

### Recommended Timeline
- **Bootcamp Material:** 8-12 weeks (self-paced)
- **Interview Preparation:** 8-12 weeks (intensive)
- **Total:** 4-6 months from beginner to interview-ready

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request. For major changes:

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🌟 Acknowledgments

- Original bootcamp curriculum from 2021
- Interview questions inspired by real FAANG interviews
- System design patterns from industry best practices
- Community contributions and feedback

## 📞 Contact & Support

- **Issues:** [GitHub Issues](https://github.com/0zturkSamet/Java-fall-2021/issues)
- **Discussions:** [GitHub Discussions](https://github.com/0zturkSamet/Java-fall-2021/discussions)

## 🗺️ Roadmap

- [ ] Add JUnit test cases for all examples
- [ ] Create video tutorials for key concepts
- [ ] Add more system design implementations (Distributed Cache, Load Balancer)
- [ ] Interactive coding exercises with auto-grading
- [ ] Mock interview simulator
- [ ] Company-specific interview prep guides

---

**⭐ Star this repository if you find it helpful!**

**📚 Happy Learning & Good Luck with Your Interviews!**

---

*Last Updated: November 2024*
*Version: 2.0.0 - Enhanced Edition*
