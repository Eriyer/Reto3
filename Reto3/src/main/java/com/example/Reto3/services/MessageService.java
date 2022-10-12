package com.example.Reto3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Reto3.entities.Message;
import com.example.Reto3.repositories.MessageRepository;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    // METODOS CRUD
    // metogo GET que me trae todos los estudiantes
    public List<Message> getListMessages() {
        return this.messageRepository.findAll();

    }

    // metodo GET que me trae un sólo estudiante
    public Message getMessage(int id) {
        return this.messageRepository.findById(id).get();
    }

    // metodoo POST
    public Message crearMessage(Message message) {
        return this.messageRepository.save(message);
    }

    // metodo DELETE
    public void eliminarMessage(int id) {
        this.messageRepository.deleteById(id);

    }

    // metodoo PUT
    public void actualizarMessage(int id, Message message) {
        if (this.messageRepository.findById(id).isEmpty()) {
            Message messageDB = this.messageRepository.findById(id).get();

            this.messageRepository.save(messageDB);
        }

    }
}
