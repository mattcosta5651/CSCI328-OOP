public class PickerFactory
{
    private static PickerFactory m_instance;
    public static PickerFactory getInstance()
    {
        if (m_instance == null)
            m_instance = new PickerFactory();
        return m_instance;
    }
    private PickerFactory() {}
    
    public IWordPicker makePicker()
    {
		if(Math.random() < 0.5)
			return new LengthPicker();
		else
			return new RatioPicker();
    }
}
