package com.crud.tasks.domain;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public class Task {
    private String id;
    private String title;
    private String content;
}
