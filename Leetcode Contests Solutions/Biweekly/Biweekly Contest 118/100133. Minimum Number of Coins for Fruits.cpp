class Solution
{
public:
    int mn = INT_MAX;

    void solve(vector<int> &prices, int i, int cost, int j)
    {
        if (i > prices.size())
        {
            mn = min(mn, cost);
            return;
        }

        solve(prices, i + 1, cost + prices[i - 1], i + i);
        if (i <= j)
        {
            solve(prices, i + 1, cost, j);
        }
    }
    int minimumCoins(vector<int> &prices)
    {
        solve(prices, 1, prices[0], 2);
        return mn;
    }
};
