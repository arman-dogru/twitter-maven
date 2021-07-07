import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

public class TrendEngine {
    ConfigurationBuilder cb;
    Twitter twitter;
    TwitterFactory tf;

    public TrendEngine(String consumerKey, String consumerSecret,String tokenSecret, String accessToken){
        cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
                cb.setOAuthConsumerKey(consumerKey);
                cb.setOAuthConsumerSecret(consumerSecret);
                cb.setOAuthAccessToken(accessToken);
                cb.setOAuthAccessTokenSecret(tokenSecret);
        tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
    }

    public TrendData searchTrend(String trendName, int WOEID) throws TwitterException {
        String[] trendNames = new String[3];
        trendNames[0] = trendName.toLowerCase();
        trendNames[1] = trendName.substring(0,1).toUpperCase() + trendName.substring(1,trendName.length());
        trendNames[2] = "#"+trendName;

        Trends trends = twitter.getPlaceTrends(WOEID);
        Trend[] trendArray = trends.getTrends();

        for (Trend trend : trendArray) {
            for (String trendAlt : trendNames) {
                if (trend.getName() == trendAlt) {
                    TrendData trendData = new TrendData(trend);
                    return trendData;
                }
            }
        }
        TrendData trendData = new TrendData(trendNames[0]);
        return trendData;
    }
}