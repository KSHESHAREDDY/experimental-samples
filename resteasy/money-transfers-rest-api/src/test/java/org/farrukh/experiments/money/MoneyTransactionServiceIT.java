package org.farrukh.experiments.money;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.EntityBuilder;
import org.farrukh.experiments.money.model.Account;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

public class MoneyTransactionServiceIT {

    static MainApp app = new MainApp();

    @BeforeClass
    public static void init() throws Exception {
        app.startServer();
    }


    @Test
    public void test() {
        Client client = ClientBuilder.newClient();
        org.farrukh.experiments.money.model.Client client1 = new org.farrukh.experiments.money.model.Client("Ali", "Valiev");
        Account account = new Account(client1, "RUR", 1_000_000.0);
        Entity<Account> requestEntity = Entity.entity(account, MediaType.APPLICATION_JSON_TYPE);
        UriBuilder uriBuilder = UriBuilder.fromPath("http://127.0.0.1:8080/money/account/create");
        Response response = client
                .target(uriBuilder)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .buildPost(requestEntity)
                .invoke();
        Assert.assertEquals(response.getStatus(), 201);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        app.stopServer();
    }

}
