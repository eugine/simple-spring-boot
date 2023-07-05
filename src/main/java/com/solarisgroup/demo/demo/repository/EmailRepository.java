package com.solarisgroup.demo.demo.repository;

import com.solarisgroup.demo.demo.entity.Contact;
import com.solarisgroup.demo.demo.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

}
