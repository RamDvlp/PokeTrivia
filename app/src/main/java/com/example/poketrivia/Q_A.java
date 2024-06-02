package com.example.poketrivia;

public class Q_A {

    private String name;
    private String[] answers;
    private int img;

    public Q_A() {}

    public Q_A(String[] answers) {
        this.answers = answers;
    }

    public String getName() {
        return name;
    }

    public Q_A setName(String name) {
        String nm = name.substring(name.indexOf('/')+1);
        if(nm.startsWith("ic")||nm.startsWith("pokeba"))
            this.name = "";
        this.name = nm;
        return this;
    }

    public String[] getAnswers() {
        return answers;
    }

    public Q_A setAnswers(String[] answers) {
        this.answers = answers;
        return this;
    }

    public int getImg() {
        return img;
    }

    public Q_A setImg(int img) {
        this.img = img;
        return this;
    }
}
