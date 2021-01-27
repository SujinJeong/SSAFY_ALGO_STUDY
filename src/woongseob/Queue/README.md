# Queue

<p align="center">
  <img src="./img/Queue.png" style="background-color:white">
</p>

# 특징
- FIFO(First In First Out)

# 사용법

```java
import java.util.LinkedList;
import java.util.Queue;
Queue<Element> queue = new LinkedList<Element>();
```

# 기타 Method

```java
queue.offer(item);  // queue에 값 추가
queue.peek();       // queue의 최상단 요소 반환
queue.poll();       // queue의 최상단 요소 제거
queue.size();       // queue의 크기 출력
queue.empty();      // queue이 비어있는지 확인
```

# 적용 가능 문제 
- <a href = https://www.acmicpc.net/problem/1966 >1966번 프린터큐</a> 
