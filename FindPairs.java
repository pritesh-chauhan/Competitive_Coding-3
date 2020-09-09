//Time Complexity: O(n)
//Space Complexity: O(1)

import java.util.HashMap;
import java.util.Map;

public class FindPairs {
    public static int findPairs(int[] nums, int k) {
        if(k<0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count =0;
        //create a map with key as array element value and index as count
        for(int i : nums)
            map.put(i, map.getOrDefault(i,0)+1);
        for(int i=0; i<nums.length; i++){
            int rem = nums[i]-k;
            if(map.containsKey(rem)){     
                //if rem and element is same with occurence greter than 1           
                if(rem == nums[i] && map.get(rem)>1){
                    count++;
                    map.put(rem,0);
                }
                //if rem and element is not same with occurence greter than and equal to 1
                else if(rem != nums[i] && map.get(rem) >= 1){
                    count++;
                    map.put(rem,0);
                }          
            }  
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4};
        System.out.println(findPairs(nums, 1));
    }
}