package com.infoshare.eventmanagers.dto;

import com.infoshare.eventmanagers.dao.UserDao;
import com.infoshare.eventmanagers.models.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserFavoritesDto {
    private Integer id;
    private List<EventDto> favoriteList;

    public static UserFavoritesDto toUserFavoritesDto(User user) {
        UserFavoritesDto userFavoritesDto = new UserFavoritesDto();
        userFavoritesDto.setId(user.getId());
        userFavoritesDto.setFavoriteList(user.getFavoriteList().stream().map(EventDto::toEventDto).collect(Collectors.toList()));
        return userFavoritesDto;
    }

    public static User toUser(UserFavoritesDto userFavoritesDto){
        UserDao userDao = new UserDao();
        User user = userDao.getById(userFavoritesDto.getId());
        user.setFavoriteList(userFavoritesDto.getFavoriteList().stream().map(EventDto::toEvent).collect(Collectors.toList()));
        return user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<EventDto> getFavoriteList() {
        return favoriteList;
    }

    public void setFavoriteList(List<EventDto> favoriteList) {
        this.favoriteList = favoriteList;
    }
}
