/**
 * @author: Armand Moussaouyi
 * @date: January 03, 2018
 * 
 * @description: This software demonstrates basic GUI programming techniques in 
 * JavaFX/Java. It is mimicking a simple learning application. The user is 
 * presented with an array of questions and answers one element at a time and
 * requested to select the correct answer.
 */
package computer.architecture;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;

public class Interface {
    protected Toolkit tools = Toolkit.getDefaultToolkit();
    private final Dimension dimension = tools.getScreenSize(); // Getting hardware screen size
    private final double height = dimension.getHeight();       // screen height
    private final double width = dimension.getWidth();         // screen width
    
    data questions = new data();        // Instant of data object
    
    private final GridPane pane1 = new GridPane();
    private final VBox pane2 = new VBox();
    private final VBox pane2Sub = new VBox();
    private final HBox pane2Sub1 = new HBox();
    
    private final BorderPane pane3 = new BorderPane();
    private final HBox pane3Sub1 = new HBox();
    private final HBox pane3Sub2 = new HBox();
    private final HBox pane3Sub3 = new HBox();
    private final HBox pane3Sub4 = new HBox();
    
    private final Separator separator1 = new Separator();
    private final Separator separator2 = new Separator();
    
    private final Button btn1 = new Button("Go to");
    private final Button btn2 = new Button("Go to");
    private final Button btn3 = new Button("Random Question");
    private final Button btn4 = new Button("<<");
    private final Button btn5 = new Button(">>");
    
    private final Button btn6 = new Button("A");
    private final Button btn7 = new Button("B");
    private final Button btn8 = new Button("C");
    private final Button btn9 = new Button("D");
    private final Button btn10 = new Button("E");
    private final Button btn11 = new Button("F");
    private final Button btn12 = new Button("G");
    
    private final ComboBox<Integer> box1 = new ComboBox<>();
    private final ComboBox<Integer> box2 = new ComboBox<>();
    private final ComboBox<Integer> box3 = new ComboBox<>();
    
    private final Label label1 = new Label("First");
    private final Label label2 = new Label("Questions");
    private final Label label3 = new Label("Question");
    private final Label label4 = new Label("to");
    
    private final Label label5 = new Label(questions.getQuestionsAnswered());
    private final Label label6 = new Label(questions.getCorrectAnswers());
    private final Label label7 = new Label(questions.getIncorrectAnswers());
    
    private final Label label8 = new Label("Select all correct answers");
    private final Label label9 = new Label("SCORE:\n----------------------");
    private final Label label10;
    
    private final Text q = new Text(questions.getQ());
    private final Text a = new Text(questions.getA());
    
    private int count = 0;
    private int limit = questions.getNumberOfQuestions() - 1;
    private int min = 0;
    private byte _limit = 0;
    private int points = 0;
    
    String answer = questions.getCorrectA();
    
    /**
     * Default constructor, initialize label-10 and orient the separators
     */
    public Interface(){
        this.label10 = new Label(""+points);
        separator2.setOrientation(Orientation.VERTICAL);
        separator1.setOrientation(Orientation.VERTICAL);
    }
    
    /**
     * Control variable getter and setters
     */
    private void setCount(int cnt){
        this.count = cnt;
    }
    private int getCount(){
        return count;
    }
    
    /**
     * Limits the number of available questions to the set limit.
     * Used in both "go to" buttons
     */
    private void setLimit(int lmt){
        this.limit = lmt;
    }
    private int getLimit(){
        return limit;
    }
    
    /**
     * Limits the number of correct answers per question
     * A question may have 1 to 3 correct answers
     */
    private void set_Limit(byte _l){
        this._limit = _l;
    }
    private byte get_Limit(){
        return _limit;
    }
    private void increment_Limit(){
        _limit++;
    }
    
    /** 
     * Assigns points based on user correct and incorrect answers
     */ 
    private void setPoints(int pts){
        this.points = pts;
    }
    private void computePoints(){
        int value;
        value = questions.getIntCorrect() - questions.getIntWrong();
        setPoints(value);
        label10.setText(""+getPoints());
    }
    private int getPoints(){
        if (points < 0)
            return 0;
        else
            return points;
    }
    
