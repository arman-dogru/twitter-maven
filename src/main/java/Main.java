import twitter4j.TwitterException;

import javax.crypto.SecretKey;

public class Main {
    public static void main(String[] args) throws TwitterException {
        int WOEID = 23424969; //Where on Earth ID of the designated location
        String topicName = ""; //The name of the trending topic
        String ConsumerKey = ""; //Consumer Key goes here
        String ConsumerSecret = ""; //Secret Consumer Key
        String AccessToken = ""; //AccessToken goes here
        String TokenSecret = ""; //Secret Access Token

        ConfigureTwitter twitter = new ConfigureTwitter(ConsumerKey, ConsumerSecret, AccessToken, TokenSecret);
        if (twitter.searchTrend(topicName,WOEID)){
            System.out.println("The subject you are searching for is not on Trending Topics on your area");
        }
        System.out.println("The subject you are searching for is on Trending Topics on your area");
    }
}
