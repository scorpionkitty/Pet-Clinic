package com.sherlockHomies.orm;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.sherlockHomies.beans.Pet;
import com.sherlockHomies.beans.PetType;

@Repository(value="petDao")
@Scope(value="prototype")
public class PetDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED,
			propagation=Propagation.REQUIRED,
			rollbackFor=Exception.class)
	public List<Pet> getAll(){
		return sessionFactory.getCurrentSession().createCriteria(Pet.class).list();
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED,
			propagation=Propagation.REQUIRED,
			rollbackFor=Exception.class)
	public Pet getById(int id){
		return (Pet) sessionFactory.getCurrentSession().get(Pet.class, id);
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED,
			propagation=Propagation.REQUIRED,
			rollbackFor=Exception.class)
	public List<Pet> getByType(int typeId){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Pet.class);
		criteria.add(Restrictions.like("petType.petTypeId", typeId));
		return criteria.list();		
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED,
			propagation=Propagation.REQUIRED,
			rollbackFor=Exception.class)
	public List<Pet> getByUser(String un){
		///Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Pet.class);
		//criteria.add(Restrictions.like("owner.username", un));
		//return criteria.list();
		String HQL = "select P from Pet P join P.owner Us where Us.username= :u";
		Query query = sessionFactory.getCurrentSession().createQuery(HQL);
		query.setString("u", un);
		return query.list();
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED,
			propagation=Propagation.REQUIRED,
			rollbackFor=Exception.class)
	public List<Pet> getByType(String type){
		String HQL = "select P from Pet P join P.petType PT where PT.petTypeName= :t";
		Query query = sessionFactory.getCurrentSession().createQuery(HQL);
		query.setString("t", type);
		return query.list();
	}
	
	

}
