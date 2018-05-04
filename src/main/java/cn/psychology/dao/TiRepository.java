package cn.psychology.dao;

import cn.psychology.entity.Ti;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("dao")
public interface TiRepository extends MongoRepository <Ti,String> {

//   // public Ti findByShiti_name(String shiti_name);
//    public Ti findByExamination_No(String Examination_No);
//   // public Ti findById(String id);
    public Ti findByExaminationId(String ExaminationId);
}
