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
public class PersonTypeServiceImpl implements PersonTypeService{

	@Autowired
	private PersonTypeRepository personTypeRepository;
	
	@Autowired
	private Validator validator;
                
    @Override        		
	public void validate(PersonType personType)throws ConstraintViolationException{		
		
		Set<ConstraintViolation<PersonType>> constraintViolations =validator.validate(personType);
		 if (!constraintViolations.isEmpty()) {			
			throw new ConstraintViolationException(constraintViolations);
		}
		
	}
	
	@Override
	@Transactional(readOnly=true)
	public Long count(){
	 	return personTypeRepository.count();
	}

	@Override
	@Transactional(readOnly=true)
	public List<PersonType> findAll(){
		log.debug("finding all PersonType instances");
       	return personTypeRepository.findAll();
    }
			
			
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)			
    public PersonType save(PersonType entity) throws Exception {
		log.debug("saving PersonType instance");
	   
	    
	    if(entity==null){
			throw new ZMessManager().new NullEntityExcepcion("PersonType");
		}
		
		validate(entity);	
	
		if(personTypeRepository.existsById(entity.getPrstId())){
           throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }    
	
	    return personTypeRepository.save(entity);
	   
    }
			
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void delete(PersonType entity) throws Exception {
            	log.debug("deleting PersonType instance");
            	
	            if(entity==null){
	    			throw new ZMessManager().new NullEntityExcepcion("PersonType");
	    		}
    	
                                if(entity.getPrstId()==null){
                    throw new ZMessManager().new EmptyFieldException("prstId");
                    }
                        
            if(personTypeRepository.existsById(entity.getPrstId())==false){
           		throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        	} 
            
            	            findById(entity.getPrstId()).ifPresent(entidad->{	            	
	                													List<Clients> clientses = entidad.getClientses();
	                    	                    if(Utilities.validationsList(clientses)==true){
                       	 	throw new ZMessManager().new DeletingException("clientses");
                        }
	                													List<Emitters> emitterses = entidad.getEmitterses();
	                    	                    if(Utilities.validationsList(emitterses)==true){
                       	 	throw new ZMessManager().new DeletingException("emitterses");
                        }
	                	            });
                       

           
            
            personTypeRepository.deleteById(entity.getPrstId());
            log.debug("delete PersonType successful");
            
           
            	
            }
            
            @Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void deleteById(Integer id) throws Exception {            
            	log.debug("deleting PersonType instance");
            	if(id==null){
            		throw new ZMessManager().new EmptyFieldException("prstId");
            	}
            	if(personTypeRepository.existsById(id)){
           			delete(personTypeRepository.findById(id).get());
       			}    
            }	
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public PersonType update(PersonType entity) throws Exception {

				log.debug("updating PersonType instance");
				
	           
	            
	            	if(entity==null){
		    			throw new ZMessManager().new NullEntityExcepcion("PersonType");
		    		}
		    		
	            validate(entity);
	            
	            
	            if(personTypeRepository.existsById(entity.getPrstId())==false){
           			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        		}	            
	
	            return personTypeRepository.save(entity);
	        
            }
			
			@Override
			@Transactional(readOnly=true)
            public Optional<PersonType> findById(Integer prstId) {            
            	log.debug("getting PersonType instance");
            	return personTypeRepository.findById(prstId);
            }
			
}
