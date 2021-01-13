package service;

import model.User;

public class UserCreator {

    public static final String USER_NAME="test.data.user.username";
    public static final String USER_LAST_NAME="test.data.user.userlastname";
    public static final String USER_PATRONYMIC="test.data.user.userpatronymic";
    public static final String USER_PASSWORD="test.data.user.userpassword";
    public static final String USER_EMAIL="test.data.user.useremail";

    public static User withAllProperty(){
        return new User(TestDataReader.getTestData(USER_NAME),
                TestDataReader.getTestData(USER_LAST_NAME),
                TestDataReader.getTestData(USER_PATRONYMIC),
                TestDataReader.getTestData(USER_PASSWORD),
                TestDataReader.getTestData(USER_EMAIL));
    }
    
}
