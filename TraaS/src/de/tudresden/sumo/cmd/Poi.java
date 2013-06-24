/*   
    Copyright (C) 2013 Mario Krumnow, Evamarie Wießner, Dresden University of Technology

    This file is part of TraaS.

    TraaS is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License.

    TraaS is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with TraaS.  If not, see <http://www.gnu.org/licenses/>.
*/

package de.tudresden.sumo.cmd;
import de.tudresden.sumo.config.Constants;
import de.tudresden.sumo.util.SumoCommand;
import de.tudresden.ws.container.SumoColor;
import de.tudresden.ws.container.SumoPosition2D;

public class Poi {

	//getter methods

	/**
	 * Add a new poi.
	 */

	public static SumoCommand add(String poiID, double x, double y, SumoColor color, String poiType, int layer){
		Object[] array = new Object[]{poiType, color, layer, new SumoPosition2D(x, y)};
		return new SumoCommand(Constants.CMD_SET_POI_VARIABLE, Constants.ADD, poiID, array);
	}

	/**
	 * Returns the color of this poi.
	 */

	public static SumoCommand getColor(String poiID){
		return new SumoCommand(Constants.CMD_GET_POI_VARIABLE, Constants.VAR_COLOR, poiID, Constants.RESPONSE_GET_POI_VARIABLE, Constants.TYPE_COLOR);
	}

	/**
	 * Returns a list of IDs of all poi.
	 */

	public static SumoCommand getIDList(){
		return new SumoCommand(Constants.CMD_GET_POI_VARIABLE, Constants.ID_LIST, "", Constants.RESPONSE_GET_POI_VARIABLE, Constants.TYPE_STRINGLIST);
	}

	/**
	 * Returns the position of this poi.
	 */

	public static SumoCommand getPosition(String poiID){
		return new SumoCommand(Constants.CMD_GET_POI_VARIABLE, Constants.VAR_POSITION, poiID, Constants.RESPONSE_GET_POI_VARIABLE, Constants.POSITION_2D);
	}

	/**
	 * Returns the type of the poi.
	 */

	public static SumoCommand getType(String poiID){
		return new SumoCommand(Constants.CMD_GET_POI_VARIABLE, Constants.VAR_TYPE, poiID, Constants.RESPONSE_GET_POI_VARIABLE, Constants.TYPE_STRING);
	}

	//setter methods

	/**
	 * Remove a poi.
	 */

	public static SumoCommand remove(String poiID, int layer){

		return new SumoCommand(Constants.CMD_SET_POI_VARIABLE, Constants.REMOVE, poiID, layer);
	}

	/**
	 * Set the color of this poi.
	 */

	public static SumoCommand setColor(String poiID, SumoColor color){

		return new SumoCommand(Constants.CMD_SET_POI_VARIABLE, Constants.VAR_COLOR, poiID, color);
	}

	/**
	 * Set the position of this poi.
	 */

	public static SumoCommand setPosition(String poiID, double x, double y){

		Object[] array = new Object[]{x, y};
		return new SumoCommand(Constants.CMD_SET_POI_VARIABLE, Constants.CMD_SET_POI_VARIABLE, poiID, array);
	}

	/**
	 * Set the type of the poi.
	 */

	public static SumoCommand setType(String poiID, String poiType){

		return new SumoCommand(Constants.CMD_SET_POI_VARIABLE, Constants.CMD_SET_POI_VARIABLE, poiID, poiType);
	}


}