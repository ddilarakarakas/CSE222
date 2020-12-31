public class SelectionSort{
    /**
     * Sort the array using selection sort algorithm.
     * pre: table contains Comparable objects.
     * post: table is sorted.
     * @param table The array to be sorted
     */
    public static <T extends Comparable<T>> void sort(T [] table){
        int n = table.length;
        for(int fill=0;fill<n-1;fill++){
            int posMin = fill;
            for(int next=fill+1;next<n;next++){
                if(table[next].compareTo(table[posMin]) < 0)
                    posMin = next;
            }
            T temp = table[fill];
            table[fill] = table[posMin];
            table[posMin] = temp;
        }
    }
}