import java.util.*;
public class Median implements IGrader
{
    protected int[] m_grades;
    
    public Median(int[] grades)
    {
        m_grades = grades;
    }
    
    @Override
    public double grade()
    {
        return median();
    }
    
    protected double median()
    {
        Arrays.sort(m_grades);
        double median = 0;
        int l = m_grades.length;
        if (l % 2 == 0)
        {
            median = (m_grades[l/2 - 1] + m_grades[l/2])/2.0;
        }
        else
        {
            median = m_grades[l/2];    
        }
        return median;
    }
}