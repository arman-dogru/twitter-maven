package TrendPackage;

import twitter4j.TwitterException;

public class Main {
    public static void main(String[] args) throws TwitterException, IllegalArgumentException {
        int WOEID = 23424969; //Where on Earth ID of the designated location
        String topicName = ""; //The name of the trending topic
        String consumerKey = ""; //Consumer Key goes here
        String consumerSecret = ""; //Secret Consumer Key
        String accessToken = ""; //AccessToken goes here
        String tokenSecret = ""; //Secret Access Token

        TrendEngine twitter = new TrendEngine(consumerKey, consumerSecret, accessToken,tokenSecret);
        TrendData trendData = twitter.searchTrend(topicName,WOEID);

        System.out.println("Topic searched: "+trendData.getTrendName());
        System.out.println("Currently trending: "+trendData.isTrending());
        if (trendData.isTrending())
            System.out.println("Tweet volume of the Trend: "+trendData.getTweetVolume());
    }
}
