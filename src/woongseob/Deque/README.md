# Deque

<p align="center">
  <img src="./img/Deque.png">
</p>

# 특징
- 양방향으로 삽입과 삭제가 가능한 큐

# 사용법

```java
import java.util.Deque;
Deque<Element> deque = new ArrayDeque<Element>();
```

# 시간 복잡도
- **삽입**
  * 원소를 앞/뒤에 삽입하는 경우: O(1)
- **삭제**
  * 원소를 앞/뒤에 제거하는 경우: O(1)
- **탐색**
  * 원소를 탐색하는 경우: O(1) (index 접근)
# 기타 Method

```java
deque.addFirst(item);       // deque의 앞에 값 추가
dueue.addLast(item);        // deque의 뒤에 값 추가
deque.pollFirst();          // deque의 앞의 값 제거
deque.pollLast();           // deque의 뒤의 값 제거
```

# 적용 가능 문제 
- <a href = https://www.acmicpc.net/problem/3190 >3190번 뱀 </a>
- <a href = https://www.acmicpc.net/problem/18115 >18115번 카드놓기 </a> 


