package com.pql.design.factory.method;

public class ShenZhenReportWorkerFactory implements IReportWorkerFactory {

    @Override
    public IWorker create() {
        return new ShenZhenWorker();
    }
}
