package com.pql.design.factory.method;

public class WuHanReportWorkerFactory implements IReportWorkerFactory {
    @Override
    public IWorker create() {
        return new WuHanWorker();
    }
}
