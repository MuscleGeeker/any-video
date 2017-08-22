package me.musclegeeker.serv.service;

import me.musclegeeker.serv.mapper.FriendLinkMapper;
import me.musclegeeker.serv.model.FriendLink;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 友情链接
 */
@Service
@Log4j2
@AllArgsConstructor
public class FriendLinkServiceImpl implements FriendLinkService {

    private final FriendLinkMapper friendLinkMapper;

    public List<FriendLink> listHome() {
        return friendLinkMapper.selectShowEqYesDesc();
    }


}
