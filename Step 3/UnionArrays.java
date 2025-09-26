import java.util.ArrayList;
import java.util.HashSet;
public class UnionArrays {

    public static ArrayList<Integer> setapproach(int arr1[], int arr2[], int n, int m){
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> union = new ArrayList<>();
        for(int i = 0; i < n; i++){
            set.add(arr1[i]);
        }
        for(int i = 0; i < n; i++){
            set.add(arr2[i]);
        }
        for(int x: set){
            union.add(x);
        }
        return union;
    }

    public static ArrayList<Integer> twopointersapproach(int arr1[], int arr2[], int n, int m){
        ArrayList<Integer> union = new ArrayList<>();
        int i = 0, j = 0;
        while(i < n && j < m){
            if(arr1[i] <= arr2[j]){
                if(union.isEmpty() || (union.get(union.size()-1)) != arr1[i]){
                    union.add(arr1[i]);
                }
                i++;
            }
            else {
                if(union.isEmpty() || (union.get(union.size()-1)) != arr2[j]){
                    union.add(arr2[j]);                    
                }
                j++;
            }
        }
        while(i < n){
            if(union.isEmpty() || (union.get(union.size()-1)) != arr1[i]){
                union.add(arr1[i]);               
            }
            i++;
        }
        while(j < m){
            if(union.isEmpty() || (union.get(union.size()-1)) != arr2[j]){
                union.add(arr2[j]);

            }
            j++;
        }
        return union;
    }

    public static void main(String args[]){
        int arr1[] = {1, 2, 3, 4, 5};
        int arr2[] = {1, 3,4, 6, 7};
        int n = arr1.length;
        int m = arr2.length;
        ArrayList<Integer> union = twopointersapproach(arr1, arr2, n, m);
        for(int x: union){
            System.out.print(x + " ");
        }
        
    }
}
