package com.meat.meatshop.Repository;

import com.meat.meatshop.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeatRepository extends JpaRepository<User,Integer> {
}
