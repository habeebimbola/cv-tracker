package cvtrackertask.info.guesword.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


@JsonDeserialize
public  class Word {

    @JsonProperty("content")
    private String content;

    @JsonProperty("length")
    private Integer length;

    public Word(Word word) {
        word = this;
    }

    public Word() {

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
