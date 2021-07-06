import twitter4j.TwitterException;

public class Main {
    public static void main(String[] args) throws TwitterException {
        int WOEID = 23424969; //Where on Earth ID of the designated location
        String topicName = "getir"; //The name of the trending topic
        String ConsumerKey = ""; //Consumer Key goes here
        String AccessToken = ""; //AccessToken goes here

        ConfigureTwitter twitter = new ConfigureTwitter(ConsumerKey,AccessToken);
        if (twitter.searchTrend(topicName,WOEID)){
            System.out.println("The subject you are searching for is not on Trending Topics on your area");
        }
        System.out.println("The subject you are searching for is on Trending Topics on your area");
    }
}
