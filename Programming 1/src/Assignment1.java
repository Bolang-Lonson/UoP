/**
 * Author: Bolang-Lonson Beinyoh Nfi
 * Programming Assignment Unit 1
 */ 
import textio.TextIO;

public class Assignment1 {
    public static void main(String[] args){
        // list of scores. 1 for passed and 0 for failed.  They all start at 0.
        byte[] scores = {0, 0, 0, 0, 0} ;
        // Instantiating the list of questions
        String[] questions = {
            "\nWhich of the following is NOT a primitive data type in Java?\na) int\nb) String\nc) double\nd) boolean",
            "\nWhat is the purpose of a variable in Java?\na) To perform calculations\nb) To print messages\nc) To define functions\nd) To store data",
            "\nWhat happens when you add 5 and 3 * 2 in Java without parentheses?\na) The answer is always 11 (3 * 2 first)\nb) The answer is always 8 (addition first)\nc) The answer depends on the order they are written\nd) This code will cause an error",
            "\nWhich conditional statement is best suited to check if a grade is A, B, or C?\na) if-else\nb) switch-case\nc) for loop\nd) while loop",
            "\nWhich of the following data types in Java can store a single character?\na) int\nb) double\nc) char\nd) String"
        };
        char[] correctAnswers = {'B', 'D', 'A', 'B', 'C'};  // The correct answers to each question
        
        System.out.println("******Quiz Game*****");
        System.out.println("Start? y/n");
        Boolean resp = TextIO.getlnBoolean();
        if (!resp){
            // Program execution would end here 
            System.out.println("Ending Program...");
            return;
        }
        // Looping through the questions
        for (int i = 0; i < questions.length; i++){
            System.out.println(questions[i]);
            System.out.println("Ans: ");
            char ans = TextIO.getlnChar();
            char refAns = correctAnswers[i];    // the reference answer
            
            if(ans == refAns || ans == Character.toLowerCase(refAns)){
                scores[i] = 1;
                // Updating score value when answer is correct
            }
        }

        int totalScore = 0;
        for(byte score: scores){
            totalScore += score;
            // Summing up the total scores
        }

        System.out.printf("Your total score is %d", totalScore);
    }
}