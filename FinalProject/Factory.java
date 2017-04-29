import java.util.*;
import java.lang.reflect.*;
import java.io.*;

public class Factory implements IFactory
{
  private Map<String, List<Class>> classes;
	
  private static IFactory m_instance;
  public static IFactory getInstance()
  {
    if (m_instance == null)
      m_instance = new Factory();
    return m_instance;
  }
  private Factory() {
	BufferedReader reader = null;  
	try{
		reader = new BufferedReader(new FileReader("data.txt"));
		classes = new HashMap<String, List<Class>>();
	
		while(reader.ready()){
			String input = reader.readLine();
			String[] line = input.split(":");
			String[] list;

			//multiples
			if(line[1].contains(","))
				list = line[1].split(",");
			else{
				list = new String[1];
				list[0] = line[1].trim();
			}
			classes.put(line[0], new ArrayList<Class>());
			
			for(String s : list){
				try{
					Class c = Class.forName(s.trim());
					classes.get(line[0]).add(c);
				}
				catch(Exception e){
					throw new Error("Class does not exist");
				}
			}
		}	
	}
	catch(IOException e){
		throw new Error("File not found");
	}
  }

  @Override
  public List<IGameObject> createEnemies(int maxx, int maxy, int w, int h, int dX, int dY)
  {
	java.util.Random rand = new java.util.Random();
	List<IGameObject> objs = new ArrayList<IGameObject>();
    
    IGameObject obj = null;
    for(Class c : classes.get("Enemies")){
		//5 of each
		for(int i = 0; i < 5; i++){
			try{
				Constructor cs = c.getConstructor(int.class, int.class, int.class, int.class, int.class, int.class);
				objs.add((IGameObject) cs.newInstance(rand.nextInt(maxx), rand.nextInt(maxy), w, h, dX, dY));
			}
			catch(Exception e){
				e.printStackTrace();
			}	
		}	
	}
	
	return objs;
  }

  @Override
  public IGameObject createHero(int maxx, int maxy, int w, int h, int dX, int dY)
  {
	java.util.Random rand = new java.util.Random();
		  
	//1 hero, at index 0
	Class hero = classes.get("Hero").get(0);
	IGameObject obj = null;
	try{
		Constructor cs = hero.getConstructor(int.class, int.class, int.class, int.class, int.class, int.class);
		obj = (IGameObject) cs.newInstance(rand.nextInt(maxx), rand.nextInt(maxy), w, h, dX, dY);
	}
	catch(Exception e){
		e.printStackTrace();
	}
    return obj;
  }


  @Override
  public IGameView createMainView(Map<String, List<IGameObject>> objects)
  {
    return new GameView(objects);
  }

  @Override
  public IGameView createStatusView(Map<String, List<IGameObject>> objects){
    //1 view, at index 0
	 Class view = classes.get("Status").get(0);
	 IGameView obj = null;
	 try{
	 	Constructor cs = view.getConstructor(Map.class);
	 	obj = (IGameView) cs.newInstance(objects);
	 }
	 catch(Exception e){
	 	e.printStackTrace();
	 }
     return obj;
  }

  @Override
  public IGameController createController(int interval, Map<String, List<IGameObject>> objects, List<IGameView> views)
  {
    return new GameController(interval, objects, views);
  }
}
