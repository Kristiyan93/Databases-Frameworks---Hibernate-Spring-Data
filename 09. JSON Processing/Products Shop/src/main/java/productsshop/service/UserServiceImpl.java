package productsshop.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import productsshop.domain.dtos.UserSeedDto;
import productsshop.domain.entities.User;
import productsshop.repository.UserRepository;
import productsshop.util.ValidatorUtil;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ValidatorUtil validatorUtil, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedUsers(UserSeedDto[] userSeedDtos) {
        for (UserSeedDto userSeedDto : userSeedDtos) {
            if (!this.validatorUtil.isValid(userSeedDto)) {
                this.validatorUtil
                        .violations(userSeedDto)
                        .forEach(v -> System.out.println(v.getMessage()));

                continue;
            }

            User entity = this.modelMapper.map(userSeedDto, User.class);

            this.userRepository.saveAndFlush(entity);
        }
    }
}
