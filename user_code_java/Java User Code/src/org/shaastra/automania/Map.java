/**
 * 
 */
package org.shaastra.automania;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.shaastra.automania.*;

/**
 * Represents the map.
 * @author devesh
 *
 */
public class Map {
	
	int MAP_SIZE;
	char [][]array;
	
	public Map()
	{
	}
	
	/*
	 * initializes various things.
	 * 
	 * POSSIBLE ERROR AT THIS PLACE
	 */
	public void initialize(String file_name ) throws IOException
	{
		MAP_SIZE = GlobalDataStore.MAX_X;
		FileReader map_file = new FileReader(file_name);
		
		BufferedReader bufRead = new BufferedReader(map_file);
		
		String temp;
		temp = bufRead.readLine();
		
		int i;
		for(i = 0; i < MAP_SIZE; i++)
		{
			array[i] = temp.toCharArray();
			temp = bufRead.readLine();
		}

	}
	
	/**
	 * Sets a position to a symbol.
	 * @param position
	 * @param symbol
	 */
	public void set_symbol(Position pos, char symbol)
	{
	        if( pos.x >= MAP_SIZE || pos.x < 0 ||  pos.y >= MAP_SIZE || pos.y < 0 );
	                //exception. Disqualify the player?
	        array[pos.x][pos.y] = symbol ;
	}
	

	char get_symbol( Position pos )
	{
	        if( pos.x >= MAP_SIZE || pos.x < 0 ||  pos.y >= MAP_SIZE || pos.y < 0 );
	                //exception. Disqualify the player?
	        return array[pos.x][pos.y];
	}

	int moveable_position( Position pos )
	{
	        if( pos.x < 0 || pos.x >= MAP_SIZE || pos.y < 0 || pos.y >= MAP_SIZE )
	                return 0;
	        if( get_symbol( pos ) == GlobalDataStore.EMPTY )
	                return 1;       //NOTE THIS MUST BE CHANGED IF PARALLEL PLAY IS DECIDED.
	        return 0;
	}

}
