package me.silentdoer.controller;

import io.quarkus.runtime.Quarkus;
import me.silentdoer.service.TestService;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingController {

    @Inject
    private TestService testService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        this.testService.test();
        return "Hello RESTEasy";
    }

    /**
     * 如果一启动应用就直接调用shutdown会有问题
     * @return
     */
    @GET
    @Path("/shutdown")
    @Produces(MediaType.TEXT_PLAIN)
    public String shutdown() {
        System.out.println("will shutdown");
        // 可以退出程序，在IDE里不能退出是因为处于开发模式
        Quarkus.asyncExit();
        return "Hello RESTEasy";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    public String greeting(@PathParam String name) {
        return "DDD" + name;
    }
}