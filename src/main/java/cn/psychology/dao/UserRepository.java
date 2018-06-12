
package cn.psychology.dao;

import cn.psychology.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

public User findByUsernameAndUserpwd(String name,String pwd);
public User findByUsername(String username);
public User findAllByUserId(int userId);



}