    /**
     * Top grid panel
     * Adds HBoxes, labels, buttons and drop down menus to the GridPane 
     * @return a GridPane
     */
    public GridPane getTop(){
        HBox b1 = new HBox();
        HBox b2 = new HBox();
        
        // Adding Integer items to each ComboBox
        processBox(box1);       
        processBox(box2);
        processBox(box3);
        
        // Styling each component. See the style(Object obj, int w, int h) for reference
        styleObject(pane1, 1, 6);
        styleObject(b1, 3, 10);
        styleObject(b2, 3, 10);
        styleObject(btn1, 22, 26);
        styleObject(btn2, 22, 26);
        styleObject(btn3, 8, 16);
        styleObject(box1, 15, 26);
        styleObject(box2, 15, 26);
        styleObject(box3, 15, 26);
        styleObject(label1, 35, 14);
        styleObject(label2, 75, 14);
        styleObject(label3, 60, 14);
        styleObject(label4, 20, 14);
        
        // Adding components to the top HBoxes
        b1.getChildren().addAll(label1, box1, label2, btn1);
        b2.getChildren().addAll(label3, box2, label4, box3, btn2);
        
        // Adding all components to the GridPane
        pane1.add(b1, 0, 0);
        pane1.add(separator2, 1, 0);
        pane1.add(b2, 2, 0);
        pane1.add(separator1, 3, 0);
        pane1.add(btn3, 4, 0);
        
        return pane1;
    }
    
    /**
     * Right panel (VBox)
     * Adds all the panes, button, labels, texts and other components the right
     * @return VBox
     */
    public VBox getRight(){
        label9.setStyle("-fx-text-fill: #fff; -fx-font-family: monospace;"
            + "-fx-font-weight: bold; -fx-font-size: 20;");
        label10.setStyle("-fx-text-fill: #fff; -fx-font-family: monospace;"
            + "-fx-font-weight: bold; -fx-font-size: 110;");
        
        label9.setTextAlignment(TextAlignment.CENTER);
        pane2Sub.getChildren().add(label9);
        pane2Sub.getChildren().add(label10);
        styleObject(pane2, 5, 0);
        styleObject(label5, 200, 30);
        styleObject(label6, 200, 30);
        styleObject(label7, 200, 30);
        styleObject(pane2Sub1, 15, 6);
        styleObject(pane2Sub, 15, 1);
        
        label8.setTextAlignment(TextAlignment.JUSTIFY);
        label8.setStyle("-fx-text-fill: #800000; -fx-font-family: monospace;"
            + "-fx-font-weight: bold; -fx-font-size: 16;");
        pane2Sub1.getChildren().add(label8);
        
        pane2.setSpacing(6);
        
        //pane2.getChildren().add(new Separator());
        pane2.getChildren().add(label5);
        pane2.getChildren().add(new Separator());
        pane2.getChildren().add(label6);
        pane2.getChildren().add(new Separator());
        pane2.getChildren().add(label7);
        pane2.getChildren().add(new Separator());
        pane2.getChildren().add(pane2Sub1);
        pane2.getChildren().add(pane2Sub);
        
        return pane2;
    }

