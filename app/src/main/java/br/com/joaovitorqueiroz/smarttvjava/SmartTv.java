package br.com.joaovitorqueiroz.smarttvjava;

import static br.com.joaovitorqueiroz.smarttvjava.TelevisionMode.STREAMING;
import static br.com.joaovitorqueiroz.smarttvjava.TelevisionMode.TV;

import androidx.annotation.NonNull;

import java.util.HashMap;

public class SmartTv extends Television{

    private boolean isConected = false;
    private TelevisionMode mode = TV;

    private HashMap<String, User> users = new HashMap(){{
        put("123456",new User("123456", "987654"));
    }};

    public SmartTv(String room) {
        super(room);
    }

    public boolean isConected() {
        return isConected;
    }

    @Override
    public void setActualChannel(int chooseChannel) {
        if (isOn() && mode == TV) {
            super.setActualChannel(chooseChannel);
        }
    }

    private void setConected() {
        isConected = true;
    }

    public void disconnect(){
        if (mode == TV && isConected) isConected = false;
    }

    public TelevisionMode getMode() {
        return mode;
    }

    public boolean setMode(TelevisionMode mode, User inputUser) {
        boolean isAuth = authentication(inputUser);
        if (isOn() && !isConected && mode == STREAMING && isAuth){
            this.mode = mode;
            setConected();
            return true;
        }
        return false;
    }

    private boolean authentication(User inputUser) {
        UserAuthenticator auth = new UserAuthenticator();

        return auth.isAuth(inputUser, users);
    }

    @Override
    public void power() {
        super.power();
        if (!isOn()){
            isConected = false;
        }
    }

    public HashMap<String, User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        if (!users.containsKey(user.getLogin())) {
            this.users.put(user.getLogin(), user);
        }
    }

    @NonNull
    @Override
    public String toString() {
        return "SmartTv{" +
                "isConected=" + isConected +
                ", mode=" + mode +
                ", users=" + users +
                '}';
    }


    public void updateLogin(User user){
        if (isOn() && mode == STREAMING && isConected) {
            updateUser(user);
        }
    }

    private void updateUser(User user) {
        try{
            users.get("123456").setLogin(user.getLogin());
            users.get("123456").setPassword(user.getPassword());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
