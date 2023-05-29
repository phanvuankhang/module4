package com.example.validate_song_information.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.lang.annotation.Annotation;

public class SongDto implements Validator {
    private Integer id;
    @NotBlank(message = "Cannot allow to blank.")
    @Size(max = 800,message = "No more than 800 characters.")
    @Pattern(regexp = "^[A-Za-z0-9 ]{1,800}$",message = "Does not contain special characters like @ ; , . = - + , ….")
    private String name;
    @NotBlank(message = "Cannot allow to blank.")
    @Size(max = 300,message = "No more than 300 characters.")
    @Pattern(regexp = "^[A-Za-z0-9 ]{1,300}$",message = "Does not contain special characters like @ ; , . = - + , ….")
    private String singer;
    @NotBlank(message = "Cannot allow to blank.")
    @Size(max = 300,message = "No more than 1000 characters.")
    @Pattern(regexp = "^[A-Za-z0-9, ]{1,1000}$",message = "Except for the comma \",\" , the remaining special characters are not allowed to be saved to the DB.")
    private String songType;

    public SongDto() {
    }


    public SongDto(Integer id, String name, String singer, String songType) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.songType = songType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getSongType() {
        return songType;
    }

    public void setSongType(String songType) {
        this.songType = songType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
