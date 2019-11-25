package com.excel.repository;

import com.excel.entity.QRRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lwy on 2019/11/21.
 *
 * @description
 */
@Repository
public interface QRRecordRepository extends JpaRepository<QRRecord, Integer>{

    @Query(value = "select * from qRRecord", nativeQuery = true)
    List<QRRecord> findQRRecordList();

}
