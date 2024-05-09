package com.example.demo.service;

import com.example.demo.model.Load;
import com.example.demo.repository.LoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class service {
    @Autowired
    LoadRepository loadRepository;


    public String addLoad(Load load) {
        try{
            loadRepository.save(load);
            return "Succesfully added";
        }catch (Error e){
            return "cannot add because of this error "+e.toString();
        }
    }

    public Optional<Load> getLoad(Long id) {
        return loadRepository.findById(id);

    }

    public Optional<Load> getLoadById(Long id) {
        return loadRepository.findById(id);
    }

    public Load saveLoad(Load updatedLoad) {
        return loadRepository.save(updatedLoad);
    }

    public String deleteLoad(Long id) {
        try{
            loadRepository.deleteById(id);
            return "succesfully deleted";
        }catch (Error e){
            return "cannot delete because of this error "+e.toString();
        }
    }
}
