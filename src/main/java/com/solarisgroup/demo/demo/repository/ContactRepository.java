package com.solarisgroup.demo.demo.repository;

import com.solarisgroup.demo.demo.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findByUserId(String userId);

}
