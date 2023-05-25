package com.example.KursinisWebService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

public class Comment {

    private Date postingDate;
    private String authorUsername;
    private String title;
    private String content;

    public Comment(Date postingDate, String authorUsername, String title, String content) {
        this.postingDate = postingDate;
        this.authorUsername = authorUsername;
        this.title = title;
        this.content = content;
    }
}
