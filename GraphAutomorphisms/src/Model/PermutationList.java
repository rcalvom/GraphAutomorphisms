package Model;

public final class PermutationList {
    private int[][] Array;
    private int[] GlobalArray;
    private int pointer;

    public PermutationList(int n){
        this.Array = new int[factorial(n)][n];
        this.GlobalArray = new int[n];
        this.pointer = 0;
        for(int i = 1; i <=n; i++){
            this.GlobalArray[i-1] = i;
        }
        this.f(0, n - 1);
    }

    private void f(int start, int end){
        if(start == end){
            System.arraycopy(this.GlobalArray, 0, this.Array[this.pointer++],0, this.GlobalArray.length);
        }else{
            for(int i = 0; i < end - start + 1; i++){
                this.f(start + 1, end);
                this.GlobalArray = RotateArray(this.GlobalArray, start, end);
            }
        }
    }

    private int[] RotateArray(int[] array, int start, int end){
        int a = array[start];
        for(int i = start; i< end; i++){
            array[i] = array[i+1];
        }
        array[end] = a;
        return array;
    }

    private int factorial(int n){
        int fact = 1;
        for(int i = 2; i <= n; i++){
            fact *= i;
        }
        return fact;
    }

    public static int[][] getPermutations(int n){
        PermutationList list = new PermutationList(n);
        return list.Array;
    }
}