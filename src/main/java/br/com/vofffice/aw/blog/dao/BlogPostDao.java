package br.com.vofffice.aw.blog.dao;

import java.util.List;

import br.com.vofffice.aw.blog.domain.BlogPost;

public interface BlogPostDao {
	public BlogPost getOne(Long id);
	public List<BlogPost> findAll();
	public BlogPost save(BlogPost blogPost);
	public BlogPost delete(BlogPost blogPost);
}
