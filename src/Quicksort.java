import java.util.ArrayList;

public class Quicksort
{
    public static ArrayList quickSort(ArrayList toSort, int begin, int end)
    {   
        Lagu[] sort = new Lagu[toSort.size()];
        for (int i = 0; i < toSort.size(); i++)
            sort[i] = (Lagu)toSort.get(i);
            
        quicksort(sort, begin, end);
        
        toSort = new ArrayList();
        for (int i = 0; i < sort.length; i++)
            toSort.add(sort[i]);
        
        return toSort;
    }
    
    private static void quicksort(Lagu[] toSort, int begin, int end)
    {
        Lagu middle;
        int left, right;

        left = begin;
        right = end;

        middle = toSort[(begin + end) / 2];
        do
        {
            while ((toSort[left].getName()).compareTo(middle.getName()) < 0)
                ++left;
            while ((middle.getName()).compareTo(toSort[right].getName()) < 0)
                --right;
            
            if (left <= right)
            {
                Lagu temp = toSort[left];
                toSort[left] = toSort[right];
                toSort[right] = temp;
                ++left;
                --right;
            }
        } while (left < right);

        if (begin < right)
            quicksort(toSort, begin, right);
        if (left < end)
            quicksort(toSort, left, end);
    }
}