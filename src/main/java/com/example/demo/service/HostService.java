package com.example.demo.service;

import org.atto.alivecheck.HostInfo;

import java.util.List;

public interface HostService {

    HostInfo add(String hostName);

    List<HostInfo> addList(String hostName);

    void start(int threadCount, int intervalMs);

    int getThreadCount();

    void stop();

    void stopNow() throws InterruptedException;

    boolean isRunning();

    HostInfo get(String hostName);

    List<HostInfo> get();

    void delete(String hostName);
}
