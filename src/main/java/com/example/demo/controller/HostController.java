package com.example.demo.controller;

import com.example.demo.service.HostService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.atto.alivecheck.HostInfo;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HostController {

    private final HostService hostService;

    @GetMapping("/hosts/{hostName}")
    public HostInfo addHostInfo(@PathVariable String hostName) {
        return hostService.add(hostName);
    }

    @GetMapping("/hosts/list/{hostName}")
    public List<HostInfo> addHostInfos(@PathVariable String hostName) {
        return hostService.addList(hostName);
    }

    @GetMapping("/monitoring/action/{threads}/{interval}")
    public void startMonitoring(@PathVariable int threads, @PathVariable int interval) {
        hostService.start(threads, interval);
    }

    @GetMapping("/monitoring/count")
    public int getTheadCount() {
        return hostService.getThreadCount();
    }

    @GetMapping("/monitoring/stop")
    public void stop() {
        hostService.stop();
    }

    @GetMapping("/monitoring/running-check")
    public boolean isRunning() {
        return hostService.isRunning();
    }

    @GetMapping("/monitoring/hosts/{hostName}")
    public HostInfo getHostInfo(@PathVariable String hostName) {
        return hostService.get(hostName);
    }

    @GetMapping("/monitoring/hosts")
    public Result<List<HostInfo>> getHostInfos() {
        List<HostInfo> hostInfos = hostService.get();
        return new Result<>(hostInfos.size(), hostInfos);
    }

    @GetMapping("/monitoring/stop-now")
    public void stopNow() throws InterruptedException {
        hostService.stopNow();
    }

    @DeleteMapping("/hosts/{hostName}")
    public void removeHost(@PathVariable String hostName) {
        hostService.delete(hostName);
    }

    @Data
    @AllArgsConstructor
    private static class Result<T> {
        private int count;
        private T hostInfos;
    }

}
