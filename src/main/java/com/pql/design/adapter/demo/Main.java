package com.pql.design.adapter.demo;

public class Main {
    public static void main(String[] args) {
        DC5 dc5 = new PowerAdapter(new AC220());
        int i = dc5.outputDC5V();
    }
}
