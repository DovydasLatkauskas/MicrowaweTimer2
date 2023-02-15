public class Main{
    public static void main(String[] args){
        int[] testInput = {1, 80};
        System.out.println(microwaveTimer(testInput));
    }

    public static int[][] microwaveTimer(int[] startState){
        int[][] output = new int[startState[0] * 60 + startState[1] + 1][2];
        return output;
    }
}