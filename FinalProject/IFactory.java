import java.util.*;

public interface IFactory
{
  public List<IGameObject> createEnemies(int x, int y, int w, int h, int dX, int dY);
  public IGameObject createHero(int x, int y, int w, int h, int dX, int dY);
  public IGameView createMainView(Map<String, List<IGameObject>> objects);
  public IGameView createStatusView(Map<String, List<IGameObject>> objects);
  public IGameController createController(int interval, Map<String, List<IGameObject>> objects, List<IGameView> views);
}
