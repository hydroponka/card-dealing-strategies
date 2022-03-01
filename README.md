## Card Dealing Strategy
**Strategy** is a behavioral design pattern that lets you define a family of algorithms, put each of them into a separate class, and make their objects interchangeable.

*CardDealingStrategy* is a strategy of dealing cards for a card game.
Each game defines how many cards should be dealt to a player and what additional card stacks should be dealt as well.

It's result of it is a Map containing named card stacks (as Lists).
Each player's stack has a name on its number: "Player 1", "Player 2", an so on.
Additional stacks varies from game to game.
The rest, if any, of the card deck becomes a "Remaining" stack.

Note that at first, cards are dealt to players, one per round and then cards are dealt to additional stacks and the remaining deck becomes a "Remaining" stack.

Implement [`com.epam.rd.autocode.startegy.cards.CardDealingStrategies`](src\main\java\com\epam\rd\autocode\startegy\cards\CardDealingStrategies.java) methods:
- `texasHoldemCardDealingStrategy` - returns a CardDealingStrategy for Texas Hold'em Poker.
2 cards per player, 5 cards in additional "Community" stack.
- `classicPokerCardDealingStrategy` - returns a CardDealingStrategy for Classic Poker.
5 cards per player, no additional stacks.
- `bridgeCardDealingStrategy` - returns a CardDealingStrategy for Bridge.
13 cards per player, no additional stacks. 
- `foolCardDealingStrategy` - returns a CardDealingStrategy for Fool.
6 cards per player, 1 card in additional "Trump card" stack.
