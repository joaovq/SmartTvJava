package br.com.joaovitorqueiroz.smarttvjava;

import java.util.Collection;
import java.util.Map;

public abstract class Authenticator<K,T> {

    public abstract boolean isAuth(T input, Map<K, T> base);

}
