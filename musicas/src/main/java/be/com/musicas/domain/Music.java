package be.com.musicas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MUSIC")
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long idMusic;

    @Column(name = "MUSIC_NAME")
    private String nameMusic;

    
    @Column(name = "MUSIC_ARTIST")
    private String artistMusic;
    
    @Column(name = "MUSIC_YEAR")
    private String yearMusic;
}
