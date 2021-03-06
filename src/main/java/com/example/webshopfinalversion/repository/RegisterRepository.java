package com.example.webshopfinalversion.repository;

import com.example.webshopfinalversion.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RegisterRepository extends JpaRepository<User, Long> {


}