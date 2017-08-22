package me.musclegeeker.serv.service;

import me.musclegeeker.serv.model.FriendLink;

import java.util.List;

/**
 * 友情链接 Service
 */
public interface FriendLinkService {

    // 得到首页友情链接
    List<FriendLink> listHome();

}
