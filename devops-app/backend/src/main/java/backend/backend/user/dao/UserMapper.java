package backend.backend.user.dao;

import org.apache.ibatis.annotations.Mapper;

import backend.backend.user.domain.UserRequestDTO;
import backend.backend.user.domain.UserResponseDTO;

@Mapper
public interface UserMapper {
    public void signUp(UserRequestDTO params) ;
    public UserResponseDTO signIn(UserRequestDTO params) ;
    
}
