package be.com.musicas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import be.com.musicas.dto.MusicDto;
import be.com.musicas.service.MusicService;

@Controller
public class MusicController {
    
    @Autowired MusicService service;

    @GetMapping("/")
    public String index(Model model) {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String listMusic(Model model) {
        model.addAttribute("musiList", service.listMusics());
        return "index";
    }
    
    @GetMapping("/addmusic")
    public String addMusic(MusicDto music, Model model) {
        model.addAttribute("music", music);
        return "add-music";
    }
    
    @PostMapping("/savemusic")
    public String saveMusic(@Valid MusicDto music, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("music", music);
            return "redirect:/add-music";
        }
        
        service.saveMusic(music);
        model.addAttribute("musiList", service.listMusics());
        return "redirect:/index";
    }
    
    @GetMapping("/edit/{id}")
    public String editMusic(@PathVariable("id") long idMusic, Model model) throws NotFoundException {
        MusicDto music = service.findMusicById(idMusic);
        model.addAttribute("music", music);
        
        return "edit-music";
    }
    
    @PostMapping("/update/{id}")
    public String updateMusic(@PathVariable("id") long idMusic, @Valid MusicDto music, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "edit-music";
        }

        music.setIdMusic(idMusic);
        service.updateMusic(music);
        return "redirect:/index";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteMusic(@PathVariable("id") long idMusic, Model model) {
        service.removeById(idMusic);
        
        return "redirect:/index";
    }
}
