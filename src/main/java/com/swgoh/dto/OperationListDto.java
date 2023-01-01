package com.swgoh.dto;

import com.swgoh.entity.Operation;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OperationListDto {

    private List<Operation> operations;

    private void addOperation(Operation operation) {

        if (operations == null) {
            operations = new ArrayList<>();
        }

        operations.add(operation);
    }
}
