import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

public class ConfigureTwitter {
    ConfigurationBuilder cb;
    Twitter twitter;
    TwitterFactory tf;

    public ConfigureTwitter(String ConsumerKey, String ConsumerSecret,String TokenSecret, String AccessToken){
        cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
                cb.setOAuthConsumerKey(ConsumerKey);
                cb.setOAuthConsumerSecret(ConsumerSecret);
                cb.setOAuthAccessToken(AccessToken);
                cb.setOAuthAccessTokenSecret(TokenSecret);
        tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
    }

    public boolean searchTrend(String trendName, int WOEID) throws TwitterException {
        String[] trendNameS = new String[3];
        trendNameS[0] = trendName.substring(0,1).toLowerCase() + trendName.substring(1,trendName.length());
        trendNameS[1] = trendName.substring(0,1).toUpperCase() + trendName.substring(1,trendName.length());
        trendNameS[2] = "#"+trendName;

        Trends trends = twitter.getPlaceTrends(WOEID);
        Trend[] trendS = trends.getTrends();
        for (Trend trend : trendS) {
            for (String tName : trendNameS) {
                if (trend.toString() == tName) {
                    return true;
                }
            }
        }
        return false;
    }
}