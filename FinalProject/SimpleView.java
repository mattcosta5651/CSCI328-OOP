import javax.swing.*;
import java.awt.BorderLayout;
import java.util.*;

public class SimpleView extends StatusView
{
  public SimpleView(Map<String, List<IGameObject>> objects)
  {
	super(objects);
  }

  @Override
  public void tick(int time)
  {
	super.tick(time);
  }
}
