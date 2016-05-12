import java.io.IOException;
import java.awt.*;
import javax.swing.*;

public class GameMain {
	
	
	
	public static void main(String[] args)  throws Exception {
        
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() 
            {
				try {
					new GameControllers().setVisible(true);
				} catch (HeadlessException | IOException e) {
					e.printStackTrace();
				}
            }
        });
	}
}