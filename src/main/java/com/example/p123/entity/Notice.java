package com.example.p123.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Notice extends TimeEntity{
    @Id
    @Column(name = "notice_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 45)
    private String title;

    @Lob
    @NotNull
    @Column(nullable = false)
    private String content;

    @Builder
    public Notice(String title, String content){
        this.title = title;
        this.content = content;
    }
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
