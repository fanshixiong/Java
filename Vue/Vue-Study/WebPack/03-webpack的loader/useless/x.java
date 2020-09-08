class Solution {
    bool vis[10010];
    int Top=1;
    string Ans="0";
    public:
        void DFS(int k,string s,int num){
            vis[num]=false;
            num-=(s[0]-'0')*Top;
            num*=10;
            for(int i=0;i<k;i++){
                int temp=num+i;
                char c='0'+i;
                string s0=s+c;
                if(vis[temp]){
                    DFS(k,s0.substr(1),temp);
                    Ans+=c;
                }
            }
        return;
    }

    string crackSafe(int n, int k) {
        for(int i=1;i<n;i++) Top*=10;
        string st="";
        for(int i=0;i<n;i++) st+='0';
        memset(vis,true,sizeof(vis));
        DFS(k,st,0);
        return Ans+st.substr(1);
      }
};
