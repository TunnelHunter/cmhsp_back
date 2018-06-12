package cn.psychology.dao;

import cn.psychology.entity.Social;
import cn.psychology.entity.Social.Comments;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;
import java.util.List;

public interface SocialRepository extends MongoRepository<Social,String>{
    Social findAllBySocialid(String id);


}
