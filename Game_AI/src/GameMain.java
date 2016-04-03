import javax.swing.JFrame;

public class GameMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame window = new JFrame("MyGame");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window.setContentPane(new GamePanel());
		
		window.pack();
		window.setVisible(true);
	}

}
