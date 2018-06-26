
package cn.psychology.dao;


import cn.psychology.entity.Music;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MusicRepository extends MongoRepository<Music,String> {
    List<Music> findAllByMusicsceneId(String id);
    Music findAllBySongId(String id);

}

