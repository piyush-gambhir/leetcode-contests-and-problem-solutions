class Solution
{
private:
    int helper(vector<int> &nums)
    {
        int s = 0, t = 1;
        for (int i = 0; i < nums.size() - 1; i++)
        {
            if (nums[i + 1] - nums[i] == 1)
                t++;
            else
            {
                s = max(s, t + 1);
                t = 1;
            }
        }
        s = max(s, t + 1);
        return s;
    }

public:
    int maximizeSquareHoleArea(int n, int m, vector<int> &hBars, vector<int> &vBars)
    {
        sort(hBars.begin(), hBars.end());
        sort(vBars.begin(), vBars.end());
        int s1 = helper(hBars);
        int s2 = helper(vBars);
        int s = min(s1, s2);
        return s * s;
    }
};