package be.com.musicas.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MusicDto {

    @JsonProperty
    private Long idMusic;

    @JsonProperty
    @NotBlank(message = "O nome da música deve ser informado.")
    private String name;
    
    @JsonProperty
    @NotBlank(message = "O artista deve ser informado.")
    private String artist;
    
    @JsonProperty
    @NotBlank(message = "O ano deve ser preenchido.")
    private String year;
}