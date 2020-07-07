package furama.resort.services.impl;

import furama.resort.models.AttachService;
import furama.resort.repositories.AttachServiceRepository;
import furama.resort.services.AttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceServiceImpl implements AttachServiceService {

    @Autowired
    AttachServiceRepository attachServiceRepository;

    @Override
    public List<AttachService> getAllAttachService() {
        return attachServiceRepository.findAll();
    }

    @Override
    public AttachService findAttachServiceById(long id) {
        return attachServiceRepository.findById(id).orElse(null);
    }
}
