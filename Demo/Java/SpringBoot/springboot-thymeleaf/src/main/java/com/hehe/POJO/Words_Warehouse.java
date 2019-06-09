package com.hehe.POJO;

public class Words_Warehouse {
    private String word;
    private String chinese_meaning;
    private String level;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word == null ? null : word.trim();
    }

    public String getChinese_meaning() {
        return chinese_meaning;
    }

    public void setChinese_meaning(String chinese_meaning) {
        this.chinese_meaning = chinese_meaning == null ? null : chinese_meaning.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    @Override
    public String toString() {
        return "Words_Warehouse{" +
                "word='" + word + '\'' +
                ", chinese_meaning='" + chinese_meaning + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}