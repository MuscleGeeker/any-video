package me.musclegeeker.serv.service;

import me.musclegeeker.serv.mapper.TipMapper;
import me.musclegeeker.serv.model.Tip;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TipServiceImpl implements TipService {

  private final TipMapper mapper;

  @Override
  public List<Tip> list() {
    return mapper.list();
  }

}
