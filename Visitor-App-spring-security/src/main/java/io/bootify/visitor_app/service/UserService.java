package io.bootify.visitor_app.service;

import io.bootify.visitor_app.domain.Address;
import io.bootify.visitor_app.domain.Flat;
import io.bootify.visitor_app.domain.Role;
import io.bootify.visitor_app.domain.User;
import io.bootify.visitor_app.model.UserDTO;
import io.bootify.visitor_app.repos.AddressRepository;
import io.bootify.visitor_app.repos.FlatRepository;
import io.bootify.visitor_app.repos.RoleRepository;
import io.bootify.visitor_app.repos.UserRepository;
import io.bootify.visitor_app.util.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final FlatRepository flatRepository;
    private final AddressRepository addressRepository;
    private final RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserService(final UserRepository userRepository, final FlatRepository flatRepository,
            final AddressRepository addressRepository, final RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.flatRepository = flatRepository;
        this.addressRepository = addressRepository;
        this.roleRepository = roleRepository;
    }

    public List<UserDTO> findAll() {
        final List<User> users = userRepository.findAll(Sort.by("id"));
        return users.stream()
                .map((user) -> mapToDTO(user, new UserDTO()))
                .collect(Collectors.toList());
    }

    public UserDTO get(final Long id) {
        return userRepository.findById(id)
                .map(user -> mapToDTO(user, new UserDTO()))
                .orElseThrow(() -> new NotFoundException());
    }

    public Long create(final UserDTO userDTO) {
        final User user = new User();
        user.setPassword(passwordEncoder.encode("123456"));
        mapToEntity(userDTO, user);
        return userRepository.save(user).getId();
    }

    public void update(final Long id, final UserDTO userDTO) {
        final User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException());
        mapToEntity(userDTO, user);
        userRepository.save(user);
    }

    public void delete(final Long id) {
        userRepository.deleteById(id);
    }

    private UserDTO mapToDTO(final User user, final UserDTO userDTO) {
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        userDTO.setFlat(user.getFlat() == null ? null : user.getFlat().getId());
        userDTO.setAddress(user.getAddress() == null ? null : user.getAddress().getId());
        userDTO.setRoleId(user.getRole() == null ? null : user.getRole().getId());
        return userDTO;
    }

    private User mapToEntity(final UserDTO userDTO, final User user) {
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        final Flat flat = userDTO.getFlat() == null ? null : flatRepository.findById(userDTO.getFlat())
                .orElseThrow(() -> new NotFoundException("flat not found"));
        user.setFlat(flat);
        final Address address = userDTO.getAddress() == null ? null : addressRepository.findById(userDTO.getAddress())
                .orElseThrow(() -> new NotFoundException("address not found"));
        user.setAddress(address);
        final Role roleId = userDTO.getRoleId() == null ? null : roleRepository.findById(userDTO.getRoleId())
                .orElseThrow(() -> new NotFoundException("roleId not found"));
        user.setRole(roleId);
        return user;
    }

}
