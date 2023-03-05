from collections import deque
N, M, K = map(int, input().split())
# (r, c) 질량 m 방향 d 속력 s
fireball = [list(map(int, input().split())) for _ in range(M)]
dx, dy = [-1,-1,0,1,1,1,0,-1], [0,1,1,1,0,-1,-1,-1]
evendir = [0, 2, 4, 6]
odddir = [1, 3, 5, 7]
arr = [[deque() for _ in range(N)] for _ in range(N)]
# 움직임을 기다리는 파이어볼에 대한 큐
waiting_fireball = deque()
for r,c,m,s,d in fireball:
    waiting_fireball.append((r-1, c-1, m, d, s))

for _ in range(K):
    # 파이어볼이 있는 좌표에 빠른 접근을 위한 set
    pair = set()
    # 이동을 먼저 해주고
    while waiting_fireball:
        x, y, m, d, s = waiting_fireball.popleft()
        nx, ny = (x+dx[d]*s) % N, (y+dy[d]*s) % N
        arr[nx][ny].append((m, d, s))
        pair.add((nx, ny))
    # 파이어볼이 있는곳에 대해 계산 필요
    while pair:
        x, y = pair.pop()
        # 좌표에 파이어볼이 많다면 계산해서 넣어줌
        siz = len(arr[x][y])
        if siz > 1:
            nm, ns, nd = 0, 0, 0
            while arr[x][y]:
                m, d, s = arr[x][y].popleft()
                if d % 2 == 0: nd+=1
                else: nd-=1
                nm += m
                ns += s
            nm = int(nm / 5)
            ns = int(ns / siz)
            if nm == 0: continue
            if nd == siz or nd == -siz:
                # 하나로 치우쳐져 있으면 0 2 4 6
                for i in evendir:
                    waiting_fireball.append((x, y, nm, i, ns))
            else:
                # 방향이 지멋대로면 1 3 5 7
                for i in odddir:
                    waiting_fireball.append((x, y, nm, i, ns))
        # 좌표에 파이어볼이 한개라면 그냥 넣어줌
        else:
            m, d, s = arr[x][y].popleft()
            waiting_fireball.append((x, y, m, d, s))
answer = 0
for i in waiting_fireball:
    answer += i[2]
print(answer)
