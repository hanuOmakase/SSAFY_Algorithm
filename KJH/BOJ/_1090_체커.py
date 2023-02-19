T = int(input())
arr = [tuple(map(int, input().split())) for _ in range(T)]
X, Y = set(), set()
for x, y in arr:
    X.add(x)
    Y.add(y)
answer = [float('inf') for _ in range(T)]
for x in X:
    for y in Y:
        temp = []
        for xx, yy in arr:
            temp.append(abs(xx-x)+abs(yy-y))
        temp = sorted(temp)
        for i in range(T-1):
            temp[i+1] += temp[i]
            answer[i] = min(answer[i], temp[i])
        answer[T-1] = min(answer[T-1], temp[T-1])
for i in answer:
    print(i, end=' ')