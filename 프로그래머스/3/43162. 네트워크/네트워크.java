class Solution {
    int[][] computers;
    boolean[] visited;
    int n;
    int count = 0;
    
    public int solution(int n, int[][] computers) {
        this.computers= computers;
        this.n = n;
        
        visited = new boolean[n];
        
        
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                dfs(i);
                count++;
            }
           
        }
        
      
        return count;
    }
    
    
    public void dfs(int v){
        visited[v] = true;
        System.out.println(v);
        
        for(int next=0;next<n;next++){
            if(visited[next]==false &&computers[v][next] ==1){
                dfs(next);
            }
        }
    }
}