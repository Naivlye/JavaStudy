package test;

public class Main {
    public static void utils(cumpter cumpter , int num1, int num2){
        int result  = cumpter.computer(num1,num2);
        System.out.println(result);
    }

    public static void main(String[] args) {
        Main.utils(new add(),1,2);
    }
}
