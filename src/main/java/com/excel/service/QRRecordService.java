package com.excel.service;


import com.excel.entity.QRRecord;

import java.util.List;

/**
 * Created by lwy on 2019/11/21.
 *
 * @description
 */
public interface QRRecordService {

    List<QRRecord> findQRRecordList();

}
