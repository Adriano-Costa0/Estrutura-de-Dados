import java.util.Collections;
import java.util.*;

public class Exercicio5 {

    static int MIN_MERGE = 32; 
    public static void main(String[] args) {
        float array[] = { (float) 0.897, (float) 0.565, (float) 0.656, (float) 0.1234, (float) 0.665, (float) 0.3434 };
        int vetor[] = {0, 12, 569, -6, 985, -5, -1, 1002, 856, 795, 652, 147, -80 };
        int vetorAux[] = {};
        int size = array.length;
        
        //array = bucketSort(array, size);
        //vetorAux = cocktailSort(vetor);
        vetorAux = timSort(vetor, vetor.length);

       /*if for (float elemento : array) {
            System.out.print(elemento+", ");
        }
*/
        for (int elemento : vetorAux) {
           System.out.print(elemento+", ");
        }
    }

    public static float [] bucketSort(float array[], int size) {
        if (size <= 0)
            return array;

        @SuppressWarnings("unchecked")
        Vector<Float>[] buckets = new Vector[size];

        for (int i = 0; i < size; i++) {
            buckets[i] = new Vector<Float>();
        }

        for (int i = 0; i < size; i++) {
            float idx = array[i] * size;
            buckets[(int) idx].add(array[i]);
        }

        for (int i = 0; i < size; i++) {
            Collections.sort(buckets[i]);
        }

        int index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                array[index++] = buckets[i].get(j);
            }
        }
        return array;
    }

    public static int [] cocktailSort(int array[]) {
        boolean swapped = true;
        int start = 0;
        int end = array.length;

        while (swapped == true) {
            swapped = false;

            for (int i = start; i < end - 1; ++i) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }

            if (swapped == false)
                break;

            swapped = false;

            end = end - 1;

            for (int i = end - 1; i >= start; i--) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
            start = start + 1;
        }
        return array;
    }

   
  
    public static int minRunLength(int num) 
    { 
        assert num >= 0; 
        
        
        int r = 0; 
        while (num >= MIN_MERGE)  
        { 
            r |= (num & 1); 
            num >>= 1; 
        } 
        return num + r; 
    } 
  
   
    public static void insertionSort(int[] array, int left, 
                                     int right) 
    { 
        for (int i = left + 1; i <= right; i++)  
        { 
            int temp = array[i]; 
            int j = i - 1; 
            while (j >= left && array[j] > temp)  
            { 
                array[j + 1] = array[j]; 
                j--; 
            } 
            array[j + 1] = temp; 
        } 
    } 
  

    public static void merge(int[] array, int l,  
                                 int meio, int r) 
    { 
     
        int len1 = meio - l + 1, len2 = r - meio; 
        int[] left = new int[len1]; 
        int[] right = new int[len2]; 
        for (int x = 0; x < len1; x++)  
        { 
            left[x] = array[l + x]; 
        } 
        for (int x = 0; x < len2; x++)  
        { 
            right[x] = array[meio + 1 + x]; 
        } 
  
        int i = 0; 
        int j = 0; 
        int k = l; 
  
 
        while (i < len1 && j < len2)  
        { 
            if (left[i] <= right[j])  
            { 
                array[k] = left[i]; 
                i++; 
            } 
            else { 
                array[k] = right[j]; 
                j++; 
            } 
            k++; 
        } 

        while (i < len1)  
        { 
            array[k] = left[i]; 
            k++; 
            i++; 
        } 
  
        while (j < len2)  
        { 
            array[k] = right[j]; 
            k++; 
            j++; 
        } 
    } 
    public static int[] timSort(int[] array, int num) 
    { 
        int minRun = minRunLength(MIN_MERGE); 
        
        for (int i = 0; i < num; i += minRun) 
        { 
            insertionSort(array, i, 
                          Math.min((i + 31), (num - 1))); 
        } 
  
       
        for (int size = minRun; size < num; size = 2 * size)  
        { 
   
            for (int left = 0; left < num;  
                                 left += 2 * size)  
            { 
                int mid = left + size - 1; 
                int right = Math.min((left + 2 * size - 1), 
                                     (num - 1)); 

                merge(array, left, mid, right); 
            } 
        }
        return array;
    

}
}
