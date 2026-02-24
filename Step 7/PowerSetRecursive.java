import java.util.ArrayList;
public class PowerSetRecursive {

    private static void helper(String s, int index, StringBuilder curr, ArrayList<String> result){
        if(index == s.length()){
            result.add(curr.toString());
            return;
        }

        //exclude current and recurse
        helper(s, index+1, curr, result);

        //include current and recurse
        curr.append(s.charAt(index));
        helper(s, index+1, curr, result);

        //backtrack by removing last char
        curr.deleteCharAt(curr.length()-1);
    }

    public static ArrayList<String> getSubsequence(String s){
        ArrayList<String> result = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        helper(s, 0, curr, result);
        return result;
    }
    
    public static void main(String args[]){
        String s = "Aakanksha";
        ArrayList<String> subsequences = getSubsequence(s);

        for(String subseq: subsequences){
            System.out.println("\"" + subseq + "\"");
        }
    }
}
