# PokerBestHandExtension (Problem statement)
This repository have an implementation of java program to identify the Rank of hand in poker game.

1. Change the poker program to include following new hand rankings:
Straight flush: All cards in the same suit, and in sequence
Two pair: Two pairs of cards have the same rank
The new hand rankings are:
1. Straight flush: All cards in the same suit, and in sequence
2. Four of a kind: Four of the cards have the same rank
3. Full House: Three cards of one rank, the other two of another rank
4. Flush: All cards in the same suit
5. Straight: All cards in sequence (aces can be high or low, but not both at once)
6. Three of a kind: Three of the cards have the same rank
7. Two pair: Two pairs of cards have the same rank
8. Pair: Two cards have the same rank
9. High card: None of the above conditions are met
2. Modification:
High card rule should return the highest card as well,
Example ["S2" "D5" "C7" "ST" "HA"] should return, "high-card-ace"

# domain Package - It consist domain models and domain services
## model.valueobject Package - It consist value object classes

## HandRank
### Enum Values
- `PAIR`
- `THREEOFAKIND`
- `FOUROFAKIND`
- `STRAIGHT`
- `STRAIGHTFLUSH`
- `TWOPAIR`
- `FULLHOUSE`
- `FLUSH`
- `HIGHCARD`

## domain.model.service Package - This package having domain service classes

## FlushRankEvaluator
### States
- `private RankEvaluator nextEvaluator`

### Behaviors
- `public HandRank getRank(List<CardDto> cards)`
- `private boolean isFlushRank(List<CardDto> cards)`
- `public RankEvaluator setNextEvaluator(RankEvaluator nextEvaluator)`

## FourOfAKindRankEvaluator
### States
- `private RankEvaluator nextEvaluator`

### Behaviors
- `public HandRank getRank(List<CardDto> cards)`
- `private boolean isFourOfAKindRank(List<CardDto> cards)`
- `public RankEvaluator setNextEvaluator(RankEvaluator nextEvaluator)`

## FullHouseRankEvaluator
### States
- `private RankEvaluator nextEvaluator`

### Behaviors
- `public HandRank getRank(List<CardDto> cards)`
- `private boolean isFullHouse(List<CardDto> cards)`
- `public RankEvaluator setNextEvaluator(RankEvaluator nextEvaluator)`

## PairRankEvaluator
### States
- `private RankEvaluator nextEvaluator`

### Behaviors
- `public HandRank getRank(List<CardDto> cards)`
- `private boolean isPairRank(List<CardDto> cards)`
- `public RankEvaluator setNextEvaluator(RankEvaluator nextEvaluator)`

## StraightFlushRankEvaluator
### States
- `private RankEvaluator nextEvaluator`

### Behaviors
- `public HandRank getRank(List<CardDto> cards)`
- `public boolean isStraightFlushRank(List<CardDto> cards)`
- `public RankEvaluator setNextEvaluator(RankEvaluator nextEvaluator)`

## StraightRankEvaluator
### States
- `private RankEvaluator nextEvaluator`

### Behaviors
- `public HandRank getRank(List<CardDto> cards)`
- `private boolean isStraightRank(List<CardDto> cardDtos)`
- `public RankEvaluator setNextEvaluator(RankEvaluator nextEvaluator)`

## ThreeOfAKindRankEvaluator
### States
- `private RankEvaluator nextEvaluator`

### Behaviors
- `public HandRank getRank(List<CardDto> cards)`
- `private boolean isThreeOfAKindRank(List<CardDto> cards)`
- `public RankEvaluator setNextEvaluator(RankEvaluator nextEvaluator)`

## TwoPairRankEvaluator
### States
- `private RankEvaluator nextEvaluator`

### Behaviors
- `public HandRank getRank(List<CardDto> cards)`
- `private boolean isTwoPairRank(List<CardDto> cards)`
- `public RankEvaluator setNextEvaluator(RankEvaluator nextEvaluator)`

## RankEvaluator ( interface )

