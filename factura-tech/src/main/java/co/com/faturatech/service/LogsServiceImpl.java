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
public class LogsServiceImpl implements LogsService{

	@Autowired
	private LogsRepository logsRepository;
	
	@Autowired
	private Validator validator;
                
    @Override        		
	public void validate(Logs logs)throws ConstraintViolationException{		
		
		Set<ConstraintViolation<Logs>> constraintViolations =validator.validate(logs);
		 if (!constraintViolations.isEmpty()) {			
			throw new ConstraintViolationException(constraintViolations);
		}
		
	}
	
	@Override
	@Transactional(readOnly=true)
	public Long count(){
	 	return logsRepository.count();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Logs> findAll(){
		log.debug("finding all Logs instances");
       	return logsRepository.findAll();
    }
			
			
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)			
    public Logs save(Logs entity) throws Exception {
		log.debug("saving Logs instance");
	   
	    
	    if(entity==null){
			throw new ZMessManager().new NullEntityExcepcion("Logs");
		}
		
		validate(entity);	
	
		if(logsRepository.existsById(entity.getLgsId())){
           throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }    
	
	    return logsRepository.save(entity);
	   
    }
			
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void delete(Logs entity) throws Exception {
            	log.debug("deleting Logs instance");
            	
	            if(entity==null){
	    			throw new ZMessManager().new NullEntityExcepcion("Logs");
	    		}
    	
                                if(entity.getLgsId()==null){
                    throw new ZMessManager().new EmptyFieldException("lgsId");
                    }
                        
            if(logsRepository.existsById(entity.getLgsId())==false){
           		throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        	} 
            
            	            findById(entity.getLgsId()).ifPresent(entidad->{	            	
	                													List<Bills> billses = entidad.getBillses();
	                    	                    if(Utilities.validationsList(billses)==true){
                       	 	throw new ZMessManager().new DeletingException("billses");
                        }
	                	            });
                       

           
            
            logsRepository.deleteById(entity.getLgsId());
            log.debug("delete Logs successful");
            
           
            	
            }
            
            @Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void deleteById(Integer id) throws Exception {            
            	log.debug("deleting Logs instance");
            	if(id==null){
            		throw new ZMessManager().new EmptyFieldException("lgsId");
            	}
            	if(logsRepository.existsById(id)){
           			delete(logsRepository.findById(id).get());
       			}    
            }	
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public Logs update(Logs entity) throws Exception {

				log.debug("updating Logs instance");
				
	           
	            
	            	if(entity==null){
		    			throw new ZMessManager().new NullEntityExcepcion("Logs");
		    		}
		    		
	            validate(entity);
	            
	            
	            if(logsRepository.existsById(entity.getLgsId())==false){
           			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        		}	            
	
	            return logsRepository.save(entity);
	        
            }
			
			@Override
			@Transactional(readOnly=true)
            public Optional<Logs> findById(Integer lgsId) {            
            	log.debug("getting Logs instance");
            	return logsRepository.findById(lgsId);
            }
			
}
