package com.gfa.orientation_exam_example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class UrlAlias {
    @Id
    @GeneratedValue
    private long id;
    private String url;
    private String alias;
    private long hitCount;
    @JsonIgnore
    private String secretCode;
}
