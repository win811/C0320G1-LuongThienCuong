package orm.sbblog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import orm.sbblog.model.Blog;

import java.util.List;

public interface BlogService {
    Page<Blog> findAllBlog(Pageable pageable);

    Page<Blog> findAllBlogByNameContainingAndContentContaining (String name,String content,Pageable pageable);

    List<Blog> findAllByStatusIsTrue();

    Blog findBlogById(int id);

    void saveBlog(Blog blog);

    void removeBlog(int id);
}
