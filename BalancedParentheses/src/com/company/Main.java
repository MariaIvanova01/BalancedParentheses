package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("");

        ArrayDeque<String> firstHalfStack = new ArrayDeque<>();
        ArrayDeque<String> secondHalfQueue = new ArrayDeque<>();

        int firstEl = 0;
        int lastEl = input.length -1;

        for (int i = lastEl; i > (input.length - 1) / 2; i--) {
            secondHalfQueue.offer(input[i]);
        }
        for (int j = (input.length - 1 ) / 2; j >= firstEl ; j--) {
            firstHalfStack.push(input[j]);
        }
        while (!firstHalfStack.isEmpty() && !secondHalfQueue.isEmpty()){
            String toPoll = secondHalfQueue.poll();
            String toPop = firstHalfStack.pop();
            if (toPoll.equals("}")){
                if (toPop.equals("{")) {
                    continue;
                }else{
                    break;
                }
            }else if (toPoll.equals("]")){
                if (toPop.equals("[")){
                    continue;
                }else{
                    break;
                }
            }else if (toPoll.equals(")")){
                if (toPop.equals("(")){
                    continue;
                }else{
                    break;
                }
            }else{
                break;
            }
        }
        if (firstHalfStack.isEmpty() && secondHalfQueue.isEmpty()){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
}
