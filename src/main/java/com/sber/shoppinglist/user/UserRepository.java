package com.sber.shoppinglist.user;

import com.sber.shoppinglist.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
