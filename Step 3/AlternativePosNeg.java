import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class AlternativePosNeg {

    public static void bruteforce(int arr[], int n) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        int ps = 0, ng = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] >= 0)
                pos.add(arr[i]);
            else
                neg.add(arr[i]);
        }
        for(int i = 0; i < n; i++) {
            if(i % 2 == 0){
                if(ps < pos.size()){
                    arr[i] = pos.get(ps++);
                }
                else if (ng < neg.size()){
                    arr[i] = neg.get(ng++);
                }
            }
            else {
                if(ng < neg.size()){
                    arr[i] = neg.get(ng++);
                }
                else if(ps < pos.size()){
                    arr[i] = pos.get(ps++);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }


    public static void twopointerapproach(int arr[], int n) {
        ArrayList<Integer> rearr = new ArrayList<>(Collections.nCopies(n, 0));
        int posIdx = 0, negIdx = 1;
        int nextFree = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] > 0) {
                if (posIdx < n){
                    rearr.set(posIdx, arr[i]);
                    posIdx += 2;
                }
                else {
                    while(rearr.get(nextFree) != 0)
                        nextFree++;
                    rearr.set(nextFree, arr[i]);
                }
                
            }
            else {
                if(negIdx < n){
                    rearr.set(negIdx, arr[i]);
                    negIdx += 2;
                }
                else {
                    while(rearr.get(nextFree) != 0)
                        nextFree++;
                    rearr.set(nextFree, arr[i]);
                }
                
            }
        }
        System.out.println(rearr);
    }

    public static void main(String args[]) {
        int arr[] = {1, 3, 7, 9, 5, -4, -5};
        int n = arr.length;
        twopointerapproach(arr, n);
    }
}
