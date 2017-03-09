import java.util.*;

public class DropHigh implements IFilter{
	@Override
	public int[] filter(int[] g){
		int[] copy = new int[g.length-1];
		Arrays.sort(g);
        for (int i = 0; i < g.length-1; i++)
            copy[i] = g[i];			
		return copy;
	}
}
