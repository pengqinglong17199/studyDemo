package com.pql.design.prototype.shallow;

public class Client {
    private Prototype prototype;

    public Client(Prototype prototype){
        this.prototype = prototype;
    }

    public Prototype startClone(Prototype prototype){
        return prototype.clone();
    }
}
