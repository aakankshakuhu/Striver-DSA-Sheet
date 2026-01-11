import java.util.HashMap;
import java.util.Map;
public class CountUniqueSubstrings {

    //count substrings with at most k distinct characters
        public static int atMostDistinct(String s, int k){
            int left = 0, res = 0;
            Map<Character, Integer> freq = new HashMap<>();


            //iterate with right pointer
            for(int right = 0; right < s.length(); right++){
                freq.put(s.charAt(right), freq.getOrDefault(s.charAt(right), 0) + 1);

                //shrink window if distinct characters exceed k
                while(freq.size() > k){
                    char leftChar = s.charAt(left);
                    freq.put(leftChar, freq.get(leftChar) - 1);
                    if(freq.get(leftChar) == 0) freq.remove(leftChar);
                    left++;
                }

                //add count of substrings in current window
                res += (right - left + 1);
            }
            return res;
        }

        public static int countSubstrings(String s, int k) {
            return atMostDistinct(s, k) - atMostDistinct(s, k-1);
        }

    public static void main(String args[]){
        
        String s = "pqpqs";
        int k = 2;

        System.out.println("Count: " + CountUniqueSubstrings.countSubstrings(s, k));

    }
}
