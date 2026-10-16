package com.example.JWTNIKHIL.Repository;


import com.example.JWTNIKHIL.Entity.UserUS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserUsRepository extends JpaRepository<UserUS,Long> {
    UserUS findByUserName(String username);
}
