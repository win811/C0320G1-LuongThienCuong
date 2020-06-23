package orm.sbblog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import orm.sbblog.model.Blog;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {
//    @Query(value = "select * from blog where status = true" , nativeQuery = true)
    List<Blog> findAllByStatusIsTrue();
    Page<Blog> findAllByNameContainingAndContentContaining(String name,String content,Pageable pageable);
}
