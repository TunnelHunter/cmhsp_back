package cn.psychology.dao;

import cn.psychology.entity.ReadTable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

;import java.util.List;


@Repository
public interface ReadRepository extends MongoRepository<ReadTable,Integer> {

    //获取详细信息接口（书/文章）
    ReadTable findByReadId(String readId);

    //获取列表接口（书/文章）
    List<ReadTable> findByReadType(int readType);

}
