package com.example.validate_song_information.controller;

import com.example.validate_song_information.dto.SongDto;
import com.example.validate_song_information.model.Song;
import com.example.validate_song_information.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("/")
    public String showList(Model model) {
        List<Song> songList = songService.findAll();
        model.addAttribute("songList", songList);
        return "list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "create";
    }

    @PostMapping("/create")
    public String save(@Validated @ModelAttribute("songDto") SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.save(song);
        redirectAttributes.addFlashAttribute("mess","Create is Successfully!");
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id")Integer id, Model model){
    SongDto songDto=new SongDto();
    Song song=songService.findById(id);
    BeanUtils.copyProperties(song,songDto);
    model.addAttribute("songDto",songDto);
    return "edit";
    }
    @PostMapping("/edit")
    private String edit(@Validated @ModelAttribute("songDto")SongDto songDto,BindingResult bindingResult,RedirectAttributes redirectAttributes){
        new SongDto().validate(songDto,bindingResult);
        if(bindingResult.hasErrors()){
            return "edit";
        }
        Song song=new Song();
        BeanUtils.copyProperties(songDto,song);
        songService.save(song);
        redirectAttributes.addFlashAttribute("mess","Edit is successfully.");
        return "redirect:/";
    }
}
