package history;

import java.util.ArrayList;
import java.util.Arrays;

public class HistoryStack implements iHistoryStackObserve {

    private static HistoryStack instance = null;

    private ArrayList<int[][]> historyStack = new ArrayList<int[][]>();
    private int top;

    private HistoryStack(){
        top = -1;
    }

    public static HistoryStack getHistoryStack(){
        if(instance == null){
            instance = new HistoryStack();
        }
        return instance;
    }

    @Override
    public void update(int[][] arrayInteraction) {
            push(arrayInteraction);
    }

    public void push(int[][] arrayInteraction){
        top += 1;
        historyStack.add(deepCopy(arrayInteraction));

//   this code is used for showing all the moves in history
//        for (int[][] state : historyStack) {
//            for (int[] row : state) {
//                System.out.println(Arrays.toString(row));
//            }
//            System.out.println();
//        }
    }

    public int[][] pop(){
        if(top >= 0) {
            return historyStack.get(top--);
        }
        else{
            return null;
        }
    }

    public void resetStack(){
        top = -1;
    }

    public static int[][] deepCopy(int[][] original) {
        if (original == null) {
            return null;
        }

        final int[][] result = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return result;
    }
}
