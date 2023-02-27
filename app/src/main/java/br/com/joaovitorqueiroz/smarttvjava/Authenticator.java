package br.com.joaovitorqueiroz.smarttvjava;

import java.util.Map;

public interface Authenticator<K,T> {

     boolean isAuth(T input, Map<K, T> base);

}
