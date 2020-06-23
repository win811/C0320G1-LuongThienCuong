package orm.sbblog.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<Blog> findAllBlog(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllBlogByNameContainingAndContentContaining(String name, String content, Pageable pageable) {
        return blogRepository.findAllByNameContainingAndContentContaining(name,content,pageable);
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
