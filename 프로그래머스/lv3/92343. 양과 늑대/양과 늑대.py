max_sheep = 0

def dfs(current_node, sheep, wolf, info, tree, visited):
    global max_sheep
    if sheep <= wolf:
        return
    max_sheep = max(max_sheep, sheep)
    
    for next_node in tree.get(current_node, []):
        if visited[next_node]:
            continue
        visited[next_node] = True
        next_sheep = sheep + (info[next_node] == 0)
        next_wolf = wolf + (info[next_node] == 1)
        dfs(next_node, next_sheep, next_wolf, info, tree, visited)
        # 백트래킹: visited를 원상 복구합니다.
        visited[next_node] = False

def solution(info, edges):
    global max_sheep
    max_sheep = 0
    
    # 각 노드의 자식 노드 리스트를 딕셔너리로 만듭니다.
    tree = {}
    for parent, child in edges:
        if parent not in tree:
            tree[parent] = []
        tree[parent].append(child)
    
    visited = [False] * len(info)
    visited[0] = True
    
    dfs(0, 1, 0, info, tree, visited)
    return max_sheep