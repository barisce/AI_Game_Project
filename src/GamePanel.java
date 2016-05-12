import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import Models.*;

public class GamePanel extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	//Variables
	public static int WIDTH = 1920;
	public static int HEIGHT = 1920;
	
	private Thread thread;
	private boolean running;
	
	private BufferedImage image;
	private Graphics2D g;
	private Map m;
	private InfluenceMap fogMap;
	private InfluenceMap special;
	


	private InfluenceMap found;
	
	private Tile selectedTile = new Tile();
	
	private int FPS = 60;
	private double averageFPS;
	
	
	private ArrayList<Image> texture;
	private ArrayList<Image> ownership;
	private ArrayList<Image> entities;
	private Image fog;
	
	//Constructor
	public GamePanel() throws IOException {
		super();
		found = new InfluenceMap(1);
		fogMap = new InfluenceMap(1);
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
		
		
	}
	
	public GamePanel(Map ma) throws IOException {
		//super();
		found = new InfluenceMap(1);
		fogMap = new InfluenceMap(1);
		special = new InfluenceMap(1);
		special.setType("none");
		texture = new ArrayList<Image>();
		ownership = new ArrayList<Image>();
		entities = new ArrayList<Image>();
		fog = ImageIO.read(new File(System.getProperty("user.dir") + "/assets/fog.png"));
		texture.add(ImageIO.read(new File(System.getProperty("user.dir") + "/assets/black.png")));//texture 0
		texture.add(ImageIO.read(new File(System.getProperty("user.dir") + "/assets/grass.png")));//texture 1
		texture.add(ImageIO.read(new File(System.getProperty("user.dir") + "/assets/snow.png")));//texture 2
		texture.add(ImageIO.read(new File(System.getProperty("user.dir") + "/assets/forest.png")));//texture 3
		texture.add(ImageIO.read(new File(System.getProperty("user.dir") + "/assets/forest_depleted.png")));//texture 4
		texture.add(ImageIO.read(new File(System.getProperty("user.dir") + "/assets/mine_small.png")));//texture 5
		texture.add(ImageIO.read(new File(System.getProperty("user.dir") + "/assets/mine_big.png")));//texture 6
		ownership.add(ImageIO.read(new File(System.getProperty("user.dir") + "/assets/empty.png")));
		ownership.add(ImageIO.read(new File(System.getProperty("user.dir") + "/assets/Player1.png")));
		ownership.add(ImageIO.read(new File(System.getProperty("user.dir") + "/assets/Player2.png")));
		entities.add(ImageIO.read(new File(System.getProperty("user.dir") + "/assets/empty.png")));//entity 0
		entities.add(ImageIO.read(new File(System.getProperty("user.dir") + "/assets/town.png")));//entity 1
		entities.add(ImageIO.read(new File(System.getProperty("user.dir") + "/assets/tower.png")));//entity 2
		entities.add(ImageIO.read(new File(System.getProperty("user.dir") + "/assets/mine1.png")));//entity 3
		entities.add(ImageIO.read(new File(System.getProperty("user.dir") + "/assets/mine2.png")));//entity 4
		entities.add(ImageIO.read(new File(System.getProperty("user.dir") + "/assets/barracks.png")));//entity 5
		entities.add(ImageIO.read(new File(System.getProperty("user.dir") + "/assets/tile_improvement.png")));//entity 6
		entities.add(ImageIO.read(new File(System.getProperty("user.dir") + "/assets/warrior.png")));//entity 7
		entities.add(ImageIO.read(new File(System.getProperty("user.dir") + "/assets/archer.png")));//entity 8
		entities.add(ImageIO.read(new File(System.getProperty("user.dir") + "/assets/cavalry.png")));//entity 9
		entities.add(ImageIO.read(new File(System.getProperty("user.dir") + "/assets/siege.png")));//entity 10
		entities.add(ImageIO.read(new File(System.getProperty("user.dir") + "/assets/worker.png")));//entity 11
		
		
		
		//System.out.println("other constructor");
		setPreferredSize(new Dimension (WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
		this.m = ma;
		//prints the whole map as type map
//		for(int i = 0;i<60;i++){
//			for(int j = 0;j<60;j++){
//				System.out.print(""+m.getTile(i, j).getType()+" ");
//			}
//			System.out.print("\n");
//		}
		
		
		
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
		if(special.getType().equalsIgnoreCase("battle")||special.getType().equalsIgnoreCase("Defensive")){
			for (int i = 0; i < 60; i++ )
			{
				for (int j = 0; j < 60; j++ )
				{
					if(found.getIndex(i, j)==1){
						if(special.getIndex(i, j)>0){
							g.setColor(new Color(0,0,special.getIndex(i, j)/12));
						}else if(special.getIndex(i, j)<0){
							g.setColor(new Color(-special.getIndex(i, j)/12,0,0));
						}else{
							g.setColor(Color.BLACK);
						}
						g.fillRect(i*32, j*32, 32, 32);
						//g.drawImage(texture.get(m.getTile(i, j).getType()), i*32, j*32, null);
						if(m.getTile(i, j).getEntity()<7){
							g.drawImage(ownership.get(m.getTile(i, j).getOwner()), i*32, j*32, null);
							g.drawImage(entities.get(m.getTile(i, j).getEntity()), i*32, j*32, null);
						}else if(fogMap.getIndex(i, j)==1){
							g.drawImage(ownership.get(m.getTile(i, j).getOwner()), i*32, j*32, null);
							g.drawImage(entities.get(m.getTile(i, j).getEntity()), i*32, j*32, null);
						}
						if(fogMap.getIndex(i, j)==0){
							g.drawImage(fog, i*32, j*32, null);
						}
						
					}else{
						g.drawImage(texture.get(0), i*32, j*32, null);
						g.drawImage(ownership.get(0), i*32, j*32, null);
						g.drawImage(entities.get(0), i*32, j*32, null);
					}
					
				}
			}
		}else if(special.getType().equalsIgnoreCase("Buildable")||special.getType().equalsIgnoreCase("AvailableToMoveMap")){
			for (int i = 0; i < 60; i++ )
			{
				for (int j = 0; j < 60; j++ )
				{
					if(found.getIndex(i, j)==1){
						if(special.getIndex(i, j)>0){
							g.setColor(Color.GREEN);
						}else if(special.getIndex(i, j)<0){
							g.setColor(Color.RED);
						}else{
							g.setColor(Color.BLACK);
						}
						g.fillRect(i*32, j*32, 32, 32);
						//g.drawImage(texture.get(m.getTile(i, j).getType()), i*32, j*32, null);
						if(m.getTile(i, j).getEntity()<7){
							g.drawImage(ownership.get(m.getTile(i, j).getOwner()), i*32, j*32, null);
							g.drawImage(entities.get(m.getTile(i, j).getEntity()), i*32, j*32, null);
						}else if(fogMap.getIndex(i, j)==1){
							g.drawImage(ownership.get(m.getTile(i, j).getOwner()), i*32, j*32, null);
							g.drawImage(entities.get(m.getTile(i, j).getEntity()), i*32, j*32, null);
						}
						if(fogMap.getIndex(i, j)==0){
							g.drawImage(fog, i*32, j*32, null);
						}
						
					}else{
						g.drawImage(texture.get(0), i*32, j*32, null);
						g.drawImage(ownership.get(0), i*32, j*32, null);
						g.drawImage(entities.get(0), i*32, j*32, null);
					}
					
				}
			}
		}else{
			for (int i = 0; i < 60; i++ )
			{
				for (int j = 0; j < 60; j++ )
				{
					if(found.getIndex(i, j)==1){
						g.drawImage(texture.get(m.getTile(i, j).getType()), i*32, j*32, null);
						if(m.getTile(i, j).getEntity()<7){
							g.drawImage(ownership.get(m.getTile(i, j).getOwner()), i*32, j*32, null);
							g.drawImage(entities.get(m.getTile(i, j).getEntity()), i*32, j*32, null);
						}else if(fogMap.getIndex(i, j)==1){
							g.drawImage(ownership.get(m.getTile(i, j).getOwner()), i*32, j*32, null);
							g.drawImage(entities.get(m.getTile(i, j).getEntity()), i*32, j*32, null);
						}
						if(fogMap.getIndex(i, j)==0){
							g.drawImage(fog, i*32, j*32, null);
						}
						
					}else{
						g.drawImage(texture.get(0), i*32, j*32, null);
						g.drawImage(ownership.get(0), i*32, j*32, null);
						g.drawImage(entities.get(0), i*32, j*32, null);
					}
					
				}
			}
		}
		
		g.drawString("FPS: " + averageFPS, 10, 10);
		//draw all tiles
		
		
	}


	public InfluenceMap getFogMap() {
		return fogMap;
	}

	public void setFogMap(InfluenceMap fogMap) {
		this.fogMap = fogMap;
	}

	private void gameUpdate() {
		Graphics g2 = this.getGraphics();
		g2.drawImage(image, 0, 0, null);
		g2.dispose();
	}
	public InfluenceMap getFound() {
		return found;
	}

	public void setFound(InfluenceMap found) {
		this.found = found;
	}

	public InfluenceMap getSpecial() {
		return special;
	}

	public void setSpecial(InfluenceMap special) {
		this.special = special;
	}
	
}