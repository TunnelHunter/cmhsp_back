package cn.psychology.dao;

import cn.psychology.entity.Favorite;
import cn.psychology.entity.Music;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FavoriteRepository extends MongoRepository<Favorite,String> {

}
