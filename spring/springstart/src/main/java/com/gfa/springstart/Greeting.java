package com.gfa.springstart;

public class Greeting {
    long greetingCount;
    String content;

    public Greeting(long greetingCount, String content) {
        this.greetingCount = greetingCount;
        this.content = content;
    }

    public long getGreetingCount() {
        return greetingCount;
    }

    public String getContent() {
        return content;
    }
}
