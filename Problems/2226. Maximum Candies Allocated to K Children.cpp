#include <vector>
#include <algorithm>

class Solution
{
public:
    int maximumCandies(std::vector<int> &candies, long long k)
    {
        int max_candy = *max_element(candies.begin(), candies.end());

        long long left = 1;
        long long right = max_candy;

        while (left <= right)
        {
            long long mid = left + (right - left) / 2;
            long long total = 0;
            for (int candy : candies)
            {
                total += candy / mid;
            }
            if (total >= k)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }

        return static_cast<int>(right);
    }
};
