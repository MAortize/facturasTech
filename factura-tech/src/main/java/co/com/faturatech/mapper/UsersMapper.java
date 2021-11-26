package co.com.faturatech.mapper;

import co.com.faturatech.domain.Users;
import co.com.faturatech.dto.UsersDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
* Mapper Build with MapStruct https://mapstruct.org
* MapStruct is a code generator that greatly simplifies the
* implementation of mappings between Java bean type
* based on a convention over configuration approach.
*/
@Mapper
public interface UsersMapper {
    public UsersDTO usersToUsersDTO(Users users);

    public Users usersDTOToUsers(UsersDTO usersDTO);

    public List<UsersDTO> listUsersToListUsersDTO(List<Users> userss);

    public List<Users> listUsersDTOToListUsers(List<UsersDTO> usersDTOs);
}
