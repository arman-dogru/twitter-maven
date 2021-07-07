import twitter4j.Trend;

public class TrendData {
    public int tweetVolume;
    public String trendName;
    public boolean trending;
    public Trend trend;

    public TrendData(String trendName){
        this.trend = null;
        this.trendName = trendName;
        this.trending = false;
        this.tweetVolume = 0;
    }

    public TrendData(Trend trend){
        tweetVolume = trend.getTweetVolume();
        trendName = trend.getName();
        this.trending = true;
        this.trend = trend;
    }
}
