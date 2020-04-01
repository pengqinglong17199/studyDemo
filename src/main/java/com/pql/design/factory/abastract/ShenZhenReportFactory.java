package com.pql.design.factory.abastract;

public class ShenZhenReportFactory implements ReportFactory {

    @Override
    public IWorker createWorker() {
        return new ShenZhenWorker();
    }

    @Override
    public IGroup createGroup() {
        return new ShenZhenGroup();
    }
}
