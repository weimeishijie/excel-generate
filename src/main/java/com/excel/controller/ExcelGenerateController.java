package com.excel.controller;

import com.excel.entity.QRRecord;
import com.excel.generate.ExcelUtil;
import com.excel.service.QRRecordService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by lwy on 2019/11/21.
 *
 * let url = "localhost:808//.../.../exportExcel?pageStart=0&pageSize=50";
 * location.href = url;
 *
 * @description
 */
@Controller
public class ExcelGenerateController {

    @Autowired
    private QRRecordService qrRecordService;

    /**
     * 根据条件将数据导出为Excel
     * 如果需要浏览器发送请求时即下载Excel，就不能用ajax进行传输，所以这里用GET方式进行提交
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/exportExcel", method = RequestMethod.GET)
    public void exportExcel(HttpServletRequest request, HttpServletResponse response) {
        QRRecord obj = new QRRecord();
        obj.setPageStart(Integer.valueOf(request.getParameter("pageStart")));
        obj.setPageSize(Integer.valueOf(request.getParameter("pageSize")));
        obj.setTerm(request.getParameter("term"));
        List<QRRecord> list = qrRecordService.findQRRecordList();
        String[] title = {"ID", "业主姓名", "识别时间", "设备名称", "识别位置", "目的楼层", "备注信息"};
        String filename = "QRCodeRecord.xls";
        String sheetName = "sheet1";
        String[][] content = new String[list.size()][7];
        try {
            for (int i = 0; i < list.size(); i++) {
                content[i][0] = String.valueOf(list.get(i).getRid());
                content[i][1] = list.get(i).getOwnerName();
                content[i][2] = list.get(i).getAddTime();
                content[i][3] = list.get(i).getDeviceName();
                content[i][4] = list.get(i).getLocation();
                content[i][5] = String.valueOf(list.get(i).getAimFloor());
                content[i][6] = list.get(i).getDescription();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content);
        try {
            // 响应到客户端
            this.setResponseHeader(response, filename);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 向客户端发送响应流方法
     *
     * @param response
     * @param fileName
     */
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
