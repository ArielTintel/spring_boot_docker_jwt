package br.com.arieltintel.cliente.service;

import br.com.arieltintel.cliente.entities.Cliente;
import br.com.arieltintel.cliente.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente findById(Long id) throws Exception {
        Optional<Cliente> optional = clienteRepository.findById(id);
        return optional.orElseThrow(() -> new Exception("Não existe cliente com ID: " + id));
    }

    public Cliente findByEmail(String email) throws Exception {
        Optional<Cliente> optional = clienteRepository.findByEmail(email);
        return optional.orElseThrow(() -> new Exception("Não existe cliente com EMAIL: " + email));
    }

}