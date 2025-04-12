package com.shop.NFTshop.persistence.repository;

import com.shop.NFTshop.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
