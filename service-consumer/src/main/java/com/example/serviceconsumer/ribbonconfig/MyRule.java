package com.example.serviceconsumer.ribbonconfig;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;


public class MyRule extends AbstractLoadBalancerRule  {
    int time = 3;
    public Server choose(ILoadBalancer lb, Object o) {
        // 获取服务器列表
        List<Server> servers = lb.getAllServers();
        return getServerByPort(servers, 7070);

//        if (time >= 1 && time <= 3) {
//            time -= 1;
//            return getServerByPort(servers, 7070);
//        } else if (time == 0 || time == -1) {
//            time -= 1;
//            return getServerByPort(servers, 7071);
//        } else {
//            time = 3;
//            return getServerByPort(servers, 7071);
//
//        }
    }

    /**
     * 根据传入的端口号，返回服务对象
     * @param servers
     * @param port
     * @return
     */
    private Server getServerByPort(List<Server> servers, int port){
        for(Server s : servers){
            if(s.getPort() == port){
                return s;
            }
        }
        return null;
    }


    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {
        return choose(getLoadBalancer(), o);
    }
}
