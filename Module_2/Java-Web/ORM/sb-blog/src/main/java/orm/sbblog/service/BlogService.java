package orm.sbblog.service;

import orm.sbblog.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAllBlog();

    List<Blog> findAllByStatusIsTrue();

    Blog findBlogById(int id);

    void saveBlog(Blog blog);

    void removeBlog(int id);
}