    /**
     * Center pane (BorderPane)
     * Adds components to the center panel
     * @return BorderPane
     */
    public BorderPane getCenter(){
        // Adding functionality to each button (click action)
        btn1.setOnAction(e -> { firstNumQuestions();});
        btn2.setOnAction(e -> { rangeControl();     });
        btn3.setOnAction(e -> { randomControl();    });
        btn4.setOnAction(e -> { backwardControl();  });
        btn5.setOnAction(e -> { forwardControl();   });
        
        btn6.setOnAction(e -> { answerButtonControl(btn6);   });
        btn7.setOnAction(e -> { answerButtonControl(btn7);   });
        btn8.setOnAction(e -> { answerButtonControl(btn8);   });
        btn9.setOnAction(e -> { answerButtonControl(btn9);   });
        btn10.setOnAction(e -> { answerButtonControl(btn10);  });
        btn11.setOnAction(e -> { answerButtonControl(btn11);  });
        btn12.setOnAction(e -> { answerButtonControl(btn12);  });
        
        styleObject(pane3Sub1, 30, 5, false);
        styleObject(pane3Sub2, 30, 10, false);
        styleObject(pane3Sub3, 1.4, 10, false);
        styleObject(pane3Sub4, 30, 4, false);
        styleObject(btn4, 26, 5);
        styleObject(btn5, 26, 5);
        styleObject(btn6, 10, 12);
        styleObject(btn7, 10, 12);
        styleObject(btn8, 10, 12);
        styleObject(btn9, 10, 12);
        styleObject(btn10, 10, 12);
        styleObject(btn11, 10, 12);
        styleObject(btn12, 10, 12);
        styleObject(q, 500, 20, true);
        styleObject(a, 500, 20, false);

        enableDisableButtons();
        pane3Sub4.getChildren().add(a);
        pane3Sub3.getChildren().add(q);
        pane3Sub1.getChildren().addAll(btn4, pane3Sub3, btn5);
        pane3Sub2.getChildren().addAll(btn6, btn7, btn8, btn9, btn10, btn11, btn12);
        
        pane3.setTop(pane3Sub1);
        pane3.setBottom(pane3Sub2);
        pane3.setCenter(pane3Sub4);
        
        return pane3;
    }
    
    /**
     * Sets and get the min value, the starting question
     */ 
    private void setMin(int mn){
        this.min = mn;
    }
    private int getMin(){
        return min;
    }
    
    /**
     * Sets combo box values
     * Reads the number of available questions and adds them to the ComboBox
     * using a for loop
     */ 
    private void processBox(ComboBox<Integer> box){
        box.getItems().clear();                 // Clears the menu
        for (int i = 1; i <= questions.getNumberOfQuestions(); i++){
            box.getItems().add(i);              // Add i to the menu
        }
        box.getSelectionModel().selectFirst();  // Sets 1 as the first or default value
    }
    
    /**
     * Process control display
     * Sets and gets the new question and answer
     */
    private void processDisplay(){
        questions.setQ(count);              // Sets next question
        questions.setA(count);              // Sets next answer
        questions.setCorrectA(count);
        q.setText(questions.getQ());        // Resets q label
        a.setText(questions.getA());        // Resets a label
        styleObject(q, 500, 20, true);
        styleObject(a, 500, 20, false);
    }
    
    /**
    * Controls
    * Allows the user to set the min and max limit
    * Example, looking at question 1 to 5 or 3 to 10
    */
    private void rangeControl(){
        int minimum = box2.getValue() - 1;  // Assign box2 value to minimum
        int max = box3.getValue() - 1;      // Assign box3 value to max
        if (minimum > max){
            setMin(max);                    
            setLimit(minimum);
        }
        else{
            setMin(minimum);
            setLimit(max);
        }
        setCount(getMin());
        processDisplay();
        enableDisableButtons();
    }
    
    /**
     * Allows user to iterate through the first n questions
     */ 
    private void firstNumQuestions(){
        setLimit(box1.getValue() - 1);
        setMin(0);
        setCount(0);
        processDisplay();
        enableDisableButtons();
    }
    
    /**
     * Allows the user to go to the next question in the array,
     * if last question is reached go back to question one.
     */ 
    private void forwardControl(){
        setCount(questions.linearSearch(questions.getAnswerPool(),  a.getText()));
        if (getCount() >= getLimit())    // If count reached last question
            setCount(getMin() - 1);      // Set count equal to -1
        this.count++;                    // Increment count
        processDisplay();
        computePoints();
        enableDisableButtons();
    }
    
    /**
     * Allows the user to go to the previous question in the array, if user
     * first question go to the last question
     */ 
    private void backwardControl(){
        setCount(questions.linearSearch(questions.getAnswerPool(), a.getText()));
        if (getCount() <= getMin())
            setCount(getLimit());
        else
            this.count--;
        processDisplay();
        computePoints();
        enableDisableButtons();
    }
    
