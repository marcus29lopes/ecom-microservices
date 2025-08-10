package com.eCommerce.user.repository;

import com.eCommerce.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserEmail(String userEmail);

    boolean existsByUserEmail(String userEmail);
}
