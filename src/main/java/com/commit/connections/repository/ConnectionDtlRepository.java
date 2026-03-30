package com.commit.connections.repository;

import com.commit.connections.entity.ConnectionDtl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConnectionDtlRepository extends JpaRepository<ConnectionDtl, Integer> {

    List<ConnectionDtl> findAllByStatusAndConhdrid(String status, Integer conhdrid);
    ConnectionDtl findAllByGidAndStatusAndConhdrid(Integer gid, String status, Integer conhdrid);
}
