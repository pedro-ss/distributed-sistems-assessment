package be.com.musicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.com.musicas.domain.Music;

@Repository
public interface MusicRepository extends JpaRepository<Music, Long>{
}
