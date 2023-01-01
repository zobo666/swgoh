package com.swgoh.service;

import com.swgoh.entity.Operation;
import com.swgoh.repository.OperationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationRepository operationRepository;

    @Override
    public Operation getOperation(Long id) {
        Operation operation = null;

        Optional<Operation> result = operationRepository.findById(id);

        if (result.isPresent()) {
            operation = result.get();
        }
        return operation;
    }

    @Override
    public List<Operation> getOperations(Long territoryId) {
        return operationRepository.findOperationByTerritoryId(territoryId);
    }

    @Override
    public Operation saveOperation(Operation operation) {
        return operationRepository.save(operation);
    }

    @Override
    public List<Operation> saveOperations(List<Operation> operations) {
        return operationRepository.saveAll(operations);
    }
}
