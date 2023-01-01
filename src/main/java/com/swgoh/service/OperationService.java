package com.swgoh.service;

import com.swgoh.entity.Operation;
import com.swgoh.entity.Territory;

import java.util.List;

public interface OperationService {

    Operation getOperation(Long id);

    List<Operation> getOperations(Long territoryId);

    Operation saveOperation(Operation operation);

    List<Operation> saveOperations(List<Operation> operations);
}
