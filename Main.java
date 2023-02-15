public class Main{
    public static void main(String[] args){
        int[] testInput = {1, 80};
        printTimer(microwaveTimer(testInput));
    }

    public static int[][] microwaveTimer(int[] startState){
        int[][] output = new int[startState[0] * 60 + startState[1] + 1][2];
        output[0] = startState;
        for(int i = 1; i > output.length + 1; i++){ // we start at 1 since we defined 0 already
            if(output[i-1][1] > 0){ // base case, where we count 1 second down
                output[i][1] = output[i-1][1] - 1;
            }
            else if ((output [i-1][1] == 0)&&(output [i-1][0] > 0)){ // if there are no more seconds left but there are minutes
                output[i][0] = output[i-1][0] - 1;
                output[i][1] = 59;
            }
            else{
                return output;
            }
        }
        return output; // will not fire but needed for the compiler to be happy
    }

    private static void printTimer(int[][] printInput){
        for (int[] element : printInput) {
            System.out.println(element[0] + ":" + element[1]);
        }
    }
}