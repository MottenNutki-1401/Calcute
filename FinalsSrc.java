import javax.swing.*;

public class FinalsSrc {
    private JTextArea screen;
    
    public FinalsSrc(JTextArea screen) {
        this.screen= screen;
        
    }
    public void SetScreenEditableBtn(){
    screen.setEditable(true);
 }
 public void StringLenghtbtn (){
    int stringLenght = screen.getText().length();
    screen.setText("≽^•⩊•^≼ string lenght: " +stringLenght);
 }
 public void ConcatenateStringBtn () {
   
   String inputText = screen.getText(); // Get the current text from the JTextArea
   
      
       
   }
}

 
   

