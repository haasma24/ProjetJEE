package tn.pi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.pi.entities.Operation;
import tn.pi.repositories.OperationRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OperationService {

    private final OperationRepository operationRepository;

    public List<Operation> getAllOperations() {
        return operationRepository.findAll();
    }

    public Optional<Operation> getOperationById(Long id) {
        return operationRepository.findById(id);
    }

    public Operation createOperation(Operation operation) {
        return operationRepository.save(operation);
    }

    public Operation updateOperation(Long id, Operation updatedOperation) {
        return operationRepository.findById(id).map(operation -> {
            operation.setType(updatedOperation.getType());
            operation.setMontant(updatedOperation.getMontant());
            operation.setDate(updatedOperation.getDate());
            operation.setCompte(updatedOperation.getCompte());
            return operationRepository.save(operation);
        }).orElseThrow(() -> new RuntimeException("Operation not found"));
    }

    public void deleteOperation(Long id) {
        operationRepository.deleteById(id);
    }
}
