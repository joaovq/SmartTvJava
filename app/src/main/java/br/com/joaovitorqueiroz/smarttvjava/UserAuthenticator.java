package br.com.joaovitorqueiroz.smarttvjava;

import java.util.Map;

public class UserAuthenticator implements Authenticator<String, User> {
    @Override
    public boolean isAuth(User input, Map<String, User> base) {
       if (base.containsKey(input.getLogin())){
           User user = base.get(input.getLogin());
           if (user == null) return false;
           return input.getPassword().equals(user.getPassword());
       }
       return false;
    }

}