    /**
     * Generates a random number between minimum and limit/max,
     * and display the question at that position (array[random])
     */
    private void randomControl(){
        Random random = new Random();
        setCount(random.nextInt(getLimit()) + getMin());
        processDisplay();
        enableDisableButtons();
    }
    
    /**
     * Response control
     * If the selected button is correct increment coverage and number of correct
     * answer, then go to the next question.
     * If there is more than one answer and correct button is clicked increment
     * the _Limit counter, disable the button, and prompt the user to make another selection.
     * Else, increment the incorrect counter and stay at that question until correct selection is made.
     */
    private void answerButtonControl(Button b){
        byte length = ((byte) questions.getCorrectA().length());
        
        if ((length == 1) && questions.getCorrectA().compareTo(b.getText()) == 0){
            questions.incrementCoverage();
            questions.incrementCorrectAnswers();
            label5.setText(questions.getQuestionsAnswered());
            label6.setText(questions.getCorrectAnswers());
            label8.setText("Correct!!");
            label8.setStyle("-fx-text-fill: green; -fx-font-family: monospace;"
                + "-fx-font-weight: bold; -fx-font-size: 30;");
            forwardControl();
        }
        else if( (length == 2) && questions.getCorrectA().contains(b.getText())){
            if (get_Limit() == 1){
                questions.incrementCoverage();
                questions.incrementCorrectAnswers();
                
                label5.setText(questions.getQuestionsAnswered());
                label6.setText(questions.getCorrectAnswers());
                label8.setText("Correct!!");
                label8.setStyle("-fx-text-fill: green; -fx-font-family: monospace;"
                + "-fx-font-weight: bold; -fx-font-size: 30;");
                set_Limit((byte)0);
                forwardControl();
            }
            else{
                increment_Limit();
                questions.incrementCoverage();
                questions.incrementCorrectAnswers();
                label6.setText(questions.getCorrectAnswers());
                label8.setText("Correct, \nThere is one more \ncorrect answer remaining");
                label8.setStyle("-fx-text-fill: yellow; -fx-font-family: monospace;"
                + "-fx-font-weight: bold; -fx-font-size: 18;");
                b.setDisable(true);
            }
        }
        else if ((length == 3) && questions.getCorrectA().contains(b.getText())){
            if (get_Limit() == 2){
                questions.incrementCoverage();
                questions.incrementCorrectAnswers();
                
                label5.setText(questions.getQuestionsAnswered());
                label6.setText(questions.getCorrectAnswers());
                label8.setText("Correct!!");
                label8.setStyle("-fx-text-fill: green; -fx-font-family: monospace;"
                + "-fx-font-weight: bold; -fx-font-size: 30;");
                set_Limit((byte)0);
                forwardControl();
            }
            else{
                increment_Limit();
                questions.incrementCoverage();
                questions.incrementCorrectAnswers();
                label6.setText(questions.getCorrectAnswers());
                label8.setText("Correct, \nThere is 1 or 2 more \ncorrect answer remaining");
                label8.setStyle("-fx-text-fill: yellow; -fx-font-family: monospace;"
                + "-fx-font-weight: bold; -fx-font-size: 18;");
                b.setDisable(true);
            }
        }
        else{
            label8.setText("Incorrect, \ntry again!");
            label8.setStyle("-fx-text-fill: red; -fx-font-family: monospace;"
                + "-fx-font-weight: bold; -fx-font-size: 30;");
            questions.incrementIncorrectAnswers();
            label7.setText(questions.getIncorrectAnswers());  
        }
    }

    /**
     * Enable and disable buttons as the user make selections.
     * Goes through the available selection and disable unavailable selections
     * and enable available selections.
     */
    private void enableDisableButtons(){
        String buttons = a.getText();
        if (!buttons.contains("A."))
            btn6.setDisable(true);
        else
            btn6.setDisable(false);
        
        if (!buttons.contains("B."))
            btn7.setDisable(true);
        else
            btn7.setDisable(false);
        
        if (!buttons.contains("C."))
            btn8.setDisable(true);
        else
            btn8.setDisable(false);
        
        if (!buttons.contains("D."))
            btn9.setDisable(true);
        else
            btn9.setDisable(false);
        
        if (!buttons.contains("E."))
            btn10.setDisable(true);
        else
            btn10.setDisable(false);
        
        if (!buttons.contains("F."))
            btn11.setDisable(true);
        else
            btn11.setDisable(false);
        
        if (!buttons.contains("G."))
            btn12.setDisable(true);
        else
            btn12.setDisable(false);   
    }
    
