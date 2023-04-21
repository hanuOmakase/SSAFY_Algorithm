#include <iostream>
#include <vector>
using namespace std;

int main()
{
    int N;
    cin >> N;
    vector<int> T(N + 1);
    vector<int> P(N + 1);
    vector<int> dp(N + 2, 0);
    for (int i = 1; i <= N; i++)
    {
        cin >> T[i] >> P[i];
        if (i + T[i] <= N + 1)
            dp[i + T[i]] = max(dp[i + T[i]], dp[i] + P[i]);
        dp[i + 1] = max(dp[i], dp[i + 1]);
    }
    cout << dp[N + 1] << "\n";
    return 0;
}