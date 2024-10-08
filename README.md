# 알고리즘 문제 접근법

## 문제를 마주했을때

1. 문제를 확실히 이해한다.
    1. 간단한 예를 통해 문제를 확실히 이해하고 있는지 파악한다
2. 어떤 알고리즘/자료구조를 사용할지 초점을 맞춘다
3. 위 과정에 시간이 오래 소모되어 코딩을 하고 싶은 유혹이 들어도 참는다.

## 문제를 풀다가 막혔을때

1. 예를 다시 따져본다.
    1. 위에서 시도했던 특정 예를 일반적인 경우로 확장시켜보자.
2. 다른 자료구조를 시도해본다. 
    1. 연결 리스트, 배열, 해시 테이블 등 다양한 자료구조를 사용해보자. 
    2. 올바른 자료구조를 사용하는 것만으로 문제 풀이가 수월해지는 일도 흔하다.
3. 문제의 본질을 뽑아내어, 본질은 같되 다른말로 풀어 생각해보자. 
4. 언어에서 그리 많이 쓰이지 않는 기능 또는 고급 기능을 고려해보자.

## 막혔을때 다시 생각해볼 자료구조
1. 어레이/구조체
2. 스택/큐
3. 연결리스트
4. 트리
5. 그래프
6. 정렬(자료구조는 아니지만)
7. 해시
8. 우선순위 큐
---


## 막혔을때 다시 생각해볼 알고리즘
## 1. 탐색 알고리즘

### - DFS (Depth First Search)
- 깊이 우선 탐색.
- 재귀나 스택을 이용한다.

### - BFS (Breadth First Search)
- 너비 우선 탐색.
- 큐를 이용한다.
### **백트래킹 (Backtracking)**

- 결정 문제(Decision Problem)에서 사용되는 탐색 알고리즘.
- 여러 선택지가 있는 상황에서 한 방향을 선택하다가, 해당 선택이 최적의 해답이 아니라고 판단되면 이전 상태로 돌아와 다른 경로를 탐색한다.
## 2. 분할 정복

- 문제를 작은 문제로 나누어 해결하는 방식.
- 재귀를 자주 사용한다.

## 3. 동적 프로그래밍

- 부분 문제의 해를 저장해서 큰 문제의 해를 빠르게 구하는 방식.
- 예: 피보나치 수열, LCS.

## 4. 그리디 알고리즘

- 매 순간 최적의 선택을 하는 방식.
- 예: 화폐 문제, 스케줄링 문제.

## 5. 트리와 그래프

### - 이진 트리, AVL 트리, 힙
- 트리의 여러 종류와 그에 따른 연산.

### - 그래프
- 정점(Vertex)과 간선(Edge)으로 이루어진 자료구조.
- 연결 여부, 최단 경로 등을 판단할 때 사용.

## 6. 정렬 알고리즘

- 퀵소트, 병합정렬, 버블정렬, 삽입정렬 등.

## 7. 데이터 구조

### - 스택, 큐, 덱
- LIFO, FIFO 등의 특성에 따른 자료구조.

### - 해쉬맵, 집합
- 키와 값의 쌍으로 데이터를 저장하거나 중복 없이 데이터를 저장하는 구조.

## 8. 문자열 처리

- KMP, Z-Algorithm, Manacher's Algorithm 등.

## 9. 최단 경로 알고리즘

- 다익스트라, 플로이드-와샬, 벨만-포드 등.

## 10. 최소 신장 트리

- 크루스칼, 프림의 알고리즘.

## 11. 비트 연산

- AND, OR, XOR 등의 비트 연산자를 이용한 문제 풀이.

