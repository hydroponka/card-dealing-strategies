package com.epam.rd.autocode.startegy.cards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardDealingStrategies {
    public static CardDealingStrategy texasHoldemCardDealingStrategy() {
        return new TexasHoldemCardDealingStrategy();
    }

    public static CardDealingStrategy classicPokerCardDealingStrategy() {
        return new ClassicPokerCardDealingStrategy();
    }

    public static CardDealingStrategy bridgeCardDealingStrategy(){
        return new BridgePokerCardDealingStrategy();
    }

    public static CardDealingStrategy foolCardDealingStrategy(){
        return new FoolCardDealingStrategy();
    }
    public static class TexasHoldemCardDealingStrategy implements CardDealingStrategy {

        @Override
        public Map<String, List<Card>> dealStacks(Deck deck, int players) {
            Map<String, List<Card>> stacks = new HashMap<>();

            for (int i = 1; i <= players; i++) {
                stacks.put("Player " + i, new ArrayList<>());
            }
            int cardsPerPlayer = 2;
            for (int i = 0; i < cardsPerPlayer; i++) {
                for (int j = 1; j <= players; j++) {
                    String playerKey = "Player " + j;
                    List<Card> playerCards = stacks.get(playerKey);
                    playerCards.add(deck.dealCard());
                    stacks.put(playerKey, playerCards);
                }
            }
            List<Card> community = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                community.add(deck.dealCard());
            }
            stacks.put("Community", community);

            List<Card> remaining = new ArrayList<>();
            while (deck.size() > 0) {
                remaining.add(deck.dealCard());
            }
            stacks.put("Remaining", remaining);

            return stacks;
        }
    }

    public static class ClassicPokerCardDealingStrategy implements CardDealingStrategy {

        @Override
        public Map<String, List<Card>> dealStacks(Deck deck, int players) {
            Map<String, List<Card>> stacks = new HashMap<>();

            for (int i = 1; i <= players; i++) {
                stacks.put("Player " + i, new ArrayList<>());
            }

            int cardsPerPlayer = 5;
            for (int i = 0; i < cardsPerPlayer; i++) {
                for (int j = 1; j <= players; j++) {
                    String playerKey = "Player " + j;
                    List<Card> playerCards = stacks.get(playerKey);
                    playerCards.add(deck.dealCard());
                    stacks.put(playerKey, playerCards);
                }
            }

            List<Card> remaining = new ArrayList<>();
            while (deck.size() > 0) {
                remaining.add(deck.dealCard());
            }
            stacks.put("Remaining", remaining);

            return stacks;
        }
    }

    public static class BridgePokerCardDealingStrategy implements CardDealingStrategy {

        @Override
        public Map<String, List<Card>> dealStacks(Deck deck, int players) {
            Map<String, List<Card>> stacks = new HashMap<>();

            for (int i = 1; i <= players; i++) {
                stacks.put("Player " + i, new ArrayList<>());
            }

            int cardsPerPlayer = 13;
            for (int i = 0; i < cardsPerPlayer; i++) {
                for (int j = 1; j <= players; j++) {
                    String playerKey = "Player " + j;
                    List<Card> playerCards = stacks.get(playerKey);
                    playerCards.add(deck.dealCard());
                    stacks.put(playerKey, playerCards);
                }
            }

            return stacks;
        }
    }
    public static class FoolCardDealingStrategy implements CardDealingStrategy {

        @Override
        public Map<String, List<Card>> dealStacks(Deck deck, int players) {
            Map<String, List<Card>> stacks = new HashMap<>();

            for (int i = 1; i <= players; i++) {
                stacks.put("Player " + i, new ArrayList<>());
            }
            int cardsPerPlayer = 6;
            for (int i = 0; i < cardsPerPlayer; i++) {
                for (int j = 1; j <= players; j++) {
                    String playerKey = "Player " + j;
                    List<Card> playerCards = stacks.get(playerKey);
                    playerCards.add(deck.dealCard());
                    stacks.put(playerKey, playerCards);
                }
            }

            List<Card> remaining = new ArrayList<>();
            while (deck.size() > 0) {
                remaining.add(deck.dealCard());
            }
            stacks.put("Remaining", remaining);

            List<Card> trumpCard = new ArrayList<>();
            while (deck.size() > 0) {
                trumpCard.add(deck.dealCard());
                stacks.put("TrumpCard", trumpCard);
                return stacks;
            }
            stacks.put("TrumpCard", trumpCard);
            return stacks;
        }
    }

}
