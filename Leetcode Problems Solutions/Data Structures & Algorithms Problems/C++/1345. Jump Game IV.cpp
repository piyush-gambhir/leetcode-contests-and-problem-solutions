class Solution {
public:
    int minJumps(vector<int>& arr) 
    {
        map<int,vector<int>> m;
        for(int i=0;i<arr.size();i++)
        {
            m[arr[i]].push_back(i);
        }
        queue<int> q;
        vector<int> ans(arr.size(),INT_MAX),vis(arr.size(),0);
        q.push(arr.size()-1);
        ans.back()=0;
        while(q.size())
        {
            int ind=q.front();
            q.pop();
            vis[ind]=1;
            for(auto e:m[arr[ind]])
            {  
                if(!vis[e])
                {
                     q.push(e);
                     ans[e]=min(ans[e],ans[ind]+1);
                     vis[e]=1;
                }

                m[arr[ind]].clear();
            }
            if(ind-1>=0 && !vis[ind-1]){
                    ans[ind-1]=min(ans[ind-1],ans[ind]+1);
                    vis[ind-1]=1;
                    q.push(ind-1);
                } 
                if(ind<arr.size()-1 && !vis[ind+1]){
                    ans[ind+1]=min(ans[ind+1],ans[ind]+1);
                    q.push(ind+1);
                    vis[ind+1]=1;
                }
        }
        return ans[0];
    }
};