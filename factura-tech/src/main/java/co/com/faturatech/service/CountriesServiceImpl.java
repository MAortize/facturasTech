package  co.com.faturatech.service;


import java.math.*;
import java.util.*;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import co.com.faturatech.exception.*;
import co.com.faturatech.repository.*;
import co.com.faturatech.utility.Utilities;

import co.com.faturatech.domain.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import lombok.extern.slf4j.Slf4j;

/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org/
* www.zathuracode.org
* 
*/

@Scope("singleton")
@Service
@Slf4j
public class CountriesServiceImpl implements CountriesService{

	@Autowired
	private CountriesRepository countriesRepository;
	
	@Autowired
	private Validator validator;
                
    @Override        		
	public void validate(Countries countries)throws ConstraintViolationException{		
		
		Set<ConstraintViolation<Countries>> constraintViolations =validator.validate(countries);
		 if (!constraintViolations.isEmpty()) {			
			throw new ConstraintViolationException(constraintViolations);
		}
		
	}
	
	@Override
	@Transactional(readOnly=true)
	public Long count(){
	 	return countriesRepository.count();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Countries> findAll(){
		log.debug("finding all Countries instances");
       	return countriesRepository.findAll();
    }
			
			
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)			
    public Countries save(Countries entity) throws Exception {
		log.debug("saving Countries instance");
	   
	    
	    if(entity==null){
			throw new ZMessManager().new NullEntityExcepcion("Countries");
		}
		
		validate(entity);	
	
		if(countriesRepository.existsById(entity.getCntId())){
           throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }    
	
	    return countriesRepository.save(entity);
	   
    }
			
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void delete(Countries entity) throws Exception {
            	log.debug("deleting Countries instance");
            	
	            if(entity==null){
	    			throw new ZMessManager().new NullEntityExcepcion("Countries");
	    		}
    	
                                if(entity.getCntId()==null){
                    throw new ZMessManager().new EmptyFieldException("cntId");
                    }
                        
            if(countriesRepository.existsById(entity.getCntId())==false){
           		throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        	} 
            
            	            findById(entity.getCntId()).ifPresent(entidad->{	            	
	                													List<Departments> departmentses = entidad.getDepartmentses();
	                    	                    if(Utilities.validationsList(departmentses)==true){
                       	 	throw new ZMessManager().new DeletingException("departmentses");
                        }
	                	            });
                       

           
            
            countriesRepository.deleteById(entity.getCntId());
            log.debug("delete Countries successful");
            
           
            	
            }
            
            @Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void deleteById(Integer id) throws Exception {            
            	log.debug("deleting Countries instance");
            	if(id==null){
            		throw new ZMessManager().new EmptyFieldException("cntId");
            	}
            	if(countriesRepository.existsById(id)){
           			delete(countriesRepository.findById(id).get());
       			}    
            }	
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public Countries update(Countries entity) throws Exception {

				log.debug("updating Countries instance");
				
	           
	            
	            	if(entity==null){
		    			throw new ZMessManager().new NullEntityExcepcion("Countries");
		    		}
		    		
	            validate(entity);
	            
	            
	            if(countriesRepository.existsById(entity.getCntId())==false){
           			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        		}	            
	
	            return countriesRepository.save(entity);
	        
            }
			
			@Override
			@Transactional(readOnly=true)
            public Optional<Countries> findById(Integer cntId) {            
            	log.debug("getting Countries instance");
            	return countriesRepository.findById(cntId);
            }
			
}
