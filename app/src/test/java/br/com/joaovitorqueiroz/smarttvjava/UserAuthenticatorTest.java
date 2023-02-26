package br.com.joaovitorqueiroz.smarttvjava;

import junit.framework.TestCase;

import org.junit.Assert;

import java.util.HashMap;

public class UserAuthenticatorTest extends TestCase {

    public void testIsAuth() {
        UserAuthenticator auth = new UserAuthenticator();

        User joaovq = new User("joaovq", "123456");
        HashMap<String, User> userHashMap = new HashMap<>();
        boolean isAuth = auth.isAuth(joaovq, userHashMap);
        Assert.assertFalse(isAuth);
        userHashMap.put(joaovq.getLogin(), joaovq);
        boolean isAuth1 = auth.isAuth(joaovq, userHashMap);
        Assert.assertTrue(isAuth1);
    }
}