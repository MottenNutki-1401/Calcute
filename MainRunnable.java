import javax.swing.SwingUtilities;

public class MainRunnable{

    public static void main (String [] args) {

        SwingUtilities.invokeLater (new Runnable ()  {  //to prevent app from crushing
            
            public void run () {

                      new MidtermSrc (); 
                         }
                  });
            }
    }