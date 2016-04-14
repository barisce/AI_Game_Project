import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	//Variables
	public static int WIDTH = 1920;
	public static int HEIGHT = 1920;
	
	private Tile selectedTile = null;
	
	private Thread thread;
	private boolean running;
	
	private BufferedImage image;
	private Graphics2D g;
	private Map m;
	
	private int FPS = 60;
	private double averageFPS;
	
	private ArrayList<Image> texture;
	private ArrayList<Image> ownership;
	private ArrayList<Image> entities;
	
	//Constructor
	public GamePanel() throws IOException {
		super();
		setPreferredSize(new Dimension (WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
		m = new Map();
		addMouseListener (new MouseAdapter() 
		{
			public void mousePressed(MouseEvent e) 
			{
				int x = e.getX();
				int y = e.getY();
				System.out.println("x: " + x/32 + ", y: " + y/32);
				//get the tile at the specific coordinate
				setSelectedTile( m.getTile(x/32, y/32));
			}
		});
		
		setSelectedTile(new Tile(61, 61, 100));
	}
	
	public GamePanel(Map ma) throws IOException {
		//super();
		texture = new ArrayList<Image>();
		ownership = new ArrayList<Image>();
		entities = new ArrayList<Image>();
		
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream input = classLoader.getResourceAsStream("grass.png");
		texture.add(ImageIO.read(input));
		input = classLoader.getResourceAsStream("snow.png");
		texture.add(ImageIO.read(input));
		input = classLoader.getResourceAsStream("forest.png");
		texture.add(ImageIO.read(input));
		input = classLoader.getResourceAsStream("forest_depleted.png");
		texture.add(ImageIO.read(input));
		input = classLoader.getResourceAsStream("Player1.png");
		ownership.add(ImageIO.read(input));
		input = classLoader.getResourceAsStream("Player2.png");
		ownership.add(ImageIO.read(input));
		input = classLoader.getResourceAsStream("town.png");
		entities.add(ImageIO.read(input));
		input = classLoader.getResourceAsStream("tower.png");
		entities.add(ImageIO.read(input));
		input = classLoader.getResourceAsStream("warrior.png");
		entities.add(ImageIO.read(input));
		input = classLoader.getResourceAsStream("worker.png");
		entities.add(ImageIO.read(input));
		input = classLoader.getResourceAsStream("archer.png");
		entities.add(ImageIO.read(input));
		input = classLoader.getResourceAsStream("barracks.png");
		entities.add(ImageIO.read(input));
		input = classLoader.getResourceAsStream("cavalry.png");
		entities.add(ImageIO.read(input));
		input = classLoader.getResourceAsStream("mine1.png");
		entities.add(ImageIO.read(input));
		input = classLoader.getResourceAsStream("mine2.png");
		entities.add(ImageIO.read(input));
		input = classLoader.getResourceAsStream("siege.png");
		entities.add(ImageIO.read(input));
		input = classLoader.getResourceAsStream("tile_improvement.png");
		entities.add(ImageIO.read(input));
		
		setPreferredSize(new Dimension (WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
		this.m = ma;
		for(int i = 0;i<60;i++){
			for(int j = 0;j<60;j++){
				System.out.print(""+m.getTile(i, j).getType()+" ");
			}
			System.out.print("\n");
		}
		
		setSelectedTile(new Tile(61, 61, 100));
		
		addMouseListener (new MouseAdapter() 
		{
			public void mousePressed(MouseEvent e) 
			{
				int x = e.getX();
				int y = e.getY();
				System.out.println("x: " + x/32 + ", y: " + y/32);
				//get the tile at the specific coordinate
				setSelectedTile( m.getTile(x/32, y/32));
				//send tile to GameControllers
				
				
				if(m.getTile(x/32, y/32).getType()==1){
					try {
						m.getTile(x/32, y/32).setType(0);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}else{
					try {
						m.getTile(x/32, y/32).setType(1);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				
			}
		});
	}
	
	//Functions
	public Tile getSelectedTile() {
		return selectedTile;
	}

	public void setSelectedTile(Tile selectedTile) {
		this.selectedTile = selectedTile;
	}
	
	
	public void addNotify() {
		super.addNotify();
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}
	
	public void run() {
		running = true;
		
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		
		long startTime;
		long URDTimeMilis;
		long waitTime;
		long totalTime = 0;
		
		int frameCount = 0;
		int maxFrameCount = 60;
		
		long targetTime = 1000 / FPS;
		
		//Game Loop
		while(running) {
			
			startTime = System.nanoTime();
			
			gameUpdate();
			gameRender();
			gameDraw();
			
			URDTimeMilis = (System.nanoTime() - startTime) / 1000000;
			
			waitTime = targetTime - URDTimeMilis;
			
			try {
				Thread.sleep(waitTime);
			}
			catch(Exception e) {
				
			}
			
			totalTime += System.nanoTime() - startTime;
			frameCount++;
			if (frameCount == maxFrameCount) {
				averageFPS = 1000.0 / ((totalTime / frameCount) / 1000000);
				frameCount = 0;
				totalTime = 0;
				
			}
		}
	}


	public Map getM() {
		return m;
	}

	public void setM(Map m) {
		this.m = m;
	}

	private void gameDraw() {
		
		
	}


	private void gameRender() {
		g.setColor(Color.RED);
		//drawing the map
		for (int i = 0; i < 60; i++ )
		{
			for (int j = 0; j < 60; j++ )
			{
				//g.drawImage(m.getTile(i, j).getTerrain().getTexture(), i*32, j*32, null);
				g.drawImage(texture.get(m.getTile(i, j).getType()), i*32, j*32, null);
				//g.drawImage(ownership.get(1), i*32, j*32, null);
				//g.drawImage(entities.get(0), i*32, j*32, null);
			}
		}
		g.drawString("FPS: " + averageFPS, 10, 10);
		//draw all tiles
	}


	private void gameUpdate() {
		Graphics g2 = this.getGraphics();
		g2.drawImage(image, 0, 0, null);
		g2.dispose();
	}
}
