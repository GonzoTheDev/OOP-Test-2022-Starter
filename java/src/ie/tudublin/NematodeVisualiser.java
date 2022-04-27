package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{

	// Create an Array list for nematodes
	ArrayList<Nematode> nematodes = new ArrayList<Nematode>();

	//Initialize variables
	int option = 0;

	public void keyPressed()
	{		
		if (keyCode == LEFT)
		{
			if(option == 0)
				{
					option = nematodes.size() - 1;
				}
			option--;
		}		
		if (keyCode == RIGHT)
		{
			if(option == nematodes.size() - 1)
			{
				option = 0;
			}
			
			option++;
		}	
	}


	public void settings()
	{
		size(800, 800);
	}

	public void setup() 
	{
		colorMode(HSB);
		background(0);
		smooth();			
		loadNematodes();
	}
	

	public void loadNematodes()
	{

		// Create a table instance and populate it with nematodes data
		Table table = loadTable("nematodes.csv", "header");
		for(TableRow r:table.rows())
		{
			Nematode n = new Nematode(r);
			nematodes.add(n);
		}

	}


	public void draw()
	{
		Nematode n = nematodes.get(option);
		for (int i = 0; i < n.getLength(); i++){
				int x = width / 2;
				int y;
				if( i == 0){
					y = 100;
				} else {
					y = i * 50;
				}
				stroke(255, 255, 255);
				noFill();
				circle(x, y, 50);
			}
		
	}
}
