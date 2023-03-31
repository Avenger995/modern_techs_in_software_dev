package com.example.footballers.soap;

import com.example.footballers.repos.interfaces.IPlayerRepos;
import com.example.footballers.repos.interfaces.ISkillsRepos;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class WSConfig {

    @Autowired
    private Bus bus;
    @Autowired
    private IPlayerRepos _playerRepos;
    @Autowired
    private ISkillsRepos _skillsRepos;

    @Bean
    public Endpoint helloEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new HelloServiceImpl());
        endpoint.publish("/Hello");
        return endpoint;
    }

    @Bean
    public Endpoint addSkillsEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new SkillsServiceImpl(_playerRepos, _skillsRepos));
        endpoint.publish("/Skills");
        return endpoint;
    }
}
