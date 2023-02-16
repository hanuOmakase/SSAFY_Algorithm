from collections import deque
# N * N칸   / M 마리 / k번 이동
N, M, K = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
dx = [0, -1, 1, 0, 0]
dy = [0, 0, 0, -1, 1]
first_dir = [0] + (list(map(int, input().split())))
# t(toward) 방향
t = [[[]] for _ in range(M+1)]
for i in range(1, M+1):
    for _ in range(4):
        t[i].append([0] + list(map(int, input().split())))
# (상어번호, 시간)
pool = [[(0, -1) for _ in range(N)] for _ in range(N)]
# (상어번호, x, y, 방향)
wait = deque()
for i in range(N):
    for j in range(N):
        if arr[i][j] > 0:
            wait.append((arr[i][j], i, j, first_dir[arr[i][j]]))
            pool[i][j] = (arr[i][j], K)
wait = deque(sorted(wait))
time = 0
while wait:
    k = len(wait)
    if k == 1: break
    time += 1
    goque = deque()
    for _ in range(k):
        snum, x, y, d = wait.popleft()
        nnx, nny, nd = x, y, d
        for i in range(1, 5):
            nx, ny = x + dx[t[snum][d][i]], y + dy[t[snum][d][i]]
            if not 0 <= nx < N or not 0 <= ny < N: continue
            # 냄새가 다 없을땐 바로 움직인다
            if pool[nx][ny][1] < time:
                nnx, nny = nx, ny
                nd = t[snum][d][i]
                break
            # 주위에 냄새가 다 차가지고 내가 원래 왔던 곳으로 되돌아 가야 하고 먼저 내 냄새로 가지 않았을 때
            elif pool[nx][ny][0] == snum and (nnx == x and nny == y):
                nnx, nny = nx, ny
                nd = t[snum][d][i]
        goque.append((snum, nnx, nny, nd))
    while goque:
        snum, x, y, d = goque.popleft()
        if pool[x][y][1] == time+K: continue
        pool[x][y] = (snum, time+K)
        wait.append((snum, x, y, d))
    if time > 1000: break
if time > 1000: print(-1)
else: print(time)