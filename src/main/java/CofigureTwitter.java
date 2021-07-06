import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
public class ConfigureTwitter {
    ConfigurationBuilder cb = new ConfigurationBuilder();
    String ConsumerKey;
    String AccessToken;
    public void config(String ConsumerKey, String AccessToken){
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey()
                .setOAuthConsumerSecret("******************************************")
                .setOAuthAccessToken("**************************************************")
                .setOAuthAccessTokenSecret("******************************************");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
    }
}