package tn.pi.BankApp.service;

import org.springframework.stereotype.Service;
import tn.pi.BankApp.entities.Operation;
import tn.pi.BankApp.repository.OperationRepository;

import java.util.List;
import java.util.Optional;


@Service
public class OperationService {

    private final OperationRepository operationRepository;

    public OperationService(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    public List<Operation> getAllOperations() {
        return operationRepository.findAll();
    }

    public Optional<Operation> getOperationById(Long id) {
        return operationRepository.findById(id);
    }

    public Operation saveOperation(Operation operation) {
        return operationRepository.save(operation);
    }

    public void deleteOperation(Long id) {
        operationRepository.deleteById(id);
    }
}
