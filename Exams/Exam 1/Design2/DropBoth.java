import java.util.*;

public class DropBoth implements IFilter{
	@Override
	public int[] filter(int[] g){
        int[] copy = new int[g.length-2];
        Arrays.sort(g);
        for (int i = 1; i < g.length-1; i++)
            copy[i-1] = g[i];
        return copy;		
	}
}
