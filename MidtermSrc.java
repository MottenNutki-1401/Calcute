import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
    
public class MidtermSrc extends JFrame {
    
    private JTextArea screen; //here we display screen
    private JPanel btn; // 28 buttons plus added feature
    
    private String operator = "";
    private double firstOperand = 0;

    public MidtermSrc () {



    super ("DSA Calculator by Parazo_Daniel_Estrellado"); //class constructor from CalcuApp
    setLayout (new BorderLayout()) ;//for background and stuff layout
    
    
    Font font = new Font ("EmojiOne", Font.BOLD, 30);
    //display window for output
           screen = new JTextArea();
           screen.setPreferredSize(new Dimension(40,100));
           screen.setBackground(Color.BLACK);
           screen.setForeground(Color.CYAN);
           screen.setFont(font);
           screen.setEditable(false);
           
    //Borderssss
        Border Border = BorderFactory.createLineBorder(Color.PINK, 10);
        Border Border2 = BorderFactory.createLineBorder(Color.PINK, 10);
           screen.setBorder(Border);
          add (screen, BorderLayout.NORTH);

    //buttons operations
           btn = new JPanel();
          
           btn.setBackground(Color.PINK);
           btn.setBorder(Border2);
           btn.setPreferredSize(new Dimension(800,600));
           btn.setLayout(new GridLayout(10,6,3,3));
           btn.setFont (font);
          
             
    //function JButton AC to reset the screen
          JButton ac = new JButton ("AC");
          btn.add(ac);
          ac.addActionListener(e -> screen.setText (""));
    //del function bt
          JButton del = new JButton ("DEL"); 
          btn.add(del);

          del.addActionListener(e -> {
           String text = screen.getText();
           if (!text.isEmpty()) {
               screen.setText(text.substring(0, text.length() - 1));
           }
       });
     //numeric bt summation
         JButton Sum = new JButton ("∑"); 
         btn.add(Sum);
         Sum.addActionListener(e -> {
            String input = screen.getText();
             int n = Integer.parseInt(input.trim());
             
             int result = 0;

             // summation of numbers from 1 to n
             for (int i = 1; i <= n; i++) {             
                   result = result + i;               
             }
           screen.setText("the summation of 1-" + n + " is " + result);
        });

    //numeric bt prod (factorial)
          JButton fact = new JButton ("!"); 
           btn.add(fact);
           fact.addActionListener(e -> {
            String input = screen.getText();
             int n = Integer.parseInt(input.trim());
             
             int prod = 1;

             // summation of numbers from 1 to n
             for (int i = 1; i <= n; i++) {             
                   prod = prod* i;               
             }
          screen.setText("the factorial of " + n + " is " + prod);
        });

       
        

//numeric bt 1
      JButton one = new JButton ("1"); 
      btn.add(one);
      one.addActionListener(e -> {
      screen.setText(screen.getText() + "1");
   });
//numeric bt 2
      JButton two = new JButton ("2"); 
      btn.add(two);
      two.addActionListener(e -> {
     screen.setText(screen.getText() + "2");
});
 //numeric bt 3
    JButton thr = new JButton ("3");
    btn.add(thr);
    thr.addActionListener(e -> {
    screen.setText(screen.getText() + "3");
});
// multiply operator
 JButton mul = new JButton ("X");
 btn.add(mul);
 mul.addActionListener(e -> {
  setOperation("*");
  screen.setText(screen.getText() + "*");
});


//numeric bt 4
JButton fr = new JButton ("4");
btn.add(fr);
fr.addActionListener(e -> {
 screen.setText(screen.getText()+ "4");
});
//numeric bt 5
JButton fv = new JButton ("5");
btn.add (fv);
fv.addActionListener (e -> {
 screen.setText(screen.getText()+ "5");
});

//numeric JBtuuon 6
JButton six = new JButton ("6");
btn.add (six);
six.addActionListener (e -> {
screen.setText(screen.getText()+ "6");
});

 //division operator;
 JButton div = new JButton ("÷");
 btn.add(div);
 div.addActionListener (e -> {
  setOperation ("/");
  screen.setText(screen.getText() + "/");
});




    //numeric bt 7 (not a grid layout), bto buttons is set to flow layout
    JButton sev = new JButton ("7");
    btn.add (sev);
    sev.addActionListener  (e -> {
        screen.setText(screen.getText()+ "7");
    });
//numeric bt 8
    JButton eight = new JButton ("8");
    btn.add (eight);
    eight.addActionListener  (e -> {
        screen.setText(screen.getText()+ "8");
    });
//numeric JButton 9
    JButton nine = new JButton ("9");
     btn.add (nine);
     nine.addActionListener  (e -> {
         screen.setText(screen.getText()+ "9");
     });
     //addition button operator    
     JButton plus = new JButton("+");
     btn.add(plus);
     plus.addActionListener(e -> {
        setOperation("+");
        screen.setText(screen.getText() + "+"); 
    });
     



    //JButton deimal point
    JButton dot = new JButton (".");
    btn.add (dot);
    dot.addActionListener (e -> {
    screen.setText(screen.getText()+ ".");
    });
     //numeric bt 0
     JButton zero = new JButton ("0"); 
     btn.add(zero);
     zero.addActionListener(e -> {
     screen.setText(screen.getText() + "0");
  });
  //result bt =    
  JButton equals = new JButton("=");
  equals.addActionListener(e -> calculate());
  btn.add(equals);
//Operation JButton minus
     
JButton minus = new JButton("-");
btn.add(minus);
minus.addActionListener(e -> {
screen.setText(screen.getText() + "-");
setOperation("-"); 
}); 



//Function JButton Absolute Value
JButton abs = new JButton("ABS");
btn.add(abs);

abs.addActionListener(e -> {
  double value = Double.parseDouble(screen.getText());
  double result = Math.abs(value);
  
  screen.setText(String.valueOf("absolute value = "+result));        
});
//btp.add(new JButton ("FL"));
JButton flor = new JButton("Floor");
btn.add(flor);
flor.addActionListener(e -> {
   double value = Double.parseDouble(screen.getText());
   double result = Math.floor(value);
   screen.setText(String.valueOf("Floor value = "+result));        
});

//Function JButton min
JButton min = new JButton("MIN");
btn.add(min);
min.addActionListener(e -> {
String input = screen.getText();
       if (input.contains("-")) {
       String[] parts = input.split("-");
       if (parts.length == 2) {
    {
      double operand1 = Double.parseDouble(parts[0].trim());
      double operand2 = Double.parseDouble(parts[1].trim());
      double result = Math.min(operand1, operand2);
      screen.setText(String.valueOf("Min value is: "+result));
     }
   }
 }
});


// Operation JButton %
JButton percent = new JButton ("%");
btn.add(percent);
percent.addActionListener (e -> {
   double value = Double.parseDouble(screen.getText());
   value = value/ 100;
screen.setText(String.valueOf( "% value is: "+value));
});






 // math.round
 JButton rnd = new JButton("ROUND OFF");
 btn.add(rnd);
 rnd.addActionListener(e -> {
         double value = Double.parseDouble(screen.getText());
         double result = Math.round(value);
         screen.setText(String.valueOf("Rounded value = "+result));        
     });
//function JButton Ceiling
 JButton ceill = new JButton("Ceil");
 btn.add(ceill);
 ceill.addActionListener(e -> {
         double value = Double.parseDouble(screen.getText());
         double result = Math.ceil(value);
         screen.setText(String.valueOf("ceiling value = "+result));        
     });
      
//btn.add(new JButton ("MAX"));
 JButton max = new JButton("MAX");
 btn.add(max);
 max.addActionListener(e -> {
 String input = screen.getText();
        if (input.contains("-")) {
        String[] parts = input.split("-");
        if (parts.length == 2) {
     {
       double operand1 = Double.parseDouble(parts[0].trim());
       double operand2 = Double.parseDouble(parts[1].trim());
       double result = Math.max(operand1, operand2);
       screen.setText(String.valueOf("Max value is: "+result));
      }
    }
  }
});
 
 //power
JButton power = new JButton("^");
btn.add(power);
power.addActionListener(e -> {
    String text = screen.getText();
        setOperation("^");
        screen.setText(text + "^");
    
});
//setScreen Editable button for string functions
JButton editableScreen = new JButton("setSc");
editableScreen.addActionListener (e-> {
    FinalsSrc screenBtn = new FinalsSrc(screen);
    screenBtn.SetScreenEditableBtn();
});
btn.add(editableScreen);

//string length buttton
JButton stringL = new JButton ("Strlen()");
stringL.addActionListener (e->{
    FinalsSrc strlen = new FinalsSrc(screen);
    strlen.StringLenghtbtn();
});
btn.add(stringL);

//set n value button
JButton setN = new JButton ("Set N");
btn.add (setN);

// set r value button
JButton setR = new JButton ("Set R");
btn.add (setR);

//Enque button (Ques)
JButton enqueue = new JButton ("Enqueue()");
btn.add (enqueue);

//string concatenate button
JButton concat = new JButton ("str.concat");
btn.add (concat);

//Permutation button
JButton permutation = new JButton ("Permutation");
btn.add (permutation);

// Combination Button
JButton combination = new JButton ("Combination");
btn.add (combination);

//Dequeue button (Ques)
JButton dequeue = new JButton ("Dequeue()");
btn.add (dequeue);

//push button (Stack)
JButton push = new JButton ("Push()");
btn.add (push);

//pop button (Stack)
JButton pop = new JButton ("pop()");
btn.add (pop);

//peek button (Stack)
JButton peek = new JButton ("peek()");
btn.add (peek);
          

//putting function button to calculator
          add(btn,BorderLayout.CENTER);

//coloring buttons
          equals.setBackground(Color.GREEN);
          equals.setForeground(Color.BLACK);


          ac.setBackground(Color.ORANGE);
          ac.setForeground((Color.BLACK));
          del.setBackground(Color.white);
          del.setForeground((Color.black));
          Sum.setBackground(Color.white);
          Sum.setForeground((Color.black));


          one.setBackground(Color.pink);
          one.setForeground((Color.black));
          two.setBackground(Color.pink);
          two.setForeground((Color.black));
          thr.setBackground(Color.pink);
          thr.setForeground((Color.black));
          fr.setBackground(Color.pink);
          fr.setForeground((Color.black));
          fv.setBackground(Color.pink);
          fv.setForeground((Color.black));
          six.setBackground(Color.pink);
          six.setForeground((Color.black));
          sev.setBackground(Color.pink);
          sev.setForeground((Color.black));
          eight.setBackground(Color.pink);
          eight.setForeground((Color.black));
          nine.setBackground(Color.pink);
          nine.setForeground((Color.black));
          dot.setBackground(Color.pink);
          dot.setForeground((Color.black));
          zero.setBackground(Color.pink);
          zero.setForeground((Color.black));



          max.setBackground(Color.LIGHT_GRAY);
          max.setForeground((Color.BLACK));
          ceill.setBackground(Color.LIGHT_GRAY);
          ceill.setForeground((Color.BLACK));
          rnd.setBackground(Color.LIGHT_GRAY);
          rnd.setForeground((Color.BLACK));
          min.setBackground(Color.LIGHT_GRAY);
          min.setForeground((Color.BLACK));
          flor.setBackground(Color.LIGHT_GRAY);
          flor.setForeground((Color.BLACK));
          abs.setBackground(Color.LIGHT_GRAY);
          abs.setForeground((Color.BLACK));

          fact.setBackground(Color.DARK_GRAY);
          fact.setForeground((Color.pink));
          
          mul.setBackground(Color.DARK_GRAY);
          mul.setForeground((Color.pink));
          div.setBackground(Color.DARK_GRAY);
          div.setForeground((Color.pink));
          plus.setBackground(Color.DARK_GRAY);
          plus.setForeground((Color.pink));
          minus.setBackground(Color.DARK_GRAY);
          minus.setForeground((Color.pink));
          percent.setBackground(Color.DARK_GRAY);
          percent.setForeground((Color.pink));

          power.setBackground(Color.DARK_GRAY);
          power.setForeground((Color.pink));

          


          


    setSize(500, 700); //no need for frame name we can directly call from parent class
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // to quit application                           
    setVisible (true); //make our frame visible  
    setResizable(false);              
     
    }

    private void setOperation(String op) {
      
          firstOperand = Double.parseDouble(screen.getText());
          operator = op;
      
    }
    //executing actions
      private void calculate() {
        String screenText = screen.getText();
       
    
    // to display previous operation on our screen we use split
        String[] parts = screenText.split("\\" + operator);
        
         {
            double secondOperand = Double.parseDouble(parts[1].trim());
            double result = 0;  
          
            switch (operator) {
                case "+":
                    result = firstOperand + secondOperand;
                    break;
                case "-":
                    result = firstOperand - secondOperand;
                    break;
                case "*":
                    result = firstOperand * secondOperand;
                    break;
                case "/":
                    if (secondOperand != 0) {
                        result = firstOperand / secondOperand;
                    } else {
                        JOptionPane.showMessageDialog(this, "Oops! number cannot be divide by zero.");
                        return;
                    }
                    break;
                case "^":
                    result = +Math.pow(firstOperand,secondOperand);
                    break;
                
                }
            screen.setText(screenText + " = " +result ); 
            screen.setText(String.valueOf(result));    
           }    
        }
    }

    