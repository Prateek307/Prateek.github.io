**Course Name:** Algorithmic Problem Solving  
**Course Code:** 23ECSE309  
**Name:** Prateek Kanaujia  
**SRN:** 01FE21BCS307   
**University:** KLE Technological University, Hubballi-31  
**Portfolio domain:** Facebook  

## Table of Contents
- [Introduction](#introduction)
- [Objectives](#objectives)
- [Facebook's System Architecture](#facebooks-system-architecture)
- [Business Use Cases](#business-use-cases)

## Introduction
<p align="center">
    <img src="Image/img1.webp" width="700" alt="HLD-Youtube">
</p>
<div style="text-align: justify;">
<p>
Facebook, now known as Meta Platforms, began as a social media platform founded in 2004 quickly evolved into the world's largest social network, boasting nearly three billion users globally as of 2021, with about half of them engaging daily. Facebook operates primarily through revenue from advertisements on its platform, offering free access to users.
</p>
<p>
Facebook requires users to use real identities to foster genuine connections and interactions. This approach has facilitated personal relationships, information sharing, and business-consumer interactions. Initially launched as "TheFacebook" at Harvard, the platform expanded rapidly to other universities and then globally, reaching significant milestones such as adding the Wall feature in 2004, enabling friends to post on user profiles. By 2005, tagging photos and unlimited photo uploads enhanced user engagement, attracting millions from diverse demographics beyond students.
</p>
<p>
Despite efforts to improve user controls, privacy remains a contentious issue for Facebook. Commercially, Facebook's influence grew with its expansion beyond students in 2006, facilitating direct consumer engagement and advertising innovations. The company's IPO in 2012 raised $16 billion, marking a significant financial milestone and underlining its market dominance. Strategic acquisitions like Instagram and WhatsApp expanded its service portfolio, enhancing its market presence. Facebook's impact extends beyond social networking, playing pivotal roles in political movements globally, from U.S. elections to protests in Colombia and Egypt. The platform's API opened opportunities for third-party developers, fostering a robust app ecosystem and generating substantial revenue.
</p>
<p>
In recent years, Facebook rebranded as Meta Platforms in 2021, signaling a shift towards developing the metaverse—a virtual reality environment promising new interactive possibilities. Facebook/Meta Platforms has evolved from a university-based social network into a global powerhouse, reshaping communication, commerce, and societal interactions.
</p>
</div>

## Objectives
- Evaluate and classify Facebook features and technological framework.
- Investigate critical data structures , Algorithms and system design strategies used by Facebook.
- Create a resource that can be used for educational purposes to understand the intersection of data structures, algorithms, and real-world applications in a social media platform like Facebook.
- Explore opportunities for algorithmic enhancement and optimization within Facebook's operational framework.

## Facebook's System Architecture
<div style="text-align: justify;">
<h3 id="facebooks-system-architecture">The Data Model For Social Graph</h3>
<p>
Facebook stores majority, if not all, of users’ data, such as profiles, friends, posts and comments, inside a single giant social graph. There are two elements inside a social graph, nodes and edges. A node represents an entity, such a user, a post, a comment and a location.
An edge represents the relationships between the nodes.
</p>
<p align="center">
    <img src="Image/img2.webp" width="700" alt="HLD-Youtube">
</p>
<h3>The Database Design For the Social Graph</h3>
<p>
Facebook uses only two database tables to represent the social graph that captures the activities of its one billion users, object table and association table.
Object table has a very simple schema. It has 3 columns. The id column stores the unique id of the object. otype stores the object type. Additionally, each object/node can have a list of key-value pairs. otype specifies the possible keys and value type. For instance, otype of User means there could be a key name with value type string. The list of key-value pairs are serialized and stored in the data column.
</p>
<p>
The schema of the association table is similar. It has 4 columns. id1 and id2 represents the source and destination of the edge. atype is the edge type and data stores the optional list of key-value pairs associated with the edge.The edge from the post to the comment will result in the following row in the association table.
</p>
<h3>The Highly Scalable Backends that Serve the Social Graph</h3>
<p align="center">
    <img src="Image/img3.webp" width="700" alt="HLD-Youtube">
</p>
<p>
In Facebook's backend system, two main components are crucial: TAO and the database. TAO serves as Facebook's distributed data store, fulfilling dual roles. First, it defines a data access API, providing interfaces for querying and modifying objects and associations. Application servers within Facebook interact with TAO rather than directly with the database. The API encompasses two main categories: object-related and association-related functionalities. Additionally, TAO operates as a write-through cache, actively caching objects and associations to minimize latency and alleviate the database system's workload.
</p>
<h3>Database</h3>
<p>
Facebook's approach to scaling its MySQL database involved two major modifications. Firstly, they implemented Database Sharding, partitioning objects and associations into logical shards distributed across database instances. TAO, their distributed data store, determines shard placement for new data and handles queries to the appropriate shard. Secondly, Facebook optimized storage efficiency by adopting the LSM (Log-Structured Merge) tree storage engine, specifically MyRocks DB. This replaced the traditional InnoDB engine's B+ trees, reducing storage requirements by 50% and enhancing database latency, particularly beneficial with the shift from HDD to Flash or SSD storage technologies.
</p>
</div>

## Business Use Cases
- [Sort Friend List](#friends)
- [Database Modification](#db-modify)
- [Friends Recommendation](#friend-recommend)
- [Auto Complete Searches](#auto)
- [Content Monitoring](#monitor)
- [Viewing Stories](#view)
- [Spam Detection](#spam)
- [News Feed Sorting & Filtering](#news-filter)
- [Data Saver](#data-saver)
- [Managing Chats & Notifications](#chats-and-notify)
- [Tag Verification](#tag)
- [Analytics and Metrics](#analyze-and-metrics)
- [Data Center Network Optimization](#optimize)
- [User Authentication](#authenticate)
- [Reminders](#reminder)
- [Notification System](#notify)

<!-- ---------------------------------------------------------------------------------------------------------------------------------------------->
<!-- 1 use case -->

<h3 id="friends">1. Sort Friends List</h3>
<div  style="text-align: justify;">
There are several ways of sorting the friend list, such as by recent interactions, least interacted with, and mutual friends. Using the Merge Sort algorithm, which is a divide-and-conquer approach, can significantly improve the efficiency of sorting large friends lists. Merge Sort is particularly suitable for this task due to its predictable time complexity and stable sorting nature, ensuring that the order of equal elements remains unchanged. When a user requests to view their sorted friend list, the system can quickly divide the list into smaller sublists, sort them, and then merge them back together in a sorted manner.
</div>

**Challenges**: Handling dynamically changing friends lists, ensuring low latency during sorting operations.

**Market Benefits**: Improved user experience with faster and more responsive friend list management.

**Design techniques and algorithms:**  
- **Merge Sort:** Divide-and-conquer technique
   - **Time Complexity:** O(n log n), where n is the number of friends in the list.
   - **Space Complexity:** O(n), for the temporary arrays used during the merging process.

**View Implementation:** <a href="https://github.com/Prateek307/Prateek.github.io/blob/main/Codes/MergeSort.cpp" target="_blank">Merge Sort</a>

<!-- ---------------------------------------------------------------------------------------------------------------------------------------------->
<!-- 2 use case -->

<h3 id="db-modify">2. Database Modification</h3>
<div style="text-align: justify;">
Facebook’s database is based on MySQL. It is not feasible for a MySQL database to serve tens of petabytes of data efficiently. To address this, One notable optimization is the implementation of the LSM (Log-Structured Merge) tree storage engine. Originally, Facebook used the InnoDB engine, which employs B+ trees. However, B+ trees can lead to index fragmentation, resulting in wasted storage space that neither holds useful data nor can be used for new data. This issue became more pronounced as Facebook transitioned from HDD to Flash or SSD, where wasted space is more expensive. To resolve this, Facebook developed a new storage engine, MyRocks DB, based on the LSM tree. This optimization reduced storage usage by 50% and decreased database latency.

</div>

**Challenges**:  Managing massive data volumes efficiently, minimizing index fragmentation, and optimizing for SSD storage.

**Market Benefits**: Reduced storage costs, improved database performance, and enhanced scalability.

**Design techniques and algorithms:**  
- **LSM Tree Storage Engine:** Log-structured storage
   - **Time Complexity:**Varies with operations; generally O(log n) for reads and writes
   - **Space Complexity:**Efficient use of storage due to reduced fragmentation

**View Implementation:** <a href="https://engineering.fb.com/2016/08/31/core-infra/myrocks-a-space-and-write-optimized-mysql-database/" target="_blank">MyRocks DB
</a>

<!-- ---------------------------------------------------------------------------------------------------------------------------------------------->
<!-- 3 use case -->

<h3 id="friend-recommend">3. Friends Recommendation</h3>
<div style="text-align: justify;">
<p>
Facebook uses advanced algorithms to recommend friends by analyzing user data and connections. One effective approach to this problem is by using the concept of degrees of separation, which can be efficiently implemented using graph traversal algorithms such as breadth-first search (BFS).
</p>
<h4>Case 1: Simplifying the Problem (Not considering millions of users)</h4>
<p>
To represent the problem, we construct a graph where each person is a node, and an edge between two nodes indicates a friendship. To find the path between two people, we start with one person and perform a simple BFS. Alternatively, bidirectional BFS can be used, which involves two simultaneous BFS operations: one from the source and one from the destination. When the searches collide, we have found a path. Depth-first search (DFS) is not suitable here as it does not guarantee finding the shortest path and can be inefficient. In the implementation, two classes, BFSData and PathNode, are used to store necessary data for the BFS, such as visited nodes and the path being traced.
</p>
<p>
<h4>Case 2: Handling Millions of Users</h4>
When dealing with millions of users, data cannot be stored on a single machine. Thus, the simple data structure for a Person needs to be adjusted to accommodate distributed storage. Instead of a list of friends, each user maintains a list of their friends' IDs. The traversal process involves determining the machine that holds a friend's data and querying that machine for the friend's information. This approach ensures efficient handling of large-scale data across multiple servers.
</p>
</div>

**Challenges**: Handling the vast number of users and their connections, ensuring efficient and accurate recommendations.

**Market Benefits**:Enhanced user engagement through accurate friend recommendations, increased user activity, and retention.

**Design techniques and algorithms:**  
- **Breadth-First Search (BFS):** Graph traversal technique
   - **Time Complexity:** O(V + E), where V is the number of vertices (users) and E is the number of edges (friend connections).
   - **Space Complexity:** O(V), for storing visited nodes and the queue.
- **Bidirectional BFS:** Optimized graph traversal
   - **Time Complexity:** O(b^(d/2)), where b is the branching factor and d is the distance between the nodes.
   - **Space Complexity:** O(b^(d/2)), for storing nodes in the queues of both searches.

**View Implementation:** 
<a href="https://github.com/Prateek307/Prateek.github.io/blob/main/Codes/RecommendCase1.java" target="_blank">Case 1</a>,
<a href="https://github.com/Prateek307/Prateek.github.io/blob/main/Codes/RecommendCase2.java" target="_blank">Case 2</a>

<!-- ---------------------------------------------------------------------------------------------------------------------------------------------->
<!-- 4 use case -->

<h3 id="auto">4. Auto Complete Searches</h3>
<div style="text-align: justify;">
    The Trie data structure is utilized for efficient auto-completion of  searches based on past user inputs. The Trie stores a set of strings representing past searches by users.When a user types in a prefix of their search query, the system provides recommendations to auto-complete the query based on the stored strings in the Trie.For example, if the Trie stores {"abc", "abcd", "aa", "abbbaba"} and the user types in "ab", they should be shown {"abc", "abcd", "abbbaba"}.

</div>

**Challenges**: Handling dynamic user queries efficiently, ensuring fast response times during auto-completion.

**Market Benefits**:  Enhanced user experience with quicker and more accurate hashtag suggestions, improving user engagement.

**Design techniques and algorithms:**  
- **Trie Data Structure:** Efficient for prefix-based searches
   - **Time Complexity:** O(Q + k), where Q is the length of the query prefix and k is the number of matching words found. 
   - **Space Complexity:** O(N * L), where N is the number of strings stored in the Trie and L is the average length of these strings. 

**View Implementation:** <a href="https://github.com/Prateek307/Prateek.github.io/blob/main/Codes/Trie.cpp" target="_blank">Trie</a>

<!-- ---------------------------------------------------------------------------------------------------------------------------------------------->
<!-- 5 use case -->

<h3 id="monitor">5. Content Monitoring</h3>
<div style="text-align: justify;">
   Facebook's content moderation strategy relies heavily on community flagging and human review processes to enforce community standards, including the monitoring of Facebook Live broadcasts. When content is flagged, a global team proficient in over 40 languages reviews it promptly. The Rabin-Karp string matching algorithm can efficiently detect specific patterns or content violations within posts, comments, and live videos. This algorithm enhances the team's ability to quickly identify and respond to flagged content, contributing to a safer and compliant platform environment.

</div>

**Challenges**: Ensuring real-time detection of prohibited content, handling large volumes of data efficiently.

**Market Benefits**:  Enhanced platform safety and compliance with community guidelines, fostering a trusted user environment.

**Design techniques and algorithms:**  
- **Rabin-Karp Algorithm:** String matching technique based on hashing
   - **Time Complexity:** O(n + m), where n is the length of the text and m is the length of the pattern.
   - **Space Complexity:** O(1), excluding the space required for storing the input text and pattern.

**View Implementation:** <a href="https://github.com/Prateek307/Prateek.github.io/blob/main/Codes/RabinKarp.cpp" target="_blank">Rabin-Karp</a>

<!-- ---------------------------------------------------------------------------------------------------------------------------------------------->
<!-- 6 use case -->

<h3 id="view">6. Viewing Stories</h3>
<div style="text-align: justify;">
   The deque (double-ended queue) data structure is utilized in Facebook's "Viewing Stories" feature for efficient management and display of user-generated stories. Stories are temporary multimedia posts that users can view and share with their friends. Using a deque allows Facebook to efficiently manage the sequence of stories displayed to users, supporting both forward and backward navigation through the list of stories.

</div>

**Challenges**:Ensuring smooth and responsive navigation between stories, handling dynamic updates as new stories are posted.

**Market Benefits**: Enhanced user engagement with a seamless and intuitive story-viewing experience, encouraging frequent user interaction.

**Design techniques and algorithms:**  
- **Deque Data Structure:** Efficiently manages the sequence of stories
   - **Time Complexity:**  O(1) for both front and back operations.
   - **Space Complexity:** Access: O(1) for accessing elements at both ends.

**View Implementation:** <a href="https://github.com/Prateek307/Prateek.github.io/blob/main/Codes/Deque.cpp" target="_blank">Deque</a>

<!-- ---------------------------------------------------------------------------------------------------------------------------------------------->
<!-- 7 use case -->

<h3 id="spam">7. Spam Detection</h3>
<div style="text-align: justify;">
For the efficient detection of spam content within posts, comments, and messages on Facebook. Hashmap and Tries can be utilized . Hashmap enables quick lookup and categorization of flagged patterns, while tries facilitate rapid matching against stored spam keywords and phrases.
</div>

**Challenges**: Ensuring real-time detection of evolving spam tactics, maintaining low latency during content evaluation.

**Market Benefits**: Enhanced user safety and experience by reducing spam visibility, improving community engagement and trust.

**Design techniques and algorithms:**  
- **Hashmaps and Tries:** Enables fast lookup and matching of spam patterns and keywords
   - **Time Complexity:**  O(L), where L is the length of the spam pattern or keyword.
   - **Space Complexity:**Efficient use of memory with hashmap and trie nodes.

**View Implementation:** <a href="https://github.com/Prateek307/Prateek.github.io/blob/main/Codes/Maps.cpp" target="_blank">Hashmaps</a>,
<a href="https://github.com/Prateek307/Prateek.github.io/blob/main/Codes/Trie.cpp" target="_blank">Tries</a>

<!-- ---------------------------------------------------------------------------------------------------------------------------------------------->
<!-- 8 use case -->

<h3 id="news-filter">8. News Feed Sorting & Filtering</h3>
<div style="text-align: justify;">
<p>
Facebook's news feed algorithm condenses approximately 1,500 daily potential posts into roughly 300 prioritized ones. Factors influencing this selection include how frequently users interact with friends, pages, or public figures, the engagement levels (likes, shares, comments) of individual posts, historical interaction patterns with similar content, and the prevalence of hiding or reporting specific posts. 
</p>
<p>
B+ trees are balanced tree structures designed to maintain sorted data efficiently and support rapid access to sorted subsets of data. They strike a balance between depth and breadth, ensuring that operations such as insertion, deletion, and search maintain logarithmic time complexity relative to the number of entries. This makes B+ trees well-suited for scenarios where quick and efficient access to sorted data subsets, crucial for managing and prioritizing content in the news feed, is essential.
</p>
</div>

**Challenges**:Managing diverse content types and user preferences dynamically, ensuring timely updates and personalized feeds.

**Market Benefits**:  Improved user engagement through personalized and relevant content delivery, enhancing overall user satisfaction and interaction.

**Design techniques and algorithms:**  
- **B+ Trees:** Provides efficient indexing and sorting capabilities for news feed items
   - **Time Complexity:**  O(1) for both front and back operations.
   - **Space Complexity:** Access: O(1) for accessing elements at both ends.

**View Implementation:** <a href="https://github.com/Prateek307/Prateek.github.io/blob/main/Codes/BPlusTrees.cpp" target="_blank">B+ Trees</a>


<!-- ---------------------------------------------------------------------------------------------------------------------------------------------->

<!-- 9 use case -->


<h3 id="data-saver">9. Data Saver</h3>
<div style="text-align: justify;">
Facebook offers a Data Saver feature designed to minimize data consumption while maintaining efficient application functionality. This feature allows users to run the app using less data by reducing the quality of images and videos displayed. It ensures that users can browse their feed, view content, and interact with posts while conserving data usage, making it particularly beneficial in regions with limited internet access or expensive data plans. Facebook employs Huffman coding to optimize data storage and transmission, especially in scenarios where minimizing data size is critical. Huffman coding is a lossless data compression algorithm that assigns shorter codes to frequently used data patterns and longer codes to less frequent ones, based on their probability of occurrence. This ensures efficient data representation and reduced storage requirements, beneficial for enhancing data transmission speeds and reducing bandwidth usage across Facebook's platform.

</div>

**Challenges**:Ensuring effective data compression without compromising content quality, managing varying internet speeds and data constraints.

**Market Benefits**:Improved user experience with reduced data costs, enhanced accessibility in low-bandwidth regions, and efficient media content delivery.

**Design techniques and algorithms:**  
- **Huffman Coding:**  Lossless data compression technique
   - **Time Complexity:**   Assigns shorter codes to frequently used data patterns and longer codes to less frequent ones based on probability.
   - **Space Complexity:** Utilizes Huffman coding to compress media files and reduce data consumption while maintaining acceptable quality standards.

**View Implementation:** <a href="https://github.com/Prateek307/Prateek.github.io/blob/main/Codes/HuffmanCoding.cpp" target="_blank">Huffman Coding</a>

<!-- ---------------------------------------------------------------------------------------------------------------------------------------------->


<!-- 10 use case -->

<h3 id="chats-and-notify">10. Managing Chats & Notifications</h3>
<div style="text-align: justify;">
There are several chats and notifications for a user in Facebook, where a user can view each chat and notification and perform various actions such as deleting a chat. Facebook makes use of a doubly linked list data structure to efficiently manage these interactions. This approach allows users to navigate through their chat history and notifications chronologically, ensuring quick access and manipulation of individual messages and notifications. Each node in the doubly linked list contains details such as message content, sender information, timestamps, and notification specifics. By utilizing bidirectional traversal and dynamic node management, Facebook ensures that users can interact seamlessly with their chats and notifications, performing actions like deletion or archiving with optimal efficiency and responsiveness.
</div>

**Challenges**: Ensuring real-time updates across multiple users, managing memory efficiently for dynamic data changes.

**Market Benefits**:  Enhanced user experience with fast access to chat history and notifications, improved responsiveness in message management and notification handling.

**Design techniques and algorithms:**  
- **Doubly Linked List:** Supports bidirectional traversal
   - **Time Complexity:**   O(1) time complexity for operations, facilitating efficient updates.
   - **Space Complexity:** Uses pointers to maintain connections between nodes, optimizing space utilization.

**View Implementation:** <a href="https://github.com/Prateek307/Prateek.github.io/blob/main/Codes/DoublyLinkedList.cpp" target="_blank">Doubly Linked List</a>


<!-- ---------------------------------------------------------------------------------------------------------------------------------------------->

<!-- 11 use case -->

<h3 id="tag">11. Tag Verification</h3>
<div style="text-align: justify;">
Tagging is a feature in Facebook where users can tag other users in posts, photos, or comments. Once a user tags another, the tag needs to be authenticated and verified based on the privacy settings of the tagged user. This entire process of verification and authentication can be efficiently managed using Depth-First Search (DFS), a fundamental algorithm in graph theory and data structures. DFS is utilized by Facebook to traverse through the network of tagged users and their privacy settings. It starts from the tagged user and explores all connected users recursively, ensuring that the tag reaches only those users whose privacy settings permit such tagging. This approach helps maintain user privacy and ensures that tags are visible and actionable only to intended recipients. By employing DFS, Facebook efficiently verifies the authenticity of tags and adheres to privacy preferences set by its users.
</div>

**Challenges**: Ensuring tag authenticity and privacy compliance across diverse user settings, managing real-time updates in tag permissions.

**Market Benefits**:  Improved user trust with secure and compliant tagging features, enhanced user engagement through accurate tag notifications and interactions.

**Design techniques and algorithms:**  
- **Depth-First Search (DFS):**  Graph traversal technique for exploring tag permissions
   - **Time Complexity:** O(V + E), where V is the number of users and E is the number of connections (edges) between users.
   - **Space Complexity:**  O(V), where V is the number of users, for maintaining the DFS stack and visited nodes.

**View Implementation:** <a href="https://github.com/Prateek307/Prateek.github.io/blob/main/Codes/DFS.cpp" target="_blank"> Depth-First Search</a>

<!-- ---------------------------------------------------------------------------------------------------------------------------------------------->
<!-- 12 use case -->

<h3 id="analyze-and-metrics">12. Analytics and Metrics</h3>
<div style="text-align: justify;">
Analytics and metrics play a crucial role in Facebook's platform, providing insights into users behavior, engagement metrics, and content performance. Segment Trees, a specialized data structure, can efficiently compute and manage these analytics.Segment Trees are utilized by Facebook to aggregate and analyze large volumes of user data, such as interactions (likes, comments, shares), posting frequency, and content preferences. These trees enable efficient range queries and updates, allowing Facebook to compute metrics like user engagement over specific time intervals or across different user segments.
</div>

**Challenges**: Handling massive data volumes, ensuring real-time updates for dynamic user interactions, optimizing query performance for diverse analytics queries.

**Market Benefits**:Enhanced user insights for personalized content recommendations, improved ad targeting based on user behavior, and refined platform performance based on data-driven decisions.

**Design techniques and algorithms:**  
- **Segment Trees:**  Efficient data structure for range query and update operations
   - **Time Complexity:**  O(log n) for both query and update operations, where n is the number of data points or segments.
   - **Space Complexity:** O(n), where n is the number of data points or segments, for storing segment tree nodes.

**View Implementation:** <a href="https://github.com/kevinzg/segment-tree/blob/master/segment_tree/segment_tree.hpp" target="_blank">Segment Trees</a>

<!-- ---------------------------------------------------------------------------------------------------------------------------------------------->
<!-- 13 use case -->

<h3 id="optimize">13. Data Center Network Optimization</h3>
<div style="text-align: justify;">
Data Center Network Optimization at Facebook involves ensuring efficient routing of packets and minimizing latency across a vast network infrastructure. Facebook's data centers are interconnected through a complex network topology designed to handle massive amounts of data and user requests. The A* algorithm proves invaluable in achieving these goals by optimizing routing decisions based on various criteria such as shortest path, network congestion, and real-time traffic conditions. It navigates this intricate network topology by evaluating potential paths using a combination of a heuristic function and actual network metrics, enabling A* to efficiently select optimal routes that minimize latency and maximize throughput. A* operates by expanding the least costly path first, balancing between the cost of the path so far and the estimated cost to reach the destination. This approach ensures that Facebook's network can dynamically adapt to varying traffic patterns and network failures.
</div>

**Challenges**: Ensuring secure storage and retrieval of user credentials, preventing unauthorized access through robust hashing and encryption methods, and managing scalability as the user base grows.

**Market Benefits**: Enhanced security measures against unauthorized access, improved user experience with faster login processes, and scalable infrastructure to accommodate increasing user demands.

**Design techniques and algorithms:**  
- **A Star Algorithm:**Efficient storage and retrieval
   - **Time Complexity:** O(1) for average-case operations, ensuring rapid access to user credentials.
   - **Space Complexity:** Depends on the number of users and stored credentials, scalable with Facebook's infrastructure needs.

**View Implementation:** <a href="https://github.com/Prateek307/Prateek.github.io/blob/main/Codes/AStar.cpp" target="_blank">A Star Algorithm</a>

<!-- ---------------------------------------------------------------------------------------------------------------------------------------------->
<!-- 14 use case -->

<h3 id="authenticate">14. User Authentication</h3>
<div style="text-align: justify;">
User authentication at Facebook relies on hash maps to securely store and manage user credentials. Each user's account details, including usernames, email addresses, and hashed passwords, are stored as key-value pairs in a hash map. This data structure allows for rapid retrieval and validation of user credentials during login attempts. Hash maps ensure that user authentication operations, such as checking the validity of login credentials and retrieving user information, are performed with optimal time complexity. Additionally, hash maps support efficient management of user sessions and permissions, enhancing the overall security and user experience on the platform.
</div>

**Challenges**: Ensuring secure storage and retrieval of user credentials, preventing unauthorized access through robust hashing and encryption methods, and managing scalability as the user base grows.

**Market Benefits**: Enhanced security measures against unauthorized access, improved user experience with faster login processes, and scalable infrastructure to accommodate increasing user demands.

**Design techniques and algorithms:**  
- **HashMaps:** : Efficient storage and retrieval
   - **Time Complexity:**   O(1) for average-case operations, ensuring rapid access to user credentials.
   - **Space Complexity:** Depends on the number of users and stored credentials, scalable with Facebook's infrastructure needs.

**View Implementation:** <a href="https://github.com/Prateek307/Prateek.github.io/blob/main/Codes/Maps.cpp"  target="_blank">Hashmaps</a>

<!-- ---------------------------------------------------------------------------------------------------------------------------------------------->
<!-- 15 use case -->

<h3 id="reminder">15. Reminders</h3>
<div style="text-align: justify;">
There are several reminders provided in Facebook, such as birthday reminders, event reminders, and more. Facebook utilizes Binary Search Trees (BST) to efficiently manage these reminders for users. Each reminder type, whether it's a birthday or an event, is stored as a node in the BST, sorted based on its scheduled time. This structured approach allows for quick insertion, deletion, and retrieval operations, ensuring that users can easily manage their reminders with minimal computational overhead. The BST structure facilitates efficient searching for upcoming reminders and supports functionalities such as updating reminder details or marking reminders as completed. By leveraging BST, Facebook optimizes the user experience with reliable and timely reminder notifications.
</div>

**Challenges**:  Handling concurrent user acc   ess to reminder operations, ensuring efficient BST balancing to maintain optimal performance, and integrating reminder functionalities across different Facebook platforms.

**Market Benefits**:   Improved user productivity with organized reminders, enhanced reliability in reminder notifications, and scalable infrastructure to support growing user demands.

**Design techniques and algorithms:**  
- **Binary Search Trees (BST):** Sorted storage and retrieval
   - **Time Complexity:**   O(log n) for average-case operations, ensuring efficient reminder management.
   - **Space Complexity:** Depends on the number of reminders stored, scalable with Facebook's user base and usage patterns.

**View Implementation:** <a href="https://github.com/Prateek307/Prateek.github.io/blob/main/Codes/BST.cpp" target="_blank">Binary Search Tree</a>

<!-- ---------------------------------------------------------------------------------------------------------------------------------------------->
<!-- 16 use case -->

<h3 id="notify">16. Notification System</h3>
<div style="text-align: justify;">
Facebook's notification system is important in keeping users informed about interactions, updates, and activities within their network. It uses advanced data structures to ensure timely delivery and management of notifications across its platform. Notifications can range from likes on posts to friend requests, event invitations, and more, each requiring efficient handling to maintain a responsive user experience. Facebook employs a combination of data structures, including priority queues and hash tables, to organize and prioritize notifications based on relevance and user interaction patterns. Priority queues are particularly useful for ordering notifications by urgency or time sensitivity, ensuring that critical updates are promptly delivered. Hash tables optimize retrieval times for specific user notifications, allowing quick access and updates as users interact with their notifications.
</div>

**Challenges**:Managing notification delivery across diverse user bases and interaction patterns, optimizing data structure performance for real-time updates, and ensuring scalability as user engagement grows.

**Market Benefits**:Enhanced user engagement through timely and relevant notifications, improved platform responsiveness, and scalable infrastructure to support increasing notification volumes.

**Design techniques and algorithms:**  
- **Priority Queues:** Ordering notifications by priority
   - **Time Complexity:**  Efficient insertion and removal operations, typically O(log n).
   - **Space Complexity:** Varied, optimized for quick access to high-priority notifications.
- **Hash Tables:** Fast retrieval and update of individual notifications
   - **Time Complexity:**  O(1) for average-case lookups and updates.
   - **Space Complexity:**Depends on the number of notifications stored, scalable with user activity.

**View Implementation:** 
<a href="https://github.com/Prateek307/Prateek.github.io/blob/main/Codes/PriorityQueue.cpp" target="_blank">Priority Queues</a>,
<a href="https://github.com/Prateek307/Prateek.github.io/blob/main/Codes/HashTables.java" target="_blank">HashTables</a>


<!-- ---------------------------------------------------------------------------------------------------------------------------------------------->
<!-- ---------------------------------------------------------------------------------------------------------------------------------------------->
<!-- ---------------------------------------------------------------------------------------------------------------------------------------------->
<!-- ---------------------------------------------------------------------------------------------------------------------------------------------->
<!-- ---------------------------------------------------------------------------------------------------------------------------------------------->

## References
[1] Facebook social network July 07, 2024 [https://www.britannica.com/money/Facebook](https://www.britannica.com/money/Facebook){:target="_blank"} <br>

[2] Facebook Explained: Origins, Why People Like It, and Key Features  May 15, 2024 [https://www.lifewire.com/what-is-facebook-3486391](https://www.lifewire.com/what-is-facebook-3486391){:target="_blank"} <br>

[3] An Introduction to Facebook’s System Architecture: Social Graph and TAO Sep 7, 2020 [https://medium.com/swlh/an-introduction-to-facebooks-system-architecture-47cfcf597101](https://medium.com/swlh/an-introduction-to-facebooks-system-architecture-47cfcf597101){:target="_blank"} <br>

[4] Design data structures for a very large social network like Facebook or Linkedln 20 Feb, 2023 [https://www.geeksforgeeks.org/design-data-structures-for-a-very-large-social-network-like-facebook-or-linkedln/](https://www.geeksforgeeks.org/design-data-structures-for-a-very-large-social-network-like-facebook-or-linkedln/){:target="_blank"} <br>

[5] Auto-complete feature using Trie  20 Feb, 2023 [https://www.geeksforgeeks.org/auto-complete-feature-using-trie/](https://www.geeksforgeeks.org/auto-complete-feature-using-trie/){:target="_blank"} <br>

[6] Good Question: How Does Facebook Monitor Its Content? April 18, 2017 [https://www.cbsnews.com/minnesota/news/gq-facebook-monitoring/](https://www.cbsnews.com/minnesota/news/gq-facebook-monitoring/){:target="_blank"} <br>

[7] Deque in Java [https://www.tutorialspoint.com/deque-in-java](https://www.tutorialspoint.com/deque-in-java){:target="_blank"} <br>

[8] How Facebook uses machine learning to detect fake accounts Apr 02, 2020 [https://www.technologyreview.com/2020/03/04/905551/how-facebook-uses-machine-learning-to-detect-fake-accounts/](https://www.technologyreview.com/2020/03/04/905551/how-facebook-uses-machine-learning-to-detect-fake-accounts/){:target="_blank"} <br>

[9] Facebook found a new way to identify spam and false news articles in your News Feed Jun 30, 2017 [https://www.vox.com/2017/6/30/15896544/facebook-fake-news-feed-algorithm-update-spam](https://www.vox.com/2017/6/30/15896544/facebook-fake-news-feed-algorithm-update-spam){:target="_blank"} <br>

[10] Map 24 November, 2023 [https://en.cppreference.com/w/cpp/container/map](https://en.cppreference.com/w/cpp/container/map){:target="_blank"} <br>

[11] How does Facebook decide what to show in my news feed? 30 Jun, 2014 [https://www.theguardian.com/technology/2014/jun/30/facebook-news-feed-filters-emotion-study](https://www.theguardian.com/technology/2014/jun/30/facebook-news-feed-filters-emotion-study){:target="_blank"} <br>

[12] Huffman Coding [https://www.tutorialspoint.com/huffman-coding](https://www.tutorialspoint.com/huffman-coding){:target="_blank"} <br>

[13] More Control and Context in News Feed March 31, 2021 [https://about.fb.com/news/2021/03/more-control-and-context-in-news-feed/](https://about.fb.com/news/2021/03/more-control-and-context-in-news-feed/){:target="_blank"} <br>

[14] Doubly linked list [https://www.javatpoint.com/doubly-linked-list](https://www.javatpoint.com/doubly-linked-list){:target="_blank"} <br>

[15] Insertion in a Doubly Linked List 18 Mar, 2024 [https://www.geeksforgeeks.org/introduction-and-insertion-in-a-doubly-linked-list/](https://www.geeksforgeeks.org/introduction-and-insertion-in-a-doubly-linked-list/){:target="_blank"} <br>

[16] Depth First Search or DFS for a Graph 27 Jun ,2024 [https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/](https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/){:target="_blank"} <br>

[17] Segment Tree 03 Apr, 2024 [https://www.geeksforgeeks.org/segment-tree-data-structure/](https://www.geeksforgeeks.org/segment-tree-data-structure/){:target="_blank"} <br>

[18] Segment Tree December 20,2023 [https://cp-algorithms.com/data_structures/segment_tree.html](https://cp-algorithms.com/data_structures/segment_tree.html){:target="_blank"} <br>

[19] Segment Tree Implementation  [https://github.com/kevinzg/segment-tree/blob/master/segment_tree/segment_tree.hpp](https://github.com/kevinzg/segment-tree/blob/master/segment_tree/segment_tree.hpp){:target="_blank"} <br>

[20] Best practices for data center network optimization 24 Oct, 2022  [https://www.techtarget.com/searchdatacenter/tip/Best-practices-for-data-center-network-optimization](https://www.techtarget.com/searchdatacenter/tip/Best-practices-for-data-center-network-optimization){:target="_blank"} <br>

[21] Data Center Optimization Strategies March ,2022 [https://www.akcp.com/blog/data-center-optimization-strategies/](https://www.akcp.com/blog/data-center-optimization-strategies/){:target="_blank"} <br>

[22] A* Search Algorithm  07 Mar ,2024 [https://www.geeksforgeeks.org/a-search-algorithm/](https://www.geeksforgeeks.org/a-search-algorithm/){:target="_blank"}<br>

[23] Binary Search Tree 22 Feb, 2024 [https://www.geeksforgeeks.org/binary-search-tree-data-structure/](https://www.geeksforgeeks.org/binary-search-tree-data-structure/){:target="_blank"} <br>

[24] Binary Search tree [https://www.javatpoint.com/binary-search-tree](https://www.javatpoint.com/binary-search-tree){:target="_blank"} <br>

[25] Priority Queue[https://www.programiz.com/dsa/priority-queue](https://www.programiz.com/dsa/priority-queue){:target="_blank"} <br>

[26] Implementing our Own Hash Table with Separate Chaining, 13 Jun, 2024 [https://www.geeksforgeeks.org/implementing-our-own-hash-table-with-separate-chaining-in-java/](https://www.geeksforgeeks.org/implementing-our-own-hash-table-with-separate-chaining-in-java/){:target="_blank"} <br>

[27] Hash Table Explained: What it Is and How to Implement It Nov 22, 2022 [https://www.freecodecamp.org/news/hash-tables/](https://www.freecodecamp.org/news/hash-tables/){:target="_blank"} <br>



