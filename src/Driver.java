import java.net.URL;
import org.json.simple.JSONValue;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.Scanner;

public class Driver 
{

	public static void main(String[] args)
	{ 
		HearthstoneCard c1 = new HearthstoneCard("Mana Wyrm", 2, 1, 3);
		HearthstoneCard c2 = new HearthstoneCard("Sylvanias Windrunner", 6, 5, 5);
		HearthstoneCard c3 = new HearthstoneCard("Savannah Highmane", 6, 6, 5);
		c1.display();
		c2.display();
		c3.display();
		
		URLReader hearthstoneURLReader = new URLReader("https://api.hearthstonejson.com/v1/25770/enUS/cards.json");
		Object obj = JSONValue.parse(hearthstoneURLReader.getTheURLContents());
		HearthstoneCard[] theMinions = new HearthstoneCard[1924];
	    if(obj instanceof JSONArray)
	    {
	    	JSONArray array = (JSONArray)obj;
	    	int count = 0;
	    	
		    for(int i = 0; i < array.size(); i++)
		    {
		    	JSONObject cardData = (JSONObject)array.get(i);
		    	if(cardData.containsKey("cost") && cardData.containsKey("name"))
		    	{
		    		if(cardData.containsKey("type") && cardData.get("type").equals("MINION"))
		    		{
		    			System.out.println(cardData.get("name"));
			    		System.out.println(cardData.get("cost"));
			    		System.out.println(cardData.get("attack"));
			    		System.out.println(cardData.get("health"));
			    		count++;
		    		}
		    		
		    	}
		    	
		    }
		    System.out.println(count);
	    }
	}
}