package cn.psychology.dao;

import cn.psychology.entity.Favorite;
import cn.psychology.entity.Music;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FavoriteRepository extends MongoRepository<Favorite,String> {
    List<Favorite> findAllByUserid(Integer id);
    Favorite findBySourceidAndAndType(Integer sourceid,Integer type);
}
