package com.excel.service.impl;

import com.excel.entity.QRRecord;
import com.excel.repository.QRRecordRepository;
import com.excel.service.QRRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lwy on 2019/11/21.
 *
 * @description
 */
@Service("qrRecordService")
public class QRRecordServiceImpl implements QRRecordService {

    @Autowired
    private QRRecordRepository qrRecordRepository;

    @Override
    public List<QRRecord> findQRRecordList() {
        // 含有分页查询的三个条件 页面大小，起始页面，分多少页
        return qrRecordRepository.findQRRecordList();
    }
}