    /**
     * ------Overall style----\n
     * Sets object size (width and height), color, background color, border color
     * @param obj
     * @param w
     * @param h
     */
    public void styleObject(Object obj, int w, int h){
        if (obj instanceof GridPane){
            ((GridPane) obj).setPrefHeight(height / h);
            ((GridPane) obj).setAlignment(Pos.CENTER);
            ((GridPane) obj).setStyle("-fx-background-color: #5f9ea0;"
                + "-fx-border-color: lightgray");
            ((GridPane) obj).setHgap(10);
        }
        
        if (obj instanceof Separator){
            ((Separator) obj).setPrefSize(width / w, height / h);
        }
        
        if (obj instanceof HBox){
            ((HBox) obj).setSpacing(6);
            ((HBox) obj).setStyle("-fx-background-color: #add8e6;"
                + "-fx-border-radius: 10 10 0 0;"
                + "-fx-background-radius: 10 10 0 0;");
            ((HBox) obj).setAlignment(Pos.CENTER);
            ((HBox) obj).setPrefSize(width / w, height / (h + 2));
        }
        
        if (obj instanceof Button){
            ((Button) obj).setPrefSize(width / w, height / h);
            ((Button) obj).setStyle("-fx-font-size: 16; -fx-font-family: Cambria;");
        }
        
        if (obj instanceof ComboBox){
            ((ComboBox) obj).setPrefSize(width / w, height / h);
            ((ComboBox) obj).setStyle("-fx-font-size: 14; -fx-font-family: Cambria;");
            //((ComboBox) obj).setPadding(new Insets(3, 3, 3, 3));
        }
        
        if (obj instanceof Label){
            ((Label) obj).setPrefSize(w, h);
            ((Label) obj).setStyle("-fx-font-size: 14; -fx-font-family: Cambria;"
                + "-fx-font-weight: bold");
        }
        
        if (obj instanceof VBox){
            ((VBox) obj).setPrefWidth(width / w);
            ((VBox) obj).setStyle("-fx-background-color: #5f9ea0;"
                + "-fx-border-color: lightgray");
            ((VBox) obj).setAlignment(Pos.CENTER);
        }
    }
    
    /**
     * Overloading styleObject method
     * @param obj
     * @param w -> (width)
     * @param h -> (height)
     * @param b -> (true/false)
     */
    public void styleObject(Object obj, double w, int h, boolean b){
        if (obj instanceof HBox){
            ((HBox) obj).setSpacing(1);
            ((HBox) obj).setStyle("-fx-background-color: #008b8b;"
                + "-fx-border-color: lightgray");
            ((HBox) obj).setAlignment(Pos.CENTER);
            ((HBox) obj).setPrefSize(width / w, height / h);
        }
        
        if ((obj instanceof Text) && b){
            String txt = ((Text) obj).getText();
            String phrase = "";
            int wordCount = 1;
            for (int i = 0; i < txt.length(); i++){
                phrase = phrase.concat(Character.toString(txt.charAt(i)));
                if(txt.charAt(i) == ' '){
                    wordCount++;
                    if(wordCount == 10){
                        phrase = phrase.concat("\n\t");
                        wordCount = 0;
                    }
                }            
            }
            ((Text) obj).setText(phrase);
            ((Text) obj).setTextAlignment(TextAlignment.JUSTIFY);
            ((Text) obj).setStyle("-fx-text-fill: white; -fx-font-family: monospace;"
                + "-fx-font-weight: bold; -fx-font-size: 18;");
        }
        if ((obj instanceof Text) && !b){
            ((Text) obj).setTextAlignment(TextAlignment.JUSTIFY);
            ((Text) obj).setStyle("-fx-text-fill: red; -fx-font-family: monospace;"
                + "-fx-font-weight: bold; -fx-font-size: 16;");
        }
    }
}