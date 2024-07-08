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
- [Data Center Network Optimization](#optimize)
- [Content Monitoring](#monitor)
- [Data Saver](#data-saver)
- [Tag Verification](#tag)
- [Managing Chats & Notifications](#chats-and-notify)
- [Analytics and Metrics](#analyze-and-metrics)
- [News Feed Sorting & Filtering](#news-filter)
- [Auto Complete Hashtag Searches](#auto)
- [Spam Detection](#spam)
- [User Authentication](#authenticate)
- [Viewing Stories](#view)
- [Reminders](#reminder)
- [Notification System](#notify)

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
View Implementation: [Merge Sort](https://github.com/Prateek.github.io/Codes/MergeSort.cpp)







