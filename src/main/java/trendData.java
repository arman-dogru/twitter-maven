import twitter4j.Trend;

public class trendData {
    public int tweetVolume;
    public String trendName;
    public boolean trending;
    public Trend trend;

    public trendData(Trend trend){
        tweetVolume = trend.getTweetVolume();
        trendName = trend.getName();
        trending = false;
    }
}
