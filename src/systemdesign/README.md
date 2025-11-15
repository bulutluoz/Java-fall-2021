# System Design Package

This package contains implementations and explanations of common system design patterns and problems frequently asked in FAANG interviews.

## Contents

### Core Components
1. **URL Shortener** - TinyURL/bit.ly style service
2. **LRU Cache** - Least Recently Used cache implementation
3. **Rate Limiter** - API rate limiting strategies
4. **Consistent Hashing** - Distributed system data partitioning
5. **Load Balancer** - Traffic distribution across servers
6. **Message Queue** - Simple pub-sub implementation
7. **Distributed Cache** - Redis-like distributed caching

### System Design Concepts
- **Scalability** - Horizontal vs vertical scaling
- **CAP Theorem** - Consistency, Availability, Partition tolerance
- **Database Sharding** - Partitioning strategies
- **Caching Strategies** - Write-through, write-back, cache-aside
- **Load Balancing** - Round-robin, least connections, consistent hashing

## System Design Interview Framework

### Step 1: Requirements Clarification (5 min)
- **Functional Requirements**: What features?
- **Non-Functional Requirements**: Scale, performance, availability
- **Constraints**: Users, requests/sec, data size

### Step 2: Capacity Estimation (5 min)
- Storage requirements
- Bandwidth requirements
- QPS (Queries Per Second)
- Memory for caching

### Step 3: System Interface Definition (5 min)
- API endpoints
- Parameters and return types
- RESTful design

### Step 4: Database Design (10 min)
- Schema design
- SQL vs NoSQL
- Relationships and indexes

### Step 5: High-Level Design (10 min)
- Draw components
- Show data flow
- Identify bottlenecks

### Step 6: Detailed Design (10 min)
- Deep dive into 2-3 components
- Discuss algorithms
- Address scalability

### Step 7: Bottlenecks & Tradeoffs (5 min)
- Single points of failure
- Caching strategy
- Load balancing
- Database replication

## Common Interview Questions

### Easy
- Design a URL shortener
- Design a rate limiter
- Design a cache system
- Design a parking lot

### Medium
- Design Twitter/Facebook feed
- Design Instagram
- Design Uber/Lyft
- Design YouTube/Netflix

### Hard
- Design distributed file system (Google Drive, Dropbox)
- Design search autocomplete
- Design web crawler
- Design messaging system (WhatsApp, Slack)

## Key Numbers to Remember

### Latency Numbers
- L1 cache reference: 0.5 ns
- L2 cache reference: 7 ns
- Main memory reference: 100 ns
- Send 2K bytes over network: 20,000 ns
- SSD random read: 150,000 ns
- Read 1 MB sequentially from memory: 250,000 ns
- Disk seek: 10,000,000 ns
- Read 1 MB sequentially from disk: 20,000,000 ns

### Availability Numbers
- 99% = 3.65 days downtime/year
- 99.9% = 8.76 hours downtime/year
- 99.99% = 52.6 minutes downtime/year
- 99.999% = 5.26 minutes downtime/year

### Scale Estimations
- 1 million users → ~1-10 QPS
- 10 million users → ~100 QPS
- 100 million users → ~1000 QPS
- Assume average request size: 1-10 KB
- Assume average database record: 100 bytes - 1 KB

## Resources
- Designing Data-Intensive Applications (Martin Kleppmann)
- System Design Interview (Alex Xu)
- Grokking the System Design Interview
- ByteByteGo YouTube channel
