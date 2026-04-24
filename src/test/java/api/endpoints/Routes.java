package api.endpoints;

/*
https://petstore.swagger.io/

create user(post) : https://petstore.swagger.io/v2/user/username
get user(get): https://petstore.swagger.io/v2/user/{username}
update user(put):https://petstore.swagger.io/v2/user/{username}
delete user(delete) :https://petstore.swagger.io/v2/user/{username}
 */


public class Routes {

public static String base_url = "https://petstore.swagger.io/v2";

//User module

    public static String post_URL=base_url+"/user";
    public static String get_URL=base_url+"/user/{username}";
    public static String put_URL=base_url+"/user/{username}";
    public static String delete_URL=base_url+"/user/{username}";


}
