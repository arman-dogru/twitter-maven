package TrendPackage;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.Arrays;
import java.util.List;

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
        List<Trend> trendList = Arrays.stream(trends.getTrends()).toList();

        Trend temp = trendList.stream().filter(trend -> trendName.equalsIgnoreCase(trend.getName())).findFirst().orElse(null);
            if (temp != null){
                TrendData trendData = new TrendData(temp);
                return trendData;
            }

        TrendData trendData = new TrendData(trendName);
        return trendData;
    }
}