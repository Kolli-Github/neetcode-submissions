class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq =
            new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int x:stones){
            pq.offer(x);
        }

        while(pq.size()>1){
            int max1 = pq.poll();
            int max2 = pq.poll();
            if(max1!=max2){
                pq.offer(max1-max2);
            }
        }

        if(pq.size()==0){
            return 0;
        }

        return pq.poll();

    }
}
