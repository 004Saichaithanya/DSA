class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events,(a,b)->Integer.compare(a[0],b[0]));
        // for(int[] arr:events)
        // System.out.println(arr[0]+" "+arr[1]+" "+arr[2]);
        int n=events.length;
        int mid=0,low=0,high=n-1;
        int sum=0,maxSum=0,maxVal=0;

        int[] maxFromRight = new int[n];
        maxFromRight[n-1] = events[n-1][2];

        for(int i=n-2;i>=0;i--){
            maxFromRight[i] = Math.max(events[i][2], maxFromRight[i+1]);
        }

        for(int i=0;i<n;i++){
            low=i;
            high=n-1;
            while(low<=high){
                mid=(low+high)/2;

                if(events[mid][0] <= events[i][1])
                    low=mid+1;
                else
                    high=mid-1;

            }
             //case 1:if only one event maximum
            maxSum=Math.max(maxSum,events[i][2]);

            if(low != n){
            // case 2: if atmost two events are maximum 
            sum = events[i][2]+ maxFromRight[low];
          //  System.out.println(sum);
            maxSum =Math.max(sum,maxSum);
            }

        }





        return maxSum;
    }
}