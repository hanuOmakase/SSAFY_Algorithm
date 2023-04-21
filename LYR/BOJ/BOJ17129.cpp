#include <iostream>
#include <vector>
#include <string>
#include <queue>
using namespace std;

int dy[4] = {0, 0, 1, -1};
int dx[4] = {1, -1, 0, 0};

struct Bird
{
    int y;
    int x;
    int dist;
    Bird(){};
    Bird(int Y, int X, int D) : y(Y), x(X), dist(D) {}
};

main()
{
    int N, M;
    struct Bird bird;
    cin >> N >> M;

    vector<int> v(M, 0);
    vector<vector<int>> map(N, v);

    vector<bool> v2(M, false);
    vector<vector<bool>> visited(N, v2);

    for (int i = 0; i < N; i++)
    {
        string s;
        cin >> s;
        for (int j = 0; j < M; j++)
        {
            map[i][j] = s[j] - '0';
            if (map[i][j] == 2)
            {
                bird.y = i;
                bird.x = j;
                bird.dist = 0;
                map[i][j] = 0;
            }
        }
    }

    queue<Bird> q;
    q.push(bird);
    visited[bird.y][bird.x] = true;
    bool isFound = false;
    int minDist;

    while (!q.empty() && !isFound)
    {
        Bird curr = q.front();
        q.pop();
        for (int i = 0; i < 4; i++)
        {
            int ny = curr.y + dy[i];
            int nx = curr.x + dx[i];
            if (0 <= ny && ny < N && 0 <= nx && nx < M && !visited[ny][nx] && map[ny][nx] != 1)
            {
                if (map[ny][nx] > 2)
                {
                    cout << "TAK\n"
                         << curr.dist + 1 << "\n";
                    return 0;
                }
                visited[ny][nx] = true;
                q.push(Bird(ny, nx, curr.dist + 1));
            }
        }
    }
    cout << "NIE\n";

    return 0;
}