package com.kata.tdd.nameinverter;

class NameInverter {
    public String invert(String name) {
        if(name==null){
            throw new NullPointerException();
        }
        return name.trim();
    }
}