/**
 * @author: Armand Moussaouyi
 * @date: January 03, 2018
 * 
 * @description: The following object interacts with our question pool (Questions.java)
 * 
 * @Note: The linear search at the bottom is not the most effective way to search an
 * of strings, but since this example software only has arrays with 12 elements in each
 * one searching through them should not be too overwhelming (or you can design a 
 * binary search method and changes a few things in the Interface object (Interface.java) too make it work)
 */
package computer.architecture;

public class data {
    Questions quest = new Questions();
    private final String[] questions = quest.getQuestions();
    private final String[] answers = quest.getAnswers();
    private final String[] answerSet = quest.getCorrectAnswers();
    private int qCovered = 0;
    private int correctA = 0;
    private int wrongAns = 0;

    private String ques = questions[0];
    private String answ = answers[0];
    private String corr = answerSet[0];
    
    public data(){} // Default constructor
    
    /**
     * Returns question pool
     * @return 
     */ 
    public String[] getQuestionPool(){
        return questions;
    }
    
    /**
     * Returns answer pool
     * @return 
     */
    public String[] getAnswerPool(){
        return answers;
    }
    
    /**
     * Returns correct answer pool
     * @return 
     */
    public String[] getCorrectAnswerPool(){
        return answerSet;
    }
    
    // Process the number of questions covered
    public void setCoverage(int cover){
        this.qCovered = cover;
    }
    public void incrementCoverage(){
        this.qCovered++;
    }
    public String getQuestionsAnswered(){
        return "Questions covered:\t\t" + qCovered;
    }
    
    // Process the number of correct answers covered
    public void setCorrectAnswers(int correct){
        this.correctA = correct;
    }
    public void incrementCorrectAnswers(){
        this.correctA++;
    }
    public String getCorrectAnswers(){
        return "Correct answers    :\t\t" + correctA;
    }
    public int getIntCorrect(){ return correctA; }
    
    // Process the number of incorrect answers
    public void setIncorrectAnswers(int wa){
        this.wrongAns = wa;
    }
    public void incrementIncorrectAnswers(){
        this.wrongAns++;
    }
    public String getIncorrectAnswers(){
        return "Incorrect answers:\t\t" + wrongAns;
    }
    public int getIntWrong(){ return wrongAns; }
    
    public int getNumberOfQuestions(){
        return questions.length;
    }
    
    // Sets and gets current questions
    public void setQ(int q){
        this.ques = questions[q];
    }
    public String getQ(){
        return ques;
    }
    
    // Sets and gets current answer
    public void setA(int a){
        this.answ = answers[a]; 
    }
    public String getA(){
        return answ;
    }
    
    // Sets and gets current correct answer
    public void setCorrectA(int index){
        this.corr = answerSet[index];
    }
    public String getCorrectA(){
        return corr;
    }
    
    /**
     * Linear search (why not binary search; because I don't want them in sorted order)
     * @param list
     * @param key
     * @return index (int)
     */
    public int linearSearch(String[] list, String key){
        int index = -1;
        for (int i = 0; i < list.length; i++){
            if (list[i].equalsIgnoreCase(key))
               index = i;
        }
        return index;
    }
}