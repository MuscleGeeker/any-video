package me.musclegeeker.serv.service;

import me.musclegeeker.serv.model.Tip;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TipService {

    List<Tip> list();

}
