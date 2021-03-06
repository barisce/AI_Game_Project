
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Controllers.*;
import Models.*;

public class GameControllerTest extends JFrame {
	GamePanelTest gamePanel;
	PlayerController playerCont;
	TurnController turnCont;
	AIController ai;
	public Map m;
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	public static final double SCALE = 1;
	public static final String NAME = "Game";
	
	
	
	public GameControllerTest() throws IOException{
		playerCont = new PlayerController("test");
		turnCont = new TurnController();
		ai = new AIController();
		
		
		//final Map m = new Map(0);
		final Map m = new Map("C:/Users/Ubeyd/workspace/AI/assets/map1.txt", 0);
		
		
		final JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.setPreferredSize(new Dimension(400, 720));
		
		final GamePanelTest gamePanel = new GamePanelTest(m);
		gamePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		gamePanel.setPreferredSize(new Dimension(1920, 1920));

        final JScrollPane scroll = new JScrollPane(gamePanel);

		setMinimumSize(new Dimension((int)(WIDTH * SCALE), (int)(HEIGHT * SCALE)));
		setMaximumSize(new Dimension((int)(WIDTH * SCALE), (int)(HEIGHT * SCALE)));
		setPreferredSize(new Dimension((int)(WIDTH * SCALE), (int)(HEIGHT * SCALE)));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		add(panel, BorderLayout.EAST);
        add(scroll, BorderLayout.CENTER);
        setVisible(true);
        
        JButton neutral_map = new JButton("Map");
        neutral_map.addActionListener(new ActionListener() {
        	 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                System.out.println("You clicked neutral map");
                gamePanel.setM(m);
            }
        });      
 
        JButton p1_map = new JButton("TEST MOVE");
        p1_map.addActionListener(new ActionListener() {
       	 
            public void actionPerformed(ActionEvent e)
            {
                boolean re = ai.checkMove(6, 6, playerCont.getEntityFromPlayerWithIndex(1, 0),m);
                if(re){
                	System.out.println("Bast���n yere gider");
                }else{
                	System.out.println("Gidemez");
                }
            }
        }); 
        
        JButton p2_map = new JButton("MAP UPDATE");
        p2_map.addActionListener(new ActionListener() {
       	 
            public void actionPerformed(ActionEvent e)
            {
                MapUpdate(playerCont.getEntityContainer(1),m);
            }
        }); 
        
        panel.add(neutral_map);
        panel.add(p1_map);
        panel.add(p2_map);
        
        pack();
		
		setResizable(false);
		setLocationRelativeTo(null);
		//gamePanel.setM(m2);
		
	}
	
	public PlayerController getPlayerControlelr(){
		return this.playerCont;
	}
	void MapUpdate(EntityContainer e, Map m){
		int size = e.getSize();
		for(int i = 0;i<size;i++){
			m.getTile(e.getEntityFromIndex(i).getX(), e.getEntityFromIndex(i).getY()).setOwner(e.getEntityFromIndex(i).getOwner());
			m.getTile(e.getEntityFromIndex(i).getX(), e.getEntityFromIndex(i).getY()).setEntity(e.getEntityFromIndex(i).getEntityType());
		}
	}
}
