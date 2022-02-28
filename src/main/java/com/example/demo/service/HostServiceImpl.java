package com.example.demo.service;

import lombok.RequiredArgsConstructor;
import org.atto.alivecheck.AliveCheckManager;
import org.atto.alivecheck.HostInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class HostServiceImpl implements HostService {

    private final AliveCheckManager aliveCheckManager;

    @Override
    public HostInfo add(String hostName) {
        HostInfo hostInfo = aliveCheckManager.createHostInfo(hostName);
        aliveCheckManager.hostInfoTestStore().add(hostInfo);
        return hostInfo;
    }

    @Override
    public List<HostInfo> addList(String hostName) {
        ArrayList<HostInfo> hostInfos = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            HostInfo hostInfo = aliveCheckManager.createHostInfo(hostName);
            hostInfos.add(hostInfo);
        }
        aliveCheckManager.hostInfoTestStore().add(hostInfos);

        return hostInfos;
    }

    @Override
    public void start(int threadCount, int intervalMs) {
        aliveCheckManager.hostInfoMonitor().start(threadCount, intervalMs);
    }

    @Override
    public int getThreadCount() {
        return aliveCheckManager.hostInfoMonitor().getThreadCount();
    }

    @Override
    public void stop() {
        aliveCheckManager.hostInfoMonitor().stop();
    }

    @Override
    public void stopNow() throws InterruptedException {
        aliveCheckManager.hostInfoMonitor().stopNow();
    }

    @Override
    public boolean isRunning() {
        return aliveCheckManager.hostInfoMonitor().isRunning();
    }

    @Override
    public HostInfo get(String hostName) {
        return aliveCheckManager.hostInfoTestStore().get(hostName);
    }

    @Override
    public List<HostInfo> get() {
        return aliveCheckManager.hostInfoTestStore().getAll();
    }

    @Override
    public void delete(String hostName) {
        HostInfo hostInfo = get(hostName);
        aliveCheckManager.hostInfoTestStore().remove(hostInfo);
    }
}
