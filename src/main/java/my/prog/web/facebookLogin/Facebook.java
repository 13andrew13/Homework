package my.prog.web.facebookLogin;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.json.JsonObject;
import my.prog.model.User;


import java.security.Permission;

public class Facebook {
    // get these from your FB Dev App
    private static final String api_key = "1537497846368240";
    private static final String secret = "19c3043c61b982c6e5c5f2c7455a7982";
    private static final String MY_ACCESS_TOKEN ="EAACEdEose0cBAN5hTscgXfVV0HJ8uLiy5Lhe493zyVuknT9YIu9HHxmFXnGBPghJkZAVoILNm7vRNGawzNLWAZCqnheA8I7qTyU8FKJLp7bUkUmkifDvaBcZBOwo6ceUosHkRjFchm2XcJwhN7omb3y6ixZAnpOvC4ya47AsqSfq1JVkEJPkicypZAHSLg2sZD";

    // set this to your servlet URL for the authentication servlet/filter
    private static final String redirect_uri = "localhost:8080/servlet/login";
    public User fetchObject(){
        FacebookClient client = new DefaultFacebookClient ();
        //FacebookClient.AccessToken accessToken = client.obtainAppAccessToken (api_key,secret);
        client = new DefaultFacebookClient (MY_ACCESS_TOKEN);
        User user = client.fetchObject ("me",User.class, Parameter.with ("fields","id,name,email"));
        return user;
    }




}
