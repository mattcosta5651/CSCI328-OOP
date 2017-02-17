public class AngleHeadFactory implements IBodyPartFactory{
    
    private static AngleHeadFactory m_instance;
    
    private AngleHeadFactory(){}
    
    public static AngleHeadFactory getInstance(){
        return (m_instance == null) ? new AngleHeadFactory() : m_instance;
    }
    
    @Override
    public IBodyPart createEyes(){
        return new SmallEyes();
    }
    
    @Override
    public IBodyPart createNose(){
        return new SimpleNose();
    }
    
    @Override
    public IBodyPart createMouth(){
        return new Sad();
    }
    
    @Override
    public IBodyPart createHead(){
        return new AngleHead();
    }
}