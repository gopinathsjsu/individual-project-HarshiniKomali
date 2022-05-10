package org.inventory.validators;

import org.inventory.model.OrderItems;

import java.util.ArrayList;

public interface ValidationHandler {
    String validate(ArrayList<OrderItems> orderItems);
}
