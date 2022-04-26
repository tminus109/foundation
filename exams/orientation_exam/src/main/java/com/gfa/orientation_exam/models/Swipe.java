package com.gfa.orientation_exam.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Swipe {
    @Id
    @GeneratedValue
    private long id;
    private long currentUserId;
    private long randomUserId;
    private String swipeDirection;
}
