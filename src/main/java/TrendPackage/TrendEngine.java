package TrendPackage;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

public class TrendEngine {
    ConfigurationBuilder cb;
    Twitter twitter;
    TwitterFactory tf;

    public TrendEngine(String consumerKey, String consumerSecret,String accessToken, String tokenSecret){
        cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
                cb.setOAuthConsumerKey(consumerKey);
                cb.setOAuthConsumerSecret(consumerSecret);
                cb.setOAuthAccessToken(accessToken);
                cb.setOAuthAccessTokenSecret(tokenSecret);
        tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
    }

    public TrendData searchTrend(String trendName, int WOEID) throws TwitterException, IllegalArgumentException {
        if(trendName.equals(""))
            throw new IllegalArgumentException("Please enter an argument to search in Top Trendings");

        Trends trends = twitter.getPlaceTrends(WOEID);
        Trend[] trendArray = trends.getTrends();

        for (Trend trend : trendArray) {
            if (trend.getName().equalsIgnoreCase(trendName)) {
                TrendData trendData = new TrendData(trend);
                return trendData;
            }
        }
        TrendData trendData = new TrendData(trendName);
        return trendData;
    }
}