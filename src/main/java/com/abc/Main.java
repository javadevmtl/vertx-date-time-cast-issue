package com.abc;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.jdbc.impl.actions.JDBCStatementHelper;

import java.sql.Timestamp;
import java.time.Instant;

import static java.time.format.DateTimeFormatter.ISO_INSTANT;

public class Main  extends AbstractVerticle {

    public void start() {

        String now = Instant.now().toString();
        System.out.println(now);
        JsonArray test = new JsonArray().add(now);
        System.out.println(test.encodePrettily());
        // new JsonObject().put("castDatetime", false)
        JDBCStatementHelper helper = new JDBCStatementHelper();
        System.out.println(helper.optimisticCast(now));
        Instant instant = Instant.from(ISO_INSTANT.parse(now));
        System.out.println(Timestamp.from(instant));
    }
}
