package com.pql.design.template.report;

/**
 * 上报模板基类
 * */
public abstract class BaseReportService {

    protected final void report(){
        // 上报项目
        this.reportProjInfo();

        // 上报企业
        this.reportCompany();

        // 上报班组
        this.reportGroup();

        // 上报设备
        if(needDevice()){
            this.reportDevice();
        }

        // 上报劳工
        this.reportWork();

        // 上报考勤
        this.reportSignlog();
    }

    // 钩子方法 实现流程的微调
    protected boolean needDevice(){
        return false;
    }

    abstract void reportProjInfo();
    abstract void reportCompany();
    abstract void reportGroup();
    abstract void reportDevice();
    abstract void reportWork();
    abstract void reportSignlog();
}
