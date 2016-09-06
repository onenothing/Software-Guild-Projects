/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.pbdtictactoe;

import java.util.Scanner;

/**
 *
 * @author Adam Coate <adamcoate1@gmail.com>
 */
public class TicTacToeApp extends TicTacToe {

    public static void main(String[] args) {

        TicTacToe obj = new TicTacToe();
        obj.makeBoard();
        obj.display();
        int r, c;
        Scanner input = new Scanner(System.in);
        while (true) {
            boolean flag = true;
            while (flag) {
                System.out.println("Player 1");
                System.out.println("enter row");
                r = input.nextInt();
                System.out.println("enter col");
                c = input.nextInt();
                flag = obj.gamePlay(r, c, 1);
            }
            if (obj.isGameOver(1)) {
                obj.display();
                System.out.println("Player 1 Win Game");
                break;
            }
            System.out.println("============");
            obj.display();
            flag = true;
            while (flag) {
                System.out.println("Player 2");
                System.out.println("enter row");
                r = input.nextInt();
                System.out.println("enter col");
                c = input.nextInt();
                flag = obj.gamePlay(r, c, 2);
            }
            if (obj.isGameOver(2)) {
                obj.display();
                System.out.println("Player 2 Win Game");
                break;
            }
            System.out.println("============");
            obj.display();
        }
    }
}
