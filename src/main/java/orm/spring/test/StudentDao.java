package orm.spring.test;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class StudentDao {
	
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	@Transactional
	public int addStudent(Student s)
	{
		int row =(int) this.hibernateTemplate.save(s);
		return row;
	}
	
	
	public List<Student> getAllStudents()
	{
		return this.hibernateTemplate.loadAll(Student.class);
	}
	
	public Student getStudent(int sid)
	{
		return this.hibernateTemplate.get(Student.class,sid);
	}

	
	
	@Transactional

	public void studentDelete(int sid)
	{
		Student s = this.getStudent(sid);
		s=this.hibernateTemplate.get(Student.class,sid);
		this.hibernateTemplate.delete(s);
	}
	
	@Transactional

	public void studentUpdate(Student s)
	{
		this.hibernateTemplate.saveOrUpdate(s);
	}
	
	
	
	
	
	
	
}
