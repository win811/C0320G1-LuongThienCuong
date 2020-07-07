package furama.resort.services;

import furama.resort.models.AttachService;

import java.util.List;

public interface AttachServiceService {
    List<AttachService> getAllAttachService();
    AttachService findAttachServiceById(long id);
}
