package com.pql.design.factory.abastract;

public class WuHanReportFactory implements ReportFactory {
    @Override
    public IWorker createWorker() {
        return new WuHanWorker();
    }

    @Override
    public IGroup createGroup() {
        return new WuHanGroup();
    }
}
