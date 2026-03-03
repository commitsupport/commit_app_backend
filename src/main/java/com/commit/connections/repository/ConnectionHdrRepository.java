package com.commit.connections.repository;

import com.commit.connections.entity.ConnectionHdr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConnectionHdrRepository extends JpaRepository<ConnectionHdr, Integer> {

    List<ConnectionHdr> findAllByStatus(String status);

}
