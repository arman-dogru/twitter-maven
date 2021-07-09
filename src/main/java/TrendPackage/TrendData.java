package TrendPackage;

//import lombok.Getter;
//import lombok.Setter;
import twitter4j.Trend;

//@Getter
//@Setter
public class TrendData {
    public int tweetVolume;
    public String trendName;
    public boolean trending;

    public TrendData(String trendName){
        this.trendName = trendName;
        this.trending = false;
        this.tweetVolume = 0; //not Trending
    }

    public TrendData(Trend trend){
        tweetVolume = trend.getTweetVolume();
        trendName = trend.getName();
        this.trending = true;
    }

}
