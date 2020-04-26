### 学习笔记

#### 树的面试题解法一般都是递归，为什么？

树是典型的递归数据结构，它的解法用递归写最简洁直观，不容易出错（如边界条件等）。

#### Java HashMap 分析

##### 基础
HashMap是Map的一个实现类，它代表的是一种键值对的数据存储形式，具有O(1)的访问速度。

jdk8之前，其内部是由数组+链表来实现的，而jdk8对于链表长度超过8的链表将转储为红黑树。

HashMap非线程安全，即任一时刻可以有多个线程同时写HashMap，可能会导致数据的不一致。如果需要满足线程安全，可以用Collections的synchronizedMap方法使HashMap具有线程安全的能力，或者使用ConcurrentHashMap。

##### 映射碰撞
Node是HashMap的一个内部类，实现了Map.Entry接口，本质上是一个映射。若两个key定位到相同的位置，则表示发生了Hash碰撞。

HashMap类中有一个非常重要的字段，就是 Node[] table，即哈希桶数组。如果哈希桶数组很大，即使较差的Hash算法也会比较分散，如果哈希桶数组数组很小，即使好的Hash算法也会出现较多碰撞。

好的Hash算法和扩容机制可以控制map使得Hash碰撞的概率小，哈希桶数组（Node[] table）占用空间少。

在HashMap中有两个很重要的参数，容量(Capacity)和负载因子(Load factor)。

##### 扩容
扩容方法是使用一个新的数组代替已有的容量小的数组。如发现目前bucket占用程度已经超过了Load Factor所希望的比例，那么就会发生resize。在resize的过程，简单的说就是把bucket扩充为2倍，之后重新计算index，把节点再放到新的bucket中。

因为我们使用的是2次幂的扩展(指长度扩为原来2倍)，所以，元素的位置要么是在原位置，要么是在原位置再移动2次幂的位置。

因此，我们在扩充HashMap的时候，不需要重新计算hash，只需要看看原来的hash值新增的那个bit是1还是0就好了，是0的话索引没变，是1的话索引变成“原索引+oldCap”。

这个设计确实非常的巧妙，既省去了重新计算hash值的时间，而且同时，由于新增的1bit是0还是1可以认为是随机的，因此resize的过程，均匀的把之前的冲突的节点分散到新的bucket了。

##### put方法
put方法是HashMap中比较重要的方法，因为通过该方法我们可以窥探到 HashMap 在内部是如何进行数据存储的，所谓的数组+链表+红黑树的存储结构是如何形成的，又是在何种情况下将链表转换成红黑树来优化性能的。

put方法的大致实现过程如下：

- 对key的hashCode()做hash，然后再计算index;
- 如果没碰撞直接放到bucket里；
- 如果碰撞了，以链表的形式存在buckets后；
- 如果碰撞导致链表过长(大于等于TREEIFY_THRESHOLD)，就把链表转换成红黑树；
- 如果节点已经存在就替换old value(保证key的唯一性)
- 如果bucket满了(超过load factor*current capacity)，就要resize。

##### get方法
get方法的大致实现过程如下：

- bucket里的第一个节点，直接命中；
- 如果有冲突，则通过key.equals(k)去查找对应的entry
- 若为树，则在树中通过key.equals(k)查找，O(logn)；
- 若为链表，则在链表中通过key.equals(k)查找，O(n)。

##### remove方法
删除操作是一个查找+删除的过程

##### 其它方法
- clear
- keySet
- values
- entrySet
