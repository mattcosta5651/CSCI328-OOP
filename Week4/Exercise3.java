import java.util.*;

public class Exercise3{
	public static void main(String[] args){
		Exercise3 e3 = new Exercise3();
		e3.go();
	}
	
	private void go(){
		List<IEstimatable> houses = new ArrayList<IEstimatable>(){{
			add(new House(1400));
			add(new House(1800));
			add(new House(1000));
			add(new SolidConstructionHouse(1400));
			add(new SolidConstructionHouse(1800));
			add(new SolidConstructionHouse(1000));
			}};
		
		for(IEstimatable house : houses){
			try{System.out.printf("This house estimates to $%.2f%n", house.estimate());}
			catch(Exception e){throw new Error("Error!");}
		}
	}
	
	public interface IEstimatable{
		public double estimate();
	}
	
	public class House implements IEstimatable{
		private double h_sqft;
		
		public House(double sqft){
			h_sqft = sqft;
		}
		@Override
		public double estimate(){
			return h_sqft*97;
		}
	}
	
	public class SolidConstructionHouse extends House{
		public SolidConstructionHouse(double sqft){
			super(sqft);
		}
		@Override
		public double estimate(){
			return (super.estimate()+(super.estimate()*0.25));
		}
	}
}
