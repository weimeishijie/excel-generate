package com.excel.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by lwy on 2019/11/21.
 *
 * @description
 */
@Entity
@Table(name = "qRRecord")
public class QRRecord implements Serializable{

    @Id
    @GeneratedValue
    private Integer rid;

//    @Column(columnDefinition = "业主姓名")
    @Column
    private String ownerName;

//    @Column(columnDefinition = "识别时间")
    @Column
    private String addTime;

//    @Column(columnDefinition = "设备名称")
    @Column
    private String deviceName;

//    @Column(columnDefinition = "识别位置")
    @Column
    private String location;

//    @Column(columnDefinition = "目标楼层")
    @Column
    private String aimFloor;

//    @Column(columnDefinition = "备注信息")
    @Column
    private String description;

//    @Column(columnDefinition = "开始页")
    @Column
    private Integer pageStart;

//    @Column(columnDefinition = "页面大小")
    @Column
    private Integer pageSize;

//    @Column(columnDefinition = "描述")
    @Column
    private String term;

    public QRRecord() {
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAimFloor() {
        return aimFloor;
    }

    public void setAimFloor(String aimFloor) {
        this.aimFloor = aimFloor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPageStart() {
        return pageStart;
    }

    public void setPageStart(Integer pageStart) {
        this.pageStart = pageStart;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QRRecord qrRecord = (QRRecord) o;

        return rid != null ? rid.equals(qrRecord.rid) : qrRecord.rid == null;
    }

    @Override
    public int hashCode() {
        return rid != null ? rid.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "QRRecord{" +
                "rid=" + rid +
                ", ownerName='" + ownerName + '\'' +
                ", addTime=" + addTime +
                ", deviceName='" + deviceName + '\'' +
                ", location='" + location + '\'' +
                ", aimFloor='" + aimFloor + '\'' +
                ", description='" + description + '\'' +
                ", pageStart=" + pageStart +
                ", pageSize=" + pageSize +
                ", term='" + term + '\'' +
                '}';
    }
}
