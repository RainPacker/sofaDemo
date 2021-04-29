package com.springboot.threadLocal;

public class AuthTokenHolder {

    /**
     * token holder
     * TODO: need to fix, it's not work now
     */
    public static final AutoCleanThreadLocal<String> TOKEN = new AutoCleanThreadLocal<>();

    public static String getToken() {
        return TOKEN.get();
    }

    public static void setToken(String token) {
        TOKEN.set(token);
    }

    public static void remove() {
        TOKEN.remove();
    }

}