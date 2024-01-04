package com.vti.entity;

import com.vti.entity.CategoryQuestion;

import java.util.Date;

public class Question {
    long QuestionId;
    String content;
    CategoryQuestion catId;
    TypeQuestion typeId;
    long creatorId;
    Date CreateDate;
}
