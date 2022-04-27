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
		
		clear();
		Nematode n = nematodes.get(option);
		String Name = n.getName();
		int ListSize = nematodes.size();
		
		textAlign(CENTER);
		textSize(60);
		fill(255, 0, 255);
		text(Name, 400, 50);

		for (int i = 0; i < n.getLength(); i++){
				int x = width / 2;
				int y, x1, x2;
				int colour = option * 20;
				x1 = x - 50;
				x2 = x + 50;
				if( i == 0){
					y = 100;
				} else {
					y = (i * 50) + 100;
				}
				if(i == n.getLength()-1){
					if(new String(n.getGender()).equals("m")){
						if(n.getLimbs() == 1){
							stroke(colour, 255, 255);
							line(x1, y, x2, y);
							fill(0, 0, 0);
							circle(x, y, 50);
						}else{
							stroke(colour, 255, 255);
							noFill();
							circle(x, y, 50);
							line(x, y+25, x, y+50);
							circle(x, y+50, 10);
						}
					}
					if(new String(n.getGender()).equals("f")){
						if(n.getLimbs() == 1){
							stroke(colour, 255, 255);
							line(x1, y, x2, y);
							fill(0, 0, 0);
							circle(x, y, 50);
						}else{
							stroke(colour, 255, 255);
							noFill();
							circle(x, y, 50);
							circle(x, y, 30);
						}
					}
					if(new String(n.getGender()).equals("h")){
						if(n.getLimbs() == 1){
							stroke(colour, 255, 255);
							line(x1, y, x2, y);
							fill(0, 0, 0);
							circle(x, y, 50);
						}else{
							stroke(colour, 255, 255);
							noFill();
							circle(x, y, 50);
							circle(x, y, 30);
							line(x, y+25, x, y+50);
							circle(x, y+50, 10);
						}
					}
					if(new String(n.getGender()).equals("n")){
						if(n.getLimbs() == 1){
							stroke(colour, 255, 255);
							line(x1, y, x2, y);
							fill(0, 0, 0);
							circle(x, y, 50);
						}else{
							stroke(colour, 255, 255);
							noFill();
							circle(x, y, 50);
						}
					}
				}else{
					if(n.getLimbs() == 1){
						stroke(colour, 255, 255);
						line(x1, y, x2, y);
						fill(0, 0, 0);
						circle(x, y, 50);
					}else{
						stroke(colour, 255, 255);
						noFill();
						circle(x, y, 50);
					}
				}
			}
		
	}
}
