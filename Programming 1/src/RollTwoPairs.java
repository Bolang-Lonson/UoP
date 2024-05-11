class PairOfDice {
    public int die1, die2;

    public PairOfDice() {
        // constructor rolls the dice so they initially show random variables
        roll();
    }

    public PairOfDice(int val1, int val2) {
        // Initially set to val1 and val2 provided during object construction
        die1 = val1;
        die2 = val2;
    }
    
    public void roll() {
        // Roll the dice by setting each of the dice to be
        // a random number between 1 and 6.
        die1 = (int)(Math.random()*6) + 1;
        die2 = (int)(Math.random()*6) + 1;
    }
}

public class RollTwoPairs {
    /**
     * Here, for example, is a main program that uses the PairOfDice class to count
     *   how many times two pairs of dice are rolled before the two pairs come up showing the same
     *   value.
     */
    public static void main(String[] args) {
        PairOfDice firstDice = new PairOfDice();
        PairOfDice secondDice = new PairOfDice();

        int countRolls, total1, total2;
        countRolls = 0;

        do {
            firstDice.roll();
            total1 = firstDice.die1 + firstDice.die2;
            System.out.println("First pair comes up " + total1);

            secondDice.roll();
            total2 = secondDice.die1 + secondDice.die2;
            System.out.println("Second pair comes up " + total2);

            countRolls++;
            System.out.println();

        } while (total1 != total2);

        System.out.println("It took " + countRolls + " rolls until the totals were the same.");
    }
}