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
public class DepartmentsServiceImpl implements DepartmentsService{

	@Autowired
	private DepartmentsRepository departmentsRepository;
	
	@Autowired
	private Validator validator;
                
    @Override        		
	public void validate(Departments departments)throws ConstraintViolationException{		
		
		Set<ConstraintViolation<Departments>> constraintViolations =validator.validate(departments);
		 if (!constraintViolations.isEmpty()) {			
			throw new ConstraintViolationException(constraintViolations);
		}
		
	}
	
	@Override
	@Transactional(readOnly=true)
	public Long count(){
	 	return departmentsRepository.count();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Departments> findAll(){
		log.debug("finding all Departments instances");
       	return departmentsRepository.findAll();
    }
			
			
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)			
    public Departments save(Departments entity) throws Exception {
		log.debug("saving Departments instance");
	   
	    
	    if(entity==null){
			throw new ZMessManager().new NullEntityExcepcion("Departments");
		}
		
		validate(entity);	
	
		if(departmentsRepository.existsById(entity.getDptId())){
           throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }    
	
	    return departmentsRepository.save(entity);
	   
    }
			
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void delete(Departments entity) throws Exception {
            	log.debug("deleting Departments instance");
            	
	            if(entity==null){
	    			throw new ZMessManager().new NullEntityExcepcion("Departments");
	    		}
    	
                                if(entity.getDptId()==null){
                    throw new ZMessManager().new EmptyFieldException("dptId");
                    }
                        
            if(departmentsRepository.existsById(entity.getDptId())==false){
           		throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        	} 
            
            	            findById(entity.getDptId()).ifPresent(entidad->{	            	
	                													List<Cities> citieses = entidad.getCitieses();
	                    	                    if(Utilities.validationsList(citieses)==true){
                       	 	throw new ZMessManager().new DeletingException("citieses");
                        }
	                	            });
                       

           
            
            departmentsRepository.deleteById(entity.getDptId());
            log.debug("delete Departments successful");
            
           
            	
            }
            
            @Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void deleteById(Integer id) throws Exception {            
            	log.debug("deleting Departments instance");
            	if(id==null){
            		throw new ZMessManager().new EmptyFieldException("dptId");
            	}
            	if(departmentsRepository.existsById(id)){
           			delete(departmentsRepository.findById(id).get());
       			}    
            }	
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public Departments update(Departments entity) throws Exception {

				log.debug("updating Departments instance");
				
	           
	            
	            	if(entity==null){
		    			throw new ZMessManager().new NullEntityExcepcion("Departments");
		    		}
		    		
	            validate(entity);
	            
	            
	            if(departmentsRepository.existsById(entity.getDptId())==false){
           			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        		}	            
	
	            return departmentsRepository.save(entity);
	        
            }
			
			@Override
			@Transactional(readOnly=true)
            public Optional<Departments> findById(Integer dptId) {            
            	log.debug("getting Departments instance");
            	return departmentsRepository.findById(dptId);
            }
			
}
