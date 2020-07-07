package furama.resort.services;

import furama.resort.models.dto.SignUpDto;

public interface SignUpDtoService {
    void saveCustomerAndAccount(SignUpDto signUpDto);
}
