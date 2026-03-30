class RecentCounter {
    Queue<Integer> q;
    int l,h;
    public RecentCounter() {
        q=new LinkedList<>();
        l=0;
        h=0;
        
    }
    
    public int ping(int t) {
        q.add(t);
        l = t - 3000;
        h=t;

        while(!q.isEmpty() && q.peek() < l ){
                q.poll();
        }

        return q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */