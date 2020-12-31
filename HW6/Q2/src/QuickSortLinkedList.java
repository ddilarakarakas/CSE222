import java.util.LinkedList;

public class QuickSortLinkedList {
    /**
     * Sort the table using the quick sort algorithm.
     * pre: table contains Comparable objects.
     * post: table is sorted.
     * @param table The LinkedList to be sorted
     */
    public static <T extends Comparable<T>> void sort(LinkedList<T> table){
        quickSort(table,0,table.size()-1);
    }
    /**
     * Sort a part of the table using the quick sort algorithm.
     * post: The part of table from first through last is sorted.
     * @param table The LinkedList to be sorted
     * @param first The index of the low bound
     * @param last The index of the high bound
     */
    private static <T extends Comparable<T>> void quickSort(LinkedList<T> table,int first,int last){
        if(first < last){
            int pivIndex = partition(table,first,last);
            quickSort(table,first,pivIndex-1);
            quickSort(table,pivIndex+1,last);
        }
    }
    /**
     * Partition the table so that values from first to pivIndex are less than or
     * equal to the pivot value, and values from pivIndex to last are greater than the pivot value.
     * @param table The table to be partitioned
     * @param first The index of the low bound
     * @param last The index of the high bound
     * @return The location of the pivot value
     */
    private static <T extends Comparable<T>> int partition(LinkedList<T> table,int first,int last){
        T pivot = table.get(first);
        int up = first;
        int down = last;
        do{
            while ((up < last) && (pivot.compareTo(table.get(up)) >= 0)){
                up++;
            }
            while(pivot.compareTo(table.get(down)) < 0){
                down--;
            }
            if(up < down){
                swap(table,up,down);
            }
        }while (up < down);
        swap(table,first,down);
        return down;
    }
    /**
     * Swap the items in table.get(i) and table.get(j).
     * @param table The LinkedList that contains the items
     * @param i The index of one item
     * @param j The index of the other item
     */
    private static <T extends Comparable<T>> void swap(LinkedList<T> table,int i,int j){
        T temp = table.get(i);
        table.set(i,table.get(j));
        table.set(j,temp);
    }
}
