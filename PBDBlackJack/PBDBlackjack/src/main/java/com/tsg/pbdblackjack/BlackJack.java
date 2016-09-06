package com.tsg.pbdblackjack;

import java.util.Random;
import java.util.Scanner;

public class BlackJack {

    Scanner keyboard = new Scanner(System.in);
    Random r = new Random();

    public void run() {

        int playerFirstCard = 2 + r.nextInt(10);
        int playerSecondCard = 2 + r.nextInt(10);
        int playerTotal = playerFirstCard + playerSecondCard;
        int dealerFirstCard = 2 + r.nextInt(10);
        int dealerSecondCard = 2 + r.nextInt(10);
        int dealerTotal = dealerFirstCard + dealerSecondCard;
        int newCard = 2 + r.nextInt(11);
        String chance;

        System.out.println("Welcome to Adam's blackjack!");
        System.out.println("\nYou got a " + playerFirstCard + " and a " + playerSecondCard);
        System.out.println("Your total is " + playerTotal);
        System.out.println("\nThe dealer has a " + dealerFirstCard + " showing, and a hidden card.");
        System.out.println("His total is hidden, too");

        boolean blackjack = instantWin(playerTotal);//If player is dealt 21- immediate win
        if (!blackjack) {
            playerTotal = askAndNewCardDealt(playerTotal, newCard);//asks if hit or stay and deal new card
            dealerTotal = playerDealerOutcome(playerTotal, dealerTotal, dealerFirstCard, dealerSecondCard, newCard);//checks player total/d
            checkForWinner(playerTotal, dealerTotal);//Takes playerTotal and dealerTotal, determines winner and prints it
        }
        System.out.println("Game Over!");
    }

    private int playerDealerOutcome(int playerTotal, int dealerTotal, int dealerFirstCard, int dealerSecondCard, int newCard) {
        String chance;
        if (playerTotal > 21) {
            System.out.println("\nYou busted, Dealer wins! ");
        } else {
            System.out.println("\nThe dealer has " + dealerFirstCard + " and a " + dealerSecondCard);
            chance = "hit";

            while (dealerTotal <= 16 && chance.equals("hit")) {
                if (dealerTotal < 16) {
                    System.out.println("The dealer hits and gets a " + newCard);
                    newCard = 2 + r.nextInt(11);
                    dealerTotal = dealerTotal + newCard;

                    System.out.println("His total is " + dealerTotal);

                } else {
                    boolean equals = chance.equals("stay");
                }
            }
            if (dealerTotal <= 21) {
                System.out.println("\nDealer stays on " + dealerTotal);
            } else {
                System.out.println("\nDealer busts, you win!!");
            }
        }
        return dealerTotal;
    }

    private int askAndNewCardDealt(int playerTotal, int newCard) {
        String chance;
        boolean hit = true;
        while (hit == true && playerTotal <= 21) {
            System.out.print("\nWould you like to 'hit' or 'stay'? ");
            chance = keyboard.next();
            if (chance.equals("hit")) {
                newCard = 2 + r.nextInt(11);
                System.out.print("You drew a " + newCard + ".");
                playerTotal = playerTotal + (newCard);
                System.out.print("Your total is " + playerTotal + ".");
            } else {
                System.out.println("You stay on " + playerTotal + ".");
                hit = false;

            }
        }
        return playerTotal;
    }

    private void checkForWinner(int playerTotal, int dealerTotal) {//Takes playerTotal and dealerTotal, determines winner and prints it
        if (playerTotal <= 21 && dealerTotal <= 21) {
            System.out.println("\nYou have " + playerTotal + " and the dealer has " + dealerTotal);
            if (playerTotal > dealerTotal) {
                System.out.println("PLayer wins!!! :)");
            } else {
                System.out.println("Dealer wins! :(");
            }
        }
    }

//If player is dealt 21- immediate win
    private boolean instantWin(int playerTotal) {
        if (playerTotal == 21) {
            System.out.println("\nBlackjack! You Win!");
            return true;

        }
        return false;
    }

}
