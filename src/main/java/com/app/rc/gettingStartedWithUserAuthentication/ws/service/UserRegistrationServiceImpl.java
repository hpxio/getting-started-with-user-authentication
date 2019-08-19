
package com.app.rc.gettingStartedWithUserAuthentication.ws.service;

import com.app.rc.gettingStartedWithUserAuthentication.ws.io.entity.UserRegistrationEntity;
import com.app.rc.gettingStartedWithUserAuthentication.ws.repository.UserRegistrationRepository;
import com.app.rc.gettingStartedWithUserAuthentication.ws.shared.dto.UserRegistrationDTO;
import com.app.rc.gettingStartedWithUserAuthentication.ws.shared.utils.GenerateRandomUserId;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author Harsh
 */
@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

  @Autowired
  UserRegistrationRepository repository;

  @Autowired
  GenerateRandomUserId generateUid;

  @Autowired
  BCryptPasswordEncoder bCryptPasswordEncoder;

  @Override
  public UserRegistrationDTO registerUser(
      UserRegistrationDTO registerDto) {

    UserRegistrationEntity entity = new UserRegistrationEntity();
    UserRegistrationEntity resEntity = new UserRegistrationEntity();
    UserRegistrationDTO res = new UserRegistrationDTO();

    /* Prepare internal data */
    registerDto.setEmailVerificationStatus(true);
    registerDto.setEmailVerificationToken(generateUid.getRandomUserId(24));
    registerDto.setEncryptedPassword(bCryptPasswordEncoder.encode(registerDto.getPassword()));
    registerDto.setUserId(generateUid.getRandomUserId(16));

    /* Prepare data to push into DB */
    BeanUtils.copyProperties(registerDto, entity);

    /* Get the saved data state */
    resEntity = repository.save(entity);

    /* Prepare resultant DTO for controller */
    BeanUtils.copyProperties(resEntity, res);

    return res;
  }

  /**
   * @param updateDTO
   * @return
   */
  @Override
  public UserRegistrationDTO updateUser(UserRegistrationDTO updateDTO) {

    UserRegistrationEntity entity = new UserRegistrationEntity();
    UserRegistrationDTO response = new UserRegistrationDTO();

    updateDTO.setEncryptedPassword(bCryptPasswordEncoder.encode(updateDTO.getPassword()));
    BeanUtils.copyProperties(updateDTO, entity);

    final UserRegistrationEntity result = repository.save(entity);
    BeanUtils.copyProperties(result, response);
    return null;
  }

  /**
   *
   */
  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

    UserRegistrationEntity entity = repository.findByEmail(email);

    if (entity == null) { throw new UsernameNotFoundException(email); }
    return new User(entity.getEmail(), entity.getEncryptedPassword(), new ArrayList<>());
  }

  /**
   *
   */
  @Override
  public UserRegistrationDTO getUser(String email) {

    UserRegistrationEntity entity = repository.findByEmail(email);

    if (entity == null) { throw new RuntimeException(); }
    UserRegistrationDTO dto = new UserRegistrationDTO();
    BeanUtils.copyProperties(entity, dto);

    return dto;
  }

  /**
   * @param userId
   * @return
   */
  @Override
  public UserRegistrationDTO getUserByUserId(String userId) {
    UserRegistrationDTO response = new UserRegistrationDTO();
    final UserRegistrationEntity result = repository.findByUserId(userId);

    if (result == null) { throw new UsernameNotFoundException("User does not exists for " + userId);}

    BeanUtils.copyProperties(result, response);
    return response;
  }
}
