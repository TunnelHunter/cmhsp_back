package cn.psychology.Impl;

import cn.psychology.dao.FavoriteRepository;
import cn.psychology.entity.Favorite;
import cn.psychology.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteImpl implements FavoriteService {
    @Autowired
    private FavoriteRepository favoriteRepository;
    public List<Favorite> getFavorite(Integer id){
        return favoriteRepository.findAllByUserid(id);
    }
}
