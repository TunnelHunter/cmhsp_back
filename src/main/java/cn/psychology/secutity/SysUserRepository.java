package cn.psychology.secutity;

import cn.psychology.secutity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SysUserRepository extends MongoRepository<SysUser, Integer> {
    SysUser findByUsername(String username);
}