package com.pql.design.template.report;

public class WuHanReportService extends BaseReportService {
    @Override
    void reportProjInfo() {
        System.out.println("武汉上报考勤");
    }

    @Override
    void reportCompany() {
        System.out.println("武汉上报企业");
    }

    @Override
    void reportGroup() {
        System.out.println("武汉上报班组");
    }

    @Override
    void reportDevice() {
        System.out.println("武汉上报设备");
    }

    @Override
    void reportWork() {
        System.out.println("武汉上报劳工");
    }

    @Override
    void reportSignlog() {
        System.out.println("武汉上报考勤记录");
    }
}