### Behaviors
- `HandRank getRank(List<CardDto> cards)`
- `RankEvaluator setNextEvaluator(RankEvaluator nextEvaluator)`

## HandEvaluatorChain ( class who define chain of responsibility )
### States
- `private final RankEvaluator rankEvaluator`

### Constructors
- `public HandEvaluatorChain()`

### Behaviors
- `public HandRank getRank(List<CardDto> cards)`

# controller Package - This package having controller classes

## CardController
### States
- `private final CardService cardService`

### Constructors
- `public CardController(CardService cardService)`

### Behaviors
- `public Response create(String code)`
- `public CardDto get(String code)`


## HandController
### States
- `private final HandService handService`

### Constructors
- `public HandController(HandService handService)`

### Behaviors
- `public Response create(List<CardDto> cards)`
- `public List<CardDto> getCardsForHand(Hand hand)`

## GameController
### States
- `private final GameService gameService`

### Constructors
- `public GameController(GameService gameService)`

### Behaviors
- `public HandRank checkRankFor(Hand hand)`

## controller.dto Package - This package consist class to return http status from the controller methods
## HttpStatus
### Enum Values
- `BAD_REQUEST`
- `OK`

## Response
### States
- `private final HttpStatus httpStatus`
- `private final String message`

### Constructors
- `public Response(HttpStatus httpStatus, String message)`

# service Package - Classes from this package are the middalware between controller layer and repository layer

## CardService
### States
- `private final CardRepository cardRepository`

### Constructors
- `public CardService(CardRepository cardRepository)`

### Behaviors
- `public CardDto create(String code)`
- `public CardDto get(String code)`

## HandService
### States
- `private final HandRepository handRepository`

### Constructors
- `public HandService(HandRepository handRepository)`

### Behaviors
- `public Hand create(List<CardDto> cards)`
- `public List<CardDto> getCardsForHand(Hand hand)`

## GameService
### States
- `private final HandEvaluatorChain handEvaluatorChain`
- `private final HandService handService`

### Constructors
- `public GameService(HandEvaluatorChain handEvaluatorChain, HandService handService)`

### Behaviors
- `public HandRank checkRankFor(Hand hand)`

# Repository Package - Classes from this package interact with the database, performing operations requested by the services.

## InMemoryCardRepository
### States
- `InMemoryDatabase inMemoryDatabase`

### Constructors
- `public InMemoryCardRepository(InMemoryDatabase inMemoryDatabase)`

### Behaviors
- `public CardDto add(CardDto card)`
- `public CardDto findCard(String code)`

## InMemoryHandRepository
### States
- `InMemoryDatabase inMemoryDatabase`

### Constructors
- `public InMemoryHandRepository(InMemoryDatabase inMemoryDatabase)`

### Behaviors
- `public Hand add(Hand hand)`
- `public List<CardDto> getCardsForHand(Hand hand)`

# repository.db Package - It gives the implementation for the fake database.

## FakeInMemoryDatabase
### States
- `List<CardDto> cards`
- `List<Hand> hands`

### Behaviors
- `public CardDto insertIntoCardTable(CardDto cardDto)`
- `public CardDto findCard(String code)`
- `public Hand insertIntoHandTable(Hand hand)`
- `public List<CardDto> getCardsForHand(Hand hand)`

## repository.dto package ( It defines the dto's)
## CardDto
### States
- `private final String code`

### Constructors
- `public CardDto(String code)`
- `public static CardDto create(String code)`

### Behaviors
- `public String getCode()`
- `public String getSuit()`
- `public String getRank()`

## Hand
### States
- `private final List<CardDto> cards`

### Constructors
- `public Hand(List<CardDto> cards)`
- `public static Hand create(List<CardDto> cards)

### Behaviors
- `public List<CardDto> getCards()`

## repository.dto.validator package ( it validates the dto memebers )

## CardValidator
### Behaviors
- `public static boolean isValidCode(String code)`
- `public static boolean isInvalidCode(String code)`
- `public static boolean isEmptyCode(String code)`
- `public static boolean isNullCode(String code)`
