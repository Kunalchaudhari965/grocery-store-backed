package com.example.grocerystorebacked.Repository;

import com.example.grocerystorebacked.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>
{
    User findByusername(String username);

    User findByemail(String email);

    User findByEmailAndUsername(String email, String username);

    User findById(Long userId);
}
