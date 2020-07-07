package furama.resort.repositories;

import furama.resort.models.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRoleRepository extends JpaRepository<AccountRole,Long> {
    List<AccountRole> findByAccount_Id (long accountId);
}
