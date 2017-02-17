public class Builder3 implements IBuilder{
	
	private static Builder3 m_instance; 
	
	private Builder3(){}
	
	public static Builder3 getInstance(){
		return (m_instance == null) ? new Builder3() : m_instance;
	} 
	
	@Override
	public MrPotatoHead makePotatoHead(){
	   return new MrPotatoHead(22, 12, new AngleHead(),
                new SmallEyes(), new SimpleNose(), new Sad());
	}
}