package com.pql.design.template.report;

public class ShenZhenReportService extends BaseReportService {

    private boolean needDeviceFlag = true;

    @Override
    void reportProjInfo() {
        System.out.println("深圳上报项目");
    }

    @Override
    void reportCompany() {
        System.out.println("深圳上报企业");
    }

    @Override
    void reportGroup() {
        System.out.println("深圳上报班组");
    }

    @Override
    void reportDevice() {
        System.out.println("深圳上报设备");
    }


    @Override
    void reportWork() {
        System.out.println("深圳上报劳工");
    }

    @Override
    void reportSignlog() {
        System.out.println("深圳上报考勤记录");
    }

    @Override
    protected boolean needDevice() {
        return this.needDeviceFlag;
    }
}
