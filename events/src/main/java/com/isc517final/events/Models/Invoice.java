package com.isc517final.events.Models;

import javax.persistence.*;
import org.json.simple.JSONObject;

@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private long id;

    @Column(nullable = false)
    private long userId;

    @Column(nullable = false)
    private long eventId;

    @Column(nullable = false)
    private float amount;

    @Column(nullable = false)
    private float transactionFee;

    public String toJson() {

        JSONObject json = new JSONObject();

        json.put("id", this.id);
        json.put("user_id", this.userId);
        json.put("event_id", this.eventId);
        json.put("amount", this.amount);
        json.put("transactionFee", this.transactionFee);

        return json.toJSONString();
    }
}
