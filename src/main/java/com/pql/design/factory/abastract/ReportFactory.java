package com.pql.design.factory.abastract;

public interface ReportFactory {

    IWorker createWorker();

    IGroup createGroup();
}
