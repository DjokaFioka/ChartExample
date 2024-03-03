package djokafioka.rs.chartexample;

public class Growth
{
    private int mYear;
    private Float mGrowthRate;

    public Growth()
    {
    }

    public Growth(int year, Float growthRate)
    {
        mYear = year;
        mGrowthRate = growthRate;
    }

    public void setYear(int year)
    {
        mYear = year;
    }

    public int getYear()
    {
        return mYear;
    }

    public void setGrowthRate(Float growthRate)
    {
        mGrowthRate = growthRate;
    }

    public Float getGrowthRate()
    {
        return mGrowthRate;
    }


}
