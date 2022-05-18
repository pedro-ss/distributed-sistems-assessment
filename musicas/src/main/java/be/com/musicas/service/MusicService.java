package be.com.musicas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import be.com.musicas.builder.MusicBuilder;
import be.com.musicas.domain.Music;
import be.com.musicas.dto.MusicDto;
import be.com.musicas.repository.MusicRepository;

@Service
public class MusicService {
    
    @Autowired MusicRepository repo;

    @Autowired MusicBuilder builder;

    public List<MusicDto> listMusics() {
        
        var listMusics = repo.findAll();
        
        List<MusicDto> musicDtos = new ArrayList<>();
        
        listMusics.forEach(music -> {
            musicDtos.add(builder.musicDtoBuilder(music));
        });

        return musicDtos;

    }

    public MusicDto findMusic(MusicDto musicDto) {
        return null;
    }

    public MusicDto updateMusic(MusicDto musicDto) {
        var musicUpdated = repo.save(builder.musicBuilder(musicDto));
        return builder.musicDtoBuilder(musicUpdated);
    }

    public MusicDto saveMusic(MusicDto musicDto) {
        var musicSaved = repo.save(builder.musicBuilder(musicDto));
        return builder.musicDtoBuilder(musicSaved);
    }

    public MusicDto findMusicById(Long idMusic) throws NotFoundException {
        var musicReturned = repo.findById(idMusic).orElseThrow(() -> new IllegalArgumentException("Id de música inválido:" + idMusic));
        return builder.musicDtoBuilder(musicReturned);
    }

    public void removeById(Long idMusic) {
        Music music = repo.findById(idMusic)
            .orElseThrow(() -> new IllegalArgumentException("Id de música inválido:" + idMusic));
        repo.deleteById(music.getIdMusic());
    }
}
