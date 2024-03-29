package com.coder.coderschool.repository;

import com.coder.coderschool.model.Contact;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {


    List<Contact> findByStatus(String status);

    //@Query(value = "SELECT * FROM contact_msg c WHERE c.status = :status", nativeQuery = true) --> SQL query
    @Query("SELECT c FROM Contact c WHERE c.status= :status") //JPQL
    Page<Contact> findByStatus(@Param("status") String state, Pageable pageable);

    @Transactional
    @Modifying
    @Query("UPDATE Contact c SET c.status = ?1 WHERE c.contactId = ?2")
    int updateStatusById(String status, int id);

    Page<Contact> findsOpenMsgs(@Param("status") String status, Pageable pageable);

    @Transactional
    @Modifying
    int updateMsgStatus(String status, int id);

}
