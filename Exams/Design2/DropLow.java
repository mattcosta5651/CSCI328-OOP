import java.util.*;

public class DropLow implements IFilter{
	@Override
	public int[] filter(int[] g){
		int[] copy = new int[g.length-1];
		Arrays.sort(g);
		for (int i = 1; i < g.length; i++)
			copy[i-1] = g[i];
		return copy;
	}
}
