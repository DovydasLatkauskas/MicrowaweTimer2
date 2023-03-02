public class Main{
    public static void main(String[] args){
        int[] testInput = {1, 99};
        printTimer(microwaveTimer(testInput));
    }

    public static int[][] microwaveTimer(int[] startState){
        int[][] output = new int[startState[0] * 60 + startState[1] + 1][2];
        output[0] = startState; // start state is output and used in calculation
        for(int i = 1; i < output.length; i++){ // we start at 1 since we defined 0 already
            if(output[i-1][1] > 0){ // base case, where we count 1 second down
                output[i][1] = output[i-1][1] - 1;
                output[i][0] = output[i-1][0]; // need to carry the minute counter over from [i-1] to [i]
            }
            // if there are no more seconds left but there are minutes
            else if ((output [i-1][1] == 0)&&(output [i-1][0] > 0)){
                output[i][0] = output[i-1][0] - 1;
                output[i][1] = 59;
            }
        }
        return output;
    }

    private static void printTimer(int[][] printInput){ // method to print output of the timer
        for (int[] element : printInput) {
            System.out.println(element[0] + ":" + element[1]);
        }
    }
}