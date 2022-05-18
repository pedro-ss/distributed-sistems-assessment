package be.com.musicas.builder;

import org.springframework.stereotype.Component;

import be.com.musicas.domain.Music;
import be.com.musicas.dto.MusicDto;

@Component
public class MusicBuilder {
    
    public MusicDto musicDtoBuilder(Music music) {

        return MusicDto.builder()
            .idMusic(music.getIdMusic())
            .artist(music.getArtistMusic())
            .name(music.getNameMusic())
            .year(music.getYearMusic())
        .build();
    }

    public Music musicBuilder(MusicDto music) {

        return Music.builder()
            .idMusic(music.getIdMusic())
            .artistMusic(music.getArtist())
            .nameMusic(music.getName())
            .yearMusic(music.getYear())
        .build();
    }
}
