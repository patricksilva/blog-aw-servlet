package br.com.vofffice.aw.blog.dao;

import java.util.List;

import br.com.vofffice.aw.blog.domain.User;

public interface UserDao {
	public User getOne(Long id);
	public List<User> findAll();
	public User save(User user);
	public User delete(User user);
	public User findByUsername(String username);
}
