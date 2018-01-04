/**
 * @author: Armand Moussaouyi
 * @date: January 03, 2018
 * 
 * @description: This object is being used to store our data
 */
package computer.architecture;

public class Questions {
    private final String[] questions = {
        "1.\tThe information technology industry accounts for about ____ percent of the United States' gross national product", 
        "2.\tIn the last 30 years, technology revolutions begun by a new computer design were stopped short by",
        "3.\tAlongside the computer revolution is the ______ revolution",
        "4.\tEach time the cost of computing goes down",
        "5.\tA terabyte is 2^___ bytes",
        "6.\tAn embedded computer is distinguished from other types of computer by the fact that it",
        "7.\tThe role of the personal computer is now being replaced by the",
        "8.\tUnderstanding the hardware layer",
        "9.\tWhich area of performance improvement is out of the scope of this course",
        "10.\tWhich kind of parallelism is not discussed in computer organization and architecture?",
        "11.\tWhich has the least influence on the performance of a computer running a program?",
        "12.\tThe basic boolean algebra operators are?"
    };
    
    private final String[] answers = {
        "A. 60\nB. 30\nC. 50\nD. 10",
        "A. Even faster computers\nB. Foreign competition\nC. Presidential decree\nD. Laws",
        "A. Information\nB. Leisure\nC. Travel\nD. Electrical",
        "A. It is more difficult for hackers to create effective exploits.\nB. New market opportunities put processors into new areas of business and life.\nC. The risks associated with processor failure increase.\nD. The cost of big IT project failure goes up.",
        "A. 20\nB. 10\nC. 30\nD. 40",
        "A. Primarily runs a single, predetermined application\nB. has strict power requirements\nC. Must survive harsh operating conditions\nD. is built into an incredibly small space",
        "A. cloud\nB. super computer\nC. personal mobile device\nD. wearable computer",
        "A. provides for a steady income\nB. makes you a better programmer\nC. builds character\nD. is the key to an early retirement",
        "A. Memory systems\nB. The I/O system\nC. Algorithms\nD. Programming languages",
        "A. Data-level parallelism\nB. Instruction-level parallelism\nC. Thread-level parallelism\nD. Circuit-level parallelism",
        "A. The I/O system and devices\nB. The power supply wattage\nC. The processor\nD. The programming language or compiler\nE. The operating system\nF. The algorithm chosen\nG. The size of the screen",
        "A. And, Or and Not\nB. Or, Nor and Xor\nC. , / %\nD. If, And and But\nE. Equal and Not Equal\nF. &, | ^\nG. &, |, ~"
    };
    
    private final String[] correctAnswers = {
      "D", "A", "A", "B", "D", "A", "C", "B", "C", "D", "BG", "ACG"
    };
    
    public Questions(){}
    
    // Returns questions
    public String[] getQuestions(){
        return questions;
    }
    
    // Returns answers
    public String[] getAnswers(){
        return answers;
    }
    
    // Returns correct answers
    public String[] getCorrectAnswers(){
        return correctAnswers;
    }
}