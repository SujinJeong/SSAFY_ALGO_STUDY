# Stack

<p align="center">
  <img src="./img/stack.png">
</p>

# 특징
- LIFO(Last In First Out)

# 사용법

```java
import java.util.Stack;
Stack<Element> stack = new Stack<>();
```

# 기타 Method

```java
stack.push(item);  // stack에 값 추가
stack.peek();   // stack의 최상단 요소 반환
stack.pop();    // stack의 최상단 요소 제거
stack.size();   // stack의 크기 출력
stack.empty();  // stack이 비어있을 경우 true, 아닐 경우 false 반환
```

# 적용 가능 문제 
- <a href = https://www.acmicpc.net/problem/2493 >2493번 탑</a> 
- <a href = https://www.acmicpc.net/problem/6198 >6198번 옥상 정원 꾸미기</a> 
- <a href = https://www.acmicpc.net/problem/9012 >9012번 괄호</a> 
- <a href = https://www.acmicpc.net/problem/10799 >10799번 쇠막대기</a> 