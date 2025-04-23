package com.fidelity.rps;

public class Game {

    String clientGesture;
    String serverGesture;
    String result;
    java.util.Date date;

    public Game(String clientGesture, String serverGesture, String result) {
        this.clientGesture = clientGesture;
        this.serverGesture = serverGesture;
        this.result = result;
        date = new java.util.Date();
    }
}
