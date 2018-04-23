package io.swagger.server.api.verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

import io.swagger.server.api.model.Employee;

import java.util.List;
import java.util.Map;

public class DefaultApiVerticle extends AbstractVerticle {
    final static Logger LOGGER = LoggerFactory.getLogger(DefaultApiVerticle.class); 
    
    final static String GET_EMPLOYEE_SERVICE_ID = "GET_employee";
    final static String POST_EMPLOYEE_SERVICE_ID = "POST_employee";
    final static String PUT_EMPLOYEE_SERVICE_ID = "PUT_employee";
    
    //TODO : create Implementation
    DefaultApi service = new DefaultApiImpl();

    @Override
    public void start() throws Exception {
        
        //Consumer for GET_employee
        vertx.eventBus().<JsonObject> consumer(GET_EMPLOYEE_SERVICE_ID).handler(message -> {
            try {
                
                Employee result = service.employeeGet();
                message.reply(new JsonObject(Json.encode(result)).encodePrettily());
            } catch (Exception e) {
                //TODO : replace magic number (101)
                message.fail(101, e.getLocalizedMessage());
            }
        });
        
        //Consumer for POST_employee
        vertx.eventBus().<JsonObject> consumer(POST_EMPLOYEE_SERVICE_ID).handler(message -> {
            try {
                Employee body = Json.mapper.readValue(message.body().getJsonObject("body").encode(), Employee.class);
                
                Employee result = service.employeePost(body);
                message.reply(new JsonObject(Json.encode(result)).encodePrettily());
            } catch (Exception e) {
                //TODO : replace magic number (101)
                message.fail(101, e.getLocalizedMessage());
            }
        });
        
        //Consumer for PUT_employee
        vertx.eventBus().<JsonObject> consumer(PUT_EMPLOYEE_SERVICE_ID).handler(message -> {
            try {
                Employee body = Json.mapper.readValue(message.body().getJsonObject("body").encode(), Employee.class);
                
                Employee result = service.employeePut(body);
                message.reply(new JsonObject(Json.encode(result)).encodePrettily());
            } catch (Exception e) {
                //TODO : replace magic number (101)
                message.fail(101, e.getLocalizedMessage());
            }
        });
        
    }
}