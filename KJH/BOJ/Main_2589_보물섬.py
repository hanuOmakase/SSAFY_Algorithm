from collections import deque
N, M = map(int, input().split())
arr = [list(input()) for _ in range(N)]
dx, dy = [-1, 0, 1, 0], [0, 1, 0, -1]
for i in range(N):
    for j in range(M):
        if arr[i][j] == 'W':
            arr[i][j] = 0
        else:
            arr[i][j] = 1
ans = 0

for i in range(N):
    for j in range(M):
        if arr[i][j] is not 1:
            continue
        visit = [[0] * M for _ in range(N)]
        visit[i][j] = 1
        wait = deque([(i, j, 0)])
        while wait:
            x, y, v = wait.popleft()
            for k in range(4):
                nx, ny = x+dx[k], y+dy[k]
                if nx < 0 or nx >= N or ny < 0 or ny >= M or arr[nx][ny] != 1 or visit[nx][ny] == 1:
                    continue
                wait.append((nx, ny, v+1))
                visit[nx][ny] = 1
                ans = max(ans, v+1)
print(ans)