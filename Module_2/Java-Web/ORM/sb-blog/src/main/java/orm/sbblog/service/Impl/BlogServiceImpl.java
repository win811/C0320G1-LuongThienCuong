package orm.sbblog.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import orm.sbblog.model.Blog;
import orm.sbblog.repository.BlogRepository;
import orm.sbblog.service.BlogService;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<Blog> findAllBlog() {
        return blogRepository.findAll();
    }

    @Override
    public List<Blog> findAllByStatusIsTrue() {
        return blogRepository.findAllByStatusIsTrue();
    }

    @Override
    public Blog findBlogById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void saveBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void removeBlog(int id) {
        blogRepository.deleteById(id);
    }
}
