package com.example.KursinisWebService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

public class ForumPost extends Comment {

    public ForumPost(Date postingDate, String authorUsername, String title, String content) {
        super(postingDate, authorUsername, title, content);
    }
}
